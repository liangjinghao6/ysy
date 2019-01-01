package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsyGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsClassMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String classId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyGoodsClass> selectByExample(YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyGoodsClass selectByPrimaryKey(String classId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyGoodsClass record, @Param("example") YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyGoodsClass record, @Param("example") YsyGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyGoodsClass record);
}