package com.mse.android.javathehutt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

public class CompleteTripActivity extends AppCompatActivity {

    private Button mDepDate;
    private Button mDepTime;
    private Button mRetDate;
    private Button mRetTime;
    private EditText mVesselName;
    private TextView mTripType;
    private EditText mLatLongDest;
    private EditText mLatLongDepart;
    private LatLng dest;
    private LatLng depart;
    private EditText crewSize;
    private Date ret_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_trip);

        mDepDate = (Button) findViewById(R.id.complete_dep_date_input);
        mDepTime = (Button) findViewById(R.id.complete_dep_time_input);
        mRetDate = (Button) findViewById(R.id.complete_ret_date_input);
        mRetTime = (Button) findViewById(R.id.complete_ret_time_input);
        mVesselName = (EditText) findViewById(R.id.complete_vessel_name_input);
        mLatLongDepart = (EditText) findViewById(R.id.complete_departure_lat_long_input);
        mLatLongDest = (EditText) findViewById(R.id.complete_destination_lat_long_input);
        crewSize = (EditText) findViewById(R.id.complete_crew_count_input);
        mTripType = (TextView) findViewById(R.id.complete_trip_purpose_input);
        ret_date = new Date();

        updateUI();
    }

    public void onTripCompleteSubmit(View view) {
        TripClass trip = MapDataSingleton.getInstance(CompleteTripActivity.this).
                getTrip(MapDataSingleton.getInstance(CompleteTripActivity.this).getLoginVesselname());
        if (null != trip) {
            mRetDate.setText(ret_date.getMonth() + "/" + ret_date.getDate() + "/" + (ret_date.getYear()+1900));
            mRetTime.setText(ret_date.getHours() + ":" + ret_date.getMinutes());
            trip.setReturnDate(ret_date);
            trip.setmTripComplete(true);
        }

        finish();
    }

    private void updateUI()
    {
        mVesselName.setText(MapDataSingleton.getInstance(CompleteTripActivity.this).getLoginVesselname());
        TripClass trip = MapDataSingleton.getInstance(CompleteTripActivity.this).
                getTrip(MapDataSingleton.getInstance(CompleteTripActivity.this).getLoginVesselname());
        if (null != trip) {
            dest = trip.getDestinationPosition();
            depart = trip.getDeparturePosition();

            mLatLongDepart.setText(depart.toString());
            mLatLongDest.setText(dest.toString());

            Integer size = trip.getCrewSize();
            Log.d("Complete Plan", "Crew Size is " + size);
            crewSize.setText(Integer.toString(trip.getCrewSize()));
            Date dep_date = trip.getDepartDate();
            mDepDate.setText(dep_date.getMonth()+1 + "/" + dep_date.getDate() + "/" + dep_date.getYear());
            mDepTime.setText(dep_date.getHours() + ":" + dep_date.getMinutes());
            Log.d("Complete Plan", "ret_data year is " + ret_date.getYear());
            mRetDate.setText(ret_date.getMonth()+1 + "/" + ret_date.getDate() + "/" + (ret_date.getYear()+1900));
            mRetTime.setText(ret_date.getHours() + ":" + ret_date.getMinutes());

            mTripType.setText(trip.getReason());

        }
    }


}
