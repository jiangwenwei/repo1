package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Profile({"test","dev"})
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket01(Environment environment){

        return new Docket(SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("one")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.controller"))
//                .paths(PathSelectors.ant("/controller/**"))
                .paths(PathSelectors.ant("/hello/**"))
                .build();
    }
    private ApiInfo apiInfo(){
        Contact contact= new Contact("还可以", "http://www.baidu.com", "12121212@12.com");

        return new ApiInfo(

                "Swagger文档",
                "第一个swagger文档",
                "v1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

    @Bean
    public Docket docket02(){
        return new Docket(SWAGGER_2).groupName("all");
    }
}
