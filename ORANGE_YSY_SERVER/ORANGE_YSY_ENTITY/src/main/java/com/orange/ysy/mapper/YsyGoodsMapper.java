package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoods;
import com.orange.ysy.entity.YsyGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String goodsId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyGoods> selectByExample(YsyGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyGoods selectByPrimaryKey(String goodsId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyGoods record, @Param("example") YsyGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyGoods record, @Param("example") YsyGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyGoods record);
}