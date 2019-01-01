package com.orange.ysy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.ysy.entity.ResultBean;
import com.orange.ysy.exception.OrangeRunTimeException;

/**
 * @author liangjh
 * @date 2017年6月23日 下午4:27:53
 * @description
 * @version
 */
public class ResultUtil {
	private static Logger log = LoggerFactory.getLogger(ResultUtil.class);

	private static ObjectMapper mapper = new ObjectMapper();

	public static ResultBean returnResult(Object result, String message, boolean status) {
		ResultBean rb = new ResultBean();
		rb.setResult(result);
		rb.setStatus(status);
		rb.setMessage(message);
		return rb;
	}

	public static ResultBean returnResult(Object result, String message) {
		ResultBean rb = new ResultBean();
		rb.setResult(result);
		rb.setStatus(true);
		rb.setMessage(message);
		return rb;
	}

	public static ResultBean returnResult(Exception e) {
		ResultBean rb = null;
		if (e instanceof OrangeRunTimeException || e instanceof OrangeRunTimeException) {
			OrangeRunTimeException te = (OrangeRunTimeException) e;
			rb = new ResultBean();
			rb.setStatus(false);
			rb.setMessage(te.getMessage());
			rb.setCode(te.getErrorCode());
		} else {
			log.error(e.getMessage(), e);
			rb = new ResultBean();
			rb.setStatus(false);
			rb.setMessage("系统内部异常");
		}
		return rb;
	}

	public static String returnJson(Exception e) {
		ResultBean rb = returnResult(e);
		try {
			return mapper.writeValueAsString(rb);
		} catch (JsonProcessingException e1) {
			log.error(e.getMessage(), e);
		}
		return "{\"status\":false,\"description\":\"系统内部异常\"}";
	}

	public static void main(String args[]) {
		System.out.println(returnJson(new Exception("1")));
	}

}