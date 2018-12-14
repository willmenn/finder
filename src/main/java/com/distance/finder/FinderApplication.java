package com.distance.finder;

import com.distance.finder.domain.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.nio.file.*;


@SpringBootApplication
@EnableSwagger2
public class FinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinderApplication.class, args);
    }

    @Bean
    public StoreService buildLocationsFromFile(@Value("${stores.file}") String storesFilePath) {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get(storesFilePath));
            return new ObjectMapper().readValue(mapData, StoreService.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
