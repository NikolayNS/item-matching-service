package com.dmitrenko.database.dto.response.reference;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.dmitrenko.database.util.Constant.ISO_DATE_TIME_PATTERN;

@Data
@Accessors(chain = true)
public class ReferenceResponse {
	private Long id;

	private String name;
	private ReferenceTypeResponse type;

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime created;
	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime modified;
}
