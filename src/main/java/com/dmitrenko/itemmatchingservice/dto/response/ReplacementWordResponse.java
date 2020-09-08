package com.dmitrenko.itemmatchingservice.dto.response;

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
public class ReplacementWordResponse {
	private String replaceable;
	private String replacement;
}
