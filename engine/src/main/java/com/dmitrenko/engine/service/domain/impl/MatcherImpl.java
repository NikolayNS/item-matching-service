package com.dmitrenko.engine.service.domain.impl;

import com.dmitrenko.engine.service.domain.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatcherImpl implements Matcher {

	private boolean isCanceled;


	@Override
	public void run() {

	}

	@Override
	public void cancel() {
		this.isCanceled = true;
	}
}
