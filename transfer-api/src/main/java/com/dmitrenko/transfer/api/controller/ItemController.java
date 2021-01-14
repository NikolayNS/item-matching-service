package com.dmitrenko.transfer.api.controller;

import com.dmitrenko.database.dto.request.item.CurrencyAddRequest;
import com.dmitrenko.database.dto.request.item.CurrencyUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemAddRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeAddRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemUpdateRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.response.item.CurrencyResponse;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;
import com.dmitrenko.transfer.api.service.TransferApiService;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class ItemController {

	public static final String ITEM_ADD = "/api/v1/item";
	public static final String ITEMS = "/api/v1/items/{companyId}";
	public static final String ITEM = "/api/v1/item/{itemId}";
	public static final String ITEM_TYPE_ADD = "/api/v1/item/type";
	public static final String ITEM_TYPES = "/api/v1/item/types";
	public static final String ITEM_TYPE = "/api/v1/item/type/{typeId}";
	public static final String ITEM_CURRENCY_ADD = "/api/v1/item/currency";
	public static final String ITEM_CURRENCIES = "/api/v1/item/currencies";
	public static final String ITEM_CURRENCY = "/api/v1/item/currency/{currencyId}";

	private final TransferApiService transferApiService;

	@ResponseStatus(CREATED)
	@PostMapping(value = ITEM_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add item to company")
	public ObjectResponse<ItemResponse> addItem(@RequestBody ItemAddRequest request) {

		return transferApiService.addItem(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add items to company")
	public ListResponse<ItemResponse> addItems(@RequestBody ItemsAddRequest request) {

		return transferApiService.addItems(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get item by id")
	public ObjectResponse<ItemResponse> getItem(@PathVariable Long itemId) {

		return transferApiService.getItem(itemId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all items by company id")
	public ListResponse<ItemResponse> getAllItemsByCompany(@PathVariable Long companyId) {

		return transferApiService.getAllItemsByCompany(companyId);
	}

	@ResponseStatus(OK)
	@PatchMapping(value = ITEM, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update item by id")
	public ObjectResponse<ItemResponse> updateItem(@PathVariable Long itemId,
												   @RequestBody ItemUpdateRequest request) {

		return transferApiService.updateItem(itemId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEM, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete item by id")
	public SuccessWrapper deleteItem(@PathVariable Long itemId) {

		return transferApiService.deleteItem(itemId);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete all items by company id")
	public SuccessWrapper deleteAllItemsByCompany(@PathVariable Long companyId) {

		return transferApiService.deleteAllItemsByCompany(companyId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = ITEM_TYPE_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add item type")
	public ObjectResponse<ItemTypeResponse> addItemType(@RequestBody ItemTypeAddRequest request) {

		return transferApiService.addItemType(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get item type by id")
	public ObjectResponse<ItemTypeResponse> getItemType(@PathVariable Long typeId) {

		return transferApiService.getItemType(typeId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM_TYPES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all item types")
	public ListResponse<ItemTypeResponse> getAllItemTypes() {

		return transferApiService.getAllItemTypes();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = ITEM_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update item type by id")
	public ObjectResponse<ItemTypeResponse> updateItemType(@PathVariable Long typeId,
														   @RequestBody ItemTypeUpdateRequest request) {

		return transferApiService.updateItemType(typeId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEM_TYPE, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete item type by id")
	public SuccessWrapper deleteItemType(@PathVariable Long typeId) {

		return transferApiService.deleteItemType(typeId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = ITEM_CURRENCY_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add currency")
	public ObjectResponse<CurrencyResponse> addCurrency(@RequestBody CurrencyAddRequest request) {

		return transferApiService.addCurrency(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM_CURRENCY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get currency by id")
	public ObjectResponse<CurrencyResponse> getCurrency(@PathVariable Long currencyId) {

		return transferApiService.getCurrency(currencyId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM_CURRENCIES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all currencies")
	public ListResponse<CurrencyResponse> getAllCurrencies() {

		return transferApiService.getAllCurrencies();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = ITEM_CURRENCY, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update currency by id")
	public ObjectResponse<CurrencyResponse> updateCurrency(@PathVariable Long currencyId,
														   @RequestBody CurrencyUpdateRequest request) {

		return transferApiService.updateCurrency(currencyId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEM_CURRENCY, consumes = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete currency by id")
	public SuccessWrapper deleteCurrency(@PathVariable Long currencyId) {

		return transferApiService.deleteCurrency(currencyId);
	}
}
