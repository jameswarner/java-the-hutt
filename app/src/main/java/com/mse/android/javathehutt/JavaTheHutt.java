package com.mse.android.javathehutt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JavaTheHutt extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup mListView;
    private static final int REQUEST_LOGIN_RESPONSE = 100;
    private HashMap<String, Button> mButtonMap = new HashMap<String, Button>();

    private static final String A_LOGIN = "LOGIN";
    private static final String A_PLAN = "PLAN";
    private static final String A_BEGIN = "BEGIN";
    private static final String A_COLLECT = "COLLECT";
    private static final String A_COMPLETE = "COMPLETE";
    private static final String A_MONITOR = "MONITOR";
    private static final String A_ANALYZE ="ANALYZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_the_hutt);

        mListView = (ViewGroup) findViewById(R.id.list);

        addDemo(A_LOGIN, LoginActivity.class);
        addDemo(A_PLAN, MapsActivity.class);
        addDemo(A_BEGIN, BeginTripActivity.class);
        addDemo(A_COLLECT, CollectDataActivity.class);
        addDemo(A_COMPLETE, CompleteTripActivity.class);
        addDemo(A_MONITOR, MonitorTripActivity.class);
        addDemo(A_ANALYZE, AnalTripsActivity.class);

        mButtonMap.get(A_LOGIN).setEnabled(true);

        MapDataSingleton instance = MapDataSingleton.getInstance(JavaTheHutt.this);
        TripClass tripClass = new TripClass("Northwestern");
        tripClass.setDeparturePosition((new LatLng(51.0, 119.8)));
        tripClass.setDestinationPosition((new LatLng(55.0, 119.0)));
        tripClass.setCrewSize(3);
        tripClass.setCompleted(false);
        Date depart = new Date(2015,11,1);
        depart.setHours(8);
        depart.setMinutes(20);
        depart.setSeconds(32);
        Date ret = new Date(2015,11,20);
        ret.setHours(12);
        ret.setMinutes(10);
        ret.setSeconds(45);
        tripClass.setDepartDate(depart);
        tripClass.setReturnDate(ret);
        instance.addTrip(tripClass);
        TripClass tripClass2 = new TripClass("Time Bandit");
        tripClass2.setDeparturePosition((new LatLng(51.0, 110.8)));
        tripClass2.setDestinationPosition((new LatLng(55.0, 120.0)));
        tripClass2.setCrewSize(3);
        tripClass2.setCompleted(false);
        Date depart2 = new Date(2015,11,1);
        depart2.setHours(8);
        depart2.setMinutes(20);
        depart2.setSeconds(32);
        Date ret2 = new Date(2015,11,12);
        ret2.setHours(12);
        ret2.setMinutes(10);
        ret2.setSeconds(45);
        tripClass2.setDepartDate(depart2);
        tripClass2.setReturnDate(ret2);
        instance.addTrip(tripClass2);
        TripClass tripClass3 = new TripClass("Cornelia Marie");
        tripClass3.setDeparturePosition((new LatLng(52.0, 118.8)));
        tripClass3.setDestinationPosition((new LatLng(53.0, 117.0)));
        tripClass3.setCrewSize(9);
        tripClass3.setCompleted(false);
        Date depart3 = new Date(2015,11,5);
        depart3.setHours(8);
        depart3.setMinutes(20);
        depart3.setSeconds(32);
        Date ret3 = new Date(2015,11, 22);
        ret3.setHours(12);
        ret3.setMinutes(10);
        ret3.setSeconds(45);
        tripClass3.setDepartDate(depart3);
        tripClass3.setReturnDate(ret3);
        instance.addTrip(tripClass3);
        TripClass tripClass4 = new TripClass("Wizard");
        tripClass4.setDeparturePosition((new LatLng(50.0, 110.8)));
        tripClass4.setDestinationPosition((new LatLng(53.0, 109.0)));
        tripClass4.setCrewSize(4);
        tripClass4.setCompleted(true);
        Date depart4 = new Date(2015,11,10);
        depart4.setHours(8);
        depart4.setMinutes(20);
        depart4.setSeconds(32);
        Date ret4 = new Date(2015,11,15);
        ret4.setHours(12);
        ret4.setMinutes(10);
        ret4.setSeconds(45);
        tripClass4.setDepartDate(depart4);
        tripClass4.setReturnDate(ret4);
        instance.addTrip(tripClass4);
    }

    private void addDemo(String demoName, Class<? extends Activity> activityClass) {
        Button b = new Button(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                125);
        b.setLayoutParams(layoutParams);
        b.setText(demoName);
        b.setTag(activityClass);
        b.setOnClickListener(this);
        b.setEnabled(false);
        mListView.addView(b);
        mButtonMap.put(demoName, b);
    }

    @Override
    public void onClick(View view) {
        Class activityClass = (Class) view.getTag();
        if (LoginActivity.class == activityClass) {
            startActivityForResult(new Intent(this, activityClass), REQUEST_LOGIN_RESPONSE);
        }
        else {
            startActivity(new Intent(this, activityClass));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_java_the_hutt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_LOGIN_RESPONSE) {
            if (data == null) {
                return;
            }

            if (true == LoginActivity.wasLoginValidated(data)) {
                for(Button btn: mButtonMap.values()) {
                    btn.setEnabled(true);
                }
                mButtonMap.get(A_ANALYZE).setEnabled(false);
            }
        }

    }
}
