package com.aziz.BootWithJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = "com.aziz.*")
public class BootWithJpaApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/boot-jpa");
		System.setProperty("server.port", "8585");
		SpringApplication.run(BootWithJpaApplication.class, args);
	}
	
	@Bean
    public Docket lastApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("")
                .description(" ")
                .version("2.0")
                .build();
    }

}
