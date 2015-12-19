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

    public LatLng getSavedDeparture() {
        return savedDeparture;
    }

    public LatLng getSavedDestination() {
        return savedDestination;
    }

    private LatLng savedDeparture;
    private SQLiteDatabase sqLiteDatabase;
    private MapCursorWrapper mapCursorWrapper;
    private UUID uuid;
    private String whereClause;
    private String [] whereArgs;

    public void setSavedDestination(LatLng savedDestination) {
        this.savedDestination = savedDestination;
    }

    public void addDeparture(String VesselName,
                             LatLng departure,
                             LatLng destination) {
        Departure newDeparture = new Departure();
        newDeparture.setVesselName(VesselName);
        newDeparture.setDepartureLatLng(departure);
        newDeparture.setDestinationLatLng(destination);

        ContentValues contentValues = new ContentValues();
        contentValues.put(MapDBSchema.MapTable.Cols.uuid,newDeparture.getUuid().toString());
        contentValues.put(MapDBSchema.MapTable.Cols.shipName,newDeparture.getVesselName().toString());

        contentValues.put(MapDBSchema.MapTable.Cols.departureLat,

                Double.toString(newDeparture.getDepartureLatLng().latitude));

        contentValues.put(MapDBSchema.MapTable.Cols.departureLon,
                Double.toString(newDeparture.getDepartureLatLng().longitude));

        contentValues.put(MapDBSchema.MapTable.Cols.destinationLat,
                Double.toString(newDeparture.getDestinationLatLng().latitude));

        contentValues.put(MapDBSchema.MapTable.Cols.destinationLat,
                Double.toString(newDeparture.getDestinationLatLng().longitude));

        sqLiteDatabase.insert(MapDBSchema.MapTable.name,
                null,
                contentValues);
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
        sqLiteDatabase = new JavaTheHuttHelper(inputContext).getWritableDatabase();
        context = inputContext;
    }

}
