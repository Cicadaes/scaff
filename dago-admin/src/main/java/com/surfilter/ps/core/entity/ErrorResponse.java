package com.surfilter.ps.core.entity;

import java.util.List;
import java.util.Map;

/**
 * 错误时的返回Body
 */
public class ErrorResponse {
    // 错误代码
    private String errorCode;
    // 错误信息
    private String msg;
    // 错误原因
    private List<String> cause;

    private Integer status;

    private Map<String, Object> body;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getCause() {
        return cause;
    }

    public void setCause(List<String> cause) {
        this.cause = cause;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
