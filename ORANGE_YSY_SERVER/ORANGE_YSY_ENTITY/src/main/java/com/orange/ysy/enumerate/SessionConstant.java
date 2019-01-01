package com.orange.ysy.enumerate;

public enum SessionConstant {
	VALIDATE_CODE("验证码", "validateCode"), USER("用户", "user"), LOCKTIMES("锁定次数", "locktimes");
	
	private String name;
	private String value;

	private SessionConstant(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}