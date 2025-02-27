package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepositoryPort {
	Role save(Role role);
	List<Role> saveAll(List<Role> role);


	List<Role> findAll();

	Optional<Role> findById(Long id);
	Optional<Role> findByName(String name);

	void delete(Role role);
}
