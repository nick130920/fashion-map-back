package com.co.fashion.infrastructure.configuration.graphql;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;

public class UploadCoercing implements Coercing<MultipartFile, MultipartFile> {

	@Override
	public MultipartFile serialize(Object dataFetcherResult, GraphQLContext context, Locale locale)
			throws CoercingSerializeException {
		if (dataFetcherResult instanceof MultipartFile multipartFile) {
			return multipartFile;
		}
		throw new CoercingSerializeException("Expected a MultipartFile.");
	}

	@Override
	public MultipartFile parseValue(Object input, GraphQLContext context, Locale locale)
			throws CoercingParseValueException {
		if (input instanceof MultipartFile multipartFile) {
			return multipartFile;
		}
		throw new CoercingParseValueException("Expected a MultipartFile.");
	}

	@Override
	public MultipartFile parseLiteral(Value<?> inputValue, CoercedVariables variables, GraphQLContext context, Locale locale)
			throws CoercingParseLiteralException {
		throw new CoercingParseLiteralException("Literals are not supported for file uploads.");
	}
}
