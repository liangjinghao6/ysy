package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsyLnkGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkGoodsClassMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String gcId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsyLnkGoodsClass> selectByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsyLnkGoodsClass selectByPrimaryKey(String gcId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsyLnkGoodsClass record, @Param("example") YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsyLnkGoodsClass record, @Param("example") YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsyLnkGoodsClass record);
}