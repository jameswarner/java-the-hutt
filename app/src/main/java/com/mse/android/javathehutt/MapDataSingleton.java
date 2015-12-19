package com.mse.android.javathehutt;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Bill on 12/18/15.
 */
public class MapDataSingleton {
    private static MapDataSingleton mapDataSingleton;

    public LatLng getSavedDeparture() {
        return savedDeparture;
    }

    public LatLng getSavedDestination() {
        return savedDestination;
    }

    private LatLng savedDeparture;

    public void setSavedDestination(LatLng savedDestination) {
        this.savedDestination = savedDestination;
    }

    public void setSavedDeparture(LatLng savedDeparture) {
        this.savedDeparture = savedDeparture;
    }

    private LatLng savedDestination;
    private Context context;
    public static MapDataSingleton getInstance(Context context) {
        if (null == mapDataSingleton) {
            mapDataSingleton = new MapDataSingleton(context);
        }

        return mapDataSingleton;
    }

    private MapDataSingleton(Context inputContext)
    {
        context = inputContext;
    }
}
