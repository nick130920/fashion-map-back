package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.UserRequest;
import com.co.fashion.application.dto.response.UserResponse;

import java.util.List;

public interface UserUseCase {
	UserResponse createUser(UserRequest request);

	UserResponse addRoleToUser(Long userId, String roleName);

	List<UserResponse> getAllUsers();

	UserResponse getUserById(Long id);

	UserResponse updateUser(UserRequest request);

	void deleteUser(Long id);
}
