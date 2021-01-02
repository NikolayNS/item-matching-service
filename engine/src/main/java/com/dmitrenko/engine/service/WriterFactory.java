package com.dmitrenko.engine.service;

import com.dmitrenko.database.dto.view.WriterDataView;

public interface WriterFactory {
	Writer get(WriterDataView data);
}
