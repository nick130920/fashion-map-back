package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {

	List<User> findByNameContaining(String name);
}
