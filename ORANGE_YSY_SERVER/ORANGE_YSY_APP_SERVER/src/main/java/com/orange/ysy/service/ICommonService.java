package com.orange.ysy.service;

import javax.servlet.http.HttpSession;

import com.orange.ysy.entity.YsyOpOperator;

public interface ICommonService {

	YsyOpOperator login(String account, String password, String validateCode, HttpSession session);

	YsyOpOperator loginByToken(String token);

}
