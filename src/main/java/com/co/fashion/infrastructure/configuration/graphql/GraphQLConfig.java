package com.co.fashion.infrastructure.configuration.graphql;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {
	@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
		return wiringBuilder -> wiringBuilder
				.scalar(ExtendedScalars.DateTime)
				.scalar(ExtendedScalars.GraphQLLong)
				.scalar(emailScalar())
				.scalar(uploadScalar());
	}

	@Bean
	public GraphQLScalarType dateTimeScalar() {
		return ExtendedScalars.DateTime;  // Registra DateTime
	}

	@Bean
	public GraphQLScalarType longScalar() {
		return ExtendedScalars.GraphQLLong;  // Registra Long
	}

	@Bean
	public GraphQLScalarType emailScalar() {
		return GraphQLScalarType.newScalar()
				.name("Email")
				.description("Custom scalar for email addresses")
				.coercing(new EmailCoercing())
				.build();
	}

	@Bean
	public GraphQLScalarType uploadScalar() {
		return GraphQLScalarType.newScalar()
				.name("Upload")
				.description("Custom scalar for file uploads")
				.coercing(new UploadCoercing())
				.build();
	}

}
