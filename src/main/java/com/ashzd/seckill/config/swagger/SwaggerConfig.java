package com.ashzd.seckill.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @file: SwaggerConfig
 * @author: Ash
 * @date: 2019/7/14 16:54
 * @description:
 * @since:
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //swagger要扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.ashzd.seckill.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("简易秒杀系统 v1.0")
                .description("简易秒杀系统API文档")
                .termsOfServiceUrl("localhost:8080/")
                .contact(new Contact("Swagger测试", "localhost:8080/swagger-ui.html", "ash_zd@qq.com"))
                .version("1.0")
                .build();
    }
}
