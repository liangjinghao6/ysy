package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkUserGoods;
import com.orange.ysy.entity.YsyLnkUserGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkUserGoodsMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyLnkUserGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyLnkUserGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String uiId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyLnkUserGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyLnkUserGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyLnkUserGoods> selectByExample(YsyLnkUserGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyLnkUserGoods selectByPrimaryKey(String uiId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyLnkUserGoods record, @Param("example") YsyLnkUserGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyLnkUserGoods record, @Param("example") YsyLnkUserGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyLnkUserGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyLnkUserGoods record);
}