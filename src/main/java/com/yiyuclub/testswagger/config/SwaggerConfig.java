package com.yiyuclub.testswagger.config;

import io.swagger.annotations.Api;
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket创建
     * 通过groupName进行分组
     * paths属性进行过滤
     * apis属性可以设置扫描包，或者通过注解的方式标识
     * 通过enable属性，可以在application-{profile}.properties文件中设置相应值，主要用于控制生产环境不生成接口文档
     */
    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                .apis((RequestHandlerSelectors.withClassAnnotation(Api.class)))
                .paths(PathSelectors.any())
                .build();
    }

    //接口文档的基本说明信息，包括标题、描述、服务网址、联系人、版本等信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("swagger测试")
                //描述
                .description("springboot 整合swagger测试")
                .termsOfServiceUrl("www.baidu.com")
                .contact(new Contact("yiyu","guangxi","1062849557@qq.com"))
                .version("version 1.0")
                .build();
    }

}
