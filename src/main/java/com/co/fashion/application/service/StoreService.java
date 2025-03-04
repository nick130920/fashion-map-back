package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.application.mapper.StoreMapper;
import com.co.fashion.application.port.input.ImageUseCase;
import com.co.fashion.application.port.input.StoreUseCase;
import com.co.fashion.application.port.output.BrandRepositoryPort;
import com.co.fashion.application.port.output.StoreRepositoryPort;
import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;
import com.co.fashion.domain.model.Store;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing stores.
 */
@Service
@RequiredArgsConstructor
public class StoreService implements StoreUseCase {

    private final StoreRepositoryPort storeRepositoryPort;
    private final ImageUseCase imageUseCase;
    private final StoreMapper storeMapper;
    private final BrandRepositoryPort brandRepositoryPort;

    /**
     * Creates a new store.
     *
     * @param storeInput the store request input
     * @return the created store response
     */
    @Override
    @Transactional
    public StoreResponse createStore(StoreRequest storeInput) {
        Store store = storeMapper.toEntity(storeInput);
        store.setBrand(brandRepositoryPort.findById(storeInput.getBrandId()).orElseThrow(() -> new RuntimeException("Brand not found")));

        store = storeRepositoryPort.save(store);

        if (storeInput.getImages() != null && !storeInput.getImages().isEmpty()) {
            imageUseCase.uploadImages(storeInput.getImages(), store.getId(), EntityType.STORE);
        }

        return storeMapper.toDto(store);
    }

    /**
     * Creates multiple stores.
     *
     * @param storeInputs the list of store requests
     * @return the list of created store responses
     */
    @Override
    @Transactional
    public List<StoreResponse> createStores(List<StoreRequest> storeInputs) {
        List<Store> stores = storeInputs.stream()
                .map(storeMapper::toEntity)
                .toList();
        stores = storeRepositoryPort.saveAll(stores);

        for (StoreRequest storeRequest : storeInputs) {
            List<MultipartFile> images = storeRequest.getImages();
            if (images != null && !images.isEmpty()) {
                imageUseCase.uploadImages(images, stores.get(storeInputs.indexOf(storeRequest)).getId(), EntityType.STORE);
            }
        }
        return storeMapper.toDtoList(stores);
    }

    /**
     * Retrieves all stores.
     *
     * @return the list of store responses
     */
    @Override
    public List<StoreResponse> findAll() {
        return storeRepositoryPort.findAll().stream().map(storeMapper::toDto).toList();
    }

    /**
     * Finds a store by ID.
     *
     * @param id the store ID
     * @return the found store response
     */
    @Override
    public StoreResponse findByID(Long id) {
        return storeRepositoryPort.findById(id).map(storeMapper::toDto).orElseThrow(() -> new RuntimeException("Store not found"));
    }

    /**
     * Retrieves stores by brand ID.
     *
     * @param brandId the brand ID
     * @return the list of store responses
     */
    @Override
    public List<StoreResponse> getStoresByBrand(Long brandId) {
        Optional<List<Store>> stores = storeRepositoryPort.findAllByBrandId(brandId);
        return stores.map(storeMapper::toDtoList).orElseThrow(() -> new EntityNotFoundException("Stores not found"));
    }

    /**
     * Updates a store.
     *
     * @param request the store request
     * @return the updated store response
     */
    @Override
    public StoreResponse updateStore(StoreRequest request) {
        return storeMapper.toDto(storeRepositoryPort.save(storeMapper.toEntity(request)));
    }

    /**
     * Deletes a store by ID.
     *
     * @param id the store ID
     */
    @Override
    public void deleteStore(Long id) {
        storeRepositoryPort.deleteById(id);
    }

    /**
     * Retrieves images for a store.
     *
     * @param storeId the store ID
     * @return the list of images
     */
    @Override
    public List<Image> getStoreImages(Long storeId) {
        return imageUseCase.getImagesByEntity(EntityType.STORE, storeId);
    }

}