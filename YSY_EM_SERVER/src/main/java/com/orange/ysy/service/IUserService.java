package com.orange.ysy.service;

import java.util.List;

import com.orange.ysy.entity.YsyUser;

public interface IUserService {

	Integer deleteById(String id);

	Integer updateUser(String account, String name, String id, String op);

	Integer updateUser(YsyUser user);

	Integer addUser(YsyUser user);

	List<YsyUser> findUser(String q, Integer page, Integer limit);

}
