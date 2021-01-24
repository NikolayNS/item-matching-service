package com.dmitrenko.database.dto.request.item;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@Validated
public class ItemRequest {

	private String barcode;

	@NotBlank(message = "The [name] parameter must be specified. ")
	private String name;

	@NotBlank(message = "The [currency] parameter must be specified. ")
	private String currency;

	private BigDecimal cost;

	@NotNull
	private Long typeID;
}
