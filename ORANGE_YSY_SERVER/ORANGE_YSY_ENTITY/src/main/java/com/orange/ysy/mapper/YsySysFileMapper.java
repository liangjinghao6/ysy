package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.entity.YsySysFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsySysFileMapper {
    /**
     *
     * @mbg.generated 2018-12-24
     */
    long countByExample(YsySysFileExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByExample(YsySysFileExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int deleteByPrimaryKey(String fileId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insert(YsySysFile record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int insertSelective(YsySysFile record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    List<YsySysFile> selectByExample(YsySysFileExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    YsySysFile selectByPrimaryKey(String fileId);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExampleSelective(@Param("record") YsySysFile record, @Param("example") YsySysFileExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByExample(@Param("record") YsySysFile record, @Param("example") YsySysFileExample example);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKeySelective(YsySysFile record);

    /**
     *
     * @mbg.generated 2018-12-24
     */
    int updateByPrimaryKey(YsySysFile record);
}