package com.distance.finder;

import com.distance.finder.domain.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@EnableSwagger2
public class FinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinderApplication.class, args);
    }

    @Bean
    @Profile("default")
    public StoreService buildLocationsFromFile() {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get("stores.json"));
            return new ObjectMapper().readValue(mapData, StoreService.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    @Profile("test")
    public StoreService test() {
        return new StoreService();
    }
}
