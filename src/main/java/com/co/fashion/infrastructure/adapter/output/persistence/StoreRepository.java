package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.StoreRepositoryPort;
import com.co.fashion.domain.model.Store;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataStoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This class implements the {@link StoreRepositoryPort} interface using Spring Data JPA.
 */
@Repository
public class StoreRepository implements StoreRepositoryPort {

	private final SpringDataStoreRepository springDataStoreRepository;

	/**
	 * Constructs a new instance of {@link StoreRepository}.
	 *
	 * @param springDataStoreRepository the Spring Data JPA repository for {@link Store}
	 */
	public StoreRepository(SpringDataStoreRepository springDataStoreRepository) {
		this.springDataStoreRepository = springDataStoreRepository;
	}

	/**
	 * Saves a list of stores to the repository.
	 *
	 * @param stores the list of stores to be saved
	 * @return the list of saved stores
	 */
	@Override
	public List<Store> saveAll(List<Store> stores) {
		return springDataStoreRepository.saveAll(stores);
	}

	/**
	 * Saves a store to the repository.
	 *
	 * @param brand the store to be saved
	 * @return the saved store
	 */
	@Override
	public Store save(Store brand) {
		return springDataStoreRepository.save(brand);
	}

	/**
	 * Returns a list of all stores in the repository.
	 *
	 * @return a list of all stores
	 */
	@Override
	public List<Store> findAll() {
		return springDataStoreRepository.findAll();
	}

	/**
	 * Returns a store by its ID if the store exists in the repository.
	 *
	 * @param id the ID of the store to be found
	 * @return an optional containing the store if found, empty otherwise
	 */
	@Override
	public Optional<Store> findById(Long id) {
		return springDataStoreRepository.findById(id);
	}

	/**
	 * Returns a list of all stores of a brand by its ID if the stores exist in the
	 * repository.
	 *
	 * @param brandId the ID of the brand
	 * @return an optional containing the list of stores if found, empty otherwise
	 */
	@Override
	public Optional<List<Store>> findAllByBrandId(Long brandId) {
		return springDataStoreRepository.findAllByBrandId(brandId);
	}

	/**
	 * Deletes a store by its ID.
	 *
	 * @param id the ID of the store to be deleted
	 */
	@Override
	public void deleteById(Long id) {
		springDataStoreRepository.deleteById(id);
	}

}