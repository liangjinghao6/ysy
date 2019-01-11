package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyUserAddress;
import com.orange.ysy.entity.YsyUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyUserAddressMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String addressId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyUserAddress> selectByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyUserAddress selectByPrimaryKey(String addressId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyUserAddress record, @Param("example") YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyUserAddress record, @Param("example") YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyUserAddress record);
}