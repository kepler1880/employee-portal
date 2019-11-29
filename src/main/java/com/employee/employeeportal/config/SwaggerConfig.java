package com.employee.employeeportal.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.employee.employeeportal"))
	                .paths(regex("/api/v1/employees/*"))
	                .build()
	                .apiInfo(apiInformation());
	    }
	 
	 private ApiInfo apiInformation() {
		 return new ApiInfoBuilder().title("Employee Portal")
					.description("Employee Portal API List")
					.build();
		}
}
