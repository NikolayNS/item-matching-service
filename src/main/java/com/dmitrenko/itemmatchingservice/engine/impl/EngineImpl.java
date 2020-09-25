package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;
import com.dmitrenko.itemmatchingservice.dto.response.TaskProgressResponse;
import com.dmitrenko.itemmatchingservice.dto.view.ResultView;
import com.dmitrenko.itemmatchingservice.dto.view.TaskView;
import com.dmitrenko.itemmatchingservice.engine.Engine;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.view.TaskViewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
@RequiredArgsConstructor
public class EngineImpl implements Engine {

	private final ApplicationContext context;

	private final AtomicLong taskIdCounter = new AtomicLong(1);

	private final Map<Long, TaskView> taskQueue = new HashMap<>();
	private final Map<Long, ItemMatcher> activeMatchers = new HashMap<>();
	private final Map<Long, ResultView> taskResults = new HashMap<>();

	@Override
	public Long add(TaskAddRequest request) {

		var taskViewMapper = context.getBean(TaskViewMapper.class);
		var taskView = taskViewMapper.from(request);


		taskView.setId(taskIdCounter.getAndIncrement());

		taskQueue.put(taskView.getId(), taskView);

		return taskView.getId();
	}

	@Scheduled(initialDelay = 5000, fixedDelay = 5000)
	@Override
	@Transactional
	public void run() {

	}

	@Override
	public TaskProgressResponse progress(TaskRequest request) {
		checkProgress(request.getTaskId());

		return null;
	}

	private void checkProgress(Long taskId) {
		if (activeMatchers.get(taskId) == null) throw new InvalidParametersException("Task with id: " + taskId + " not active yet.");
	}

	@Override
	public ResultResponse get(TaskRequest request) {
		checkResult(request.getTaskId());

		return null;
	}

	private void checkResult(Long taskId) {
		if (taskResults.get(taskId) == null) throw new InvalidParametersException("Task with id: " + taskId + " not ending yet.");
	}

	@Override
	public boolean cancel(TaskRequest request) {


		return false;
	}
}
