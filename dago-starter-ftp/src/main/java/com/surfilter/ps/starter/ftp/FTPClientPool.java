package com.surfilter.ps.starter.ftp;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: FTPClientPool
 * @Package com.surfilter.ps.starter.ftp
 * @Description: FTP 客户端连接池
 * @author: Alex
 * @date: 2018-07-03 上午10:19
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 *             注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class FTPClientPool {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(FTPClientPool.class);

	private GenericObjectPool<FTPClient> ftpClientPool;

	public FTPClientPool(FTPConfig config) {
		// 初始化对象池配置
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setBlockWhenExhausted(Boolean.parseBoolean(pro.getProperty("ftpClient_blockWhenExhausted")));
		poolConfig.setMaxWaitMillis(Long.parseLong(pro.getProperty("ftpClient_maxWait")));
		poolConfig.setMinIdle(Integer.parseInt(pro.getProperty("ftpClient_minIdle")));
		poolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("ftpClient_maxIdle")));
		poolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("ftpClient_maxTotal")));
		poolConfig.setTestOnBorrow(Boolean.parseBoolean(pro.getProperty("ftpClient_testOnBorrow")));
		poolConfig.setTestOnReturn(Boolean.parseBoolean(pro.getProperty("ftpClient_testOnReturn")));
		poolConfig.setTestOnCreate(Boolean.parseBoolean(pro.getProperty("ftpClient_testOnCreate")));
		poolConfig.setTestWhileIdle(Boolean.parseBoolean(pro.getProperty("ftpClient_testWhileIdle")));
		poolConfig.setLifo(Boolean.parseBoolean(pro.getProperty("ftpClient_lifo")));
		// 初始化对象池
		ftpClientPool = new GenericObjectPool<FTPClient>(new FTPClientFactory(ftpConfig), poolConfig);
	}

	public FTPClient borrowObject() throws Exception {
		/*
		 * System.out.println("获取前");
		 * System.out.println("活动"+ftpClientPool.getNumActive());
		 * System.out.println("等待"+ftpClientPool.getNumWaiters());
		 * System.out.println("----------");
		 */
		return ftpClientPool.borrowObject();
	}

	public void returnObject(FTPClient ftpClient) {

		/*
		 * System.out.println("归还前");
		 * System.out.println("活动"+ftpClientPool.getNumActive());
		 * System.out.println("等待"+ftpClientPool.getNumWaiters());
		 * System.out.println("----------");
		 */
		ftpClientPool.returnObject(ftpClient);
		System.out.println("归还后");
		System.out.println("活动" + ftpClientPool.getNumActive());
		System.out.println("等待" + ftpClientPool.getNumWaiters());
		System.out.println("----------");
	}

}
