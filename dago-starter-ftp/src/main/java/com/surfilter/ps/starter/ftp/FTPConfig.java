package com.surfilter.ps.starter.ftp;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: FtpPoolConfig
 * @Package com.surfilter.ps.starter.ftp
 * @Description: ftp配置参数对象
 * @author: Alex
 * @date: 2018-07-03 上午9:59
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 *             注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@ConfigurationProperties(prefix = "ftp")
public class FTPConfig {

	private String host;// 主机名
	private int port = 21;// 端口
	private String username;// 用户名
	private String password;// 密码

	private boolean passiveMode=true; //传输模式
	private String encoding = "utf-8"; //传输编码方式
	private int clientTimeout = 5000;// ftp 连接超时时间 毫秒
	private int threadNum=10;
	private int transferFileType = 2;// 传输数据格式 2表binary二进制数据
	private boolean renameUploaded;
	private int retryTimes = 3;
	private int bufferSize = 1024;// 缓冲区大小
	private String workingDirectory;
	private int dataTimeout = 120000;
	private boolean useEPSVwithIPv4 = false;
	
	private int maxTotal;//最大连接数
	private int maxIdle;//最大idle数
	private int minIdle;//最小idle数
	private int maxWait;//最大等待时间

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isPassiveMode() {
		return passiveMode;
	}

	public void setPassiveMode(boolean passiveMode) {
		this.passiveMode = passiveMode;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public int getClientTimeout() {
		return clientTimeout;
	}

	public void setClientTimeout(int clientTimeout) {
		this.clientTimeout = clientTimeout;
	}

	public int getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}

	public int getTransferFileType() {
		return transferFileType;
	}

	public void setTransferFileType(int transferFileType) {
		this.transferFileType = transferFileType;
	}

	public boolean isRenameUploaded() {
		return renameUploaded;
	}

	public void setRenameUploaded(boolean renameUploaded) {
		this.renameUploaded = renameUploaded;
	}

	public int getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public String getWorkingDirectory() {
		return workingDirectory;
	}

	public void setWorkingDirectory(String workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public int getDataTimeout() {
		return dataTimeout;
	}

	public void setDataTimeout(int dataTimeout) {
		this.dataTimeout = dataTimeout;
	}

	public boolean isUseEPSVwithIPv4() {
		return useEPSVwithIPv4;
	}

	public void setUseEPSVwithIPv4(boolean useEPSVwithIPv4) {
		this.useEPSVwithIPv4 = useEPSVwithIPv4;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
}
