package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.ClassificationRepositoryPort;
import com.co.fashion.domain.model.Classification;
import com.co.fashion.domain.model.ClassificationType;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataClassificationRepository;
import com.co.fashion.infrastructure.adapter.output.specification.ClassificationSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClassificationRepository implements ClassificationRepositoryPort {

	private final SpringDataClassificationRepository springDataClassificationRepository;

	public ClassificationRepository(SpringDataClassificationRepository springDataClassificationRepository) {
        this.springDataClassificationRepository = springDataClassificationRepository;
    }

	@Override
	public Classification save(Classification classification) {
		return springDataClassificationRepository.save(classification);
	}

	@Override
	public List<Classification> saveAll(List<Classification> classifications) {
		return springDataClassificationRepository.saveAll(classifications);
	}

	@Override
	public Optional<Classification> findById(Long id) {
		return springDataClassificationRepository.findById(id);
	}

	@Override
	public List<Classification> findWithFilters(String name, List<ClassificationType> types, PageRequest pageRequest) {
		Specification<Classification> specification = Specification.where(ClassificationSpecification.filterByName(name))
				.and(ClassificationSpecification.filterByTypes(types));

        return springDataClassificationRepository.findAll(specification, pageRequest).getContent();
	}

	@Override
	public List<Classification> findAll() {
		return springDataClassificationRepository.findAll();
	}

	@Override
	public void deleteById(Classification classification) {
		springDataClassificationRepository.delete(classification);
	}

	@Override
    public boolean existsByNameAndType(String name, ClassificationType type) {
        return springDataClassificationRepository.existsClassificationByNameAndClassificationType(name, type);
    }
}
