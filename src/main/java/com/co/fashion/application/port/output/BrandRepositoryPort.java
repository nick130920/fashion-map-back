package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepositoryPort {
	Brand save(Brand brand);
	List<Brand> findAll();
	Optional<Brand> findById(Long id);
	void delete(Brand brand);
}
