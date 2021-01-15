package com.dmitrenko.database.service.domain.user.impl;

import com.dmitrenko.database.domain.user.User;
import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.database.exception.EntityAlreadyExistException;
import com.dmitrenko.database.mapper.impl.domain.user.UserMapper;
import com.dmitrenko.database.mapper.impl.domain.user.UserMerger;
import com.dmitrenko.database.mapper.impl.response.user.UserResponseMapper;
import com.dmitrenko.database.repository.UserRepository;
import com.dmitrenko.database.service.domain.user.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements UserDomainService {

	private final UserRepository userRepository;

	private final UserMapper userMapper;
	private final UserMerger userMerger;
	private final UserResponseMapper userResponseMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public UserResponse addUser(@Valid UserRequest request) {
		if (userRepository.findByName(request.getName()).isPresent())
			throw new EntityAlreadyExistException(String.format("User with name %s already exist", request.getName()));

		var user = userMapper.from(request);
		user = userRepository.saveAndFlush(user);

		return userResponseMapper.from(user);
	}

	@Override
	public UserResponse getUser(Long userId) {
		return userResponseMapper.from(getEntity(userId));
	}

	private User getEntity(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(String.format("User with id %s not found", id)));
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return userResponseMapper.from(userRepository.findAll());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public UserResponse updateUser(Long userId, @Valid UserRequest request) {
		var user = getEntity(userId);
		user = userMerger.merge(user, request);

		user = userRepository.saveAndFlush(user);

		return userResponseMapper.from(user);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteUser(Long userId) {
		userRepository.delete(getEntity(userId));
		return !userRepository.existsById(userId);
	}
}
