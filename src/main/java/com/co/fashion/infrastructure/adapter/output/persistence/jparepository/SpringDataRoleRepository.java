package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataRoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);
	List<Role> findByNameContaining(String name);
}
