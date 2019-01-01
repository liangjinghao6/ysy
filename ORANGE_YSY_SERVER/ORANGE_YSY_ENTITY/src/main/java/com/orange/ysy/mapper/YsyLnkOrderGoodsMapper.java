package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkOrderGoods;
import com.orange.ysy.entity.YsyLnkOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkOrderGoodsMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String odId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyLnkOrderGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyLnkOrderGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyLnkOrderGoods> selectByExample(YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyLnkOrderGoods selectByPrimaryKey(String odId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyLnkOrderGoods record, @Param("example") YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyLnkOrderGoods record, @Param("example") YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyLnkOrderGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyLnkOrderGoods record);
}