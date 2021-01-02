package com.dmitrenko.engine.service;

import com.dmitrenko.database.dto.view.WriterDataView;
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
