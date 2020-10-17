package com.dmitrenko.itemmatchingservice.dto.view;

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
public class CompanyItemResultView {
	private Long id;
	private Long productGroup;
	private Double difference;
	private String companyItemName;
	private String modifiedCompanyItemName;
	private boolean byBarcode;
}
