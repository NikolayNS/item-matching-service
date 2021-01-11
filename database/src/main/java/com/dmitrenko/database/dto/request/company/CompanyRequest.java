package com.dmitrenko.database.dto.request.company;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Validated
public class CompanyRequest {

	@NotBlank(message = "The [name] parameter must be specified. ")
	private String name;

	@NotNull(message = "The [typeId] parameter shouldn't be null")
	@Min(1)
	private Long typeId;
}
