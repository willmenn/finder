package com.distance.finder.domain;

import org.junit.Test;

import static com.distance.finder.domain.StoreAndDistanceStub.*;
import static org.junit.Assert.*;

public class HaversineFormulaTest {

    @Test
    public void shouldBeAbleToCalculateDistanceBetweenCoordinatesFromAmsterdamToBrussels() {
        double distance = new HaversineFormula()
                .calculate(AMSTERDAM.getLatitude(), AMSTERDAM.getLongitude(),
                        BRUSSELS.getLatitude(), BRUSSELS.getLongitude());

        assertEquals(DISTANCE_AMSTERDAM_BRUSSELS, distance, 0.1);
    }

    @Test
    public void shouldBeAbleToCalculateDistanceBetweenCoordinatesFromAmsterdamToLuxembourg() {
        double distance = new HaversineFormula()
                .calculate(AMSTERDAM.getLatitude(), AMSTERDAM.getLongitude(),
                        LUXEMBOURG.getLatitude(), LUXEMBOURG.getLongitude());

        assertEquals(DISTANCE_AMSTERDAM_LUXEMBOURG, distance, 0.1);
    }

    @Test
    public void shouldBeAbleToCalculateDistanceBetweenCoordinatesFromBrusselsToLuxembourg() {
        double distance = new HaversineFormula()
                .calculate(BRUSSELS.getLatitude(), BRUSSELS.getLongitude(),
                        LUXEMBOURG.getLatitude(), LUXEMBOURG.getLongitude());

        assertEquals(DISTANCE_BRUSSELS_LUXEMBOURG, distance, 0.1);
    }
}