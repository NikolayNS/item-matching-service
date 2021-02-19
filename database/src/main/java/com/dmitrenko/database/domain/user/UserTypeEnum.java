package com.dmitrenko.database.domain.user;

public enum UserTypeEnum {
	ADMIN("ADMIN"),
	USER("USER");

	private final String value;

	UserTypeEnum(String value) {
		this.value = value;
	}

	public static UserTypeEnum fromValue(String value) {
		for (UserTypeEnum b : UserTypeEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

	public String getValue() {
		return value;
	}
}
