package com.dmitrenko.itemmatchingservice.mapper.impl.view;

import com.dmitrenko.itemmatchingservice.dto.request.engine.TaskPropertyRequest;
import com.dmitrenko.itemmatchingservice.dto.view.TaskPropertyView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskPropertyViewMapper implements Mapper<TaskPropertyView, TaskPropertyRequest> {

	@Override
	public TaskPropertyView from(TaskPropertyRequest source) {
		return new TaskPropertyView()
			.setProductGroups(source.getProductGroups());
	}
}
