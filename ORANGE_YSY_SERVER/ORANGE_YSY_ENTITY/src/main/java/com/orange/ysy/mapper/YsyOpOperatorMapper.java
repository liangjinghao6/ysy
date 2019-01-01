package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOpOperator;
import com.orange.ysy.entity.YsyOpOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOpOperatorMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String operatorId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyOpOperator record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyOpOperator record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyOpOperator> selectByExample(YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyOpOperator selectByPrimaryKey(String operatorId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyOpOperator record, @Param("example") YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyOpOperator record, @Param("example") YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyOpOperator record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyOpOperator record);
}