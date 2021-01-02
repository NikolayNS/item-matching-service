package com.dmitrenko.database.dto.request.brand;

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
public class BrandUpdateRequest {
	private Long id;
	private String name;
}
