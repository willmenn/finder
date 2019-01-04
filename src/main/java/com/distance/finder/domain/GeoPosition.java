package com.distance.finder.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static lombok.AccessLevel.PRIVATE;

@Component
public class GeoPosition {

    private StoreService storeService;
    private HaversineFormula formula;

    @Autowired
    public GeoPosition(StoreService storeService, HaversineFormula formula) {
        this.storeService = storeService;
        this.formula = formula;
    }

    public List<Store> getNumberOfStoresFromASinglePoint(int number, Double latitude, Double longitude) {
        return storeService.getStores().stream()
                .map(store -> new StoreDistance(store, formula.calculate(latitude, longitude,
                        store.getLatitude(), store.getLongitude())))
                .sorted(comparing(StoreDistance::getDistance))
                .map(StoreDistance::getStore)
                .limit(number)
                .collect(Collectors.toList());
    }

    @AllArgsConstructor
    @Getter(value = PRIVATE)
    private static class StoreDistance {
        private Store store;
        private double distance;
    }
}
