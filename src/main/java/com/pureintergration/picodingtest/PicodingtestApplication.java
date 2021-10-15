package com.pureintergration.picodingtest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pureintergration.picodingtest.model.Dog;
import com.pureintergration.picodingtest.service.IDogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PicodingtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicodingtestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(IDogService dogService){

        return args -> {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream is = TypeReference.class.getResourceAsStream("json/data.json");
            List<Dog> dogList = new ArrayList<>();
            try {
                dogList = objectMapper.readValue(is, new TypeReference<List<Dog>>() {
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            for (Dog dog : dogList) {
                dogService.save(dog);
            }
        };

    }
}
