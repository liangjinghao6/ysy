package com.sifude.lejane.status;

public enum UserType {
	MEMBER("会员", "-2"), EMPLOYEE("员工", "-1"), SUPER_OPERATOR("超级管理员", "0"),
	COMPAMY_OPERATOR("分公司管理员", "1"), STORE_OPERATOR("店长", "2"), STORE_VICE_OPEARTOR("副店长", "3")
	;
	private String name;
	private String value;

	private UserType(String name, String value) {
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
