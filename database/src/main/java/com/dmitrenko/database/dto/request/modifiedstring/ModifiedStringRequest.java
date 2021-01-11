package com.dmitrenko.database.dto.request.modifiedstring;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@Validated
public class ModifiedStringRequest {

	@NotBlank(message = "The [modifiable] parameter must be specified. ")
	private String modifiable;

	@NotBlank(message = "The [modifying] parameter must be specified. ")
	private String modifying;
}
