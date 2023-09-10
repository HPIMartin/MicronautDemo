package demo;

import static kong.unirest.Unirest.get;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import kong.unirest.Empty;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@MicronautTest
class SmokeTest {
    private @Inject EmbeddedServer embeddedServer;

    @BeforeEach
    void setup() {
        String serverUrl = embeddedServer.getURL().toString();
        Unirest.config().defaultBaseUrl(serverUrl);
    }

    @Test
    void generatesSwaggerYml() {
        HttpResponse<String> result = get("/swagger/swagger.yml").asString();

        assertStatusCode(result);
        assertThat(result.getBody()).contains("/favicon.ico:");
    }

    @ParameterizedTest
    @ValueSource(strings = { "/swagger-ui", "/live", "/favicon.ico" })
    void providesSwaggerUi(String subpath) {
        HttpResponse<Empty> result = get(subpath).asEmpty();

        assertStatusCode(result);
    }

    @Test
    @Disabled
    void healthEndpointAvailable() {
        HttpResponse<Empty> result = get("/health").asEmpty();

        assertStatusCode(result);
    }

    @Test
    @Disabled
    void graphiqlEndpointAvailable() {
        HttpResponse<Empty> result = get("/graphiql").asEmpty();

        assertStatusCode(result);
    }

    private void assertStatusCode(HttpResponse<?> response) {
        assertThat(response.getStatus()).isBetween(200, 299);
    }
}
