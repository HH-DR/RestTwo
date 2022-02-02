//package de.reipka.resttwo.documentation;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//
//
//    @Bean
//    public Docket postsApi(){
//
//        System.out.println("Building Docket");
//        return new Docket(DocumentationType.SWAGGER_2)
//                    .select()
//                    .apis(RequestHandlerSelectors.basePackage("de.reipka.resttwo"))
//                    //.apiInfo(apiDetails())
//                    //.groupName("public API")
//                    //.paths(PathSelectors.ant("/person/*"))			    // select by URI
//                    //.apis(RequestHandlerSelectors.basePackage("de.reipka.resttwo"))	// or by package
//                    .build();
//                              //  .apiIndo(apiDetails());
//    }
//
//    private ApiInfo apiDetails(){
//
//        return new ApiInfoBuilder().title("Resttwo API")
//                .description("Test Swagger on Resttwo API")
//                .termsOfServiceUrl("localhost:8080/")
//                //.contact("javainuse@gmail.com")
//                // .license("JavaInUse License")
//                //.licenseUrl("javainuse@gmail.com")
//                .version("1.0")
//                .build();
//    }
//}
