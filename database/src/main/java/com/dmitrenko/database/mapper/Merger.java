package com.dmitrenko.database.mapper;

public interface Merger<T, S> {

	T merge(T target, S source);
}
