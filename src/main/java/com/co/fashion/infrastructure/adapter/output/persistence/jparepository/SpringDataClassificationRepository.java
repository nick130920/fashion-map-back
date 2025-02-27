package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.Classification;
import com.co.fashion.domain.model.ClassificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SpringDataClassificationRepository extends JpaRepository<Classification, Long>, JpaSpecificationExecutor<Classification> {

	boolean existsClassificationByNameAndClassificationType(String name, ClassificationType classificationType);
}
