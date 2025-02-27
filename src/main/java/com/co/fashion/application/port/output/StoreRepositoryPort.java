package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepositoryPort {
	List<Store> saveAll(List<Store> stores);
	Store save(Store store);
	List<Store> findAll();
	Optional<Store> findById(Long id);
	Optional<List<Store>> findAllByBrandId(Long brandId);
	void delete(Store store);
}
