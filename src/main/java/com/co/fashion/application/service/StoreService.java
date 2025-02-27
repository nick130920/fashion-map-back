package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.StoreRequest;
import com.co.fashion.application.dto.response.StoreResponse;
import com.co.fashion.application.mapper.StoreMapper;
import com.co.fashion.application.port.input.ImageUseCase;
import com.co.fashion.application.port.input.StoreUseCase;
import com.co.fashion.application.port.output.StoreRepositoryPort;
import com.co.fashion.domain.model.Brand;
import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;
import com.co.fashion.domain.model.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService implements StoreUseCase {

	private final StoreRepositoryPort storeRepositoryPort;
	private final ImageUseCase imageUseCase;
	private final StoreMapper storeMapper;

	@Override
	@Transactional
	public Store createStore(StoreRequest storeInput, Brand brand) {
		Store store = storeMapper.toEntity(storeInput);
		store.setBrand(brand);

		store = storeRepositoryPort.save(store);

		if (storeInput.getImages() != null && !storeInput.getImages().isEmpty()) {
			imageUseCase.uploadImages(storeInput.getImages(), store.getId(), EntityType.STORE);
		}

		return store;
	}

	@Override
	@Transactional
	public List<Store> createStores(List<StoreRequest> storeInputs, Brand brand) {
		List<Store> stores = storeInputs.stream()
				.map(storeMapper::toEntity)
				.map(store -> {
					store.setBrand(brand);
					return store;
				})
				.toList();
		stores = storeRepositoryPort.saveAll(stores);

		for (StoreRequest storeRequest : storeInputs) {
			List<MultipartFile> images = storeRequest.getImages();
			if (images!= null &&!images.isEmpty()) {
                imageUseCase.uploadImages(images, stores.get(storeInputs.indexOf(storeRequest)).getId(), EntityType.STORE);
            }
		}
		return stores;
	}


	@Override
	public List<Store> getAllStores() {
		return storeRepositoryPort.findAll();
	}

	@Override
	public StoreResponse getStoreById(Long id) {
		return null;
	}

	@Override
	public List<StoreResponse> getStoresByBrand(Long brandId) {
		Optional<List<Store>> stores = storeRepositoryPort.findAllByBrandId(brandId);
		return storeMapper.toDtoList(stores.orElse(Collections.emptyList()));
	}

	@Override
	public StoreResponse updateStore(StoreRequest request) {
		return storeMapper.toDto(storeRepositoryPort.save(storeMapper.toEntity(request)));
	}

	@Override
	public void deleteStore(Store store) {
		storeRepositoryPort.delete(store);
	}

	@Override
	public List<Image> getStoreImages(Long storeId) {
		return imageUseCase.getImagesByEntity(EntityType.STORE, storeId);
	}

}
