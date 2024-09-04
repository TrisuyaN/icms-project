package com.sc.scbackend.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.description}")
    private String appDescription;

    @Autowired
    private Environment env;

    @Bean
    public OpenAPI openApi(@Value("${spring.application.name}") String applicationName, ObjectProvider<BuildProperties> buildProperties) {
        OpenAPI openAPI = new OpenAPI();

        // 从 `application.yml` 获取 Servers
        List<String> serverUrls = List.of(env.getProperty("swagger.servers").split(","));
        for (String url : serverUrls) {
            openAPI.addServersItem(new Server().url(url.trim()));
        }

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

