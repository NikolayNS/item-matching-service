package com.dmitrenko.itemmatchingservice.dto.request.engine;

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
public class CompetitorItem {
	private String barcode;
	private String name;
}
