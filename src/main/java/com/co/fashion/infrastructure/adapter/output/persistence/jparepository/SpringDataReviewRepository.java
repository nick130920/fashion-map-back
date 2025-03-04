package com.co.fashion.infrastructure.adapter.output.persistence.jparepository;

import com.co.fashion.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReviewRepository extends JpaRepository<Review, Long> {
}
