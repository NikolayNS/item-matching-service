package com.dmitrenko.engine.service;

import com.dmitrenko.database.dto.view.MatcherDataView;
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
