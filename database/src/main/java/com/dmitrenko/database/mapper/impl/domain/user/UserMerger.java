package com.dmitrenko.database.mapper.impl.domain.user;

import com.dmitrenko.database.domain.user.User;
import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMerger implements Merger<User, UserRequest> {

	@Override
	public User merge(User target, UserRequest source) {
		return target
			.setName(source.getName())
			.setEmail(source.getEmail() == null ? "" : source.getEmail());
	}
}
