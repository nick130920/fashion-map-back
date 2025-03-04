package com.co.fashion.infrastructure.adapter.input.graphql.controller;

import com.co.fashion.application.dto.request.ReviewRequest;
import com.co.fashion.application.dto.response.ReviewResponse;
import com.co.fashion.application.port.input.ReviewUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewGraphQlController {

	private final ReviewUseCase reviewUseCase;


	@QueryMapping
	public ReviewResponse review(@Argument Long id) {
		return reviewUseCase.findById(id);
	}

	@QueryMapping
	public List<ReviewResponse> reviews() {
		return reviewUseCase.findAll();
	}

	@MutationMapping
	public ReviewResponse createReview(@Argument ReviewRequest reviewRequest) {
		return reviewUseCase.createReview(reviewRequest);
	}

	@MutationMapping
	public List<ReviewResponse> createReviews(@Argument List<ReviewRequest> reviewRequest) {
		return reviewUseCase.createReviews(reviewRequest);
	}

	@MutationMapping
	public ReviewResponse updateReview(@Argument ReviewRequest reviewRequest) {
		return reviewUseCase.updateReview(reviewRequest);
	}

	@MutationMapping
	public Boolean deleteReview(@Argument Long id) {
		reviewUseCase.deleteReview(id);
		return true;
	}

}



