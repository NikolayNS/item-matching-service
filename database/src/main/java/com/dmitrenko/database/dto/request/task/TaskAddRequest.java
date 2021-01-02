package com.dmitrenko.database.dto.request.task;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
public class TaskAddRequest {
	private TaskPropertyRequest taskProperty;
	private List<CompetitorItemRequest> items = new LinkedList<>();
}
