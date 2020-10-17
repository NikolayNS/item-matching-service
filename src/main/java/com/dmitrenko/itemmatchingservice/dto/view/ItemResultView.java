package com.dmitrenko.itemmatchingservice.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class ItemResultView {
	private String competitorItemName;
	private String modifiedCompetitorItemName;
	private List<CompanyItemResultView> companyItems = new LinkedList<>();
}
