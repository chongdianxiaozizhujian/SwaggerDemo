package com.springdemo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	/**
	 * 2.0基础版
	 */
	/*@Bean
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("swaggerdemo2high", "http://xxx.xxx.xxx", "123456@qq.com");
		return new ApiInfoBuilder()
				.title("API接口")
				.description("API接口")
				.contact(contact)
				.version("2.0.0")
				.build();
	}*/
	
	/**
	 * 2.0升级版
	 */
	
	@Bean
	public Docket api() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name("x-access-token").description("令牌").modelRef(new ModelRef("String")).parameterType("header").required(false).build();
		pars.add(tokenPar.build());
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex(".*"))
				.build()
				.globalOperationParameters(pars);
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("swaggerdemo2high", "http://xxx.xxx.xxx", "123456@qq.com");
		return new ApiInfoBuilder()
				.title("API接口")
				.description("API接口")
				.contact(contact)
				.version("2.0.0")
				.build();
	}
}
