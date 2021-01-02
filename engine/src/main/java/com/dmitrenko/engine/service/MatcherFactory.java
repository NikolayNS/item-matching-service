package com.dmitrenko.engine.service;

import com.dmitrenko.database.dto.view.MatcherDataView;

public interface MatcherFactory {
	Matcher get(MatcherDataView data);
}
