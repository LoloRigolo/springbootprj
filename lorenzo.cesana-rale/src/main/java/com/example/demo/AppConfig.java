package com.example.demo;

import com.example.service.PictureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PictureService pictureService() {
        return new PictureService();
    }
}