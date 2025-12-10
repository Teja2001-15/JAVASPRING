package com.example.communitysavings.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Community Savings Hub API",
                version = "v1",
                description = "REST endpoints for managing savings groups (supplement to SOAP)",
                contact = @Contact(name = "CommunitySavings", email = "dev@example.com")
        )
)
public class OpenApiConfig {
}
