package com.example.bussapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.adapter.BusRouteAdapter;
import com.example.bussapp.data.BusDataManager;
import com.example.bussapp.model.BusRoute;
import com.google.android.material.textfield.TextInputEditText;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView routesRecyclerView;
    private BusRouteAdapter adapter;
    private TextInputEditText searchEditText;
    private List<BusRoute> busRoutes;
    private MapView mapView;
    private static final GeoPoint NONG_LAM_LOCATION = new GeoPoint(10.868056, 106.787500); // Trạm Bến Trường Đại học Nông Lâm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Khởi tạo cấu hình OSMDroid
        Configuration.getInstance().load(this, getSharedPreferences("osmdroid", MODE_PRIVATE));
        setContentView(R.layout.activity_main);

        initializeViews();
        setupRecyclerView();
        setupSearchFunction();
        loadBusRoutes();
        setupMap();
    }
// Ánh xạ các view từ layout XML và thiết lập ban đầu cho MapView và các nút

    private void initializeViews() {
        routesRecyclerView = findViewById(R.id.routesRecyclerView);
        searchEditText = findViewById(R.id.searchEditText);
        mapView = findViewById(R.id.osmMapView);
        Button myLocationButton = findViewById(R.id.myLocationButton);
        ImageButton backButton = findViewById(R.id.backButton);

        // Cấu hình MapView
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(15.0);
        mapView.getController().setCenter(NONG_LAM_LOCATION); // Đặt trung tâm ở Đại học Nông Lâm

        // Nút My Location
        myLocationButton.setOnClickListener(v -> {
            Log.d("MainActivity", "Di chuyển đến Đại học Nông Lâm: " + NONG_LAM_LOCATION);
            mapView.getController().animateTo(NONG_LAM_LOCATION);
        });

        // Nút Back
        backButton.setOnClickListener(v -> {
            Log.d("MainActivity", "Back button clicked, exiting activity");
            finish(); // Thoát Activity
        });
    }

    private void setupRecyclerView() {
        routesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        routesRecyclerView.setHasFixedSize(true);
    }
// Tạo bộ lọc tìm kiếm cho danh sách tuyến xe theo nội dung người dùng nhập vào ô tìm kiếm

    private void setupSearchFunction() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Không cần xử lý
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (adapter != null) {
                    adapter.filter(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Không cần xử lý
            }
        });
    }
// Tải dữ liệu tuyến xe từ lớp quản lý dữ liệu và hiển thị trong RecyclerView

    private void loadBusRoutes() {
        busRoutes = BusDataManager.getBusRoutesForStation();
        adapter = new BusRouteAdapter(this, busRoutes);
        routesRecyclerView.setAdapter(adapter);
    }

    private void setupMap() {
        initializeMap();
    }
// Hiển thị tất cả các trạm xe buýt từ các tuyến lên bản đồ bằng marker

    private void initializeMap() {
        // Thêm marker cho tất cả trạm của mỗi tuyến
        for (BusRoute route : busRoutes) {
            for (String stop : route.getStops()) {
                GeoPoint stopGeoPoint = BusDataManager.getStopGeoPoint(stop);
                if (stopGeoPoint != null) {
                    Log.d("MainActivity", "Thêm marker cho trạm: " + stop + " tại " + stopGeoPoint);
                    addBusStopMarker(stopGeoPoint, route, stop);
                } else {
                    Log.w("MainActivity", "Không tìm thấy tọa độ cho trạm: " + stop);
                }
            }
        }

        mapView.invalidate();
    }
// Thêm marker tại vị trí trạm xe và xử lý sự kiện khi người dùng nhấn vào marker để xem chi tiết tuyến

    private void addBusStopMarker(GeoPoint point, BusRoute route, String stopName) {
        Marker marker = new Marker(mapView);
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle(stopName);
        marker.setSnippet("Tuyến: " + route.getRouteNumber());
        marker.setOnMarkerClickListener((m, mapView) -> {
            m.showInfoWindow();
            // Chuyển đến RouteDetailActivity khi click marker
            Intent intent = new Intent(this, RouteDetailActivity.class);
            intent.putExtra("route_number", route.getRouteNumber());
            intent.putExtra("route_name", route.getRouteName());
            intent.putExtra("operating_hours", route.getOperatingHours());
            intent.putExtra("frequency", route.getFrequency());
            intent.putExtra("route_length", route.getRouteLength());
            intent.putExtra("fare", route.getFare());
            intent.putExtra("description", route.getDescription());
            intent.putStringArrayListExtra("stops", new ArrayList<>(route.getStops()));
            startActivity(intent);
            return true;
        });
        mapView.getOverlays().add(marker);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }
}
