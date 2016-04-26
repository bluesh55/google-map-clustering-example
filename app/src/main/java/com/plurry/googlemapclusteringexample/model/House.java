package com.plurry.googlemapclusteringexample.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by osh on 2016. 4. 27..
 */

public class House implements ClusterItem {

    private LatLng location;
    private String address;

    public House(LatLng location, String address) {
        this.location = location;
        this.address  = address;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public LatLng getPosition() {
        return location;
    }
}
