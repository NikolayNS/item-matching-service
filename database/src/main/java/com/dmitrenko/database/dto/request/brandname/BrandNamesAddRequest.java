package com.dmitrenko.database.dto.request.brandname;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class BrandNamesAddRequest {
	List<BrandNameRequest> brandNames;
}
