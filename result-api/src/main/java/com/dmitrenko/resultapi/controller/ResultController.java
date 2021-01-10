package com.dmitrenko.resultapi.controller;

import com.dmitrenko.resultapi.service.ResultApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResultController {

	private final ResultApiService resultApiService;
}
