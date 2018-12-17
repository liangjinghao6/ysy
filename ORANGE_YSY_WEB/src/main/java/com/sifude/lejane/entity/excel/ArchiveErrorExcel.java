package com.sifude.lejane.entity.excel;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午7:09:34
 * 类说明
 */
public class ArchiveErrorExcel extends ArchiveImportExcel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1274721097038209531L;
	
	@Excel(name="错误原因", orderNum="20")
	private String reason;

	public ArchiveErrorExcel() {
	}
	
	public ArchiveErrorExcel(ArchiveImportExcel excel) {
		super(excel);
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
