package com.dmitrenko.itemmatchingservice.mapper.impl.response;

import com.dmitrenko.itemmatchingservice.dto.response.ResultResponse;
import com.dmitrenko.itemmatchingservice.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultResponseMapper implements Mapper<ResultResponse, Object> {

	@Override
	public ResultResponse from(Object source) {
		return null;
	}
}
