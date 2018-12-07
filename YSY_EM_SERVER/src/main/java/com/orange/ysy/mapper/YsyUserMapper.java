package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyUser;
import com.orange.ysy.entity.YsyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface YsyUserMapper{
	
    long countByExample(YsyUserExample example);

    int deleteByExample(YsyUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(YsyUser record);

    int insertSelective(YsyUser record);

    List<YsyUser> selectByExample(YsyUserExample example);

    YsyUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") YsyUser record, @Param("example") YsyUserExample example);

    int updateByExample(@Param("record") YsyUser record, @Param("example") YsyUserExample example);

    int updateByPrimaryKeySelective(YsyUser record);

    int updateByPrimaryKey(YsyUser record);
}