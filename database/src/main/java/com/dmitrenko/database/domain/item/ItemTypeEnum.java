package com.dmitrenko.database.domain.item;

public enum ItemTypeEnum {
	MILK("MILK"),
	FRESH_MEAT("FRESH_MEAT"),
	FROZEN_MEAT("FROZEN_MEAT"),
	ALCOHOL("ALCOHOL"),
	SOFT_DRINKS("SOFT_DRINKS");

	private final String value;

	ItemTypeEnum(String value) {
		this.value = value;
	}

	public static ItemTypeEnum fromValue(String value) {
		for (ItemTypeEnum b : ItemTypeEnum.values()) {
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
