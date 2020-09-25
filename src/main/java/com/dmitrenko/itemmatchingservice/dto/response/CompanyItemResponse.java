package com.dmitrenko.itemmatchingservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.dmitrenko.itemmatchingservice.utils.Constant.ISO_DATE_TIME_PATTERN;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class CompanyItemResponse {

	private Long id;

	private String barcode;

	private String name;

	private ProductGroupResponse productGroup;

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime created;

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime modified;

}
