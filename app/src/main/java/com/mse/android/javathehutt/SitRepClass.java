package com.mse.android.javathehutt;

import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

/**
 * Created by Kevin on 12/19/15.
 */
public class SitRepClass {
    private Date mDate;
    private LatLng mPosition;
    private Boolean mIce;
    private Integer mAirTemp;
    private Integer mWaterTemp;
    private Integer mWindSpeed;

    public Integer getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(Integer mWindSpeed) {
        this.mWindSpeed = mWindSpeed;
    }

    public Integer getWaterTemp() {
        return mWaterTemp;
    }

    public void setWaterTemp(Integer mWaterTemp) {
        this.mWaterTemp = mWaterTemp;
    }

    public Integer getAirTemp() {
        return mAirTemp;
    }

    public void setAirTemp(Integer mAirTemp) {
        this.mAirTemp = mAirTemp;
    }

    public Boolean getIce() {
        return mIce;
    }

    public void setIce(Boolean mIce) {
        this.mIce = mIce;
    }

    public LatLng getPosition() {
        return mPosition;
    }

    public void setPosition(LatLng mPosition) {
        this.mPosition = mPosition;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

}
