package com.example.epoint;

import java.beans.PropertyEditorSupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.epoint.dao.ProductsDAO;
import com.example.epoint.dao.ProductsDAOImpl;
import com.example.epoint.model.Products;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.epoint"})
public class EpointApplication  extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EpointApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EpointApplication.class, args);
	}
	@Bean
    public ResourceBundleMessageSource messageSource() {

        var source = new ResourceBundleMessageSource();
        source.setBasenames("messages/messages");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
	
}
