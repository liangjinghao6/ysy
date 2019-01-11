package com.orange.ysy.util;

import java.text.SimpleDateFormat;

/**
 * @author liangjh
 * @date 2017年7月24日下午2:48:57
 * @description TODO
 */
public class Configs {
	/**
	 * 系统默认编码格式(UTF-8)
	 */
	public final static String DefaultEncoding = "UTF-8";
	/**
	 * Oracle数据库编码格式(GBK)
	 */
	public final static String OracleEncoding = "GBK";
	/**
	 * 系统默认时间格式(yyyy-MM-dd HH:mm:ss SS)
	 */
	public final static String DefaultDateFormatstr = "yyyy-MM-dd HH:mm:ss SS";
	/**
	 * 系统默认时间格式(yyyy-MM-dd HH:mm:ss SS)
	 */
	public final static SimpleDateFormat DefaultDateFormat = new SimpleDateFormat(DefaultDateFormatstr);
}
