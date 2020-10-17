package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.engine.Matcher;
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
