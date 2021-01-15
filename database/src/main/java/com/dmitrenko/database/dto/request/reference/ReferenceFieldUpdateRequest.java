package com.dmitrenko.database.dto.request.reference;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@Validated
public class ReferenceFieldUpdateRequest {

	@NotNull(message = "The [id] parameter shouldn't be null")
	@Min(1)
	private Long id;

	@NotBlank(message = "The [barcode] parameter must be specified. ")
	private String barcode;

	@NotBlank(message = "The [name] parameter must be specified. ")
	private String name;

	@NotNull(message = "The [referenceId] parameter shouldn't be null")
	@Min(1)
	private Long referenceId;
}
