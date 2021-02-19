package com.dmitrenko.privateapi.service.impl;

import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.database.service.domain.user.UserDomainService;
import com.dmitrenko.privateapi.service.UserService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDomainService userDomainService;

	@Override
	public ObjectResponse<UserResponse> addUser(UserRequest request) {
		return ObjectResponse.success(userDomainService.addUser(request));
	}

	@Override
	public ObjectResponse<UserResponse> getUser(Long userId) {
		return ObjectResponse.success(userDomainService.getUser(userId));
	}

	@Override
	public ListResponse<UserResponse> getAllUsers() {
		return ListResponse.success(userDomainService.getAllUsers());
	}

	@Override
	public ObjectResponse<UserResponse> updateUser(Long userId, UserRequest request) {
		return ObjectResponse.success(userDomainService.updateUser(userId, request));
	}

	@Override
	public SuccessWrapper deleteUser(Long userId) {
		return new SuccessWrapper(userDomainService.deleteUser(userId));
	}
}
