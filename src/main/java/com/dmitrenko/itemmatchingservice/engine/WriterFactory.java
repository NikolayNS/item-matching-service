package com.dmitrenko.itemmatchingservice.engine;

import com.dmitrenko.itemmatchingservice.dto.view.WriterDataView;

public interface WriterFactory {
	Writer get(WriterDataView data);
}
