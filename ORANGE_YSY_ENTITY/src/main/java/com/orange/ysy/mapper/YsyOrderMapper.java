package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOrder;
import com.orange.ysy.entity.YsyOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOrderMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyOrderExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyOrderExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String orderId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyOrder record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyOrder record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyOrder> selectByExample(YsyOrderExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyOrder selectByPrimaryKey(String orderId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyOrder record, @Param("example") YsyOrderExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyOrder record, @Param("example") YsyOrderExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyOrder record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyOrder record);
}