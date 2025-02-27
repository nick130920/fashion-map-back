package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.RoleRequest;
import com.co.fashion.application.dto.response.RoleResponse;

import java.util.List;

public interface RoleUseCase {
	RoleResponse createRole(RoleRequest request);

	List<RoleResponse> createRoles(List<RoleRequest> request);

	List<RoleResponse> getAllRoles();

	RoleResponse getRoleById(Long id);

	RoleResponse updateRole(RoleRequest request);

	void deleteRole(Long id);
}
