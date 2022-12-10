package br.com.senac.codingliferay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket liferayEvpApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.senac.codingliferay"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Coding EVP REST API",
                "REST API developed for college project on SENAC",
                "1.0",
                "Terms of Service",
                new Contact("Igor Costa Gomes Souza", "https://github.com/icgsbr", "igorcostagomessouza@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html",
                new ArrayList<>()
        );
    }
}
