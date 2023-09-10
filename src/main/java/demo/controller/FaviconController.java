package demo.controller;

import static io.micronaut.http.MediaType.APPLICATION_OCTET_STREAM;
import static io.micronaut.http.MediaType.APPLICATION_OCTET_STREAM_TYPE;

import java.io.InputStream;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.types.files.StreamedFile;

@Controller
public class FaviconController {
    public static final String PATH = "/favicon.ico";

    @Get(PATH)
    @Produces(APPLICATION_OCTET_STREAM)
    public StreamedFile getFavicon() {
        InputStream faviconStream = getClass().getResourceAsStream("/static/favicon.ico");
        return new StreamedFile(faviconStream, APPLICATION_OCTET_STREAM_TYPE).attach("favicon.ico");
    }
}
