package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.ClassificationType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface SpringDataClassificationTypeRepository extends JpaRepository<ClassificationType, Long> {
	Optional<ClassificationType> findByName(String name);

	@Query("SELECT c FROM ClassificationType c")
	@EntityGraph(value = "ClassificationType.withClassifications", type = EntityGraph.EntityGraphType.LOAD)
	List<ClassificationType> findWithClassifications();

}
