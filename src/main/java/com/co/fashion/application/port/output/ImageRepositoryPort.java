package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageRepositoryPort {
	Image save(Image image);
	List<Image> saveAll(List<Image> image);
	Optional<Image> findById(Long id);
	Optional<List<Image>> findByEntityTypeAndEntityId(EntityType entityType, Long entityId);
}
