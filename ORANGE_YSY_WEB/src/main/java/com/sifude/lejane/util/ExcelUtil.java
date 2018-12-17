package com.sifude.lejane.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;

import com.sifude.lejane.entity.excel.ArchiveErrorExcel;
import com.sifude.lejane.entity.excel.ArchiveImportExcel;
import com.sifude.tool.util.FileUtil;
import com.sifude.tool.util.JsonUtil;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午2:59:16
 * 类说明
 */
public class ExcelUtil {
	
	public static <T> List<T> importExcel(File file, Class<?> pojoClass) {
		ImportParams params = new ImportParams();
		params.setTitleRows(0);
		params.setHeadRows(1);
		params.setNeedSave(true);
		return ExcelImportUtil.importExcel(file, pojoClass, params);
	}

	public static <T> List<T> importExcel(String path, Class<?> pojoClass) {
		return importExcel(new File(path), pojoClass);
	}

	public static void exportExcel(String path, Class<?> pojoClass, List<?> errors) throws FileNotFoundException, IOException {
		ExportParams params = new ExportParams();
		Workbook book = ExcelExportUtil.exportExcel(params, pojoClass, errors);
		File targetPathFile = new File(StringUtils.substringBeforeLast(path, "/"));
		if (!targetPathFile.exists()) {
			targetPathFile.mkdirs();
		}
		book.write(new FileOutputStream(new File(path)));
	}
	
	public static void main(String args[]) {
		List<ArchiveImportExcel> e = ExcelUtil.importExcel("x:/MSP/lejane/file/archives/upload/20160329154947_467.xlsx", ArchiveImportExcel.class);
		System.out.println(JsonUtil.toJson(e));
	}

}
