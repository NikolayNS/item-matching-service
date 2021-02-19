package com.dmitrenko.privateapi.controller;

import com.dmitrenko.database.dto.request.user.UserRequest;
import com.dmitrenko.database.dto.response.user.UserResponse;
import com.dmitrenko.privateapi.service.UserService;
import com.dmitrenko.privateapi.wrapper.ListResponse;
import com.dmitrenko.privateapi.wrapper.ObjectResponse;
import com.dmitrenko.privateapi.wrapper.SuccessWrapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {

	public static final String USER_ADD = "/api/v1/user";
	public static final String USERS = "/api/v1/users";
	public static final String USER = "/api/v1/user/{userId}";

	private final UserService userService;

	@ResponseStatus(CREATED)
	@PostMapping(value = USER_ADD, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Add user")
	public ObjectResponse<UserResponse> addUser(@RequestBody UserRequest request) {

		return userService.addUser(request);
	}

	@ResponseStatus(OK)
	@GetMapping(value = USER, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get user by id")
	public ObjectResponse<UserResponse> getUser(@PathVariable Long userId) {

		return userService.getUser(userId);
	}

	@ResponseStatus(OK)
	@GetMapping(value = USERS, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Get all users")
	public ListResponse<UserResponse> getAllUsers() {

		return userService.getAllUsers();
	}

	@ResponseStatus(OK)
	@PatchMapping(value = USER, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Update user by id")
	public ObjectResponse<UserResponse> updateUser(@PathVariable Long userId,
												   @RequestBody UserRequest request) {

		return userService.updateUser(userId, request);
	}

	@ResponseStatus(OK)
	@DeleteMapping(value = USER, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@Operation(description = "Delete user by id")
	public SuccessWrapper deleteUser(@PathVariable Long userId) {

		return userService.deleteUser(userId);
	}
}
