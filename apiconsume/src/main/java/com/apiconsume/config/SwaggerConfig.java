package com.apiconsume.config;
 
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2; 

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//first way of swagger
	   @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.groupName("restApi")
	        		.apiInfo(apiInfo())
	        		.select()
	        		.apis(RequestHandlerSelectors.basePackage("com.apiconsume.controller"))
	        		.paths(PathSelectors.any()).build();
	        
	    }
	    private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
					.title("RestApi Example")
					.description("Spring Rest API reference")
					.licenseUrl("avanish.as@gmail.com")
					.version("1.0")
					.build();
		}
	//Second way of swagger example
//	  @Bean
//	    public Docket api() {
//	        return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	                .apis(RequestHandlerSelectors.basePackage("com.spring.controller"))
//	                .paths(PathSelectors.any())
//	                .build()
//	                .apiInfo(getApiInformation())
//	                .useDefaultResponseMessages(false)
//	                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages()
//	                        );
//	    }
//
//	    private ApiInfo getApiInformation(){
//	        return new ApiInfo("Demo REST API",
//	                "This is a Demo API created using Spring Boot",
//	                "1.0",
//	                "API Terms of Service URL",
//	                new Contact("Progressive Coder", "www.progressivecoder.com", "coder.progressive@gmail.com"),
//	                "API License",
//	                "API License URL"
//	                );
//	    }
//	    private List<ResponseMessage> getCustomizedResponseMessages(){
//	        List<ResponseMessage> responseMessages = new ArrayList<>();
//	        responseMessages.add(new ResponseMessageBuilder().code(500).message("Server has crashed!!").responseModel(new ModelRef("Error")).build());
//	        responseMessages.add(new ResponseMessageBuilder().code(403).message("You shall not pass!!").build());
//	        return responseMessages;
//	    }
//    
}
 