package com.sifude.lejane.status;

public enum CompanyLevelStatus {
	SUPER("斯福德", 0), LEVE_ONE_COMPANY("一级机构", 1), LEVE_TWO_COMPANY("二级机构", 2), LEVE_THREE_COMPANY("三级机构", 3);
	
	private String name;
	private Integer value;

	private CompanyLevelStatus(String name, Integer value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
