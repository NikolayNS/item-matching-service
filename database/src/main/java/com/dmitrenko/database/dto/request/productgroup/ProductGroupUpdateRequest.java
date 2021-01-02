package com.dmitrenko.database.dto.request.productgroup;

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
public class ProductGroupUpdateRequest {
	private Long id;
	private Long groupIndex;
	private String name;
}
