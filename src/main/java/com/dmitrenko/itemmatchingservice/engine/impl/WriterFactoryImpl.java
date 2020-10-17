package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.dto.view.WriterDataView;
import com.dmitrenko.itemmatchingservice.engine.Writer;
import com.dmitrenko.itemmatchingservice.engine.WriterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriterFactoryImpl implements WriterFactory {

	@Override
	public Writer get(WriterDataView data) {
		return null;
	}
}
