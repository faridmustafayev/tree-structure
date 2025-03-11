package com.example.hamburg.academy.spring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class DocumentationConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("tree structure")
                                .description("use one Entity")
                                .version("1.1.1")
                                .contact(
                                        new Contact()
                                                .email("mustafayevfarid2002@gmail.com")
                                                .name("Farid")));
    }

}
