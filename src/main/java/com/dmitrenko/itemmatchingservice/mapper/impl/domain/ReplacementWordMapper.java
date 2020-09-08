package com.dmitrenko.itemmatchingservice.mapper.impl.domain;

import com.dmitrenko.itemmatchingservice.domain.ReplacementWord;
import com.dmitrenko.itemmatchingservice.dto.request.add.ReplacementWordAddRequest;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplacementWordMapper implements Mapper<ReplacementWord, ReplacementWordAddRequest> {

	@Override
	public ReplacementWord from(ReplacementWordAddRequest source) {
		return new ReplacementWord()
			.setReplaceable(source.getReplaceable())
			.setReplacement(source.getReplacement());
	}
}
