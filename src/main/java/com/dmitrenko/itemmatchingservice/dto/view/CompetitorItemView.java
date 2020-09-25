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
public class CompetitorItemView {
	private String barcode;
	private String name;
	private NgramView ngrams;
}
