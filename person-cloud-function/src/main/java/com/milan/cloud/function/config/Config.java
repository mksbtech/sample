package com.milan.cloud.function.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.milan.cloud.function.vo.PersonVO;

@Configuration
public class Config {
	@Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
	
	@Bean
	public PersonVO getPersonVO() {
		return new PersonVO();
	}
}
