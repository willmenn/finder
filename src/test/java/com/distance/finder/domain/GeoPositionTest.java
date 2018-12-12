package com.distance.finder.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.distance.finder.domain.StoreAndDistanceStub.AMSTERDAM;
import static com.distance.finder.domain.StoreAndDistanceStub.BRUSSELS;
import static com.distance.finder.domain.StoreAndDistanceStub.LUXEMBOURG;
import static org.junit.Assert.*;

public class GeoPositionTest {

    @Mock
    HaversineFormula formula;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldBeAbleToReturnEmptyGivenNoRecord() {
        StoreService storeService = new StoreService(new ArrayList<>());
        GeoPosition geoPosition = new GeoPosition(storeService, formula);
        List<Store> stores = geoPosition
                .getNumberOfStoresFromASinglePoint(5, AMSTERDAM.getLatitude(), AMSTERDAM.getLongitude());
        assertTrue(stores.isEmpty());
    }

    @Test
    public void shouldBeAbleToReturnOnlyTheClosestStores() {
        StoreService storeService = new StoreService(new ArrayList<>());
        storeService.getStores().add(AMSTERDAM);
        storeService.getStores().add(BRUSSELS);
        storeService.getStores().add(LUXEMBOURG);

        GeoPosition geoPosition = new GeoPosition(storeService, formula);
        List<Store> stores = geoPosition
                .getNumberOfStoresFromASinglePoint(2, AMSTERDAM.getLatitude(), AMSTERDAM.getLongitude());
        assertEquals(2, stores.size());

        assertEquals(AMSTERDAM.getCity(), stores.get(0).getCity());
        assertEquals(BRUSSELS.getCity(), stores.get(1).getCity());
    }
}