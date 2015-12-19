package com.mse.android.javathehutt;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

/**
 * Created by Bill on 12/18/15.
 */
public class Departure {

    private LatLng departureLatLng,destinationLatLng;
    private String vesselName;
    private UUID uuid;

    public LatLng getDepartureLatLng() {
        return departureLatLng;
    }

    public LatLng getDestinationLatLng() {
        return destinationLatLng;
    }

    public String getVesselName() {
        return vesselName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setDepartureLatLng(LatLng departureLatLng) {
        this.departureLatLng = departureLatLng;
    }

    public void setDestinationLatLng(LatLng destinationLatLng) {
        this.destinationLatLng = destinationLatLng;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Departure() {
        uuid = UUID.randomUUID();
    }
}
