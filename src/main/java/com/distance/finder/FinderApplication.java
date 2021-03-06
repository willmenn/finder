package com.distance.finder;

import com.distance.finder.domain.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


@SpringBootApplication
@EnableSwagger2
@Slf4j
public class FinderApplication {

    private static final String FILE_NOT_FOUND_MSG_ERROR = "Could not find file with stores.";

    public static void main(String[] args) {
        SpringApplication.run(FinderApplication.class, args);
    }

    @Bean
    @Profile("default")
    public StoreService buildLocationsFromFile(@Value("${stores.file}") String storesFilePath) {
        try {
            InputStream inputStream = new ClassPathResource("classpath:" + storesFilePath).getInputStream();
            return new ObjectMapper().readValue(inputStream, StoreService.class);
        } catch (IOException e) {
            log.info(FILE_NOT_FOUND_MSG_ERROR, e);
            return new StoreService(new ArrayList<>());
        }
    }

    @Bean
    @Profile("test")
    public StoreService buildLocationsFromFileForTests(@Value("${stores.file}") String storesFilePath) {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get(storesFilePath));
            return new ObjectMapper().readValue(mapData, StoreService.class);
        } catch (IOException e) {
            log.info(FILE_NOT_FOUND_MSG_ERROR, e);
            return new StoreService(new ArrayList<>());
        }
    }
}
