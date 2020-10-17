package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.dto.view.MatcherDataView;
import com.dmitrenko.itemmatchingservice.engine.Matcher;
import com.dmitrenko.itemmatchingservice.engine.MatcherFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatcherFactoryImpl implements MatcherFactory {

	@Override
	public Matcher get(MatcherDataView data) {
		return null;
	}
}
