package com.distance.finder.controller;

import com.distance.finder.domain.Locations;
import com.distance.finder.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    private Locations locations;

    @Autowired
    public StoreController(Locations locations) {
        this.locations = locations;
    }

    @GetMapping("/stores")
    public Locations get() {
        return locations;
    }

    @GetMapping("/stores/{number}/from-single-point")
    public List<Store> getClosestFiveStoresFromPoint(@PathVariable("number") int number,
                                                     @RequestParam String latitude,
                                                     @RequestParam String longitude) {
        return locations.getNumberOfStoresFromASinglePoint(number, latitude, longitude);
    }
}
