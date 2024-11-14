package com.example.demo;

import com.example.service.PictureService;
import com.example.demo.repository.PictureRepository;
import com.example.demo.repository.PictureRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PictureService pictureService() {
        PictureRepository pictureRepository = new PictureRepositoryImpl();
        
                return new PictureService(pictureRepository);
    }
}
