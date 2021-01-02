package com.dmitrenko.database.dto.response.reference;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.dmitrenko.database.util.Constant.ISO_DATE_TIME_PATTERN;

@Data
@Accessors(chain = true)
public class ReferenceFieldResponse {
	private Long id;

	private String barcode;
	private String name;
	private ReferenceResponse reference;

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime created;
	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime modified;
}
