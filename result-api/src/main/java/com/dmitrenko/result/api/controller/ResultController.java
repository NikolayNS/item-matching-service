package com.dmitrenko.result.api.controller;

import com.dmitrenko.result.api.service.ResultApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResultController {

	private final ResultApiService resultApiService;
}
