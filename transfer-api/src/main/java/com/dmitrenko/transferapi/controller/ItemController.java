package com.dmitrenko.transferapi.controller;

import com.dmitrenko.transferapi.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

	public static final String ITEM_ADD = "/api/v1/item";
	public static final String ITEMS = "/api/v1/items";
	public static final String ITEM = "/api/v1/item/{itemId}";
	public static final String ITEM_TYPE_ADD = "/api/v1/item/type";
	public static final String ITEM_TYPES = "/api/v1/item/types";
	public static final String ITEM_TYPE = "/api/v1/item/type/{itemId}";
	public static final String ITEM_CURRENCY_ADD = "/api/v1/item/currency";
	public static final String ITEM_CURRENCIES = "/api/v1/item/currencies";
	public static final String ITEM_CURRENCY = "/api/v1/item/currency/{currencyId}";

	private final TransferService transferService;


}
