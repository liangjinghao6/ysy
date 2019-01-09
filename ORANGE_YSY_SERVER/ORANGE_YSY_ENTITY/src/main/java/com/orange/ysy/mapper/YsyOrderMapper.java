package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOrder;
import com.orange.ysy.entity.YsyOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOrderMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyOrderExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyOrderExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String orderId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyOrder record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyOrder record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyOrder> selectByExample(YsyOrderExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyOrder selectByPrimaryKey(String orderId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyOrder record, @Param("example") YsyOrderExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyOrder record, @Param("example") YsyOrderExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyOrder record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyOrder record);
}