package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsyLnkGoodsClass;
import com.orange.ysy.entity.YsyLnkGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsyLnkGoodsClassMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String gcId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsyLnkGoodsClass> selectByExample(YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsyLnkGoodsClass selectByPrimaryKey(String gcId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsyLnkGoodsClass record, @Param("example") YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsyLnkGoodsClass record, @Param("example") YsyLnkGoodsClassExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsyLnkGoodsClass record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsyLnkGoodsClass record);
}