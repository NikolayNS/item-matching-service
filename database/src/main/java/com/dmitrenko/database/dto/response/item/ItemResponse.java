package com.dmitrenko.database.dto.response.item;

import com.dmitrenko.database.dto.response.company.CompanyResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.dmitrenko.database.util.Constant.ISO_DATE_TIME_PATTERN;

@Data
@Accessors(chain = true)
public class ItemResponse {
	private Long id;

	private String barcode;
	private String originalName;
	private String modifiedName;
	private PriceResponse price;
	private ItemTypeResponse type;
	private CompanyResponse company;
	private BrandNameResponse brandName;
	private List<ModifiedStringResponse> modifiedStrings = Collections.emptyList();

	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime created;
	@JsonFormat(pattern = ISO_DATE_TIME_PATTERN)
	private LocalDateTime modified;
}
