package com.mse.android.javathehutt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.model.LatLng;
import com.mse.android.javathehutt.database.JavaTheHuttHelper;
import com.mse.android.javathehutt.database.MapCursorWrapper;
import com.mse.android.javathehutt.database.MapDBSchema;

import java.util.ArrayList;
import java.util.UUID;

    /**
     * Created by Bill on 12/18/15.
     */

    public class MapDataSingleton {
    private static MapDataSingleton mapDataSingleton;
        private String loginVesselname;

    public LatLng getSavedDeparture() {
        return savedDeparture;
    }

    public LatLng getSavedDestination() {
        return savedDestination;
    }

    private LatLng savedDeparture;
//    private SQLiteDatabase sqLiteDatabase;
//    private MapCursorWrapper mapCursorWrapper;
//    private UUID uuid;
//    private String whereClause;
//    private String [] whereArgs;
        private ArrayList<TripClass> trips;

    public void setSavedDestination(LatLng savedDestination) {
        this.savedDestination = savedDestination;
    }



    public void addTrip(TripClass mytrip) {
        trips.add(mytrip);
    }

    public TripClass getTrip(String name)
    {
        for (TripClass mytrip : trips)
        {
            if (mytrip.getVesselName().equals(name))
            {
                return mytrip;
            }
        }

        return null;
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

        public String getLoginTripname()
        {
            return loginVesselname;
        }

        public void setLoginVesselname(String vesselname)
        {
            loginVesselname = vesselname;
        }

    private MapDataSingleton(Context inputContext)
    {
        context = inputContext;
    }

}
