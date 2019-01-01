package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyUser;
import com.orange.ysy.entity.YsyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyUserMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyUserExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyUserExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String userId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyUser record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyUser record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyUser> selectByExample(YsyUserExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyUser selectByPrimaryKey(String userId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyUser record, @Param("example") YsyUserExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyUser record, @Param("example") YsyUserExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyUser record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyUser record);
}