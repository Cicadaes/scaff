package com.xxl.conf.admin.controller.interceptor;

import com.xxl.conf.admin.core.conf.Environment;
import com.xxl.conf.admin.core.model.XxlConfEnv;
import com.xxl.conf.admin.core.util.CookieUtil;
import com.xxl.conf.admin.dao.XxlConfEnvDao;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * push cookies to model as cookieMap
 * @author xuxueli 2015-12-12 18:09:04
 */
public class EnvInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private XxlConfEnvDao xxlConfEnvDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// env list
		List<XxlConfEnv> envList = xxlConfEnvDao.findAll();
		if (envList==null || envList.size()==0) {
			throw new RuntimeException("系统异常，获取Env数据失败");
		}

		// current env
		XxlConfEnv currentEnv = envList.get(0);

		String currentEnvCookie = CookieUtil.getValue(request, Environment.CURRENT_ENV);
		if (currentEnvCookie!=null && currentEnvCookie.trim().length()>0) {
			for (XxlConfEnv envItem: envList) {
				if (currentEnvCookie.equals(envItem.getEnv())) {
					currentEnv = envItem;
				}
			}
		}

		request.setAttribute("envList", envList);
		request.setAttribute(Environment.CURRENT_ENV, currentEnv);

		return super.preHandle(request, response, handler);
	}
	
}
