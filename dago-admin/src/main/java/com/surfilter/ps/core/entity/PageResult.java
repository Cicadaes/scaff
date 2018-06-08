/**
 * @date:2019-09-15
 * @describe:界面调用接口结果返回类
 * @version:1.0
 */
package com.surfilter.ps.core.entity;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PageResult", description = "接口返回公共类")
public class PageResult {

	// ==========所有接口
	@ApiModelProperty(notes = "返回数据信息")
	private Map<String, Object> body;// 返回数据信息

	@ApiModelProperty(notes = "记录接口调用所发时间(单位：毫秒)")
	private Long time;// 记录接口调用所发时间(单位：毫秒)

	@ApiModelProperty(notes = "状态码：1成功，2失败，0session失效，9未登录")
	private Integer status;// 状态码：1成功，2失败，0session失效，9未登录

	@ApiModelProperty(notes = "返回信息")
	private String msg;// 返回信息

	public Map<String, Object> getBody() {
		return body;
	}

	public void setBody(Map<String, Object> body) {
		this.body = body;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static PageResult success(String msg) {
		return success(1, msg);
	}

	public static PageResult success(Integer status, String msg) {
		PageResult pageResult = new PageResult();
		pageResult.setStatus(status);
		pageResult.setMsg(msg);
		return pageResult;
	}

	public static PageResult success(Integer status, String msg, Map<String, Object> body) {
		PageResult pageResult = new PageResult();
		pageResult.setStatus(status);
		pageResult.setMsg(msg);
		pageResult.setBody(body);
		return pageResult;
	}

	public static PageResult failed(String msg) {
		return faild(2, msg);
	}

	public static PageResult faild(Integer status, String msg) {
		PageResult pageResult = new PageResult();
		pageResult.setStatus(status);
		pageResult.setMsg(msg);
		return pageResult;
	}
}
