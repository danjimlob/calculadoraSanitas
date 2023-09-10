package com.calculadora.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${server.servlet.context-path:/}")
    private String contextPath;  // Obtiene el contexto de la aplicación desde las propiedades de Spring Boot

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.calculadora.controller"))
                .paths(PathSelectors.any())
                .build()
                .host("localhost:8080")
                ;
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Calculadora API")
                .description("API para realizar operaciones matemáticas con una calculadora")
                .version("1.0")
                .build();
    }
}
