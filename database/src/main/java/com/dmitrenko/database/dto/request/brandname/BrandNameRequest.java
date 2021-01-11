package com.dmitrenko.database.dto.request.brandname;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@Validated
public class BrandNameRequest {

	@NotBlank(message = "The [name] parameter must be specified. ")
	private String name;
}
