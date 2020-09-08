package com.dmitrenko.itemmatchingservice.engine;

import com.dmitrenko.itemmatchingservice.dto.request.ItemMatchingRequest;
import com.dmitrenko.itemmatchingservice.dto.response.ItemMatchingResponse;

public interface ItemMatchingEngine {

	ItemMatchingResponse findMatchingItems(ItemMatchingRequest request);
}
