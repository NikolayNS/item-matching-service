package com.dmitrenko.database.domain.item;

public enum ItemType {
	MILK("MILK"),
	FRESH_MEAT("FRESH_MEAT"),
	FROZEN_MEAT("FROZEN_MEAT"),
	ALCOHOL("ALCOHOL"),
	SOFT_DRINKS("SOFT_DRINKS");

	private final String value;

	ItemType(String value) {
		this.value = value;
	}

	public static ItemType fromValue(String value) {
		for (ItemType b : ItemType.values()) {
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
