package com.dmitrenko.engine.service.domain.impl;

public enum MatcherStatus {
	IDLE(false),
	RUNNING(false),
	FINISHED(true),
	FAILED(true),
	CANCELED(true);

	private final boolean finalStatus;

	MatcherStatus(boolean finalStatus) {
		this.finalStatus = finalStatus;
	}

	public boolean isFinalStatus() {
		return finalStatus;
	}
}
