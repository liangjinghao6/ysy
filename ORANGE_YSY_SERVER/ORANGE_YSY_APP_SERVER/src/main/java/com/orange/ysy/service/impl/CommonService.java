package com.orange.ysy.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.YsyOpOperator;
import com.orange.ysy.entity.YsyOpOperatorExample;
import com.orange.ysy.enumerate.SessionConstant;
import com.orange.ysy.exception.OrangeRunTimeException;
import com.orange.ysy.mapper.YsyOpOperatorMapper;
import com.orange.ysy.service.ICommonService;
import com.orange.ysy.util.MD5Util;

@Service
public class CommonService implements ICommonService {
	// 密码错误超过locktimes锁定
	@Value("${orange.ysy.user.locktimes:99999}")
	private Integer locktimes;
	// 是否交验验证码
	@Value("${orange.ysy.user.codecheck:false}")
	private Boolean codecheck;

	@Autowired
	private YsyOpOperatorMapper operatorMapper;

	@Override
	public YsyOpOperator login(String account, String password, String validateCode, HttpSession session) {
		// 1、比对验证码
		if (codecheck) {
			String vc = (String) session.getAttribute(SessionConstant.VALIDATE_CODE.getValue());
			if (validateCode == null || validateCode.trim().length() == 0
					|| !validateCode.toUpperCase().equals(vc.toUpperCase())) {
				throw new OrangeRunTimeException("验证码错误");
			}
		}

		// 2、检查账户是否存在
		YsyOpOperatorExample operatorExample = new YsyOpOperatorExample();
		operatorExample.createCriteria().andAccountEqualTo(account);
		List<YsyOpOperator> operators = operatorMapper.selectByExample(new YsyOpOperatorExample());
		if (operators == null || operators.size() < 1) {
			throw new OrangeRunTimeException("用户不存在");
		}
		YsyOpOperator operator = operators.get(0);
		// 3、检查密码
		String md5pwd = MD5Util.GetMD5Code(password, null, null);
		if (!StringUtils.equals(md5pwd, operator.getPassword())) {
			lockUser(operator, session);
			throw new OrangeRunTimeException("密码错误");
		}
		
		unLockUser(operator, session);
		// 4、检查账户状态
		if (operator.getIsAccountExpire() && operator.getAccountTime().before(new Date())) {
			throw new OrangeRunTimeException("账户已过期");
		}
		if (operator.getIsLock()) {
			throw new OrangeRunTimeException("账户已锁定");
		}
		if (operator.getIsStop()) {
			throw new OrangeRunTimeException("账户已停用");
		}
		if (operator.getIsPwdExpire() && operator.getPwdDuration() != null) {
			int passDays = (int) (new Date().getTime() - operator.getPwdTime().getTime()) / 86400000;
			if (passDays > operator.getPwdDuration()) {
				operator.setIsPwdChange(true);
			}
		}
		operator.setToken(operator.getOperatorId() + '_' + operator.getPassword());
		return operator;
	}

	// 锁定账户
	private void lockUser(YsyOpOperator operator, HttpSession session) {
		if (operator.getIsLock()) {
			throw new OrangeRunTimeException("用户已被锁定");
		}
		Integer validatetimes = 1;
		if (session.getAttribute(SessionConstant.LOCKTIMES.getValue() + operator.getAccount()) != null) {
			validatetimes = (Integer) session
					.getAttribute(SessionConstant.LOCKTIMES.getValue() + operator.getAccount());
			validatetimes++;
		}
		session.setAttribute(SessionConstant.LOCKTIMES.getValue() + operator.getAccount(), validatetimes);
		if (validatetimes >= locktimes) {
			operator.setIsLock(true);
			operatorMapper.updateByPrimaryKey(operator);
			session.setAttribute(SessionConstant.USER.getValue(), operator);
		}
	}

	// 账户解锁
	private void unLockUser(YsyOpOperator operator, HttpSession session) {
		session.setAttribute(SessionConstant.LOCKTIMES.getValue() + operator.getAccount(), null);
	}

	@Override
	public YsyOpOperator loginByToken(String token) {
		String[] tokenArr = StringUtils.split(token, "_");
		
		YsyOpOperator operator = operatorMapper.selectByPrimaryKey(tokenArr[0]);
		if (!StringUtils.equals(tokenArr[1], operator.getPassword())) {
			throw new OrangeRunTimeException("密码错误");
		}
		operator.setToken(operator.getOperatorId() + '_' + operator.getPassword());
		return operator;

	}

}
