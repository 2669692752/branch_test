package com.jm.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author lyx
 * @date
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jm.test.controller"))
                .paths(PathSelectors.any())
                .build();

    }
    private ApiInfo apiInfo() {
        // TODO Auto-generated method stub
        return new ApiInfoBuilder()
                //页面标题
                .title("test")
                //创建人
//                .contact(new Contact("use_admin", "https://blog.csdn.net/use_admin/article/details/88901342",""))
                //版本号
                .version("1.0.1")
                //描述
                .description("SpringBoot使用swagge2构建的API")
                .build();
    }
}
