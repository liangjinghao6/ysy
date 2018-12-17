package com.sifude.lejane.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sifude.exception.SifudeException;
import com.sifude.lejane.exception.SifudeLejaneExceptionEnum;
import com.sifude.lejane.service.ICommonService;
import com.sifude.tool.util.RedisUtil;

/**
 * @author 梁景皓
 * @version 创建时间：2015年6月8日 上午11:25:11 类说明
 */
@Service("commonService")
public class CommonService implements ICommonService {
	private static Logger log = LoggerFactory.getLogger(CommonService.class);

	@Resource(name = "redisUtil")
	private RedisUtil redisUtil;

	@Override
	public void checkUser(HttpServletRequest request, String[] permissions) {
		String token = request.getHeader("token");
		log.debug(request.getHeader("safetyId") + "=============" + token);
		String addOpId = request.getParameter("addOpId");
		String addRoleLevel = request.getParameter("addRoleLevel");
		String addCompId = request.getParameter("addCompId");
		
		if (StringUtils.isEmpty(token) || redisUtil.get(token, "addOpId") == null) {
			throw new SifudeException(SifudeLejaneExceptionEnum.USER_UNLOG_EXCEPTION);
		}
		if (StringUtils.isNotEmpty(addOpId) && !StringUtils.equals(addOpId, redisUtil.get(token, "addOpId") + "")) {
			throw new SifudeException(SifudeLejaneExceptionEnum.USER_OPID_ILLEGAL_EXCEPTION, addOpId);
		}
		
		if (StringUtils.isNotEmpty(addCompId) && !StringUtils.equals(addCompId, redisUtil.get(token, "addCompId") + "")) {
			throw new SifudeException(SifudeLejaneExceptionEnum.USER_COMPANY_ILLEGAL_EXCEPTION, addCompId);
		}
		if (StringUtils.isNotEmpty(addRoleLevel) && !StringUtils.equals(addRoleLevel, redisUtil.get(token, "addRoleLevel") + "")) {
			throw new SifudeException(SifudeLejaneExceptionEnum.ROLE_LEVEL_ILLEGAL_EXCEPTION, addRoleLevel);
		}

		String sids = redisUtil.get(token, "sids") + "";

		if (permissions != null) {
			boolean flag = false;
			for (String permission : permissions) {
				if (sids.contains(permission)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				throw new SifudeException(SifudeLejaneExceptionEnum.USER_PERMISSON_ILLEGAL_EXCEPTION);
			}
		}
	}
	
}
