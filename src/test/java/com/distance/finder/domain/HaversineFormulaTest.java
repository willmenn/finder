package com.distance.finder.domain;

import org.junit.Test;

import static com.distance.finder.domain.StoreAndDistanceStub.*;
import static org.junit.Assert.*;

public class HaversineFormulaTest {

    @Test
    public void shouldBeAbleToCalculateDistanceBetweenCoordinates() {
        double distance = new HaversineFormula()
                .calculate(AMSTERDAM.getLatitude(), AMSTERDAM.getLongitude(),
                        BRUSSELS.getLatitude(), BRUSSELS.getLongitude());

        assertEquals(DISTANCE_AMSTERDAM_BRUSSELS, distance, 0.1);
    }
}