package com.dmitrenko.privateapi.service;

import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;

public interface UserService {

	ObjectResponse<UserResponse> addUser(UserRequest request);

	ObjectResponse<UserResponse> getUser(Long userId);

	ListResponse<UserResponse> getAllUsers();

	ObjectResponse<UserResponse> updateUser(Long userId, UserRequest request);

	SuccessWrapper deleteUser(Long userId);
}
