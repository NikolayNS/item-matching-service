package com.dmitrenko.itemmatchingservice.engine;

import com.dmitrenko.itemmatchingservice.dto.view.MatcherDataView;

public interface MatcherFactory {
	Matcher get(MatcherDataView data);
}
