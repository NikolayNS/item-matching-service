package com.dmitrenko.database.domain.task;

public enum TaskType {
	DEFAULT("DEFAULT");

	private final String value;

	TaskType(String value) {
		this.value = value;
	}

	public static TaskType fromValue(String value) {
		for (TaskType b : TaskType.values()) {
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
