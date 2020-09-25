package com.dmitrenko.itemmatchingservice.dto.request.engine;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@ApiModel(value = "Task add request to queue")
@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class TaskAddRequest {

	@ApiModelProperty(value = "Property used for match", position = 1)
	private TaskPropertyRequest taskProperty;

	@ApiModelProperty(value = "Product group IDs used for match", position = 1)
	private List<CompetitorItemRequest> items = new LinkedList<>();
}
