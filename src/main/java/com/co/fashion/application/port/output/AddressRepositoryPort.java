package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Address;

import java.util.List;
import java.util.Optional;

/**
 * Output port for Address repository.
 *
 * @author Firstname Lastname
 */
public interface AddressRepositoryPort {
	/**
	 * Save all Addresss.
	 *
	 * @param addresss the Addresss to save
	 * @return the saved Addresss
	 */
	List<Address> saveAll(List<Address> addresss);
	/**
	 * Save a Address.
	 *
	 * @param address the Address to save
	 * @return the saved Address
	 */
	Address save(Address address);
	/**
	 * Get all addresss.
	 *
	 * @return all Addresss
	 */
	List<Address> findAll();
	/**
	 * Find a Address by id.
	 *
	 * @param id the id of the Address
	 * @return the Address if found, optional empty if not found
	 */
	Optional<Address> findById(Long id);
	/**
	 * Delete a Address by id.
	 *
	 * @param id the id of the Address
	 */
	void deleteById(Long id);
}