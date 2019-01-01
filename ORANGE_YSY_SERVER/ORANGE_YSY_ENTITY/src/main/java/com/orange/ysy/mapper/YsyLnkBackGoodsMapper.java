package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkBackGoods;
import com.orange.ysy.entity.YsyLnkBackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkBackGoodsMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyLnkBackGoods> selectByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyLnkBackGoods selectByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyLnkBackGoods record);
}