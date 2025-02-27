package com.co.fashion.domain.service;

import com.co.fashion.domain.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandDomainService {

	public boolean isBrandNameUnique(String name, List<Brand> existingBrands) {
		return existingBrands.stream()
				.noneMatch(brand -> brand.getName().equalsIgnoreCase(name));
	}
}
