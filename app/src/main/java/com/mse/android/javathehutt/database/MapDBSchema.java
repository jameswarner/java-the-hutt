package com.mse.android.javathehutt.database;

/**
 * Created by Bill on 12/18/15.
 */
public class MapDBSchema {
    public static final class MapTable{
        public static final String name = "departures";
        public static final class Cols {
            public static final String uuid = "uuid";
            public static final String shipName = "shipname";
            public static final String departureLat = "departurelat";
            public static final String departureLon = "departurelon";
            public static final String destinationLat = "destinationlat";
            public static final String destinationLon = "destinationlon";
        }
    }
}
