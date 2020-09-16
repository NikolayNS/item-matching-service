package com.dmitrenko.itemmatchingservice.dto.request.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class CompanyItemUpdateRequest {
	private Long id;
	private String barcode;
	private String name;
	private Long productGroupId;
}