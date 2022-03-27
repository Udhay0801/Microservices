package com.profiling.ProfilingDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ProfilingDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProfilingDemoApplication.class, args);
		ConfigReaderSample configReaderSample = ctx.getBean(ConfigReaderSample.class);
		configReaderSample.print();
	}

}
