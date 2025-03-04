package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Store;

import java.util.List;
import java.util.Optional;

/**
 * Output port for store repository.
 *
 * @author marvin
 */
public interface StoreRepositoryPort {
	/**
	 * Save all stores.
	 *
	 * @param stores the stores to save
	 * @return the saved stores
	 */
	List<Store> saveAll(List<Store> stores);
	/**
	 * Save a store.
	 *
	 * @param store the store to save
	 * @return the saved store
	 */
	Store save(Store store);
	/**
	 * Get all stores.
	 *
	 * @return all stores
	 */
	List<Store> findAll();
	/**
	 * Find a store by id.
	 *
	 * @param id the id of the store
	 * @return the store if found, optional empty if not found
	 */
	Optional<Store> findById(Long id);
	/**
	 * Find all stores of a brand by id.
	 *
	 * @param brandId the id of the brand
	 * @return the stores of the brand if found, optional empty if not found
	 */
	Optional<List<Store>> findAllByBrandId(Long brandId);
	/**
	 * Delete a store by id.
	 *
	 * @param id the id of the store
	 */
	void deleteById(Long id);
}