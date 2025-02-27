package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.BrandRepositoryPort;
import com.co.fashion.domain.model.Brand;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandRepository implements BrandRepositoryPort {

	private final SpringDataBrandRepository springDataBrandRepository;


	@Override
	public Brand save(Brand brand) {
		return springDataBrandRepository.save(brand);
	}

	@Override
	public List<Brand> findAll() {
		return springDataBrandRepository.findAll();
	}

	@Override
	public Optional<Brand> findById(Long id) {
		return springDataBrandRepository.findById(id);
	}

	@Override
	public void delete(Brand brand) {
		springDataBrandRepository.delete(brand);
	}

}
