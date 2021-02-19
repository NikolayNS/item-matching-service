package com.dmitrenko.database.domain.company;

public enum CompanyType {
	COSTCO("COSTCO"),
	TARGET("TARGET"),
	WHOLE_FOODS("WHOLE_FOODS"),
	WALLMART("WALLMART");

	private final String value;

	CompanyType(String value) {
		this.value = value;
	}

	public static CompanyType fromValue(String value) {
		for (CompanyType b : CompanyType.values()) {
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
