package com.orange.ysy.exception;

/**
 * @author liangjh
 * @date 2017年6月27日 下午12:57:06
 * @description
 */
public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 634027478963759988L;

	public ServiceException(String message) {
		super(message);
	}
}
