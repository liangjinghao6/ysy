package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOrderBack;
import com.orange.ysy.entity.YsyOrderBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOrderBackMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String backId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyOrderBack> selectByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyOrderBack selectByPrimaryKey(String backId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyOrderBack record, @Param("example") YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyOrderBack record, @Param("example") YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyOrderBack record);
}