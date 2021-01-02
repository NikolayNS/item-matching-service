package com.dmitrenko.database.mapper.impl.response.user;

import com.dmitrenko.database.domain.user.User;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<UserResponse, User> {

	@Override
	public UserResponse from(User source) {
		return new UserResponse()
			.setId(source.getId())
			.setName(source.getName())
			.setEmail(source.getEmail())
			.setCreated(source.getCreatedDateTime())
			.setCreated(source.getModifiedDateTime());
	}
}
