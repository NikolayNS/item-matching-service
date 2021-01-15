package com.dmitrenko.database.service.impl;

import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.database.service.UserService;
import com.dmitrenko.database.service.domain.user.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDomainService userDomainService;

	@Override
	public UserResponse addUser(UserRequest request) {
		return userDomainService.addUser(request);
	}

	@Override
	public UserResponse getUser(Long userId) {
		return userDomainService.getUser(userId);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return userDomainService.getAllUsers();
	}

	@Override
	public UserResponse updateUser(Long userId, UserRequest request) {
		return userDomainService.updateUser(userId, request);
	}

	@Override
	public boolean deleteUser(Long userId) {
		return userDomainService.deleteUser(userId);
	}
}
