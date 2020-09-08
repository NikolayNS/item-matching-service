package com.dmitrenko.itemmatchingservice.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class ItemMatchingRequest {
	private List<CompetitorItem> competitorItems;

}
