package com.dmitrenko.database.dto.request.reference;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Validated
public class ReferenceRequest {
	@NotNull
	private String name;

	@NotNull
	private Long typeId;
}
