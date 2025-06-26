package com.example.bussapp.adapter;
// Gói chứa adapter kết nối dữ liệu với RecyclerView (danh sách tuyến xe buýt)

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.R;
import com.example.bussapp.RouteDetailActivity;
import com.example.bussapp.model.BusRoute;

import java.util.ArrayList;
import java.util.List;

public class BusRouteAdapter extends RecyclerView.Adapter<BusRouteAdapter.RouteViewHolder> {
    // Adapter giúp hiển thị danh sách tuyến xe buýt trong RecyclerView

    private List<BusRoute> routes; // Danh sách gốc tất cả tuyến xe
    private List<BusRoute> routesFiltered; // Danh sách sau khi lọc (dùng trong tìm kiếm)
    private Context context; // Ngữ cảnh, thường là Activity

    // Constructor nhận danh sách tuyến xe và context
    public BusRouteAdapter(Context context, List<BusRoute> routes) {
        this.context = context;
        this.routes = routes;
        this.routesFiltered = new ArrayList<>(routes); // Khởi tạo bản sao để dùng khi lọc
    }

    @NonNull
    @Override
    public RouteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Tạo ViewHolder, liên kết layout item_bus_route với từng item trong RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.item_bus_route, parent, false);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteViewHolder holder, int position) {
        // Gán dữ liệu cho từng item hiển thị trên RecyclerView
        BusRoute route = routesFiltered.get(position);

        // Đặt dữ liệu vào các TextView
        holder.routeNumberTextView.setText(route.getRouteNumber()); // Số tuyến
        holder.routeNameTextView.setText(route.getRouteName()); // Tên tuyến
        holder.operatingHoursTextView.setText(route.getOperatingHours()); // Giờ hoạt động
        holder.frequencyTextView.setText(route.getFrequency()); // Tần suất
        holder.routeLengthTextView.setText(route.getRouteLength() + " • " + route.getFare()); // Độ dài + giá vé

        // Xử lý sự kiện click vào item -> chuyển sang màn hình chi tiết tuyến xe
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RouteDetailActivity.class);
            // Gửi toàn bộ thông tin tuyến xe sang RouteDetailActivity
            intent.putExtra("route_number", route.getRouteNumber());
            intent.putExtra("route_name", route.getRouteName());
            intent.putExtra("operating_hours", route.getOperatingHours());
            intent.putExtra("frequency", route.getFrequency());
            intent.putExtra("route_length", route.getRouteLength());
            intent.putExtra("fare", route.getFare());
            intent.putExtra("description", route.getDescription());
            intent.putStringArrayListExtra("stops", new ArrayList<>(route.getStops()));
            context.startActivity(intent); // Mở màn hình chi tiết
        });
    }

    @Override
    public int getItemCount() {
        return routesFiltered.size(); // Trả về số lượng tuyến xe đang hiển thị
    }

    // Phương thức lọc danh sách tuyến xe theo từ khóa tìm kiếm
    public void filter(String query) {
        routesFiltered.clear(); // Xóa danh sách hiện tại
        if (query.isEmpty()) {
            routesFiltered.addAll(routes); // Nếu chuỗi rỗng, hiển thị lại tất cả
        } else {
            String lowerCaseQuery = query.toLowerCase().trim(); // Chuyển về chữ thường để tìm
            for (BusRoute route : routes) {
                // Nếu số tuyến hoặc tên tuyến có chứa từ khóa -> thêm vào danh sách lọc
                if (route.getRouteNumber().toLowerCase().contains(lowerCaseQuery) ||
                        route.getRouteName().toLowerCase().contains(lowerCaseQuery)) {
                    routesFiltered.add(route);
                }
            }
        }
        notifyDataSetChanged(); // Cập nhật lại giao diện danh sách
    }

    // Lớp giữ các view trong từng item của RecyclerView
    static class RouteViewHolder extends RecyclerView.ViewHolder {
        TextView routeNumberTextView, routeNameTextView, operatingHoursTextView,
                frequencyTextView, routeLengthTextView;

        public RouteViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ các thành phần từ layout XML vào biến Java
            routeNumberTextView = itemView.findViewById(R.id.routeNumberTextView);
            routeNameTextView = itemView.findViewById(R.id.routeNameTextView);
            operatingHoursTextView = itemView.findViewById(R.id.operatingHoursTextView);
            frequencyTextView = itemView.findViewById(R.id.frequencyTextView);
            routeLengthTextView = itemView.findViewById(R.id.routeLengthTextView);
        }
    }
}

