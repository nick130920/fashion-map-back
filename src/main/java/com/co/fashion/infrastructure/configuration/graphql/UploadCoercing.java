package com.co.fashion.infrastructure.configuration.graphql;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

public class UploadCoercing implements Coercing<MultipartFile, MultipartFile> {

	@Override
	public MultipartFile serialize(@NotNull Object dataFetcherResult, @NotNull GraphQLContext context, @NotNull Locale locale)
			throws CoercingSerializeException {
		if (dataFetcherResult instanceof MultipartFile multipartFile) {
			return multipartFile;
		}
		throw new CoercingSerializeException("Expected a MultipartFile.");
	}

	@Override
	public MultipartFile parseValue(@NotNull Object input, @NotNull GraphQLContext context, @NotNull Locale locale)
			throws CoercingParseValueException {
		if (input instanceof MultipartFile multipartFile) {
			return multipartFile;
		}
		throw new CoercingParseValueException("Expected a MultipartFile.");
	}

	@Override
	public MultipartFile parseLiteral(@NotNull Value<?> inputValue, @NotNull CoercedVariables variables, @NotNull GraphQLContext context, Locale locale)
			throws CoercingParseLiteralException {
		throw new CoercingParseLiteralException("Literals are not supported for file uploads.");
	}
}
