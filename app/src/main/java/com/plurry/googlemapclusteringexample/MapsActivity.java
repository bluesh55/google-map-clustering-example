package com.plurry.googlemapclusteringexample;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.plurry.googlemapclusteringexample.model.House;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final double SEOUL_LAT = 37.5449546;
    private static final double SEOUL_LNG = 126.9647997;
    private static final LatLng Seoul = new LatLng(SEOUL_LAT, SEOUL_LNG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Seoul and move the camera
        mMap.addMarker(new MarkerOptions().position(Seoul));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Seoul, 14.0f));

        // 클러스터 매니저를 생성
        ClusterManager<House> mClusterManager = new ClusterManager<>(this, mMap);
        mMap.setOnCameraChangeListener(mClusterManager);

        for(int i=0; i<10; i++) {
            double lat = SEOUL_LAT + (i / 200d);
            double lng = SEOUL_LNG + (i / 200d);
            mClusterManager.addItem(new House(new LatLng(lat, lng), "House"+i));
        }
    }

}
