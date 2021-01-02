package com.dmitrenko.database.dto.request.task;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CompetitorItemRequest {
	private String barcode;
	private String name;
}
