package com.mse.android.javathehutt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class BeginTripActivity extends AppCompatActivity {

    private Button mDepDate;
    private Button mDepTime;
    private Button mRetDate;
    private Button mRetTime;
    private Spinner mTripType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_trip);
        mDepDate = (Button) findViewById(R.id.begin_dep_date_input);
        mDepTime = (Button) findViewById(R.id.begin_dep_time_input);
        mRetDate = (Button) findViewById(R.id.begin_ret_date_input);
        mRetTime = (Button) findViewById(R.id.begin_ret_time_input);

        mTripType = (Spinner) findViewById(R.id.trip_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.trip_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTripType.setAdapter(adapter);

    }

    public void showDepDatePickerDialog(View view) {
        DialogFragment frag = new DatePickerFragment(mDepDate);
        frag.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDepTimePickerDialog(View view) {
        DialogFragment frag = new TimePickerFragment(mDepTime);
        frag.show(getSupportFragmentManager(), "timePicker");
    }

    public void showRetDatePickerDialog(View view) {
        DialogFragment frag = new DatePickerFragment(mRetDate);
        frag.show(getSupportFragmentManager(), "datePicker");
    }

    public void showRetTimePickerDialog(View view) {
        DialogFragment frag = new TimePickerFragment(mRetTime);
        frag.show(getSupportFragmentManager(), "timePicker");
    }

    public void onTripBeginSubmit(View view) {
        finish();
    }
 }
