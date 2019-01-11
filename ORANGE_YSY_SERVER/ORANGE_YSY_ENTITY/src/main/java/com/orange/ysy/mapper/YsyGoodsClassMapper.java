package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsyGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsClassMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String classId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyGoodsClass> selectByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyGoodsClass selectByPrimaryKey(String classId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyGoodsClass record, @Param("example") YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyGoodsClass record, @Param("example") YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyGoodsClass record);
}