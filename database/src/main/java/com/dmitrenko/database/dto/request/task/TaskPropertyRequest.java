package com.dmitrenko.database.dto.request.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@ApiModel(value = "Task property")
@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class TaskPropertyRequest {

	@ApiModelProperty(value = "Product group IDs used for match", position = 1)
	private List<Long> productGroups = new LinkedList<>();
}
