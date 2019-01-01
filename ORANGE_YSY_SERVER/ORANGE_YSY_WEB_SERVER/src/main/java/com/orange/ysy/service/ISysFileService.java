package com.orange.ysy.service;

import com.orange.ysy.entity.PageBean;
import com.orange.ysy.entity.YsySysFile;

/**
* @author 梁景皓
* @date 2018-12-24
*/
public interface ISysFileService {
	
	Integer deleteById(String id);

	Integer updateSysFile(YsySysFile user);

	Integer addSysFile(YsySysFile user);

	PageBean<YsySysFile> findSysFile(String q, Integer page, Integer limit);

	YsySysFile detailSysFile(String id);
}
