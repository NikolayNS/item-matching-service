package com.dmitrenko.itemmatchingservice.engine.impl;

import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskAddRequest;
import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;
import com.dmitrenko.itemmatchingservice.dto.response.TaskProgressResponse;
import com.dmitrenko.itemmatchingservice.dto.view.MatcherDataView;
import com.dmitrenko.itemmatchingservice.dto.view.ItemResultView;
import com.dmitrenko.itemmatchingservice.dto.view.TaskView;
import com.dmitrenko.itemmatchingservice.dto.view.WriterDataView;
import com.dmitrenko.itemmatchingservice.engine.JobEngine;
import com.dmitrenko.itemmatchingservice.engine.Matcher;
import com.dmitrenko.itemmatchingservice.engine.MatcherFactory;
import com.dmitrenko.itemmatchingservice.engine.Writer;
import com.dmitrenko.itemmatchingservice.engine.WriterFactory;
import com.dmitrenko.itemmatchingservice.exception.InvalidParametersException;
import com.dmitrenko.itemmatchingservice.mapper.impl.view.TaskViewMapper;
import com.dmitrenko.itemmatchingservice.utils.Pair;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobEngineImpl implements JobEngine {

	private final ApplicationContext context;
	private final MatcherFactory matcherFactory;
	private final WriterFactory writerFactory;

	@Qualifier("JobEngineTaskExecutor")
	private final ThreadPoolTaskExecutor executor;

	@Value("${jobengine.max-active-task}")
	private final int maxActiveTask;

	private final BlockingQueue<TaskView> taskQueue = new LinkedBlockingQueue<>();

	private final Map<String, Pair<Matcher, Writer>> activeTask = new HashMap<>();

	@SneakyThrows(InterruptedException.class)
	@Override
	public String add(TaskAddRequest request) {

		var taskViewMapper = context.getBean(TaskViewMapper.class);
		var taskView = taskViewMapper.from(request);

		while (taskQueue.offer(taskView)) {
			//noinspection BusyWait
			Thread.sleep(10);
		}

		return taskView.getName();
	}

	@SneakyThrows(InterruptedException.class)
	@Scheduled(initialDelay = 5000, fixedDelay = 5000)
	@Transactional
	public void run() {
		if (activeTask.size() >= maxActiveTask) return;

		TaskView taskView = taskQueue.take();
		BlockingQueue<ItemResultView> cache = new LinkedBlockingQueue<>();

		var matcher = matcherFactory.get(new MatcherDataView()
			.setTaskView(taskView)
			.setCache(cache));
		var writer = writerFactory.get(new WriterDataView()
			.setTaskView(taskView)
			.setCache(cache));

		activeTask.put(taskView.getName(), new Pair<>(matcher, writer));

		executor.execute(matcher);
		executor.execute(writer);
	}

	@Override
	public TaskProgressResponse progress(TaskRequest request) {
		var taskView = taskQueue
			.stream()
			.filter(o -> o.getName().equals(request.getName()))
			.findFirst();

		return taskView.isPresent()
			? getProgressFromQueue(taskView.get())
			: getProgressFromMap(request.getName());
	}

	private TaskProgressResponse getProgressFromQueue(TaskView taskView) {
		return new TaskProgressResponse()
			.setActive(false)
			.setExpect((long) taskView.getItems().size())
			.setDone(0L);
	}

	private TaskProgressResponse getProgressFromMap(String taskName) {
		checkMap(taskName);

		var matcher = activeTask.get(taskName).getLeft();

		return new TaskProgressResponse()
			.setActive(true)
			.setExpect(matcher);
	}

	private void checkMap(String taskName) {
		if (!activeTask.containsKey(taskName)) {
			throw new InvalidParametersException("Task with name: " + taskName + " doesn't exist");
		}
	}

	@Override
	public ResultResponse get(TaskRequest request) {

		return null;
	}

	@Override
	public boolean cancel(TaskRequest request) {

		return false;
	}
}
