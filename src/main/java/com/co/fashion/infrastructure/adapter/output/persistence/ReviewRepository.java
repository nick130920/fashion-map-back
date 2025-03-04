package com.co.fashion.infrastructure.adapter.output.persistence;

import com.co.fashion.application.port.output.ReviewRepositoryPort;
import com.co.fashion.domain.model.Review;
import com.co.fashion.infrastructure.adapter.output.persistence.jparepository.SpringDataReviewRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This class implements the {@link ReviewRepositoryPort} interface using Spring Data JPA.
 */
@Repository
public class ReviewRepository implements ReviewRepositoryPort {

	private final SpringDataReviewRepository springDataReviewRepository;

	/**
	 * Constructs a new instance of {@link ReviewRepository}.
	 *
	 * @param springDataReviewRepository the Spring Data JPA repository for {@link Review}
	 */
	public ReviewRepository(SpringDataReviewRepository springDataReviewRepository) {
		this.springDataReviewRepository = springDataReviewRepository;
	}

	/**
	 * Saves a list of Reviews to the repository.
	 *
	 * @param Reviews the list of Reviews to be saved
	 * @return the list of saved Reviews
	 */
	@Override
	public List<Review> saveAll(List<Review> reviews) {
		return springDataReviewRepository.saveAll(reviews);
	}

	/**
	 * Saves a Review to the repository.
	 *
	 * @param review the Review to be saved
	 * @return the saved Review
	 */
	@Override
	public Review save(Review review) {
		return springDataReviewRepository.save(review);
	}

	/**
	 * Returns a list of all Reviews in the repository.
	 *
	 * @return a list of all Reviews
	 */
	@Override
	public List<Review> findAll() {
		return springDataReviewRepository.findAll();
	}

	/**
	 * Returns a Review by its ID if the Review exists in the repository.
	 *
	 * @param id the ID of the Review to be found
	 * @return an optional containing the Review if found, empty otherwise
	 */
	@Override
	public Optional<Review> findById(Long id) {
		return springDataReviewRepository.findById(id);
	}

	/**
	 * Deletes a Review by its ID.
	 *
	 * @param id the ID of the Review to be deleted
	 */
	@Override
	public void deleteById(Long id) {
		springDataReviewRepository.deleteById(id);
	}

}