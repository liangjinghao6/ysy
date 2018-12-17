package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.entity.YsyGoodsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsBrandMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String brandId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyGoodsBrand> selectByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyGoodsBrand selectByPrimaryKey(String brandId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyGoodsBrand record, @Param("example") YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyGoodsBrand record, @Param("example") YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyGoodsBrand record);
}