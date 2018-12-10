package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {

    List<Store> stores;

    public List<Store> getStores() {
        return stores;
    }


    public Store[] getNumberOfStoresFromASinglePoint(int number, String latitude, String longitude) {
        List<Store> storesWithDistance = new ArrayList();
        for (Store store : stores) {
            int distance = HaversineFormula.calculate(Double.valueOf(latitude), Double.valueOf(longitude),
                    Double.valueOf(store.getLatitude()), Double.valueOf(store.getLongitude()));

            Store copy = store.copy(distance);
            storesWithDistance.add(copy);
        }

        Collections.sort(storesWithDistance, Comparator.comparing(Store::getDistance));

        Store[] arrayLimitByNumber = new Store[number];
        System.arraycopy(storesWithDistance.toArray(), 0, arrayLimitByNumber, 0, number);

        return arrayLimitByNumber;
    }


    @Override
    public String toString() {
        return "Locations{" +
                "stores=" + stores +
                '}';
    }
}
