package com.dmitrenko.database.dto.response.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.dmitrenko.database.util.Constant.ISO_DATE_TIME_PATTERN;

@Data
@Accessors(chain = true)
public class ModifiedStringResponse {
	private Long id;

	private String modifiable;
	private String modifying;

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime created;
	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime modified;
}
