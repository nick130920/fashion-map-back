package com.co.fashion.application.port.output;

import com.co.fashion.domain.model.Review;

import java.util.List;
import java.util.Optional;

/**
 * Output port for Review repository.
 *
 * @author Firstname Lastname
 */
public interface ReviewRepositoryPort {
	/**
	 * Save all Reviews.
	 *
	 * @param reviews the Reviews to save
	 * @return the saved Reviews
	 */
	List<Review> saveAll(List<Review> reviews);
	/**
	 * Save a Review.
	 *
	 * @param review the Review to save
	 * @return the saved Review
	 */
	Review save(Review review);
	/**
	 * Get all reviews.
	 *
	 * @return all Reviews
	 */
	List<Review> findAll();
	/**
	 * Find a Review by id.
	 *
	 * @param id the id of the Review
	 * @return the Review if found, optional empty if not found
	 */
	Optional<Review> findById(Long id);
	/**
	 * Delete a Review by id.
	 *
	 * @param id the id of the Review
	 */
	void deleteById(Long id);
}