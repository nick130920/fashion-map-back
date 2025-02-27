package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.ImageRepositoryPort;
import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataImageRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImageRepository implements ImageRepositoryPort {

	private final SpringDataImageRepository springDataImageRepository;

	public ImageRepository(SpringDataImageRepository springDataImageRepository) {
		this.springDataImageRepository = springDataImageRepository;
	}
	
	
	@Override
	public Image save(Image image) {
		return springDataImageRepository.save(image);
	}
	@Override
	public List<Image> saveAll(List<Image> images) {
		return springDataImageRepository.saveAll(images);
	}

	@Override
	public Optional<Image> findById(Long id) {
		return springDataImageRepository.findById(id);
	}

	@Override
	public Optional<List<Image>> findByEntityTypeAndEntityId(EntityType entityType, Long entityId) {
		return springDataImageRepository.findByEntityTypeAndEntityId(entityType, entityId);
	}
}
