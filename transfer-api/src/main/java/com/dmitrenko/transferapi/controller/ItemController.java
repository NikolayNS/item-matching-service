package com.dmitrenko.transferapi.controller;

import com.dmitrenko.transferapi.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

	public static final String COMPANY_ITEM_ADD = "/api/v1/company-item/add";
	public static final String COMPANY_ITEM_GET = "/api/v1/company-item/get";
	public static final String COMPANY_ITEM_GET_ALL = "/api/v1/company-item/get-all";
	public static final String COMPANY_ITEM_UPDATE = "/api/v1/company-item/update";
	public static final String COMPANY_ITEM_DELETE = "/api/v1/company-item/delete";
	public static final String COMPANY_ITEM_DELETE_ALL = "/api/v1/company-item/delete-all";

	private final TransferService transferService;


}
