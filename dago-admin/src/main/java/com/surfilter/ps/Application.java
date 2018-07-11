package com.surfilter.ps;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.AccessControlException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * 
 * @author AlexYao
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.surfilter.ps","com.surfilter.ps"})
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	private static Application app = null;

	// 关闭端口
	private int port = 19000;
	// 主机地址
	private String address = "localhost";
	// 关闭系统指令
	private String startup = "start";
	// 启动系统指令
	private String shutdown = "stop";
	//
	private Random random = null;
	// 是否阻塞
	protected boolean await = true;
	// 系统阻塞socket
	private volatile ServerSocket awaitSocket = null;
	// 是否停止等待
	private volatile boolean stopAwait = false;

	public static void main(String[] args) throws Exception {
		if (app == null) {
			app = new Application();
		}
		if (args.length < 1) {
			LOGGER.info("SpringBoot args error");
			return;
		}
		String command = args[0];
		if (app.startup.equalsIgnoreCase(command)) {
			app.start();
		}
		if (app.shutdown.equalsIgnoreCase(command)) {
			app.stop();
		}
	}

	private void start() throws Exception {
		LOGGER.info("------------------------Server startup------------------------");
		long t1 = System.nanoTime();
		String[] args = new String[] {};
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		LOGGER.info("SpringBoot Start Success");
		// 打印profile
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
		for (String profile : activeProfiles) {
			LOGGER.info("Spring Boot 使用profiler为:{}", profile);
		}
		long t2 = System.nanoTime();
		LOGGER.info("Server startup in " + ((t2 - t1) / 1000000) + " ms");
		if (await) {
			await();
		}
		ExitCodeGenerator exitCodeGenerator = new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 200;
			}
		};
		SpringApplication.exit(ctx, exitCodeGenerator);
		LOGGER.info("------------------------Server shutdown------------------------");
	}

	private void await() {
		try {
			awaitSocket = new ServerSocket(port, 1, InetAddress.getByName(address));
		} catch (IOException e) {
			LOGGER.error("await: create[" + address + ":" + port + "]: ", e);
			return;
		}
		try {
			while (!stopAwait) {
				ServerSocket serverSocket = awaitSocket;
				if (serverSocket == null) {
					break;
				}
				Socket socket = null;
				StringBuilder command = new StringBuilder();
				try {
					InputStream stream;
					long acceptStartTime = System.currentTimeMillis();
					try {
						socket = serverSocket.accept();
						socket.setSoTimeout(10 * 1000);
						stream = socket.getInputStream();
					} catch (SocketTimeoutException ste) {
						LOGGER.error(
								"Provider.accept.timeout:" + Long.valueOf(System.currentTimeMillis() - acceptStartTime),
								ste);
						continue;
					} catch (AccessControlException ace) {
						LOGGER.error("Provider.accept security exception: " + ace.getMessage(), ace);
						continue;
					} catch (IOException e) {
						if (stopAwait) {
							break;
						}
						LOGGER.error("Provider.await: accept: ", e);
						break;
					}

					// 读取
					int expected = 1024;
					while (expected < shutdown.length()) {
						if (random == null) {
							random = new Random();
						}
						expected += (random.nextInt() % 1024);
					}
					while (expected > 0) {
						int ch = -1;
						try {
							ch = stream.read();
						} catch (IOException e) {
							ch = -1;
						}
						if (ch < 32)
							break;
						command.append((char) ch);
						expected--;
					}
				} finally {
					try {
						if (socket != null) {
							socket.close();
						}
					} catch (IOException e) {
						// Ignore

					}
				}
				boolean match = command.toString().equals(shutdown);
				if (match) {
					break;
				} else {

				}
			}
		} finally {
			ServerSocket serverSocket = awaitSocket;
			awaitSocket = null;

			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// Ignore

				}
			}
		}
	}

	/**
	 * 应用停止
	 */
	private void stop() {
		try (Socket socket = new Socket(address, port); OutputStream stream = socket.getOutputStream()) {
			String shutdown = this.shutdown;
			for (int i = 0; i < shutdown.length(); i++) {
				stream.write(shutdown.charAt(i));
			}
			stream.flush();
		} catch (ConnectException ce) {
			LOGGER.error("stopServer.connectException [" + address + ":" + port + "]", ce);
			ce.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			LOGGER.error("stopServer.IOException", e);
			e.printStackTrace();
			System.exit(1);
		}
	}

}
