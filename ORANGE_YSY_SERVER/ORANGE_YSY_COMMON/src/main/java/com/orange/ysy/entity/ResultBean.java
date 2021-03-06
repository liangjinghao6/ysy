package com.orange.ysy.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author liangjh
 * @date 2017年6月23日 下午4:25:41
 * @description
 * @version
 */
@JsonInclude(Include.NON_NULL)
public class ResultBean {
	/* 返回主体 */
	private Object result;
	/* 错误描述 */
	private String message;
	/* 错误码 */
	private String code;
	/* 是否成功 */
	private boolean status;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResultBean [result=" + result + ", message=" + message + ", code=" + code + ", status=" + status
				+ "]";
	}
}
