package com.dmitrenko.database.dto.request.company;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class CompanyTypeRequest {

	@NotBlank(message = "The [name] parameter must be specified. ")
	private String name;

	@NotBlank(message = "The [description] parameter must be specified. ")
	private String description;
}
