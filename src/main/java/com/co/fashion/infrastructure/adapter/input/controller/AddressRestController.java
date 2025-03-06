package com.co.fashion.infrastructure.adapter.input.rest.controller;

import com.co.fashion.application.dto.request.AddressRequest;
import com.co.fashion.application.dto.response.AddressResponse;
import com.co.fashion.application.port.input.AddressUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Address entities.
 * Provides endpoints for CRUD operations and bulk creation.
 * 
 * Endpoints:
 * - GET /api/address/{id}: Retrieve a Address by its ID.
 * - GET /api/address: Retrieve all Address entities.
 * - POST /api/address: Create a new Address.
 * - POST /api/address/bulk: Create multiple Address entities in bulk.
 * - PUT /api/address/{id}: Update an existing Address by its ID.
 * - DELETE /api/address/{id}: Delete a Address by its ID.
 * 
 * Dependencies:
 * - AddressUseCase: Use case service for Address operations.
 * 
 * Annotations:
 * - @RestController: Indicates that this class is a REST controller.
 * - @RequestMapping: Maps HTTP requests to handler methods of this controller.
 * - @RequiredArgsConstructor: Generates a constructor with required arguments.
 * - @Slf4j: Enables logging.
 */
@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
@Slf4j
public class AddressRestController {

    private final AddressUseCase addressUseCase;

    /**
     * Retrieves a Address by its ID.
     * 
     * @param id the Address ID
     * @return the found Address response
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressUseCase.findById(id));
    }

    /**
     * Retrieves all Addresss.
     * 
     * @return the list of Address responses
     */
    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddresss() {
        return ResponseEntity.ok(addressUseCase.findAll());
    }

    /**
     * Creates a new Address.
     * 
     * @param addressRequest the Address request
     * @return the created Address response
     */
    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressUseCase.createAddress(addressRequest));
    }

    /**
     * Endpoint to create multiple Addresss in bulk.
     * 
     * @param addressRequests List of AddressRequest objects to create.
     * @return List of created AddressResponse objects.
     */
    @PostMapping("/bulk")
    public ResponseEntity<List<AddressResponse>> createAddresss(@RequestBody List<AddressRequest> addressRequests) {
        return ResponseEntity.ok(addressUseCase.createAddresss(addressRequests));
    }

    /**
     * Updates a Address by its ID.
     * 
     * @param id the Address ID
     * @param addressRequest the Address request
     * @return the updated Address response
     */
    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long id, @RequestBody AddressRequest addressRequest) {
        return ResponseEntity.ok(addressUseCase.updateAddress(id, addressRequest));
    }

    /**
     * Deletes a Address by its ID.
     * 
     * @param id the Address ID
     * @return 204 No Content response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressUseCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
