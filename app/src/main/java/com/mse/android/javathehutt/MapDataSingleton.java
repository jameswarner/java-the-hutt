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
import java.util.List;
import java.util.UUID;

    /**
     * Created by Bill on 12/18/15.
     */

    public class MapDataSingleton {
    private static MapDataSingleton mapDataSingleton;
        private String loginVesselname;

        //    private SQLiteDatabase sqLiteDatabase;
//    private MapCursorWrapper mapCursorWrapper;
//    private UUID uuid;
//    private String whereClause;
//    private String [] whereArgs;
        private ArrayList<TripClass> trips;




    public void addTrip(TripClass mytrip) {
        trips.add(mytrip);
    }

    public List<TripClass> getTrips(){return trips;};

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


    private LatLng savedDestination;
    private Context context;
    public static MapDataSingleton getInstance(Context context) {
        if (null == mapDataSingleton) {
            mapDataSingleton = new MapDataSingleton(context);
        }

        return mapDataSingleton;
    }

        public String getLoginVesselname()
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
        trips = new ArrayList<>();
    }

}
