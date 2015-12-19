package com.mse.android.javathehutt.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mse.android.javathehutt.JavaTheHutt;

/**
 * Created by Bill on 12/18/15.
 */
public class JavaTheHuttHelper extends SQLiteOpenHelper {
    private static int version = 1;
    private static final String databaseName = "theHutDB.db";
    public JavaTheHuttHelper(Context context)
    {
        super(context,databaseName,null,version);

    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table "+MapDBSchema.MapTable.name+"("+
        "_id integer primary key auto_increment,"+
                MapDBSchema.MapTable.Cols.uuid+","+
        MapDBSchema.MapTable.Cols.departureLat+","+
        MapDBSchema.MapTable.Cols.departureLon+","+
        MapDBSchema.MapTable.Cols.destinationLat+","+
        MapDBSchema.MapTable.Cols.destinationLon+","+
        MapDBSchema.MapTable.Cols.shipName+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
