package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsyGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsClassMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String classId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyGoodsClass> selectByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyGoodsClass selectByPrimaryKey(String classId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyGoodsClass record, @Param("example") YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyGoodsClass record, @Param("example") YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyGoodsClass record);
}