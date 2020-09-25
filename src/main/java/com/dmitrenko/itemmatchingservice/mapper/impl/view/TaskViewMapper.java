package com.dmitrenko.itemmatchingservice.mapper.impl.view;


import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskAddRequest;
import com.dmitrenko.itemmatchingservice.dto.view.TaskView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskViewMapper implements Mapper<TaskView, TaskAddRequest> {

	private ApplicationContext context;

	@Override
	public TaskView from(TaskAddRequest source) {
		var competitorItemsViewMapper = context.getBean(CompetitorItemsViewMapper.class);
		var taskPropertyViewMapper = context.getBean(TaskPropertyViewMapper.class);

		return new TaskView()
			.setProperty(taskPropertyViewMapper.from(source.getTaskProperty()))
			.setItems(competitorItemsViewMapper.from(source.getItems()));
	}
}
