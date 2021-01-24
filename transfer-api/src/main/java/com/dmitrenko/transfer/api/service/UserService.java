package com.dmitrenko.transfer.api.service;

import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.transfer.api.wrapper.ListResponse;
import com.dmitrenko.transfer.api.wrapper.ObjectResponse;
import com.dmitrenko.transfer.api.wrapper.SuccessWrapper;

public interface UserService {

	ObjectResponse<UserResponse> addUser(UserRequest request);

	ObjectResponse<UserResponse> getUser(Long userId);

	ListResponse<UserResponse> getAllUsers();

	ObjectResponse<UserResponse> updateUser(Long userId, UserRequest request);

	SuccessWrapper deleteUser(Long userId);
}
