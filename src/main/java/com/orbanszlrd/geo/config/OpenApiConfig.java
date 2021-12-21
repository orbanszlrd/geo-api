package com.orbanszlrd.geo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Geo API")
                        .description("Geo API Documentation using OpenAPI 3.")
                        .version("v1.0.0")
                        .license(new License().name("MIT License").url("https://github.com/orbanszlrd/geo-api/blob/main/LICENSE"))
                        .contact(new Contact().name("Szilárd Orbán").email("orbanszlrd@gmail.com").url("https://weathermap.hu"))
                );
    }
}
