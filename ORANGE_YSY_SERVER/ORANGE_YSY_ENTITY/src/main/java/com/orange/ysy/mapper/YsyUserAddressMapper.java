package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyUserAddress;
import com.orange.ysy.entity.YsyUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyUserAddressMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String addressId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyUserAddress> selectByExample(YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyUserAddress selectByPrimaryKey(String addressId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyUserAddress record, @Param("example") YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyUserAddress record, @Param("example") YsyUserAddressExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyUserAddress record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyUserAddress record);
}