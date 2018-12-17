package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsCategory;
import com.orange.ysy.entity.YsyGoodsCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsCategoryMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String categoryId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyGoodsCategory record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyGoodsCategory record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyGoodsCategory> selectByExample(YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyGoodsCategory selectByPrimaryKey(String categoryId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyGoodsCategory record, @Param("example") YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyGoodsCategory record, @Param("example") YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyGoodsCategory record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyGoodsCategory record);
}