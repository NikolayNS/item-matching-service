package com.dmitrenko.database.mapper.impl.domain.user;

import com.dmitrenko.database.domain.user.User;
import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserRequest> {

	@Override
	public User from(UserRequest source) {
		return new User()
			.setName(source.getName())
			.setEmail(source.getEmail() == null ? "" : source.getEmail());
	}
}
