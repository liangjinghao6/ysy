package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsyLnkGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkGoodsClassMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String gcId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsyLnkGoodsClass> selectByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsyLnkGoodsClass selectByPrimaryKey(String gcId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsyLnkGoodsClass record, @Param("example") YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsyLnkGoodsClass record, @Param("example") YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsyLnkGoodsClass record);
}