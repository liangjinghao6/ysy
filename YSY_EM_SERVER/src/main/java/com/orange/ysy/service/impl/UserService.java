package com.orange.ysy.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.ysy.entity.YsyUser;
import com.orange.ysy.entity.YsyUserExample;
import com.orange.ysy.exception.ServiceException;
import com.orange.ysy.mapper.YsyUserMapper;
import com.orange.ysy.service.IUserService;
import com.orange.ysy.util.CreateId;

@Service
public class UserService implements IUserService{

	@Autowired
	private YsyUserMapper userMapper;
	
	@Override
	public Integer deleteById(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateUser(String account, String name, String id, String op) {
		YsyUser user = userMapper.selectByPrimaryKey(id);
		user.setUserName(account);
		user.setNickName(name);
		return userMapper.updateByPrimaryKey(user);
	}


	@Override
	public Integer updateUser(YsyUser user) {
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public Integer addUser(YsyUser user) {
		if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getWxNo())) {
			throw new ServiceException("参数为空");
		}
		
		YsyUserExample userExample = new YsyUserExample();
		userExample.createCriteria().andWxNoEqualTo(user.getWxNo());
		userExample.createCriteria().andUserNameEqualTo(user.getUserName());
		List<YsyUser> userCheck = userMapper.selectByExample(userExample);
		if (userCheck.size() > 0) {
			throw new ServiceException("用户名已经存在");
		}
		user.setUserId(CreateId.Uuid());

		return userMapper.insert(user);
	}

	@Override
	public List<YsyUser> findUser(String q, Integer page, Integer limit) {
		YsyUserExample userExample = new YsyUserExample();
		userExample.createCriteria().andWxNoEqualTo(q);
		userExample.createCriteria().andUserNameEqualTo(q);
		return userMapper.selectByExample(userExample);
	}

}
