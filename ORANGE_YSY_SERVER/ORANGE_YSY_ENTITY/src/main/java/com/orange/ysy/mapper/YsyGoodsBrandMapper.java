package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.entity.YsyGoodsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsBrandMapper {
    /**
     *
     * @mbg.generated 2019-01-11
     */
    long countByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int deleteByPrimaryKey(String brandId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insert(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int insertSelective(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    List<YsyGoodsBrand> selectByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    YsyGoodsBrand selectByPrimaryKey(String brandId);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExampleSelective(@Param("record") YsyGoodsBrand record, @Param("example") YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByExample(@Param("record") YsyGoodsBrand record, @Param("example") YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKeySelective(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2019-01-11
     */
    int updateByPrimaryKey(YsyGoodsBrand record);
}