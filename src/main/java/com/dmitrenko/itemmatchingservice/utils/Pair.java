package com.dmitrenko.itemmatchingservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Accessors(chain = true)
public class Pair<L, R> {
	private L left;
	private R right;
}
