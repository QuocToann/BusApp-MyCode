package com.example.bussapp.data;

import com.example.bussapp.model.BusRoute;
import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusDataManager {

    // Lớp nội bộ để lưu trữ thông tin trạm
    public static class BusStop {
        private final String name;
        private final GeoPoint geoPoint;
        private final String description;

        public BusStop(String name, GeoPoint geoPoint, String description) {
            this.name = name;
            this.geoPoint = geoPoint;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public GeoPoint getGeoPoint() {
            return geoPoint;
        }

        public String getDescription() {
            return description;
        }
    }

    private static final Map<String, BusStop> busStops = new HashMap<>();

    static {
        // Khởi tạo danh sách trạm với tọa độ chính xác

        // Quận 1 - Trung tâm
        busStops.put("Bến Thành", new BusStop("Bến Thành", new GeoPoint(10.7726, 106.6979), "Trạm chính • Khu vực trung tâm"));
        busStops.put("Nguyễn Huệ", new BusStop("Nguyễn Huệ", new GeoPoint(10.7747, 106.7037), "Phố đi bộ • Khu thương mại"));
        busStops.put("Đồng Khởi", new BusStop("Đồng Khởi", new GeoPoint(10.7786, 106.7024), "Trung tâm Q1 • Khách sạn cao cấp"));
        busStops.put("Hàm Nghi", new BusStop("Hàm Nghi", new GeoPoint(10.7695, 106.6952), "Khu tài chính • Quận 1"));
        busStops.put("Pasteur", new BusStop("Pasteur", new GeoPoint(10.7788, 106.6944), "Khu văn phòng • Quận 1"));
        busStops.put("Lê Lợi", new BusStop("Lê Lợi", new GeoPoint(10.7741, 106.6986), "Khu thương mại • Quận 1"));
        busStops.put("Tôn Đức Thắng", new BusStop("Tôn Đức Thắng", new GeoPoint(10.7715, 106.7055), "Khu văn phòng • Quận 1"));
        busStops.put("Nguyễn Hữu Cảnh", new BusStop("Nguyễn Hữu Cảnh", new GeoPoint(10.7853, 106.7175), "Khu đô thị mới • Quận 1"));
        busStops.put("Trần Hưng Đạo", new BusStop("Trần Hưng Đạo", new GeoPoint(10.7560, 106.6890), "Khu dân cư • Quận 1"));
        busStops.put("Phạm Viết Chánh", new BusStop("Phạm Viết Chánh", new GeoPoint(10.7598, 106.6730), "Khu thương mại • Quận 1"));
        busStops.put("Cống Quỳnh", new BusStop("Cống Quỳnh", new GeoPoint(10.7635, 106.6850), "Khu dân cư • Quận 1"));
        busStops.put("Phạm Ngũ Lão", new BusStop("Phạm Ngũ Lão", new GeoPoint(10.7569, 106.6924), "Khu phố Tây • Quận 1"));
        busStops.put("Nguyễn Cư Trinh", new BusStop("Nguyễn Cư Trinh", new GeoPoint(10.7588, 106.6910), "Khu dân cư • Quận 1"));
        busStops.put("Mạc Đỉnh Chi", new BusStop("Mạc Đỉnh Chi", new GeoPoint(10.7738, 106.6850), "Khu văn phòng • Quận 1"));
        busStops.put("Đinh Tiên Hoàng", new BusStop("Đinh Tiên Hoàng", new GeoPoint(10.7811, 106.6953), "Khu trường học • Quận 1"));
        busStops.put("Thảo Cầm Viên", new BusStop("Thảo Cầm Viên", new GeoPoint(10.7876, 106.7070), "Khu du lịch • Quận 1"));

        // Quận 3
        busStops.put("Nguyễn Thái Học", new BusStop("Nguyễn Thái Học", new GeoPoint(10.7682, 106.6816), "Khu dân cư • Quận 3"));
        busStops.put("Điện Biên Phủ", new BusStop("Điện Biên Phủ", new GeoPoint(10.7912, 106.6950), "Khu văn phòng • Quận 3"));
        busStops.put("Nguyễn Thị Minh Khai", new BusStop("Nguyễn Thị Minh Khai", new GeoPoint(10.7884, 106.6907), "Khu văn phòng • Quận 3"));

        // Quận 5 - Chợ Lớn
        busStops.put("Bến xe Chợ Lớn", new BusStop("Bến xe Chợ Lớn", new GeoPoint(10.7508, 106.6507), "Bến xe liên tỉnh • Quận 5"));
        busStops.put("Thuận Kiều Plaza", new BusStop("Thuận Kiều Plaza", new GeoPoint(10.7544, 106.6495), "Khu thương mại • Quận 5"));
        busStops.put("Bệnh viện Chợ Rẫy", new BusStop("Bệnh viện Chợ Rẫy", new GeoPoint(10.7547, 106.6598), "Bệnh viện lớn • Quận 5"));
        busStops.put("Đại học Y Dược", new BusStop("Đại học Y Dược", new GeoPoint(10.7562, 106.6611), "Trường đại học • Quận 5"));
        busStops.put("Bệnh viện Đại học Y Dược", new BusStop("Bệnh viện Đại học Y Dược", new GeoPoint(10.7566, 106.6615), "Bệnh viện • Quận 5"));
        busStops.put("Bệnh viện Nguyễn Tri Phương", new BusStop("Bệnh viện Nguyễn Tri Phương", new GeoPoint(10.7571, 106.6621), "Bệnh viện • Quận 5"));
        busStops.put("Chợ An Đông", new BusStop("Chợ An Đông", new GeoPoint(10.7580, 106.6631), "Chợ lớn • Quận 5"));
        busStops.put("Huỳnh Mẫn Đạt", new BusStop("Huỳnh Mẫn Đạt", new GeoPoint(10.7591, 106.6641), "Khu dân cư • Quận 5"));
        busStops.put("Chợ Bầu Sen", new BusStop("Chợ Bầu Sen", new GeoPoint(10.7601, 106.6651), "Chợ địa phương • Quận 5"));
        busStops.put("Đại học Sài Gòn", new BusStop("Đại học Sài Gòn", new GeoPoint(10.7625, 106.6737), "Trường đại học • Quận 5"));
        busStops.put("ĐH Khoa Học Tự Nhiên", new BusStop("ĐH Khoa Học Tự Nhiên", new GeoPoint(10.7624, 106.6672), "Trường đại học • Quận 5"));
        busStops.put("Trường Lê Hồng Phong", new BusStop("Trường Lê Hồng Phong", new GeoPoint(10.7631, 106.6681), "Trường THPT • Quận 5"));
        busStops.put("Bệnh viện Tù Dũ", new BusStop("Bệnh viện Tù Dũ", new GeoPoint(10.7641, 106.6691), "Bệnh viện • Quận 5"));
        busStops.put("Tôn Thất Tùng", new BusStop("Tôn Thất Tùng", new GeoPoint(10.7651, 106.6701), "Khu dân cư • Quận 5"));
        busStops.put("Sở Y Tế", new BusStop("Sở Y Tế", new GeoPoint(10.7661, 106.6711), "Cơ quan hành chính • Quận 5"));
        busStops.put("Nhà Văn Hóa Lao Động", new BusStop("Nhà Văn Hóa Lao Động", new GeoPoint(10.7671, 106.6721), "Trung tâm văn hóa • Quận 5"));
        busStops.put("Chợ Lớn", new BusStop("Chợ Lớn", new GeoPoint(10.7508, 106.6507), "Khu Tàu Q5 • Chợ lớn"));
        busStops.put("Lê Hồng Phong", new BusStop("Lê Hồng Phong", new GeoPoint(10.7580, 106.6750), "Trạm chính • Quận 5"));
        busStops.put("Trần Phú", new BusStop("Trần Phú", new GeoPoint(10.7570, 106.6740), "Khu dân cư • Quận 5"));
        busStops.put("Nguyễn Văn Cừ", new BusStop("Nguyễn Văn Cừ", new GeoPoint(10.7476, 106.6605), "Khu dân cư • Quận 5"));
        busStops.put("Quận 5", new BusStop("Quận 5", new GeoPoint(10.7540, 106.6680), "Trung tâm Quận 5"));

        // Quận 6
        busStops.put("Lê Quang Sung", new BusStop("Lê Quang Sung", new GeoPoint(10.7522, 106.6344), "Khu dân cư • Quận 6"));
        busStops.put("Nguyễn Thị Nhỏ", new BusStop("Nguyễn Thị Nhỏ", new GeoPoint(10.7502, 106.6334), "Khu thương mại • Quận 6"));
        busStops.put("Hồng Bàng", new BusStop("Hồng Bàng", new GeoPoint(10.7492, 106.6324), "Khu dân cư • Quận 6"));
        busStops.put("An Dương Vương", new BusStop("An Dương Vương", new GeoPoint(10.7482, 106.6314), "Khu trường học • Quận 6"));
        busStops.put("Quận 6", new BusStop("Quận 6", new GeoPoint(10.7460, 106.6290), "Trung tâm Quận 6"));

        // Bình Thạnh
        busStops.put("Cầu Thị Nghè", new BusStop("Cầu Thị Nghè", new GeoPoint(10.7922, 106.7086), "Cầu lớn • Quận Bình Thạnh"));
        busStops.put("Nhà Thờ Thì Nghè", new BusStop("Nhà Thờ Thì Nghè", new GeoPoint(10.7932, 106.7096), "Nhà thờ • Quận Bình Thạnh"));
        busStops.put("Trung tâm Dưỡng Lão", new BusStop("Trung tâm Dưỡng Lão", new GeoPoint(10.7942, 106.7106), "Trung tâm dưỡng lão • Quận Bình Thạnh"));
        busStops.put("Trường trung học Gia Định", new BusStop("Trường trung học Gia Định", new GeoPoint(10.7952, 106.7116), "Trường THPT • Quận Bình Thạnh"));
        busStops.put("Đại học Hutech", new BusStop("Đại học Hutech", new GeoPoint(10.8058, 106.7130), "Trường đại học • Quận Bình Thạnh"));
        busStops.put("Khu Du lịch Văn Thánh", new BusStop("Khu Du lịch Văn Thánh", new GeoPoint(10.8068, 106.7140), "Khu du lịch • Quận Bình Thạnh"));
        busStops.put("Bến xe Miền Đông", new BusStop("Bến xe Miền Đông", new GeoPoint(10.8150, 106.7170), "Bến xe liên tỉnh • Bình Thạnh"));
        busStops.put("Xô Viết Nghệ Tĩnh", new BusStop("Xô Viết Nghệ Tĩnh", new GeoPoint(10.8020, 106.7140), "Khu dân cư • Bình Thạnh"));

        // Quận 2 (Thủ Đức cũ)
        busStops.put("Cầu Sài Gòn", new BusStop("Cầu Sài Gòn", new GeoPoint(10.7950, 106.7220), "Cầu lớn • Quận 2"));
        busStops.put("Cầu Đen", new BusStop("Cầu Đen", new GeoPoint(10.7960, 106.7230), "Cầu lớn • Quận 2"));
        busStops.put("Thảo Điền", new BusStop("Thảo Điền", new GeoPoint(10.8040, 106.7350), "Khu dân cư cao cấp • Quận 2"));
        busStops.put("Metro Quận 2", new BusStop("Metro Quận 2", new GeoPoint(10.8050, 106.7360), "Trạm metro • Quận 2"));
        busStops.put("Cát Lái", new BusStop("Cát Lái", new GeoPoint(10.8116, 106.7681), "Khu công nghiệp • Quận 2"));
        busStops.put("Xi măng hà tiên - trạm thu phí", new BusStop("Xi măng hà tiên - trạm thu phí", new GeoPoint(10.8126, 106.7691), "Trạm thu phí • Quận 2"));
        busStops.put("Xa lộ Hà Nội", new BusStop("Xa lộ Hà Nội", new GeoPoint(10.8080, 106.7390), "Tuyến đường chính • Quận 2"));

        // Quận 9 (Thủ Đức cũ)
        busStops.put("Ngã 4 Tây Hòa (RMK)", new BusStop("Ngã 4 Tây Hòa (RMK)", new GeoPoint(10.8136, 106.7701), "Ngã tư lớn • Quận 9"));
        busStops.put("Trạm xây dựng", new BusStop("Trạm xây dựng", new GeoPoint(10.8146, 106.7711), "Khu công nghiệp • Quận 9"));
        busStops.put("Khu QLGTDT số 2", new BusStop("Khu QLGTDT số 2", new GeoPoint(10.8156, 106.7721), "Khu quản lý • Quận 9"));
        busStops.put("Trường ĐHSP Kỹ Thuật", new BusStop("Trường ĐHSP Kỹ Thuật", new GeoPoint(10.8166, 106.7731), "Trường đại học • Quận 9"));
        busStops.put("Công ty Sanofi Aventis", new BusStop("Công ty Sanofi Aventis", new GeoPoint(10.8176, 106.7741), "Khu công nghiệp • Quận 9"));
        busStops.put("Công ty may Sài Gòn", new BusStop("Công ty may Sài Gòn", new GeoPoint(10.8186, 106.7751), "Khu công nghiệp • Quận 9"));
        busStops.put("Trường mầm non Vành Khuyên", new BusStop("Trường mầm non Vành Khuyên", new GeoPoint(10.8196, 106.7761), "Trường mầm non • Quận 9"));
        busStops.put("Làng trẻ em SOS", new BusStop("Làng trẻ em SOS", new GeoPoint(10.8206, 106.7771), "Làng trẻ em • Quận 9"));
        busStops.put("Ngã ba Chương Dương", new BusStop("Ngã ba Chương Dương", new GeoPoint(10.8216, 106.7781), "Ngã ba lớn • Quận 9"));
        busStops.put("Cao đẳng xây dựng 2", new BusStop("Cao đẳng xây dựng 2", new GeoPoint(10.8226, 106.7791), "Trường cao đẳng • Quận 9"));
        busStops.put("Siêu thị Nguyễn Kim", new BusStop("Siêu thị Nguyễn Kim", new GeoPoint(10.8236, 106.7801), "Siêu thị • Quận 9"));
        busStops.put("Công an Quận 9", new BusStop("Công an Quận 9", new GeoPoint(10.8246, 106.7811), "Công an • Quận 9"));
        busStops.put("Chợ chiều", new BusStop("Chợ chiều", new GeoPoint(10.8256, 106.7821), "Chợ địa phương • Quận 9"));
        busStops.put("Khu Công nghệ cao quận 9", new BusStop("Khu Công nghệ cao quận 9", new GeoPoint(10.8266, 106.7831), "Khu công nghệ cao • Quận 9"));
        busStops.put("Khu Du lịch Suối Tiên", new BusStop("Khu Du lịch Suối Tiên", new GeoPoint(10.8850, 106.8050), "Khu du lịch • Quận 9"));
        busStops.put("Ngã tư Bình Thái", new BusStop("Ngã tư Bình Thái", new GeoPoint(10.8250, 106.7450), "Ngã tư lớn • Quận 9"));

        // Thủ Đức
        busStops.put("Đại học Nông Lâm", new BusStop("Đại học Nông Lâm", new GeoPoint(10.868056, 106.787500), "Trường đại học • Thủ Đức"));
        busStops.put("Ngã tư Thủ Đức", new BusStop("Ngã tư Thủ Đức", new GeoPoint(10.8480, 106.7720), "Trung tâm Thủ Đức • Quận Thủ Đức"));
        busStops.put("Võ Văn Ngân", new BusStop("Võ Văn Ngân", new GeoPoint(10.8500, 106.7710), "Khu trường học • Thủ Đức"));
        busStops.put("Lê Văn Chí", new BusStop("Lê Văn Chí", new GeoPoint(10.8520, 106.7800), "Khu dân cư • Thủ Đức"));
        busStops.put("Hoàng Diệu 2", new BusStop("Hoàng Diệu 2", new GeoPoint(10.8540, 106.7850), "Khu trường học • Thủ Đức"));
        busStops.put("Kha Vạn Cân", new BusStop("Kha Vạn Cân", new GeoPoint(10.8560, 106.7900), "Khu thương mại • Thủ Đức"));
        busStops.put("Quốc lộ 1A", new BusStop("Quốc lộ 1A", new GeoPoint(10.8580, 106.7950), "Tuyến đường chính • Thủ Đức"));
        busStops.put("Bến xe buýt A ĐH Quốc gia", new BusStop("Bến xe buýt A ĐH Quốc gia", new GeoPoint(10.8620, 106.8000), "Bến xe đại học • Thủ Đức"));
        busStops.put("Ký túc xá B ĐH Quốc gia", new BusStop("Ký túc xá B ĐH Quốc gia", new GeoPoint(10.8650, 106.8020), "Ký túc xá • Thủ Đức"));
        busStops.put("Nguyễn Văn Bá", new BusStop("Nguyễn Văn Bá", new GeoPoint(10.8300, 106.7350), "Khu dân cư • Thủ Đức"));
        busStops.put("Đặng Văn Bi", new BusStop("Đặng Văn Bi", new GeoPoint(10.8380, 106.7450), "Khu trường học • Thủ Đức"));
        busStops.put("Bến Trường Đại học Nông Lâm", new BusStop("Bến Trường Đại học Nông Lâm", new GeoPoint(10.868056, 106.787500), "Bến xe đại học • Thủ Đức"));

        // Tân Bình
        busStops.put("Cộng Hòa", new BusStop("Cộng Hòa", new GeoPoint(10.8010, 106.6650), "Khu thương mại • Tân Bình"));
        busStops.put("Hoàng Văn Thụ", new BusStop("Hoàng Văn Thụ", new GeoPoint(10.8040, 106.6720), "Khu dân cư • Tân Bình"));
        busStops.put("Tân Bình", new BusStop("Tân Bình", new GeoPoint(10.8000, 106.6650), "Trung tâm Tân Bình"));
        busStops.put("Sân bay Tân Sơn Nhất", new BusStop("Sân bay Tân Sơn Nhất", new GeoPoint(10.8185, 106.6519), "Sân bay quốc tế • Tân Bình"));

        // Gò Vấp
        busStops.put("Gò Vấp", new BusStop("Gò Vấp", new GeoPoint(10.8400, 106.6800), "Trung tâm Gò Vấp"));

        // Ngoại thành
        busStops.put("Bến xe Miền Tây", new BusStop("Bến xe Miền Tây", new GeoPoint(10.7390, 106.6240), "Bến xe liên tỉnh • An Lạc"));
        busStops.put("Củ Chi", new BusStop("Củ Chi", new GeoPoint(11.0300, 106.4850), "Huyện ngoại thành • Di tích lịch sử"));
        busStops.put("Hóc Môn", new BusStop("Hóc Môn", new GeoPoint(10.8800, 106.5900), "Trung tâm Hóc Môn"));
    }


    // Lấy GeoPoint của trạm
    public static GeoPoint getStopGeoPoint(String stopName) {
        BusStop stop = busStops.get(stopName);
        return stop != null ? stop.getGeoPoint() : null;
    }

    // Lấy mô tả của trạm
    public static String getStopDescription(String stopName) {
        BusStop stop = busStops.get(stopName);
        return stop != null ? stop.getDescription() : "Trạm dừng • Khu vực thuận tiện";
    }

    // Lấy danh sách tất cả trạm
    public static List<BusStop> getAllBusStops() {
        return new ArrayList<>(busStops.values());
    }

    public static List<BusRoute> getBusRoutesForStation() {
        List<BusRoute> routes = new ArrayList<>();

        // Tuyến xe buýt số 06
        routes.add(new BusRoute(
                "06",
                "Bến xe Chợ Lớn - Đại học Nông Lâm",
                "04:55 - 21:00",
                "190 chuyến/ngày",
                "26.5 km",
                "7,000 VNĐ",
                Arrays.asList(
                        "Bến xe Chợ Lớn", "Thuận Kiều Plaza", "Bệnh viện Chợ Rẫy",
                        "Đại học Y Dược", "Bệnh viện Đại học Y Dược", "Bệnh viện Nguyễn Tri Phương",
                        "Chợ An Đông", "Huỳnh Mẫn Đạt", "Chợ Bầu Sen", "Đại học Sài Gòn",
                        "ĐH Khoa Học Tự Nhiên", "Trường Lê Hồng Phong", "Phạm Viết Chánh",
                        "Bệnh viện Tù Dũ", "Tôn Thất Tùng", "Sở Y Tế", "Nhà Văn Hóa Lao Động",
                        "Pasteur", "Mạc Đỉnh Chi", "Đinh Tiên Hoàng", "Thảo Cầm Viên",
                        "Cầu Thị Nghè", "Nhà Thờ Thì Nghè", "Trung tâm Dưỡng Lão",
                        "Trường trung học Gia Định", "Đại học Hutech", "Khu Du lịch Văn Thánh",
                        "Cầu Sài Gòn", "Cầu Đen", "Thảo Điền", "Metro Quận 2", "Cát Lái",
                        "Xi măng hà tiên - trạm thu phí", "Ngã 4 Tây Hòa (RMK)", "Trạm xây dựng",
                        "Khu QLGTDT số 2", "Trường ĐHSP Kỹ Thuật", "Công ty Sanofi Aventis",
                        "Công ty may Sài Gòn", "Trường mầm non Vành Khuyên", "Làng trẻ em SOS",
                        "Ngã ba Chương Dương", "Cao đẳng xây dựng 2", "Siêu thị Nguyễn Kim",
                        "Công an Quận 9", "Chợ chiều", "Khu Công nghệ cao quận 9", "Đại học Nông Lâm"
                ),
                "Tuyến chính nối Bến xe Chợ Lớn với Đại học Nông Lâm. Vận hành bởi Hợp tác xã vận tải xe buýt Quyết Thắng."
        ));

        // Tuyến xe buýt số 53
        routes.add(new BusRoute(
                "53",
                "Lê Hồng Phong - Đại học Quốc gia",
                "05:00 - 18:15",
                "150 chuyến/ngày",
                "32.65 km",
                "7,000 VNĐ",
                Arrays.asList(
                        "Lê Hồng Phong", "Trần Phú", "Phạm Viết Chánh", "Cống Quỳnh",
                        "Phạm Ngũ Lão", "Nguyễn Cư Trinh", "Trần Hưng Đạo", "Hàm Nghi",
                        "Tôn Đức Thắng", "Nguyễn Hữu Cảnh", "Xa lộ Hà Nội",
                        "Ngã tư Bình Thái", "Ngã tư Thủ Đức", "Võ Văn Ngân",
                        "Lê Văn Chí", "Hoàng Diệu 2", "Kha Vạn Cân", "Quốc lộ 1A",
                        "Bến xe buýt A ĐH Quốc gia", "Ký túc xá B ĐH Quốc gia"
                ),
                "Tuyến kết nối Quận 5 với Đại học Quốc gia TP.HCM, phục vụ sinh viên và người dân khu vực Thủ Đức."
        ));

        // Các tuyến khác
        routes.add(new BusRoute(
                "01",
                "Bến Thành - Chợ Lớn",
                "05:00 - 21:00",
                "5-8 phút/chuyến",
                "12.5 km",
                "7,000 VNĐ",
                Arrays.asList(
                        "Bến Thành", "Nguyễn Huệ", "Đồng Khởi", "Hàm Nghi",
                        "Nguyễn Thái Học", "Chợ An Đông", "Chợ Lớn"
                ),
                "Tuyến chính nối trung tâm Quận 1 với Quận 5, đi qua các khu vực thương mại quan trọng."
        ));

        routes.add(new BusRoute(
                "19",
                "Bến xe Miền Đông - Bến Thành",
                "04:30 - 22:30",
                "4-6 phút/chuyến",
                "18.2 km",
                "8,000 VNĐ",
                Arrays.asList(
                        "Bến xe Miền Đông", "Xô Viết Nghệ Tĩnh", "Điện Biên Phủ",
                        "Pasteur", "Lê Lợi", "Bến Thành"
                ),
                "Tuyến kết nối bến xe với trung tâm thành phố, phục vụ hành khách đi xa."
        ));

        routes.add(new BusRoute(
                "36",
                "Suối Tiên - Bến Thành",
                "05:00 - 20:30",
                "8-12 phút/chuyến",
                "25.7 km",
                "10,000 VNĐ",
                Arrays.asList(
                        "Khu Du lịch Suối Tiên", "Gò Vấp", "Tân Bình",
                        "Sân bay Tân Sơn Nhất", "Cộng Hòa", "Bến Thành"
                ),
                "Tuyến dài nối khu du lịch với trung tâm, đi qua sân bay Tân Sơn Nhất."
        ));

        routes.add(new BusRoute(
                "52",
                "Củ Chi - Bến xe Miền Tây",
                "05:30 - 19:00",
                "15-20 phút/chuyến",
                "32.1 km",
                "12,000 VNĐ",
                Arrays.asList(
                        "Củ Chi", "Hóc Môn", "Tân Bình", "Quận 6",
                        "Quận 5", "Bến xe Miền Tây"
                ),
                "Tuyến ngoại thành kết nối huyện Củ Chi với các quận nội thành."
        ));

        routes.add(new BusRoute(
                "150",
                "Sân bay - Bến xe Miền Đông",
                "05:00 - 22:00",
                "10-15 phút/chuyến",
                "28.4 km",
                "15,000 VNĐ",
                Arrays.asList(
                        "Sân bay Tân Sơn Nhất", "Cộng Hòa", "Hoàng Văn Thụ",
                        "Điện Biên Phủ", "Xô Viết Nghệ Tĩnh", "Bến xe Miền Đông"
                ),
                "Tuyến cao cấp kết nối sân bay với bến xe, phục vụ du khách và hành khách đi xa."
        ));

        return routes;
    }
}
