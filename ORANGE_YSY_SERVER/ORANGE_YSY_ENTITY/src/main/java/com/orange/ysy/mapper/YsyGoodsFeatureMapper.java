package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsFeature;
import com.orange.ysy.entity.YsyGoodsFeatureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsFeatureMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String featureId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyGoodsFeature record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyGoodsFeature record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyGoodsFeature> selectByExample(YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyGoodsFeature selectByPrimaryKey(String featureId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyGoodsFeature record, @Param("example") YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyGoodsFeature record, @Param("example") YsyGoodsFeatureExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyGoodsFeature record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyGoodsFeature record);
}