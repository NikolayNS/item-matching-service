package com.dmitrenko.itemmatchingservice.mapper;

public interface Merger<T, S> {

	T merge(T target, S source);
}
