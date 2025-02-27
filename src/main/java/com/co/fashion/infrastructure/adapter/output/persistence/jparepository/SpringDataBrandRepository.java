package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataBrandRepository extends JpaRepository<Brand, Long> {

	List<Brand> findByNameContaining(String name);
}
