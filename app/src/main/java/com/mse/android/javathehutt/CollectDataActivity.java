package com.mse.android.javathehutt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;
import java.util.List;

public class CollectDataActivity extends AppCompatActivity {

    private TextView mDate;
    private TextView mLat;
    private TextView mLong;
    private TextView mIce;
    private TextView mAirTemp;
    private TextView mWaterTemp;
    private TextView mWindSpeed;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_data);

        mDate = (TextView) findViewById(R.id.collect_date_input);
        mLat = (EditText) findViewById(R.id.collect_data_lat);
        mLong = (EditText) findViewById(R.id.collect_data_long);
        mIce = (EditText) findViewById(R.id.collect_data_ice);
        mAirTemp = (EditText) findViewById(R.id.collect_data_air_temp);
        mWaterTemp = (EditText) findViewById(R.id.collect_data_water_temp);
        mWindSpeed = (EditText) findViewById(R.id.collect_data_wind_speed);
        date = new Date();

    }

    public void onCollectDataSubmit(View view) {
        TripClass trip = MapDataSingleton.getInstance(CollectDataActivity.this).
                getTrip(MapDataSingleton.getInstance(CollectDataActivity.this).getLoginVesselname());
        if (null != trip) {
            List<SitRepClass> sit_rep_list = trip.getSitRepList();
            SitRepClass sit_rep_record = new SitRepClass();
            LatLng latLng = new LatLng(Double.parseDouble(mLat.getText().toString()),
                                    Double.parseDouble(mLong.getText().toString()));
            sit_rep_record.setPosition(latLng);
            sit_rep_record.setDate(date);
            if ("false" == mIce.getText().toString()) {
                sit_rep_record.setIce(false);
            }
            else {
                sit_rep_record.setIce(true);
            }
            sit_rep_record.setAirTemp(Integer.parseInt(mAirTemp.getText().toString()));
            sit_rep_record.setWaterTemp(Integer.parseInt(mWaterTemp.getText().toString()));
            sit_rep_record.setWindSpeed(Integer.parseInt(mWindSpeed.getText().toString()));
            sit_rep_list.add(sit_rep_record);

            finish();
        }
    }

    public void getDataTime(View view) {
        mDate.setText(date.getMonth() + "/" + date.getDate() + "/" + (date.getYear()+1900) + "--" + date.getHours() + ":" + date.getMinutes());
    }
}
