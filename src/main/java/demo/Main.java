package demo;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "demo", version = "1.0", description = "API for Demo"))
public class Main {
    public static void main(String[ ] args) {
        Micronaut.run(Main.class, args);
    }
}
