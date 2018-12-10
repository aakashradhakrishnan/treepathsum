package com.aakash.treepathsum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableAutoConfiguration
@SpringBootApplication
public class TreepathsumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreepathsumApplication.class, args);
	}
}