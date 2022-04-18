package com.produtos.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //http://localhost:8080/swagger-ui.html
    @Bean
    public Docket productionApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Produtos de API Info",
                "API Rest de cadastro de produtos.",
                "1.0",
                "Termes of Service",
                new Contact("Roberto Sona Junior",
                        "https://github.com/RobertoSonaJunior",
                        "roberto.sona.jr@hotmail.com"),
                "Apache Lincese Version 2.0",
                "https://apache.org/licenses/", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

}
