package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOrderBack;
import com.orange.ysy.entity.YsyOrderBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOrderBackMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String backId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyOrderBack> selectByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyOrderBack selectByPrimaryKey(String backId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyOrderBack record, @Param("example") YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyOrderBack record, @Param("example") YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyOrderBack record);
}