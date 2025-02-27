package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.UserRepositoryPort;
import com.co.fashion.domain.model.User;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements UserRepositoryPort {

	private final SpringDataUserRepository springDataUserRepository;


	@Override
	public User save(User brand) {
		return springDataUserRepository.save(brand);
	}

	@Override
	public List<User> findAll() {
		return springDataUserRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return springDataUserRepository.findById(id);
	}

	@Override
	public void delete(User brand) {
		springDataUserRepository.delete(brand);
	}

}
