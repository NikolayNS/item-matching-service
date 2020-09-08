package com.dmitrenko.itemmatchingservice.mapper.impl.response;

import com.dmitrenko.itemmatchingservice.domain.ReplacementWord;
import com.dmitrenko.itemmatchingservice.dto.response.ReplacementWordResponse;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplacementWordResponseMapper implements Mapper<ReplacementWordResponse, ReplacementWord> {

	@Override
	public ReplacementWordResponse from(ReplacementWord source) {
		return new ReplacementWordResponse()
			.setReplaceable(source.getReplaceable())
			.setReplacement(source.getReplacement());
	}
}
