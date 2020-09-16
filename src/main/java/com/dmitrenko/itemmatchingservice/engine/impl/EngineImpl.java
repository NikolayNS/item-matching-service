package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.dto.request.engine.ItemsMatchingRequest;
import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;
import com.dmitrenko.itemmatchingservice.engine.Engine;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.engine.ComparedItemsViewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class EngineImpl implements Engine {

	private final ApplicationContext context;

	private final Map<Long, Object> activeTasks = new HashMap<>();
	private final AtomicLong taskId = new AtomicLong(1);

	@Override
	public Long run(ItemsMatchingRequest request) {

		var comparedItemsViewMapper = context.getBean(ComparedItemsViewMapper.class);
		var comparedItemsView = comparedItemsViewMapper.from(request.getCompetitorItems());

		return null;
	}

	@Override
	public boolean progress(TaskRequest request) {
		checkTask(request.getTaskId());

		return false;
	}

	private void checkTask(Long taskId) {
		if (activeTasks.get(taskId) == null) throw new InvalidParametersException("Task with id: " + taskId + " not found.");
	}

	@Override
	public ResultResponse get(TaskRequest request) {
		checkTask(request.getTaskId());

		return null;
	}

	@Override
	public void cancel(TaskRequest request) {
		checkTask(request.getTaskId());


	}
}
