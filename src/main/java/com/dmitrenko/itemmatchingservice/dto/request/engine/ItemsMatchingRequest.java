package com.dmitrenko.itemmatchingservice.dto.request.engine;

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
public class ItemsMatchingRequest {
	private List<Long> productGroups = new LinkedList<>();
	private List<CompetitorItem> competitorItems = new LinkedList<>();
}
