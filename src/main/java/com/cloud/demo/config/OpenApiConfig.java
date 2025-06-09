package com.cloud.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Springboot模板接口文档")
                        .version("1.0.0")
                        .description("Springboot模板API接口文档")
                        .contact(new Contact()
                                .name("cloud")
                                .email("cloud@gmail.com")
                                .url("https://your-site.com")
                        )
                );
    }
}
