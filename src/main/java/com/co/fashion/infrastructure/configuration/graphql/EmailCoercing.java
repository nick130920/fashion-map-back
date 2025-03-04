package com.co.fashion.infrastructure.configuration.graphql;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingSerializeException;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.regex.Pattern;

public class EmailCoercing implements Coercing<String, String> {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	@Override
	public String serialize(@NotNull Object dataFetcherResult, @NotNull GraphQLContext context, @NotNull Locale locale) throws CoercingSerializeException {
		if (dataFetcherResult instanceof String) {
			return dataFetcherResult.toString(); // Serializa como String
		}
		throw new CoercingSerializeException("Expected a String for email.");
	}
	@Override
	public String parseValue(@NotNull Object input, @NotNull GraphQLContext context, @NotNull Locale locale) throws CoercingParseLiteralException {
		if (input instanceof String email && EMAIL_PATTERN.matcher(email).matches()) {
			return email;
		}
		throw new IllegalArgumentException("Invalid email format: " + input);
	}

	@Override
	public String parseLiteral(@NotNull Value<?> inputValue, @NotNull CoercedVariables variables, @NotNull GraphQLContext context, @NotNull Locale locale) {
		if (inputValue instanceof StringValue stringValue) {
			String email = stringValue.getValue();
			if (EMAIL_PATTERN.matcher(email).matches()) {
				return email;
			}
		}
		throw new IllegalArgumentException("Invalid email format in literal: " + inputValue);
	}
}
