package com.surfilter.ps.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xxl.conf.core.core.XxlConfZkManageConf;


/**
 * 改写xxlconf形成自己的相关业务，底层mapper还是使用原生的mapper
 * 
 * @author AlexYao
 */
@Service
public class ConfManager implements InitializingBean, DisposableBean {
	private static Logger logger = LoggerFactory.getLogger(ConfManager.class);

	@Value("${xxl.conf.zkaddress}")
	private String zkaddress;

	@Value("${xxl.conf.zkdigest}")
	private String zkdigest;

	// ------------------------------ zookeeper client
	// ------------------------------

	@Override
	public void afterPropertiesSet() throws Exception {
		XxlConfZkManageConf.init(zkaddress, zkdigest);
	}

	@Override
	public void destroy() throws Exception {
		XxlConfZkManageConf.destroy();
	}

	// ------------------------------ conf opt ------------------------------

	/**
	 * set zk conf
	 *
	 * @param key
	 * @param data
	 * @return
	 */
	public void set(String env, String key, String data) {
		XxlConfZkManageConf.set(env, key, data);
	}

	/**
	 * delete zk conf
	 *
	 * @param env
	 * @param key
	 */
	public void delete(String env, String key) {
		XxlConfZkManageConf.delete(env, key);
	}

	/**
	 * get zk conf
	 *
	 * @param key
	 * @return
	 */
	public String get(String env, String key) {
		return XxlConfZkManageConf.get(env, key);
	}
}
