package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyGoodsBrand;
import com.orange.ysy.entity.YsyGoodsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyGoodsBrandMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String brandId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyGoodsBrand> selectByExample(YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyGoodsBrand selectByPrimaryKey(String brandId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyGoodsBrand record, @Param("example") YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyGoodsBrand record, @Param("example") YsyGoodsBrandExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyGoodsBrand record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyGoodsBrand record);
}