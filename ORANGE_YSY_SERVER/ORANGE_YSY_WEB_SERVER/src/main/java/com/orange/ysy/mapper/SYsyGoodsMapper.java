package com.orange.ysy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.orange.ysy.entity.YsySysFile;

public interface SYsyGoodsMapper extends YsyGoodsMapper{

	List<YsySysFile> getImagesByGoodsId(@Param("goodsId") String goodsId, @Param("type") Short type);
}