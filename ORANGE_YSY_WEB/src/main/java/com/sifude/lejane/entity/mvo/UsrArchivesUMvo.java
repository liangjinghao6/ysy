package com.sifude.lejane.entity.mvo;
/**
 * @author 梁景皓
 * @version 创建时间：2016年3月28日 下午6:26:36
 * 类说明
 */
public class UsrArchivesUMvo {
	public int total;
	public int success;
	public int fail;
	public String errorName;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
}
