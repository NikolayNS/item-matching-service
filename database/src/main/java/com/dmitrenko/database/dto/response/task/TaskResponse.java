package com.dmitrenko.database.dto.response.task;

import com.dmitrenko.database.dto.response.user.UserResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.dmitrenko.database.util.Constant.ISO_DATE_TIME_PATTERN;

@Data
@Accessors(chain = true)
public class TaskResponse {
	private Long id;

	private UserResponse user;
	private TaskTypeResponse type;
	private TaskPropertyResponse property;

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime created;
	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime modified;
}
