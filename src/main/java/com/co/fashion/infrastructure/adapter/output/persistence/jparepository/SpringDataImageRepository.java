package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SpringDataImageRepository extends JpaRepository<Image, Long> {
	Optional<List<Image>> findByEntityTypeAndEntityId(EntityType entityType, Long entityId);

}
