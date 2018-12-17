package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkGoodsImage;
import com.orange.ysy.entity.YsyLnkGoodsImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkGoodsImageMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String giId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyLnkGoodsImage record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyLnkGoodsImage record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyLnkGoodsImage> selectByExample(YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyLnkGoodsImage selectByPrimaryKey(String giId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyLnkGoodsImage record, @Param("example") YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyLnkGoodsImage record, @Param("example") YsyLnkGoodsImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyLnkGoodsImage record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyLnkGoodsImage record);
}