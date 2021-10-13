package com.mongocrud.springcrudmongo;

//import io.swagger.models.Contact;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
//@EnableSwagger2
@OpenAPIDefinition(info = @Info(title = "My Test API",version = "1.0",description = "This API helps to manage Users"))
public class SpringcrudmongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcrudmongoApplication.class, args);
    }

//    @Bean
//    public Docket swaggerConfiguration(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
////                .paths(PathSelectors.ant("/*"))
//                .apis(RequestHandlerSelectors.basePackage("com.mongocrud"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "My Test API",
//                "This API Only For Test Purposes",
//                "1.0",
//                "Terms of service",
//                new springfox.documentation.service.Contact("Manul", "manul.com", "manul@gmail.com"),
//                "License of API", "API license URL", Collections.emptyList());
//    }
}
