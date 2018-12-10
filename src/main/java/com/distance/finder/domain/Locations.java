package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {

    List<Store> stores;

    public List<Store> getStores() {
        return stores;
    }


    public List<Store> getNumberOfStoresFromASinglePoint(int number, String latitude, String longitude) {
        List<Store> storesWithDistance = new ArrayList();
        for (Store store : stores) {
            Store copy = store.copy();
            int distance = HaversineFormula.calculate(Double.valueOf(latitude), Double.valueOf(longitude),
                    Double.valueOf(copy.getLatitude()), Double.valueOf(copy.getLongitude()));
            copy.setDistance(distance);
            storesWithDistance.add(copy);
        }

        Collections.sort(storesWithDistance, Comparator.comparing(Store::getDistance));

        List<Store> arrayLimitByNumber = new ArrayList<>();
        System.arraycopy(storesWithDistance, 0, arrayLimitByNumber, 0, number);

        return arrayLimitByNumber;
    }


    @Override
    public String toString() {
        return "Locations{" +
                "stores=" + stores +
                '}';
    }
}
