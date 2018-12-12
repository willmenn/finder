package com.distance.finder.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Component
public class GeoPosition {

    private StoreService storeService;

    @Autowired
    public GeoPosition(StoreService storeService) {
        this.storeService = storeService;
    }

    public List<Store> getNumberOfStoresFromASinglePoint(int number, Double latitude, Double longitude) {
        return storeService.stores.stream()
                .map(store -> {
                    int distance = HaversineFormula.calculate(latitude, longitude,
                            store.getLatitude(), store.getLongitude());
                    return store.copy(distance);
                }).sorted(comparing(Store::getDistance))
                .limit(number)
                .collect(Collectors.toList());
    }
}
