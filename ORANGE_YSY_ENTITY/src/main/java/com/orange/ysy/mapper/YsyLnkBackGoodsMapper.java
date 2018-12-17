package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkBackGoods;
import com.orange.ysy.entity.YsyLnkBackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkBackGoodsMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyLnkBackGoods> selectByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyLnkBackGoods selectByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyLnkBackGoods record);
}