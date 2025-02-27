package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.UserRequest;
import com.co.fashion.application.dto.response.UserResponse;
import com.co.fashion.application.mapper.UserMapper;
import com.co.fashion.application.port.input.UserUseCase;
import com.co.fashion.application.port.output.RoleRepositoryPort;
import com.co.fashion.application.port.output.UserRepositoryPort;
import com.co.fashion.domain.model.Role;
import com.co.fashion.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

	public static final String USER_NOT_FOUND = "User not found ";
	private final UserRepositoryPort userRepositoryPort;
	private final RoleRepositoryPort roleRepositoryPort;
	private final UserMapper userMapper;


	@Override
	@Transactional
	public UserResponse createUser(UserRequest request) {
		User user = userMapper.toEntity(request);

		User savedUser = userRepositoryPort.save(user);

		return userMapper.toDto(savedUser);
	}

	@Override
	@Transactional
	public UserResponse addRoleToUser(Long userId, String roleName) {
		User user = userRepositoryPort.findById(userId)
				.orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));

		Role role = roleRepositoryPort.findByName(roleName)
				.orElseThrow(() -> new RuntimeException("Role not found"));

		if (!user.getRoles().contains(role)) {
			user.getRoles().add(role);
		}

		return userMapper.toDto(userRepositoryPort.save(user));
	}

	@Override
	@Transactional
	public List<UserResponse> getAllUsers() {
		return userRepositoryPort.findAll().stream()
				.map(userMapper::toDto)
				.toList();
	}

	@Override
	@Transactional
	public UserResponse getUserById(Long id) {
		var user = userRepositoryPort.findById(id)
				.orElseThrow(() -> new RuntimeException(USER_NOT_FOUND + id));
		return userMapper.toDto(user);
	}

	@Override
	@Transactional
	public UserResponse updateUser(UserRequest request) {
		User existingUser = userRepositoryPort.findById(request.getId())
				.orElseThrow(() -> new RuntimeException(USER_NOT_FOUND +"for update"));

		BeanUtils.copyProperties(request, existingUser, getNullPropertyNames(request));

		User updatedUser = userRepositoryPort.save(existingUser);

		return userMapper.toDto(updatedUser);
	}


	@Override
	@Transactional
	public void deleteUser(Long id) {
		User user = userRepositoryPort.findById(id)
				.orElseThrow(() -> new RuntimeException(USER_NOT_FOUND));
		userRepositoryPort.delete(user);
	}

	/**
	 * Obtiene una lista de propiedades nulas para excluirlas de `BeanUtils.copyProperties()`
	 */
	private String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		return Arrays.stream(src.getPropertyDescriptors())
				.map(PropertyDescriptor::getName)
				.filter(name -> src.getPropertyValue(name) == null)
				.toArray(String[]::new);
	}
}
