package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
	User save(User user);

	List<User> findAll();

	Optional<User> findById(Long id);

	void delete(User user);
}
