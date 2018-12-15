package com.distance.finder.controller;

import com.distance.finder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class StoreController {

    private static final int NUMBER_OF_STORES = 5;
    private GeoPosition geoPosition;

    @Autowired
    public StoreController(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    @GetMapping("/stores")
    public GeoPosition get() {
        return geoPosition;
    }

    @GetMapping("/stores/nearby")
    @ResponseStatus(OK)
    public List<Store> getClosestFiveStoresFromPoint(@RequestParam Double latitude,
                                                     @RequestParam Double longitude) {
        return geoPosition
                .getNumberOfStoresFromASinglePoint(NUMBER_OF_STORES, latitude, longitude);
    }

}
