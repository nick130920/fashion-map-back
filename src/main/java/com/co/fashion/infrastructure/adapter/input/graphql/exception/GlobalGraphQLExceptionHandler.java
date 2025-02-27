package com.co.fashion.infrastructure.adapter.input.graphql.exception;

import com.co.fashion.application.exception.ImageUploadException;
import com.co.fashion.domain.exception.BusinessException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;


@Component
@Slf4j
public class GlobalGraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
		if (ex instanceof NoSuchElementException) {
			return GraphQLError.newError()
					.message(ex.getMessage())
					.locations(List.of(new SourceLocation(env.getField().getSourceLocation().getLine(),
							env.getField().getSourceLocation().getColumn())))
					.build();
		}
		if (ex instanceof IllegalArgumentException) {
			return GraphQLError.newError()
					.message("Illegal argument: " + ex.getMessage())
					.path(env.getExecutionStepInfo().getPath()) // Obtén el path del error
					.build();
		}
		if (ex instanceof ImageUploadException) {
			return GraphQLError.newError()
					.message("Image Upload Failed: " + ex.getMessage())
					.locations(List.of(new SourceLocation(env.getField().getSourceLocation().getLine(),
							env.getField().getSourceLocation().getColumn())))
					.build();
		}
		if (ex instanceof RuntimeException) {
			GraphQLError graphQLError = GraphQLError.newError()
					.message("Runtime Exception: " + ex.getMessage())
					.path(env.getExecutionStepInfo().getPath())
					.build();

			log.info("GraphQLError: {}", graphQLError);

			return graphQLError;
		}

		return super.resolveToSingleError(ex, env);
	}


	/**
	 * Maneja excepciones de validación como ConstraintViolationException.
	 */
	@GraphQlExceptionHandler
	public GraphQLError handleConstraintViolationException(ConstraintViolationException ex, DataFetchingEnvironment env) {
		return GraphqlErrorBuilder.newError(env)
				.message("Validation error: " + ex.getMessage())
				.errorType(ErrorType.BAD_REQUEST)
				.build();
	}

	/**
	 * Maneja excepciones de negocio personalizadas.
	 */
	@GraphQlExceptionHandler
	public GraphQLError handleBusinessException(BusinessException ex, DataFetchingEnvironment env) {
		return GraphqlErrorBuilder.newError(env)
				.message("Business error: " + ex.getMessage())
				.errorType(ErrorType.BAD_REQUEST)
				.build();
	}

	/**
	 * Maneja excepciones genéricas.
	 */
	@GraphQlExceptionHandler
	public GraphQLError handleGenericException(Exception ex, DataFetchingEnvironment env) {
		return GraphqlErrorBuilder.newError(env)
				.message("An unexpected error occurred: " + ex.getMessage())
				.errorType(ErrorType.INTERNAL_ERROR)
				.build();
	}
	@GraphQlExceptionHandler
	public GraphQLError handleValidationException(ConstraintViolationException ex) {
		return GraphQLError.newError()
				.message("Validation error: " + ex.getMessage())
				.errorType(ErrorType.BAD_REQUEST)
				.locations(List.of(new SourceLocation(1, 1))) // Ubicación ficticia
				.build();
	}

}
