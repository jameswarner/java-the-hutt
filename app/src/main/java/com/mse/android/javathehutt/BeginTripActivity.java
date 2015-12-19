package com.mse.android.javathehutt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.maps.model.LatLng;

import java.util.Calendar;
import java.util.Date;

public class BeginTripActivity extends AppCompatActivity {

    private Button mDepDate;
    private Button mDepTime;
    private Button mRetDate;
    private Button mRetTime;
    private EditText mVesselName;
    private Spinner mTripType;
    private EditText mLatLongDest;
    private EditText mLatLongDepart;
    private LatLng dest;
    private LatLng depart;
    private EditText crewSize;
    private Date dep;
    private Date ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_trip);
        mDepDate = (Button) findViewById(R.id.begin_dep_date_input);
        mDepTime = (Button) findViewById(R.id.begin_dep_time_input);
        mRetDate = (Button) findViewById(R.id.begin_ret_date_input);
        mRetTime = (Button) findViewById(R.id.begin_ret_time_input);
        mVesselName = (EditText) findViewById(R.id.begin_vessel_name_input);
        mLatLongDepart = (EditText) findViewById(R.id.begin_departure_lat_long_input);
        mLatLongDest = (EditText) findViewById(R.id.begin_destination_lat_long_input);
        crewSize = (EditText) findViewById(R.id.begin_crew_count_input);
        dep = new Date();
        ret = new Date();

        mTripType = (Spinner) findViewById(R.id.trip_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.trip_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTripType.setAdapter(adapter);

        updateUI();
    }

    public void showDepDatePickerDialog(View view) {
        DialogFragment frag = new DatePickerFragment(mDepDate, dep);
        frag.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDepTimePickerDialog(View view) {
        DialogFragment frag = new TimePickerFragment(mDepTime, dep);
        frag.show(getSupportFragmentManager(), "timePicker");
    }

    public void showRetDatePickerDialog(View view) {
        DialogFragment frag = new DatePickerFragment(mRetDate, ret);
        frag.show(getSupportFragmentManager(), "datePicker");
    }

    public void showRetTimePickerDialog(View view) {
        DialogFragment frag = new TimePickerFragment(mRetTime, ret);
        frag.show(getSupportFragmentManager(), "timePicker");
    }

    public void onTripBeginSubmit(View view) {
        TripClass trip = MapDataSingleton.getInstance(BeginTripActivity.this).
                getTrip(MapDataSingleton.getInstance(BeginTripActivity.this).getLoginVesselname());
        if (null != trip) {
            String crew_size = crewSize.getText().toString();
            trip.setCrewSize(Integer.parseInt(crew_size));
            trip.setReason(mTripType.getSelectedItem().toString());
            Log.d("Begin Submit", "dep is " + dep.toString());
            trip.setDepartDate(dep);
            Log.d("Begin Submit", "ret is " + ret.toString());
            trip.setReturnDate(ret);
        }

        finish();
    }

    private void updateUI()
    {
        mVesselName.setText(MapDataSingleton.getInstance(BeginTripActivity.this).getLoginVesselname());
        TripClass trip = MapDataSingleton.getInstance(BeginTripActivity.this).
                    getTrip(MapDataSingleton.getInstance(BeginTripActivity.this).getLoginVesselname());
        if (null != trip) {
            dest = trip.getDestinationPosition();
            depart = trip.getDeparturePosition();

            mLatLongDepart.setText(depart.toString());
            mLatLongDest.setText(dest.toString());
        }
    }
 }
