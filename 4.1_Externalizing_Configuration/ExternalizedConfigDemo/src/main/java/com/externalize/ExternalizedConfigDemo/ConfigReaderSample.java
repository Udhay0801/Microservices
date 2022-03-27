package com.externalize.ExternalizedConfigDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class ConfigReaderSample {

    @Value("${config.read.sample}")
    public String configReadString;
    
    @Value("${internal.config.sample}")
    public String innerConfig;
    
    //@Value("${external.config.sample}")
    //public String externalConfig;
    
    public void print()
    {
	 System.out.println("Config Read value:: "+configReadString);
	 System.out.println("Config Inner specific value:: "+innerConfig);
	 //System.out.println("Config outer specific value:: "+externalConfig);
    }
   
}
