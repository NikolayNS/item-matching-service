package com.dmitrenko.itemmatchingservice.mapper.impl.view;

import com.dmitrenko.itemmatchingservice.dto.view.NgramView;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import com.dmitrenko.itemmatchingservice.utils.CharState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.dmitrenko.itemmatchingservice.utils.CharState.AFTER_CHARS;
import static com.dmitrenko.itemmatchingservice.utils.CharState.BEGIN;

@Service
@RequiredArgsConstructor
public class NgramViewMapper implements Mapper<NgramView, String> {

	@Override
	public NgramView from(String source) {
		return new NgramView()
			.setGrams(source == null ? Collections.emptyList() : getGrams(source));
	}

	private List<Long> getGrams(String source) {
		List<Character> sourceChars = source.chars()
			.mapToObj(c -> (char) c)
			.collect(Collectors.toList());

		AtomicInteger left = new AtomicInteger(0);

		CharState state = BEGIN;

		for (Character character : sourceChars) {
			switch (state) {
				case BEGIN -> {
					if ('А' <= character && character <= 'Я') {
						state = AFTER_CHARS;
						break;
					}
				}
				case AFTER_CHARS -> {}
				case TO_POINT -> {}
				case AFTER_POINT -> {}
				default -> throw new IllegalStateException("Unexpected value: " + state);
			}
		}

		List<Long> grams = new LinkedList<>();

		Collections.sort(grams);
		return grams;
	}
}
