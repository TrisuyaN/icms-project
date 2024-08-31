package com.sc.scbackend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.description}")
    private String appDescription;

    @Bean
    public OpenAPI openApi(@Value("${spring.application.name}") String applicationName, ObjectProvider<BuildProperties> buildProperties) {
        OpenAPI openAPI = new OpenAPI();
        openAPI.addServersItem(new Server().url("https://frp-bus.top:28088/"));
        openAPI.addServersItem(new Server().url("http://localhost:8088/"));

        // add header
        Map<String, SecurityScheme> map = new HashMap<>();
        map.put("x-auth-token", new SecurityScheme().type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.HEADER).name("x-auth-token"));
        openAPI.components(new Components().securitySchemes(map));
        map.keySet().forEach(key -> openAPI.addSecurityItem(new SecurityRequirement().addList(key)));

        // base info
        openAPI.info(new Info().title(applicationName)
                .description(appDescription)
                .version(Optional.ofNullable(buildProperties.getIfAvailable()).map(BuildProperties::getVersion).orElse("1.0.0")));
        return openAPI;
    }
}

