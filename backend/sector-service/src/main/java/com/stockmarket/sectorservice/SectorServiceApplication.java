package com.stockmarket.sectorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Collections;


@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
public class SectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SectorServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stockmarket"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Sector Microservice API",
				"API Documentation for Sector Microservice",
				"1.0",
				"Copyright- Udit Singhania",
				new Contact("Udit Singhania", "https://github.com/udisinghania", "udisinghania1998@gmail.com"),
				"API License",
				"https://github.com/udisinghania/stockmarket-project", Collections.emptyList());
	}
}
