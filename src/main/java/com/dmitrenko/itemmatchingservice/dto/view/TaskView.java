package com.dmitrenko.itemmatchingservice.dto.view;

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
public class TaskView {
	private Long id;
	private TaskPropertyView property;
	private List<CompetitorItemView> items;
}
