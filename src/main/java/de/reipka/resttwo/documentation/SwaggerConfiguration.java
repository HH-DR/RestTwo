package de.reipka.resttwo.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("de.reipka.resttwo.controller")) // select information to publish by Package
                //.paths(PathSelectors.any())
                .paths(PathSelectors.ant("/person/get/*"))                // select by URI
                .build()                                                            // build Docket
                .apiInfo(setApiInfo());                                             // set ApiInfo into Docket

    }

    List<VendorExtension> vendorExtensions = new ArrayList<>();
    Contact contact = new Contact("Developer Name", "DeveloperUrl", "DeveloperEmail");

    private ApiInfo setApiInfo(){

        return new ApiInfo("RestTwo API",
                "Endpoints of ResTwo API",
                "1.0",
                "http://find",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                vendorExtensions
        );
    }

}

