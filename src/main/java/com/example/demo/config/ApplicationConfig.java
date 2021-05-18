package com.example.demo.config;

import com.example.demo.data.HelloData;
import com.example.demo.mapper.HelloMapper;
import com.example.demo.response.HelloResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public HelloMapper helloMapper() {
        return new HelloMapper() {

            @Override
            public HelloResponse dataToResponse(HelloData helloData) {
                return HelloMapper.super.dataToResponse(helloData);
            }

        };
    }

}
