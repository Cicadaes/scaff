package com.surfilter.ps.config.web;

public class ResultMsg {

	Integer errcode;
	String errmsg;
	Object o;

	public ResultMsg(Integer errcode, String errmsg, Object o) {
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.o = o;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

}
