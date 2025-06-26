package com.example.bussapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bussapp.adapter.BusStopAdapter;
import java.util.ArrayList;

/**
 * Màn hình chi tiết tuyến xe buýt, hiển thị các thông tin như: mã tuyến, tên tuyến,
 * thời gian hoạt động, tần suất, độ dài, giá vé và danh sách trạm dừng.
 */
public class RouteDetailActivity extends AppCompatActivity {

    // Các thành phần giao diện để hiển thị chi tiết tuyến
    private TextView routeNumberDetail, routeNameDetail, routeDescription;
    private TextView operatingHoursDetail, frequencyDetail, routeLengthDetail, fareDetail;
    private RecyclerView stopsRecyclerView;
    private BusStopAdapter stopsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail); // Gán layout XML cho Activity

        initializeViews();     // Ánh xạ các view trong giao diện
        setupRecyclerView();   // Thiết lập danh sách trạm dừng (RecyclerView)
        loadRouteData();       // Nhận và hiển thị dữ liệu từ Intent gửi sang

        // Cấu hình nút quay lại trên thanh ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Hiện nút quay lại
            getSupportActionBar().setTitle("Chi tiết tuyến");       // Tiêu đề của màn hình
        }
    }

    /**
     * Ánh xạ các view trong layout XML bằng ID.
     */
    private void initializeViews() {
        routeNumberDetail = findViewById(R.id.routeNumberDetail);
        routeNameDetail = findViewById(R.id.routeNameDetail);
        routeDescription = findViewById(R.id.routeDescription);
        operatingHoursDetail = findViewById(R.id.operatingHoursDetail);
        frequencyDetail = findViewById(R.id.frequencyDetail);
        routeLengthDetail = findViewById(R.id.routeLengthDetail);
        fareDetail = findViewById(R.id.fareDetail);
        stopsRecyclerView = findViewById(R.id.stopsRecyclerView);
    }

    /**
     * Cấu hình RecyclerView để hiển thị danh sách các trạm dừng.
     */
    private void setupRecyclerView() {
        stopsRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Hiển thị theo chiều dọc
        stopsRecyclerView.setHasFixedSize(true);                           // Tăng hiệu suất nếu kích thước không thay đổi
        stopsRecyclerView.setNestedScrollingEnabled(false);               // Tắt cuộn lồng nhau nếu trong ScrollView
    }

    /**
     * Nhận dữ liệu từ Intent (được truyền từ MainActivity khi người dùng chọn tuyến) và hiển thị.
     */
    private void loadRouteData() {
        // Lấy dữ liệu gửi từ Intent
        String routeNumber = getIntent().getStringExtra("route_number");
        String routeName = getIntent().getStringExtra("route_name");
        String description = getIntent().getStringExtra("description");
        String operatingHours = getIntent().getStringExtra("operating_hours");
        String frequency = getIntent().getStringExtra("frequency");
        String routeLength = getIntent().getStringExtra("route_length");
        String fare = getIntent().getStringExtra("fare");
        ArrayList<String> stops = getIntent().getStringArrayListExtra("stops");

        // Hiển thị dữ liệu lên các TextView
        routeNumberDetail.setText(routeNumber);
        routeNameDetail.setText(routeName);
        routeDescription.setText(description);
        operatingHoursDetail.setText(operatingHours);
        frequencyDetail.setText(frequency);
        routeLengthDetail.setText(routeLength);
        fareDetail.setText(fare);

        // Gắn adapter để hiển thị danh sách trạm dừng
        if (stops != null) {
            stopsAdapter = new BusStopAdapter(this, stops);
            stopsRecyclerView.setAdapter(stopsAdapter);
        }
    }

    /**
     * Xử lý sự kiện khi người dùng nhấn nút back trên ActionBar.
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Quay lại màn hình trước đó
        return true;
    }
}

