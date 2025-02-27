package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.RoleRequest;
import com.co.fashion.application.dto.response.RoleResponse;
import com.co.fashion.application.port.input.RoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoleGraphQLController {

	private final RoleUseCase roleUseCase;

	@MutationMapping
	public RoleResponse createRole(@Argument RoleRequest roleRequest) {
		return roleUseCase.createRole(roleRequest);
	}

	@MutationMapping
	public List<RoleResponse> createRoles(@Argument List<RoleRequest> roleRequest) {
		return roleUseCase.createRoles(roleRequest);
	}

}