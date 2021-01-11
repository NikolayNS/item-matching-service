package com.dmitrenko.database.dto.request.modifiedstring;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Accessors(chain = true)
@Validated
public class ModifiedStringsRequest {

	@NotEmpty(message = "The [modifiedStrings] parameter must contain elements. ")
	private List<@Valid ModifiedStringRequest> modifiedStrings;
}
