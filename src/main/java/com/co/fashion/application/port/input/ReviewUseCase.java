package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.request.ReviewRequest;
import com.co.fashion.application.dto.response.ReviewResponse;

import java.util.List;

public interface ReviewUseCase {

    /**
        * Find a Review by id.
        *
        * @param id a id
        * @return a ReviewResponse
    */
	ReviewResponse findById(Long id);

	/**
    	 * Get a list of all Reviews.
    	 *
    	 * @return a list of ReviewResponses
    */
    List<ReviewResponse> findAll();

	/**
	 * Create a list of Reviews.
	 *
	 * @param requests a list of ReviewRequests
	 * @return a list of ReviewResponses
	 */
	List<ReviewResponse> createReviews(List<ReviewRequest> requests);

	/**
	 * Create a Review.
	 *
	 * @param reviewRequest a ReviewRequest
	 * @return a ReviewResponse
	 */
	ReviewResponse createReview(ReviewRequest reviewRequest);



	/**
	 * Update a Review.
	 *
	 * @param request a ReviewRequest
	 * @return a ReviewResponse
	 */
	ReviewResponse updateReview(ReviewRequest request);

    /**
         * Delete a Review.
         *
         * @param id an id
     */
	void deleteReview(Long id);





}
