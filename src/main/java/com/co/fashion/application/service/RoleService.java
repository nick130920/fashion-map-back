package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.RoleRequest;
import com.co.fashion.application.dto.response.RoleResponse;
import com.co.fashion.application.mapper.RoleMapper;
import com.co.fashion.application.port.input.RoleUseCase;
import com.co.fashion.application.port.output.RoleRepositoryPort;
import com.co.fashion.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService implements RoleUseCase {

	private final RoleRepositoryPort roleRepositoryPort;
	private final RoleMapper roleMapper;


	@Override
	@Transactional
	public RoleResponse createRole(RoleRequest request) {
		Role role = roleMapper.toEntity(request);

		Role savedRole = roleRepositoryPort.save(role);

		return roleMapper.toDto(savedRole);
	}

	@Override
	@Transactional
	public List<RoleResponse> createRoles(List<RoleRequest> rolesRequest) {
		List<Role> roles = rolesRequest.stream()
				.map(request -> {
					if (roleRepositoryPort.findByName(request.getName()).isPresent()) {
						throw new KeyAlreadyExistsException("Role with the same name already exists");
					}
					return roleMapper.toEntity(request);

				}).toList();

		List<Role> savedRoles = roleRepositoryPort.saveAll(roles);

		return roleMapper.toDtoList(savedRoles);
	}


	@Override
	@Transactional
	public List<RoleResponse> getAllRoles() {
		return roleRepositoryPort.findAll().stream()
				.map(roleMapper::toDto)
				.toList();
	}

	@Override
	@Transactional
	public RoleResponse getRoleById(Long id) {
		var role = roleRepositoryPort.findById(id)
				.orElseThrow(() -> new RuntimeException("Role not found"));
		return roleMapper.toDto(role);
	}

	@Override
	@Transactional
	public RoleResponse updateRole(RoleRequest request) {
		Role existingRole = roleRepositoryPort.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("Role not found for update"));

		BeanUtils.copyProperties(request, existingRole, getNullPropertyNames(request));

		Role updatedRole = roleRepositoryPort.save(existingRole);

		return roleMapper.toDto(updatedRole);
	}


	@Override
	@Transactional
	public void deleteRole(Long id) {
		Role role = roleRepositoryPort.findById(id)
				.orElseThrow(() -> new RuntimeException("Role not found"));
		roleRepositoryPort.delete(role);
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
