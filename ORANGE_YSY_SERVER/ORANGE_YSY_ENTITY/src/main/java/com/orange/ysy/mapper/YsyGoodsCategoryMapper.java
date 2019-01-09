package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsCategory;
import com.orange.ysy.entity.YsyGoodsCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsCategoryMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String categoryId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyGoodsCategory record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyGoodsCategory record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyGoodsCategory> selectByExample(YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyGoodsCategory selectByPrimaryKey(String categoryId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyGoodsCategory record, @Param("example") YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyGoodsCategory record, @Param("example") YsyGoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyGoodsCategory record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyGoodsCategory record);
}