package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.YsyGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsMapper {
    long countByExample(YsyGoodsExample example);

    int deleteByExample(YsyGoodsExample example);

    int deleteByPrimaryKey(String goodsId);

    int insert(YsyGoods record);

    int insertSelective(YsyGoods record);

    List<YsyGoods> selectByExample(YsyGoodsExample example);

    YsyGoods selectByPrimaryKey(String goodsId);

    int updateByExampleSelective(@Param("record") YsyGoods record, @Param("example") YsyGoodsExample example);

    int updateByExample(@Param("record") YsyGoods record, @Param("example") YsyGoodsExample example);

    int updateByPrimaryKeySelective(YsyGoods record);

    int updateByPrimaryKey(YsyGoods record);
}