package com.profiling.ProfilingDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConfigReaderSample {

    @Value("${config.read.sample}")
    public String configReadString;
    
    public String activeDBConn;
    
    @Profile("dev")
    @Bean
    public String devDBConnSetup()
    {
    	activeDBConn = "DEV DB Configured. Active DB is oracle-DEV";
    	return activeDBConn;
    }
    
    @Profile("qa")
    @Bean
    public String qaDBConnSetup()
    {
    	activeDBConn = "QA DB Configured. Active DB is oracle-QA";
    	return activeDBConn;
    }
    
    @Profile("prod")
    @Bean
    public String prodDBConnSetup()
    {
    	activeDBConn = "PROD DB is Configured. Active DB is oracle-PROD";
    	return activeDBConn;
    }
    
    public void print()
    {
		 System.out.println("Config Read value:: "+configReadString);
		 System.out.println(activeDBConn);
    }
   
}
