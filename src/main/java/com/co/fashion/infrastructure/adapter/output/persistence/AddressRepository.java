package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.AddressRepositoryPort;
import com.co.fashion.domain.model.Address;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataAddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This class implements the {@link AddressRepositoryPort} interface using Spring Data JPA.
 */
@Repository
public class AddressRepository implements AddressRepositoryPort {

	private final SpringDataAddressRepository springDataAddressRepository;

	/**
	 * Constructs a new instance of {@link AddressRepository}.
	 *
	 * @param springDataAddressRepository the Spring Data JPA repository for {@link Address}
	 */
	public AddressRepository(SpringDataAddressRepository springDataAddressRepository) {
		this.springDataAddressRepository = springDataAddressRepository;
	}

	/**
	 * Saves a list of Addresss to the repository.
	 *
	 * @param Addresss the list of Addresss to be saved
	 * @return the list of saved Addresss
	 */
	@Override
	public List<Address> saveAll(List<Address> addresss) {
		return springDataAddressRepository.saveAll(addresss);
	}

	/**
	 * Saves a Address to the repository.
	 *
	 * @param address the Address to be saved
	 * @return the saved Address
	 */
	@Override
	public Address save(Address address) {
		return springDataAddressRepository.save(address);
	}

	/**
	 * Returns a list of all Addresss in the repository.
	 *
	 * @return a list of all Addresss
	 */
	@Override
	public List<Address> findAll() {
		return springDataAddressRepository.findAll();
	}

	/**
	 * Returns a Address by its ID if the Address exists in the repository.
	 *
	 * @param id the ID of the Address to be found
	 * @return an optional containing the Address if found, empty otherwise
	 */
	@Override
	public Optional<Address> findById(Long id) {
		return springDataAddressRepository.findById(id);
	}

	/**
	 * Deletes a Address by its ID.
	 *
	 * @param id the ID of the Address to be deleted
	 */
	@Override
	public void deleteById(Long id) {
		springDataAddressRepository.deleteById(id);
	}

}