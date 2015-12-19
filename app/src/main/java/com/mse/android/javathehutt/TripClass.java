package com.mse.android.javathehutt;
import com.google.android.gms.maps.model.LatLng;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Bill on 12/18/15.
 */
public class TripClass {
    private String vesselName;
    private LatLng destinationPosition;
    private LatLng departurePosition;
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    private Integer mCrewSize;
    private Date mDepartDate;
    private Date mReturnDate;
    private Date mActualReturnDate;
    private String mReason;
    private Boolean mTripComplete;

    public Boolean getmTripComplete() {
        return mTripComplete;
    }

    public void setmTripComplete(Boolean mTripComplete) {
        this.mTripComplete = mTripComplete;
    }

    public Date getmActualReturnDate() {
        return mActualReturnDate;
    }

    public void setmActualReturnDate(Date mActualReturnDate) {
        this.mActualReturnDate = mActualReturnDate;
    }

    public String getReason() {
        return mReason;
    }

    public void setReason(String mReason) {
        this.mReason = mReason;
    }

    public Integer getCrewSize() {
        return mCrewSize;
    }

    public void setCrewSize(Integer mCrewSize) {
        this.mCrewSize = mCrewSize;
    }

    public Date getDepartDate() {
        return mDepartDate;
    }

    public void setDepartDate(Date mDepartDate) {
        this.mDepartDate = mDepartDate;
    }

    public Date getReturnDate() {
        return mReturnDate;
    }

    public void setReturnDate(Date mReturnDate) {
        this.mReturnDate = mReturnDate;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setDestinationPosition(LatLng destinationPosition) {
        this.destinationPosition = destinationPosition;
    }

    public void setDeparturePosition(LatLng departurePosition) {
        this.departurePosition = departurePosition;
    }

    public LatLng getDestinationPosition() {
        return destinationPosition;
    }

    public LatLng getDeparturePosition() {
        return departurePosition;
    }

    public TripClass(String inputVesselName)
    {
        vesselName = inputVesselName;
        destinationPosition = new LatLng(0.0,0.0);
        departurePosition = new LatLng(0.0,0.0);
        setmTripComplete(false);
    }
}
