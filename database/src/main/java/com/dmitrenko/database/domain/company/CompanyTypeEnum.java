package com.dmitrenko.database.domain.company;

public enum CompanyTypeEnum {
	COSTCO("COSTCO"),
	TARGET("TARGET"),
	WHOLE_FOODS("WHOLE_FOODS"),
	WALLMART("WALLMART");

	private final String value;

	CompanyTypeEnum(String value) {
		this.value = value;
	}

	public static CompanyTypeEnum fromValue(String value) {
		for (CompanyTypeEnum b : CompanyTypeEnum.values()) {
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
