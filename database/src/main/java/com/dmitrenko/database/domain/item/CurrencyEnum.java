package com.dmitrenko.database.domain.item;

public enum CurrencyEnum {
	USD("USD"),
	EUR("EUR"),
	RUB("RUB"),
	GBP("GBP"),
	CAD("CAD");

	private final String value;

	CurrencyEnum(String value) {
		this.value = value;
	}

	public static CurrencyEnum fromValue(String value) {
		for (CurrencyEnum b : CurrencyEnum.values()) {
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
