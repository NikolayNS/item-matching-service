package com.dmitrenko.transfer.api.controller;

import com.dmitrenko.database.dto.request.item.ItemRequest;
import com.dmitrenko.database.dto.request.item.ItemTypeRequest;
import com.dmitrenko.database.dto.request.item.ItemsAddRequest;
import com.dmitrenko.database.dto.request.item.ItemsUpdateRequest;
import com.dmitrenko.database.dto.response.item.ItemResponse;
import com.dmitrenko.database.dto.response.item.ItemTypeResponse;
import com.dmitrenko.transfer.api.service.ItemService;
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

	private final ItemService itemService;

	@ResponseStatus(CREATED)
	@PostMapping(value = ITEM_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add item to company")
	public ObjectResponse<ItemResponse> addItem(@RequestBody ItemRequest request) {

		return itemService.addItem(request);
	}

	@ResponseStatus(OK)
	@PostMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add items to company")
	public ListResponse<ItemResponse> addItems(@RequestBody ItemsAddRequest request) {

		return itemService.addItems(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get item by id")
	public ObjectResponse<ItemResponse> getItem(@PathVariable Long itemId) {

		return itemService.getItem(itemId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all items by company id")
	public ListResponse<ItemResponse> getAllItemsByCompany(@PathVariable Long companyId) {

		return itemService.getAllItemsByCompany(companyId);
	}

	@ResponseStatus(OK)
	@PatchMapping(value = ITEM, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update item by id")
	public ObjectResponse<ItemResponse> updateItem(@PathVariable Long itemId,
												   @RequestBody ItemRequest request) {

		return itemService.updateItem(itemId, request);
	}

	@ResponseStatus(OK)
	@PatchMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update company items")
	public ListResponse<ItemResponse> updateItems(@RequestBody ItemsUpdateRequest request) {

		return itemService.updateItems(request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEM, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete item by id")
	public SuccessWrapper deleteItem(@PathVariable Long itemId) {

		return itemService.deleteItem(itemId);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEMS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete all items by company id")
	public SuccessWrapper deleteAllItemsByCompany(@PathVariable Long companyId) {

		return itemService.deleteAllItemsByCompany(companyId);
	}

	@ResponseStatus(CREATED)
	@PostMapping(value = ITEM_TYPE_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add item type")
	public ObjectResponse<ItemTypeResponse> addItemType(@RequestBody ItemTypeRequest request) {

		return itemService.addItemType(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get item type by id")
	public ObjectResponse<ItemTypeResponse> getItemType(@PathVariable Long typeId) {

		return itemService.getItemType(typeId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = ITEM_TYPES, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all item types")
	public ListResponse<ItemTypeResponse> getAllItemTypes() {

		return itemService.getAllItemTypes();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = ITEM_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update item type by id")
	public ObjectResponse<ItemTypeResponse> updateItemType(@PathVariable Long typeId,
														   @RequestBody ItemTypeRequest request) {

		return itemService.updateItemType(typeId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = ITEM_TYPE, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete item type by id")
	public SuccessWrapper deleteItemType(@PathVariable Long typeId) {

		return itemService.deleteItemType(typeId);
	}
}
