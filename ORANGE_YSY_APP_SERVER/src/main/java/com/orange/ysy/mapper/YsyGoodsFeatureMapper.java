package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsFeature;
import com.orange.ysy.entity.YsyGoodsFeatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsFeatureMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String featureId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyGoodsFeature record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyGoodsFeature record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyGoodsFeature> selectByExample(YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyGoodsFeature selectByPrimaryKey(String featureId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyGoodsFeature record, @Param("example") YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyGoodsFeature record, @Param("example") YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyGoodsFeature record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyGoodsFeature record);
}