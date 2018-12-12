package com.distance.finder.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class HaversineFormulaTest {

    @Test
    public void shouldBeAbleToCalculateDistanceBetweenCoordinates() {
        double amsterdamLatitude = 52.3727598;
        double amsterdamLongitude = 4.8936041;

        double brusselsLatitude = 50.83857005;
        double brusselsLongitude = 4.375756406648373;

        double distance = new HaversineFormula()
                .calculate(amsterdamLatitude, amsterdamLongitude, brusselsLatitude, brusselsLongitude);

        assertEquals(174.3, distance, 0.1);
    }
}