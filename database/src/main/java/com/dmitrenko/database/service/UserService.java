package com.dmitrenko.database.service;

import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;

import java.util.List;

public interface UserService {

	UserResponse addUser(UserRequest request);

	UserResponse getUser(Long userId);

	List<UserResponse> getAllUsers();

	UserResponse updateUser(Long userId, UserRequest request);

	boolean deleteUser(Long userId);
}
