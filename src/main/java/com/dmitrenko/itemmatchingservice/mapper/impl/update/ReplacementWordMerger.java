package com.dmitrenko.itemmatchingservice.mapper.impl.update;

import com.dmitrenko.itemmatchingservice.domain.ReplacementWord;
import com.dmitrenko.itemmatchingservice.dto.request.update.ReplacementWordUpdateRequest;
import com.dmitrenko.itemmatchingservice.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplacementWordMerger implements Merger<ReplacementWord, ReplacementWordUpdateRequest> {

	@Override
	public ReplacementWord merge(ReplacementWord target, ReplacementWordUpdateRequest source) {
		return target
			.setReplaceable(source.getReplaceable())
			.setReplacement(source.getReplacement());
	}
}
