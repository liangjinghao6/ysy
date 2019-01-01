package com.orange.ysy.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orange.ysy.entity.YsyUser;
import com.orange.ysy.entity.YsyUserExample;
import com.orange.ysy.mapper.YsyUserMapper;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	    @Autowired
	    private YsyUserMapper userMapper;

	    @Test
	    public void testSelect() {
	        System.out.println(("----- selectAll method test ------"));
	        List<YsyUser> userList = userMapper.selectByExample(new YsyUserExample());
	        Assert.assertEquals(0, userList.size());
	        userList.forEach(System.out::println);
	    }

}
