package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.RoleRepositoryPort;
import com.co.fashion.domain.model.Role;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoleRepository implements RoleRepositoryPort {

	private final SpringDataRoleRepository springDataRoleRepository;


	@Override
	public Role save(Role role) {
		return springDataRoleRepository.save(role);
	}

	@Override
	public List<Role> saveAll(List<Role> role) {
		return springDataRoleRepository.saveAll(role);
	}

	@Override
	public List<Role> findAll() {
		return springDataRoleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return springDataRoleRepository.findById(id);
	}

	@Override
	public Optional<Role> findByName(String name) {
		return springDataRoleRepository.findByName(name);
	}

	@Override
	public void delete(Role role) {
		springDataRoleRepository.delete(role);
	}

}
