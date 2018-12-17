package com.sifude.lejane.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 梁景皓
 * @version 创建时间：2015年7月3日 下午4:14:52
 * 类说明
 */
public interface ICommonService {

	public void checkUser(HttpServletRequest request, String[] permission);
	
}
