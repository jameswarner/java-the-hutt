package com.mse.android.javathehutt;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.kml.KmlLayer;

import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.CompoundButton;

import android.content.DialogInterface.OnClickListener;


import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button doneButton;
    private Button markDestinationButton;
    private Button markDepartureButton;
    private CheckBox iceOverlayCheckbox,radarOverlayCheckbox,tempOverlayCheckbox;
    private LatLng dutchHarbor = new LatLng(53.88,166.54);

    private Marker departureMarker,destinationMarker;
    private KmlLayer iceLayer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        doneButton = (Button) findViewById(R.id.done_map);
        doneButton.setEnabled(false);
        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MapDataSingleton.getInstance(MapsActivity.this)
                        .setSavedDeparture(departureMarker.getPosition());
                MapDataSingleton.getInstance(MapsActivity.this)
                        .setSavedDestination(destinationMarker.getPosition());
                MapsActivity.this.finish();
//                MapDataSingleton.getInstance(MapsActivity.this)
//                        .addDeparture("minnow",
//                                departureMarker.getPosition(),
//                                destinationMarker.getPosition());
                MapDataSingleton instance = MapDataSingleton.getInstance(MapsActivity.this);
                TripClass tripClass = instance.getTrip(instance.getLoginVesselname());
                tripClass.setDeparturePosition(departureMarker.getPosition());
                tripClass.setDestinationPosition(destinationMarker.getPosition());
                TripClass testTrip = instance.getTrip(instance.getLoginVesselname());
                System.out.println("MapsActivity departure position "+testTrip.getDeparturePosition().toString());
            }
        });

        markDestinationButton = (Button) findViewById(R.id.mark_destination);
        markDestinationButton.setEnabled(false);
        markDestinationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LatLng center = mMap.getCameraPosition().target;
                destinationMarker = mMap.addMarker(new MarkerOptions()
                        .position(center)
                        .title("Destination")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                        .draggable(true));
                markDestinationButton.setEnabled(false);
                doneButton.setEnabled(true);
            }
        });

        markDepartureButton = (Button) findViewById(R.id.mark_departure);
        markDepartureButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                LatLng center = mMap.getCameraPosition().target;
                departureMarker = mMap.addMarker(new MarkerOptions()
                                        .position(center)
                                        .title("Departure")
                                        .draggable(true));
            markDepartureButton.setEnabled(false);
            markDestinationButton.setEnabled(true);
            }
        });

        iceOverlayCheckbox = (CheckBox)findViewById(R.id.ice);
        iceOverlayCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (true == isChecked) {
                    try {
                        iceLayer.addLayerToMap();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                } else {
                    mMap.clear();
                }
            }
        });

        radarOverlayCheckbox = (CheckBox)findViewById(R.id.radar);
        radarOverlayCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (true == isChecked) {

                } else {
                }
            }
        });

        tempOverlayCheckbox = (CheckBox)findViewById(R.id.temperature);
        tempOverlayCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (true == isChecked)
                {
                }
                else
                {
                }
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        mMap.addMarker(new MarkerOptions().position(cseds).title("Marker on CSEDS"));
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        //Move the camera to the user's location and zoom in!
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(dutchHarbor, 7.0f),4000,null);

        try {
            iceLayer = new KmlLayer(mMap,R.raw.full_latest,getApplicationContext());
        }
        catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
