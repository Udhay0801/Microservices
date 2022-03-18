package com.externalize.ExternalizedConfigDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class ExternalizedConfigDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ExternalizedConfigDemoApplication.class, args);
		ConfigReaderSample configReaderSample = ctx.getBean(ConfigReaderSample.class);
		configReaderSample.print();
	}

}
