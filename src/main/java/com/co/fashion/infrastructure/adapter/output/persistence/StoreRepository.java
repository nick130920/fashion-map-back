package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.StoreRepositoryPort;
import com.co.fashion.domain.model.Store;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StoreRepository implements StoreRepositoryPort {

	private final SpringDataStoreRepository springDataStoreRepository;

	public StoreRepository(SpringDataStoreRepository springDataStoreRepository) {
		this.springDataStoreRepository = springDataStoreRepository;
	}

	@Override
	public List<Store> saveAll(List<Store> stores) {
		return springDataStoreRepository.saveAll(stores);
	}

	@Override
	public Store save(Store brand) {
		return springDataStoreRepository.save(brand);
	}

	@Override
	public List<Store> findAll() {
		return springDataStoreRepository.findAll();
	}

	@Override
	public Optional<Store> findById(Long id) {
		return springDataStoreRepository.findById(id);
	}

	@Override
	public Optional<List<Store>> findAllByBrandId(Long brandId) {
		return springDataStoreRepository.findAllByBrandId(brandId);
	}

	@Override
	public void delete(Store brand) {
		springDataStoreRepository.delete(brand);
	}

}
