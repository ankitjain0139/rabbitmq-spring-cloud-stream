package com.demo.cloudstream.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.cloudstream.rabbitmq"})
public class RabbitmqSpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqSpringCloudStreamApplication.class, args);
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.demo.cloudstream.rabbitmq")).build();
	   }

}
