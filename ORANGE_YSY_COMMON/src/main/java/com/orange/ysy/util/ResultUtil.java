package com.orange.ysy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.ysy.entity.ResultBean;

/**
 * @author liangjh
 * @date 2017年6月23日 下午4:27:53
 * @description
 * @version
 */
public class ResultUtil {
	private static Logger log = LoggerFactory.getLogger(ResultUtil.class);

	private static ObjectMapper mapper = new ObjectMapper();

	public static ResultBean returnResult(Object result, String description, boolean status) {
		ResultBean rb = new ResultBean();
		rb.setResult(result);
		rb.setStatus(status);
		rb.setDescription(description);
		return rb;
	};

	public static ResultBean returnResult(Object result, String description) {
		ResultBean rb = new ResultBean();
		rb.setResult(result);
		rb.setStatus(true);
		rb.setDescription(description);
		return rb;
	};

	public static ResultBean returnResult(Exception e) {

		ResultBean rb = null;
		// if(e instanceof SifudeException || e instanceof
		// SifudeNoRollBackExpection) {
		// SifudeException te = (SifudeException) e;
		// rb = new ResultBean();
		// rb.setStatus(false);
		// rb.setDescription(te.getMessage());
		// rb.setCode(te.getErrorCode());
		// } else {
		log.error(e.getMessage(), e);
		rb = new ResultBean();
		rb.setStatus(false);
		rb.setDescription("系统内部异常");
		// }
		return rb;
	};

	public static String returnJson(Exception e) {
		ResultBean rb = returnResult(e);
		try {
			return mapper.writeValueAsString(rb);
		} catch (JsonProcessingException e1) {
			log.error(e.getMessage(), e);
		}
		return "{\"status\":false,\"description\":\"系统内部异常\"}";
	}

}