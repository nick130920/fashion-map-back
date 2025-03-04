package com.co.fashion.application.service;

import com.co.fashion.application.dto.request.ReviewRequest;
import com.co.fashion.application.dto.response.ReviewResponse;
import com.co.fashion.application.exception.ReviewNotFoundException;
import com.co.fashion.application.mapper.ReviewMapper;
import com.co.fashion.application.port.input.ReviewUseCase;
import com.co.fashion.application.port.output.ReviewRepositoryPort;
import com.co.fashion.domain.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing reviews.
 */
@Service
@RequiredArgsConstructor
public class ReviewService implements ReviewUseCase {

    private final ReviewRepositoryPort reviewRepositoryPort;
    private final ReviewMapper reviewMapper;

    /**
     * Creates a new review.
     *
     * @param reviewRequest the review request input
     * @return the created review response
     * @throws IllegalArgumentException if the request is null
     */
    @Override
    @Transactional
    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        if (reviewRequest == null) {
            throw new IllegalArgumentException("ReviewRequest cannot be null");
        }

        Review review = reviewMapper.toEntity(reviewRequest);
        review = reviewRepositoryPort.save(review);

        return reviewMapper.toDto(review);
    }

    /**
     * Creates multiple reviews.
     *
     * @param reviewRequests the list of review requests
     * @return the list of created review responses
     * @throws IllegalArgumentException if the request list is null or empty
     */
    @Override
    @Transactional
    public List<ReviewResponse> createReviews(List<ReviewRequest> reviewRequests) {
        if (reviewRequests == null || reviewRequests.isEmpty()) {
            throw new IllegalArgumentException("ReviewRequests cannot be null or empty");
        }

        List<Review> reviews = reviewRequests.stream()
                .map(reviewMapper::toEntity)
                .collect(Collectors.toList());

        reviews = reviewRepositoryPort.saveAll(reviews);

        return reviewMapper.toDtoList(reviews);
    }

    /**
     * Retrieves all reviews.
     *
     * @return the list of review responses
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReviewResponse> findAll() {
        return reviewRepositoryPort.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Finds a review by ID.
     *
     * @param id the review ID
     * @return the found review response
     * @throws ReviewNotFoundException if the review is not found
     */
    @Override
    @Transactional(readOnly = true)
    public ReviewResponse findById(Long id) {
        return reviewRepositoryPort.findById(id)
                .map(reviewMapper::toDto)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found with ID: " + id));
    }

    /**
     * Updates a review.
     *
     * @param request the review request
     * @return the updated review response
     * @throws ReviewNotFoundException if the review is not found
     */
    @Override
    @Transactional
    public ReviewResponse updateReview(ReviewRequest request) {
        reviewRepositoryPort.findById(request.getId())
                .orElseThrow(() -> new ReviewNotFoundException("Review not found with ID: " + request.getId()));

        reviewMapper.toEntity(request);
        Review saved = reviewRepositoryPort.save(reviewMapper.toEntity(request));

        return reviewMapper.toDto(saved);
    }

    /**
     * Deletes a review by ID.
     *
     * @param id the review ID
     * @throws ReviewNotFoundException if the review is not found
     */
    @Override
    @Transactional
    public void deleteReview(Long id) {
        reviewRepositoryPort.deleteById(id);
    }
}