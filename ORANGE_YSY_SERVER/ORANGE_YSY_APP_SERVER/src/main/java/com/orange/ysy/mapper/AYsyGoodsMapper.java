package com.orange.ysy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.orange.ysy.entity.YsyGoodsClass;
import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.entity.mvo.YsyGoodsFeatureMvo;

public interface AYsyGoodsMapper extends YsyGoodsMapper{
	List<YsySysFile> getImagesByGoodsId(@Param("goodsId") String goodsId, @Param("type") Short type);

	List<YsyGoodsFeatureMvo> selectFeatueIdByGoodsId(@Param("goodsId") String goodsId);

	List<YsyGoodsClass> selectClassByGoodsAndFeature(@Param("goodsId") String goodsId, @Param("featureId") String featureId);
}