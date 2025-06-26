package com.example.bussapp.adapter;
// Gói chứa các lớp Adapter cho RecyclerView (để hiển thị danh sách các trạm dừng)

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bussapp.R;

import java.util.List;

public class BusStopAdapter extends RecyclerView.Adapter<BusStopAdapter.StopViewHolder> {
    // Adapter giúp liên kết danh sách các trạm xe buýt với RecyclerView

    private List<String> stops; // Danh sách tên các trạm dừng
    private Context context; // Context (ngữ cảnh), thường là Activity hoặc Fragment

    // Constructor khởi tạo adapter với context và danh sách trạm
    public BusStopAdapter(Context context, List<String> stops) {
        this.context = context;
        this.stops = stops;
    }

    @NonNull
    @Override
    public StopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout cho từng item của RecyclerView từ XML item_bus_stop
        View view = LayoutInflater.from(context).inflate(R.layout.item_bus_stop, parent, false);
        return new StopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StopViewHolder holder, int position) {
        // Gán dữ liệu cho từng item hiển thị (mỗi trạm dừng)
        String stopName = stops.get(position); // Lấy tên trạm theo vị trí
        holder.stopNameTextView.setText(stopName); // Hiển thị tên trạm

        // Tạo mô tả cho từng trạm dừng bằng phương thức getStopDescription
        String description = getStopDescription(stopName);
        holder.stopDescriptionTextView.setText(description); // Hiển thị mô tả
    }

    @Override
    public int getItemCount() {
        return stops.size(); // Tổng số trạm trong danh sách
    }

    // Phương thức tạo mô tả cho từng trạm dựa trên tên
    private String getStopDescription(String stopName) {
        switch (stopName) {
            case "Bến Thành":
                return "Trạm chính • Khu vực trung tâm";
            case "Nguyễn Huệ":
                return "Phố đi bộ • Khu thương mại";
            case "Đồng Khởi":
                return "Trung tâm Q1 • Khách sạn cao cấp";
            case "Chợ Lớn":
                return "Khu Tàu Q5 • Chợ lớn";
            case "Sân bay Tân Sơn Nhất":
                return "Sân bay quốc tế • Terminal 1&2";
            case "Bến xe Miền Đông":
                return "Bến xe liên tỉnh • Khu vực Bình Thạnh";
            case "Bến xe Miền Tây":
                return "Bến xe liên tỉnh • An Lạc";
            case "Suối Tiên":
                return "Khu du lịch • Quận 9";
            case "Củ Chi":
                return "Huyện ngoại thành • Di tích lịch sử";

            // Thêm mô tả cho các trạm khác
            case "Lê Hồng Phong":
                return "Trạm chính • Quận 5";
            case "Trần Phú":
                return "Khu dân cư • Quận 5";
            case "Phạm Viết Chánh":
                return "Khu thương mại • Quận 1";
            case "Cống Quỳnh":
                return "Khu dân cư • Quận 1";
            case "Phạm Ngũ Lão":
                return "Khu phố Tây • Quận 1";
            case "Nguyễn Cư Trinh":
                return "Khu dân cư • Quận 1";
            case "Tôn Đức Thắng":
                return "Khu văn phòng • Quận 1";
            case "Nguyễn Hữu Cảnh":
                return "Khu đô thị mới • Quận 1";
            case "Xa lộ Hà Nội":
                return "Tuyến đường chính • Quận 2";
            case "Ngã tư Bình Thái":
                return "Ngã tư lớn • Quận 9";
            case "Ngã tư Thủ Đức":
                return "Trung tâm Thủ Đức • Quận Thủ Đức";
            case "Võ Văn Ngân":
                return "Khu trường học • Thủ Đức";
            case "Lê Văn Chí":
                return "Khu dân cư • Thủ Đức";
            case "Hoàng Diệu 2":
                return "Khu trường học • Thủ Đức";
            case "Kha Vạn Cân":
                return "Khu thương mại • Thủ Đức";
            case "Quốc lộ 1A":
                return "Tuyến đường chính • Thủ Đức";
            case "Bến xe buýt A ĐH Quốc gia":
                return "Bến xe đại học • Thủ Đức";
            case "Lê Quang Sung":
                return "Khu dân cư • Quận 6";
            case "Nguyễn Thị Nhỏ":
                return "Khu thương mại • Quận 6";
            case "Hồng Bàng":
                return "Khu dân cư • Quận 6";
            case "An Dương Vương":
                return "Khu trường học • Quận 6";
            case "Nguyễn Văn Cừ":
                return "Khu dân cư • Quận 5";
            case "Nguyễn Thị Minh Khai":
                return "Khu văn phòng • Quận 3";
            case "Nguyễn Văn Bá":
                return "Khu dân cư • Thủ Đức";
            case "Đặng Văn Bi":
                return "Khu trường học • Thủ Đức";
            case "Bến Trường Đại học Nông Lâm":
                return "Bến xe đại học • Thủ Đức";
            default:
                return "Trạm dừng • Khu vực thuận tiện"; // Mặc định nếu không khớp tên nào
        }
    }

    // ViewHolder: ánh xạ các thành phần trong layout item_bus_stop.xml
    static class StopViewHolder extends RecyclerView.ViewHolder {
        TextView stopNameTextView, stopDescriptionTextView;

        public StopViewHolder(@NonNull View itemView) {
            super(itemView);
            stopNameTextView = itemView.findViewById(R.id.stopNameTextView); // Hiển thị tên trạm
            stopDescriptionTextView = itemView.findViewById(R.id.stopDescriptionTextView); // Hiển thị mô tả
        }
    }
}

