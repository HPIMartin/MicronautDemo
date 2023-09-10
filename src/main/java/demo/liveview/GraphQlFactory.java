package demo.liveview;

/*
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.micronaut.context.annotation.Bean;
import io.micronaut.core.io.ResourceResolver;
import jakarta.inject.Singleton;
*/
import io.micronaut.context.annotation.Factory;

@Factory
public class GraphQlFactory {
    // @Bean
    // @Singleton
    // public GraphQL graphQL(ResourceResolver resourceResolver, LiveViewDataFetcher liveViewFetcher) {
    // SchemaParser schemaParser = new SchemaParser();
    //
    // TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
    // Optional<InputStream> graphqlSchema = resourceResolver.getResourceAsStream("classpath:schema.graphqls");
    //
    // if (graphqlSchema.isPresent()) {
    // typeRegistry.merge(schemaParser.parse(new BufferedReader(new InputStreamReader(graphqlSchema.get()))));
    //
    // RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
    // .type("Query", typeWiring -> typeWiring.dataFetcher("hello", liveViewFetcher)).build();
    //
    // return GraphQL.newGraphQL(new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring)).build();
    // } else {
    // return new GraphQL.Builder(GraphQLSchema.newSchema().build()).build();
    // }
    // }
}
