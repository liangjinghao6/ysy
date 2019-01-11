package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOpOperator;
import com.orange.ysy.entity.YsyOpOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOpOperatorMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String operatorId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyOpOperator record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyOpOperator record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyOpOperator> selectByExample(YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyOpOperator selectByPrimaryKey(String operatorId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyOpOperator record, @Param("example") YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyOpOperator record, @Param("example") YsyOpOperatorExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyOpOperator record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyOpOperator record);
}