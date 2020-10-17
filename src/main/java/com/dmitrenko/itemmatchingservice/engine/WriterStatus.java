package com.dmitrenko.itemmatchingservice.engine;

public enum WriterStatus {
	IDLE(false),
	RUNNING(false),
	FINISHED(true),
	FAILED(true),
	CANCELED(true);

	private final boolean finalStatus;

	WriterStatus(boolean finalStatus) {
		this.finalStatus = finalStatus;
	}

	public boolean isFinalStatus() {
		return finalStatus;
	}
}
