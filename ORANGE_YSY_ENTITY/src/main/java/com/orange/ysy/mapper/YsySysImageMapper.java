package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsySysImage;
import com.orange.ysy.entity.YsySysImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsySysImageMapper {
    /**
     *
     * @mbg.generated 2018-12-17
     */
    long countByExample(YsySysImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByExample(YsySysImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int deleteByPrimaryKey(String fileId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insert(YsySysImage record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int insertSelective(YsySysImage record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    List<YsySysImage> selectByExample(YsySysImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    YsySysImage selectByPrimaryKey(String fileId);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExampleSelective(@Param("record") YsySysImage record, @Param("example") YsySysImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByExample(@Param("record") YsySysImage record, @Param("example") YsySysImageExample example);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKeySelective(YsySysImage record);

    /**
     *
     * @mbg.generated 2018-12-17
     */
    int updateByPrimaryKey(YsySysImage record);
}