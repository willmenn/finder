package com.distance.finder.domain;

public class StoreAndDistanceStub {

    public static Store AMSTERDAM =
            new Store("Amsterdam", "Amsterdam", "0000001",
                    " Street 51", "Street 2", "Street 3",
                    52.3727598, 4.8936041, "0011");

    public static Store BRUSSELS =
            new Store("Brussels", "Brussels", "0000002",
                    " Street 52", "Street 2.1", "Street 3.1",
                    50.83857005, 4.375756406648373, "0012");

    public static Store LUXEMBOURG =
            new Store("Luxembourg", "Luxembourg", "0000003",
                    " Street 53", "Street 2.2", "Street 3.2",
                    49.8158683, 49.8158683, "0013");

    public static double DISTANCE_AMSTERDAM_BRUSSELS = 174.3;
    public static double DISTANCE_AMSTERDAM_LUXEMBOURG = 297.1;
    public static double DISTANCE_BRUSSELS_LUXEMBOURG = 168.6;
}
