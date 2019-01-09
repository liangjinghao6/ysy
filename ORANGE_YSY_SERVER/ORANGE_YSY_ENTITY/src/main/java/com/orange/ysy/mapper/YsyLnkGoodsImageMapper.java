package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkGoodsImage;
import com.orange.ysy.entity.YsyLnkGoodsImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkGoodsImageMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String giId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyLnkGoodsImage record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyLnkGoodsImage record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyLnkGoodsImage> selectByExample(YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyLnkGoodsImage selectByPrimaryKey(String giId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyLnkGoodsImage record, @Param("example") YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyLnkGoodsImage record, @Param("example") YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyLnkGoodsImage record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyLnkGoodsImage record);
}