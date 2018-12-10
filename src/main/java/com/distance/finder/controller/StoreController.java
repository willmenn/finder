package com.distance.finder.controller;

import com.distance.finder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Store[] getClosestFiveStoresFromPoint(@PathVariable("number") int number,
                                                     @RequestParam String latitude,
                                                     @RequestParam String longitude) {
        return locations.getNumberOfStoresFromASinglePoint(number, latitude, longitude);
    }
}
