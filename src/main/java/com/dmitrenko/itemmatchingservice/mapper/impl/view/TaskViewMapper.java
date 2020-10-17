package com.dmitrenko.itemmatchingservice.mapper.impl.view;


import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskAddRequest;
import com.dmitrenko.itemmatchingservice.dto.view.TaskView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.dmitrenko.itemmatchingservice.utils.Constant.ISO_DATE_TIME_PATTERN;

@Service
@RequiredArgsConstructor
public class TaskViewMapper implements Mapper<TaskView, TaskAddRequest> {

	private ApplicationContext context;

	@Override
	public TaskView from(TaskAddRequest source) {
		var competitorItemsViewMapper = context.getBean(CompetitorItemsViewMapper.class);
		var taskPropertyViewMapper = context.getBean(TaskPropertyViewMapper.class);

		return new TaskView()
			.setName(LocalDateTime.now().format(DateTimeFormatter.ofPattern(ISO_DATE_TIME_PATTERN)))
			.setProperty(taskPropertyViewMapper.from(source.getTaskProperty()))
			.setItems(competitorItemsViewMapper.from(source.getItems()));
	}
}
