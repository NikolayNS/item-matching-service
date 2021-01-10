package com.dmitrenko.database.dto.request.brandname;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Accessors(chain = true)
public class BrandNamesAddRequest {

	@NotEmpty(message = "The [brandNames] parameter must contain elements. ")
	private List<@Valid BrandNameRequest> brandNames;
}
