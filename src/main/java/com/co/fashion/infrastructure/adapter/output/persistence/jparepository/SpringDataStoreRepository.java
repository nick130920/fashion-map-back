package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SpringDataStoreRepository extends JpaRepository<Store, Long> {

	Optional<List<Store>> findAllByBrandId(Long aLong);
}
