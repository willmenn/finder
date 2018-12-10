package com.distance.finder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

import static java.lang.Double.valueOf;

import static java.util.Comparator.comparing;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Locations {

    List<Store> stores;

    public List<Store> getStores() {
        return stores;
    }


    public Store[] getNumberOfStoresFromASinglePoint(int number, String latitude, String longitude) {
        List<Store> storesWithDistance = new ArrayList();
        for (Store store : stores) {
            int distance = HaversineFormula.calculate(valueOf(latitude), valueOf(longitude),
                    valueOf(store.getLatitude()), valueOf(store.getLongitude()));

            Store copy = store.copy(distance);
            storesWithDistance.add(copy);
        }

        storesWithDistance.sort(comparing(Store::getDistance));

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
