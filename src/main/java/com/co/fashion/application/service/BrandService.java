package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.BrandRequest;
import com.co.fashion.application.dto.response.BrandResponse;
import com.co.fashion.application.mapper.BrandMapper;
import com.co.fashion.application.port.input.BrandUseCase;
import com.co.fashion.application.port.output.BrandRepositoryPort;
import com.co.fashion.application.port.output.ClassificationRepositoryPort;
import com.co.fashion.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService implements BrandUseCase {

	private final BrandRepositoryPort brandRepositoryPort;
	private final ClassificationRepositoryPort classificationRepositoryPort;
	private final BrandMapper brandMapper;


	@Override
	@Transactional
	public BrandResponse createBrand(BrandRequest request) {
		Brand brand = brandMapper.toEntity(request);

		if (brand.getStores() != null) {
			brand.getStores().forEach(store -> store.setBrand(brand));
		}

		brand.setClassifications(request.getClassifications().stream().map(classification ->
				classificationRepositoryPort.findById(classification.getId())
					.orElseThrow(() -> new RuntimeException("Classification not found: " + classification.getId()))).toList());


		Brand savedBrand = brandRepositoryPort.save(brand);

		return brandMapper.toDto(savedBrand);
	}

	@Override
	@Transactional
	public List<BrandResponse> getAllBrands() {
		return brandRepositoryPort.findAll().stream()
				.map(brandMapper::toDto)
				.toList();
	}

	@Override
	@Transactional
	public BrandResponse getBrandById(Long id) {
		var brand = brandRepositoryPort.findById(id)
				.orElseThrow(() -> new RuntimeException("Brand not found"));
		return brandMapper.toDto(brand);
	}

	@Override
	@Transactional
	public BrandResponse updateBrand(BrandRequest request) {
		Brand existingBrand = brandRepositoryPort.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("Brand not found for update"));

		BeanUtils.copyProperties(request, existingBrand, getNullPropertyNames(request));

		Brand updatedBrand = brandRepositoryPort.save(existingBrand);

		return brandMapper.toDto(updatedBrand);
	}


	@Override
	@Transactional
	public void deleteBrand(Long id) {
		Brand brand = brandRepositoryPort.findById(id)
				.orElseThrow(() -> new RuntimeException("Brand not found"));
		brandRepositoryPort.delete(brand);
	}

	/**
	 * Obtiene una lista de propiedades nulas para excluirlas de `BeanUtils.copyProperties()`
	 */
	private String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		return Arrays.stream(src.getPropertyDescriptors())
				.map(PropertyDescriptor::getName)
				.filter(name -> src.getPropertyValue(name) == null)
				.toArray(String[]::new);
	}
}
