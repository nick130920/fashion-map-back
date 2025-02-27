package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.UserRequest;
import com.co.fashion.application.dto.response.UserResponse;
import com.co.fashion.application.port.input.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserGraphQLController {

	private final UserUseCase userUseCase;

	@MutationMapping
	public UserResponse createUser(@Argument UserRequest userRequest) {
		return userUseCase.createUser(userRequest);
	}

	@MutationMapping
	public UserResponse addRoleToUser(@Argument Long userId, @Argument String roleName) {
		return userUseCase.addRoleToUser(userId, roleName);
	}
}