package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyUserAddress;
import com.orange.ysy.entity.YsyUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyUserAddressMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String addressId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyUserAddress> selectByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyUserAddress selectByPrimaryKey(String addressId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyUserAddress record, @Param("example") YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyUserAddress record, @Param("example") YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyUserAddress record);
}