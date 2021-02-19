package com.dmitrenko.database.domain.user;

public enum UserType {
	ADMIN("ADMIN"),
	USER("USER");

	private final String value;

	UserType(String value) {
		this.value = value;
	}

	public static UserType fromValue(String value) {
		for (UserType b : UserType.values()) {
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
