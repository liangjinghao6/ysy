package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkBackGoods;
import com.orange.ysy.entity.YsyLnkBackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkBackGoodsMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyLnkBackGoods> selectByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyLnkBackGoods selectByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyLnkBackGoods record);
}