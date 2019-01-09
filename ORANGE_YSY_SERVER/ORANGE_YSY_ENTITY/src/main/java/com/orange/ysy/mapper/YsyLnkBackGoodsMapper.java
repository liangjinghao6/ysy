package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkBackGoods;
import com.orange.ysy.entity.YsyLnkBackGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkBackGoodsMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyLnkBackGoods> selectByExample(YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyLnkBackGoods selectByPrimaryKey(String bgId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyLnkBackGoods record, @Param("example") YsyLnkBackGoodsExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyLnkBackGoods record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyLnkBackGoods record);
}