package com.dmitrenko.itemmatchingservice.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.concurrent.BlockingQueue;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class WriterDataView {
	private TaskView taskView;
	private BlockingQueue<ItemResultView> cache;
}
