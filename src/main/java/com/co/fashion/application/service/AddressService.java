package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.AddressRequest;
import com.co.fashion.application.dto.response.AddressResponse;
import com.co.fashion.application.exception.AddressNotFoundException;
import com.co.fashion.application.mapper.AddressMapper;
import com.co.fashion.application.port.input.AddressUseCase;
import com.co.fashion.application.port.output.AddressRepositoryPort;
import com.co.fashion.domain.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing addresss.
 */
@Service
@RequiredArgsConstructor
public class AddressService implements AddressUseCase {

    private final AddressRepositoryPort addressRepositoryPort;
    private final AddressMapper addressMapper;

    /**
     * Creates a new address.
     *
     * @param addressRequest the address request input
     * @return the created address response
     * @throws IllegalArgumentException if the request is null
     */
    @Override
    @Transactional
    public AddressResponse createAddress(AddressRequest addressRequest) {
        if (addressRequest == null) {
            throw new IllegalArgumentException("AddressRequest cannot be null");
        }

        Address address = addressMapper.toEntity(addressRequest);
        address = addressRepositoryPort.save(address);

        return addressMapper.toDto(address);
    }

    /**
     * Creates multiple addresss.
     *
     * @param addressRequests the list of address requests
     * @return the list of created address responses
     * @throws IllegalArgumentException if the request list is null or empty
     */
    @Override
    @Transactional
    public List<AddressResponse> createAddresss(List<AddressRequest> addressRequests) {
        if (addressRequests == null || addressRequests.isEmpty()) {
            throw new IllegalArgumentException("AddressRequests cannot be null or empty");
        }

        List<Address> addresss = addressRequests.stream()
                .map(addressMapper::toEntity)
                .collect(Collectors.toList());

        addresss = addressRepositoryPort.saveAll(addresss);

        return addressMapper.toDtoList(addresss);
    }

    /**
     * Retrieves all addresss.
     *
     * @return the list of address responses
     */
    @Override
    @Transactional(readOnly = true)
    public List<AddressResponse> findAll() {
        return addressRepositoryPort.findAll().stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Finds a address by ID.
     *
     * @param id the address ID
     * @return the found address response
     * @throws AddressNotFoundException if the address is not found
     */
    @Override
    @Transactional(readOnly = true)
    public AddressResponse findById(Long id) {
        return addressRepositoryPort.findById(id)
                .map(addressMapper::toDto)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with ID: " + id));
    }

    /**
     * Updates a address.
     *
     * @param request the address request
     * @return the updated address response
     * @throws AddressNotFoundException if the address is not found
     */
    @Override
    @Transactional
    public AddressResponse updateAddress(AddressRequest request) {
        addressRepositoryPort.findById(request.getId())
                .orElseThrow(() -> new AddressNotFoundException("Address not found with ID: " + request.getId()));


        Address saved = addressRepositoryPort.save(addressMapper.toEntity(request));

        return addressMapper.toDto(saved);
    }

    /**
     * Deletes a address by ID.
     *
     * @param id the address ID
     * @throws AddressNotFoundException if the address is not found
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        addressRepositoryPort.deleteById(id);
    }
}