package com.distance.finder;

import com.distance.finder.domain.Locations;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class FinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinderApplication.class, args);
    }

    @Bean
    @Profile("default")
    public Locations buildLocationsFromFile() {
        try {
            byte[] mapData = Files.readAllBytes(Paths.get("stores.json"));
            Locations locations = new ObjectMapper().readValue(mapData, Locations.class);
            System.out.println(locations);
            return locations;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    @Profile("test")
    public Locations test(){
        return new Locations();
    }
}
