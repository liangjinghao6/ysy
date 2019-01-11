package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkOrderGoods;
import com.orange.ysy.entity.YsyLnkOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkOrderGoodsMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String odId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyLnkOrderGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyLnkOrderGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyLnkOrderGoods> selectByExample(YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyLnkOrderGoods selectByPrimaryKey(String odId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyLnkOrderGoods record, @Param("example") YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyLnkOrderGoods record, @Param("example") YsyLnkOrderGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyLnkOrderGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyLnkOrderGoods record);
}