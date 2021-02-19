package com.dmitrenko.database.domain.item;

public enum Currency {
	USD("USD"),
	EUR("EUR"),
	RUB("RUB"),
	GBP("GBP"),
	CAD("CAD");

	private final String value;

	Currency(String value) {
		this.value = value;
	}

	public static Currency fromValue(String value) {
		for (Currency b : Currency.values()) {
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
