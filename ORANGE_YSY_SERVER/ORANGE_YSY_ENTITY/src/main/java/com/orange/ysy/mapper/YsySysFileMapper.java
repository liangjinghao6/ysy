package com.orange.ysy.mapper;

import com.orange.ysy.entity.YsySysFile;
import com.orange.ysy.entity.YsySysFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YsySysFileMapper {
    /**
     *
     * @mbg.generated 2019-01-09
     */
    long countByExample(YsySysFileExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByExample(YsySysFileExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int deleteByPrimaryKey(String fileId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insert(YsySysFile record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int insertSelective(YsySysFile record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    List<YsySysFile> selectByExample(YsySysFileExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    YsySysFile selectByPrimaryKey(String fileId);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExampleSelective(@Param("record") YsySysFile record, @Param("example") YsySysFileExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByExample(@Param("record") YsySysFile record, @Param("example") YsySysFileExample example);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKeySelective(YsySysFile record);

    /**
     *
     * @mbg.generated 2019-01-09
     */
    int updateByPrimaryKey(YsySysFile record);
}