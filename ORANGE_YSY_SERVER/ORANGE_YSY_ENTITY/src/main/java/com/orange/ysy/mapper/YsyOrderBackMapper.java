package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyOrderBack;
import com.orange.ysy.entity.YsyOrderBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyOrderBackMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String backId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyOrderBack> selectByExample(YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyOrderBack selectByPrimaryKey(String backId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyOrderBack record, @Param("example") YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyOrderBack record, @Param("example") YsyOrderBackExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyOrderBack record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyOrderBack record);
}