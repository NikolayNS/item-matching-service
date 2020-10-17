package com.dmitrenko.itemmatchingservice.dto.view;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class TaskView {

	@EqualsAndHashCode.Include
	private String name;

	private TaskPropertyView property;
	private List<CompetitorItemView> items;
}
