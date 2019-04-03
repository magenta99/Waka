package com.wakaproject.waka.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.wakaproject.waka.mainfragment.HomeFragment;
import com.wakaproject.waka.mainfragment.MallFragment;
import com.wakaproject.waka.mainfragment.NotificationFragment;
import com.wakaproject.waka.model.Product;
import com.wakaproject.waka.dao.ProductDAO;
import com.wakaproject.waka.mainfragment.ProfileFragment;
import com.wakaproject.waka.R;
import com.wakaproject.waka.base.BaseActivity;

public class HomeActivity extends BaseActivity {
    private ProductDAO productDAO;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectFragment = new HomeFragment();
                    break;
                case R.id.navigation_mall:
                    selectFragment = new MallFragment();
                    break;
                case R.id.navigation_notifications:
                    selectFragment = new NotificationFragment();
                    break;
                case R.id.navigation_profile:
                    selectFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, selectFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();
        productDAO = new ProductDAO(this);

//        Bitmap waka = convertDrawabletoBitmap(R.drawable.ipad);
//        Bitmap waka1 = convertDrawabletoBitmap(R.drawable.deal_macbook);
//        Bitmap waka2 = convertDrawabletoBitmap(R.drawable.deal_xsmax);
//        Bitmap waka3 = convertDrawabletoBitmap(R.drawable.deal_applewatch);
//
//        byte[] wakadeal = setByteArray(waka);
//        byte[] wakadeal1 = setByteArray(waka1);
//        byte[] wakadeal2 = setByteArray(waka2);
//        byte[] wakadeal3 = setByteArray(waka3);


//        productDAO.insertProduct(new Product("ID01", "iPad WiFi 128GB New 2018 White", "WakaDeals",
//                100, 100, 9000000, wakadeal,
//                "iPad WiFi 128GB New 2018 vẫn giữ phong cách thiết kế quen thuộc như phiên bản tiền nhiệm 2017 với chất liệu nhôm nguyên khối cao cấp, các cạnh được bo cong mềm mại, tạo cảm giác cầm nắm thoải mái và chắc tay"));
//        productDAO.insertProduct(new Product("ID02", "Loa bluetooth JBL Flip 3 Orange", "WakaDeals",
//                100, 100, 899000, wakadeal1,
//                "Chất lượng âm thanh sống động và vượt trội với âm trầm, hệ thống thoát hơi đặc biệt sẽ giúp loa tối ưu hóa được âm bass. Dung lượng pin chỉ có 3000 mAh, tức là phân nữa so với JBL Charge 2+ nhưng vẫn có khả năng chơi được nhạc trong khoảng 8-10 tiếng liên tục và không gián đoạn"));
//        productDAO.insertProduct(new Product("ID03", "Điện thoại iPhone Xs Max 64GB", "WakaDeals",
//                100, 100, 26900000, wakadeal2,
//                "iPhone XS MAX 64GB sử dụng màn hình AMOLED tiên tiến nhất hiện nay, hiển thị tuyệt đẹp với kích thước lớn 6,1 inch Liquid Retina sắc nét, tràn viền cạnh. Thiết kế tràn viền giúp cho dù màn hình lớn tới 6,1 inch nhưng iPhone XR vẫn nhỏ gọn hơn so với iPhone 8 Plus, dễ dàng cầm nắm thao tác bằng một tay"));
//        productDAO.insertProduct(new Product("ID04", "Đồng Hồ Apple Watch Series 4 GPS", "WakaDeals",
//                100, 100, 11990000, wakadeal3,
//                "Đồng Hồ Thông Minh Apple Watch Series 4 GPS Sport band VN/A sở hữu thiết kế không viền nhờ phần màn hình lớn hơn và được bo cong ở các góc. Nhờ vậy, kích thước của màn hình đã tăng 30%"));


        //PHONE
//        Bitmap phone = convertDrawabletoBitmap(R.drawable.phone_huawei3i);
//        Bitmap phone1 = convertDrawabletoBitmap(R.drawable.phone_hueweip9);
//        Bitmap phone2 = convertDrawabletoBitmap(R.drawable.phone_ip8plus);
//        Bitmap phone3 = convertDrawabletoBitmap(R.drawable.phone_m20);
//        Bitmap phone4 = convertDrawabletoBitmap(R.drawable.phone_oppof9);
//        Bitmap phone5 = convertDrawabletoBitmap(R.drawable.phone_ssa50);
//        Bitmap phone6 = convertDrawabletoBitmap(R.drawable.phone_ip6splus);
//        Bitmap phone7 = convertDrawabletoBitmap(R.drawable.phone_oppof11);
//
//        byte[] deal_phone = setByteArray(phone);
//        byte[] deal_phone1 = setByteArray(phone1);
//        byte[] deal_phone2 = setByteArray(phone2);
//        byte[] deal_phone3 = setByteArray(phone3);
//        byte[] deal_phone4 = setByteArray(phone4);
//        byte[] deal_phone5 = setByteArray(phone5);
//        byte[] deal_phone6 = setByteArray(phone6);
//        byte[] deal_phone7 = setByteArray(phone7);

//        productDAO.insertProduct(new Product("ID05", "Điện thoại Huawei Nova 3i Gray", "Phone",
//                100, 100, 5490000, deal_phone,
//                "Nova 3i sở hữu mặt lưng kính chuyển màu gradient kiểu như điện thoại Huawei P20 Pro, nhờ thiết kế mặt lưng kính ấn tượng đã đem lại cho máy một thiết kế hiện đại và tinh tế. Chiếc điện thoại Huawei này sở hữu cụm camera kép ở mặt lưng với cảm biến chính 16 MP và cảm biến phụ 2 MP có khả năng lấy nét rất nhanh"));
//        productDAO.insertProduct(new Product("ID06", "Điện thoại Huawei Y9 (2019) Blue", "Phone",
//                100, 100, 4490000, deal_phone1,
//                "Huawei Y9 2019 mang trong mình tới 4 camera bao gồm camera kép phía trước độ phân giải 16 MP (chính) + 2 MP (phụ) và camera kép phía sau là 13 MP (chính) + 2 MP (phụ), cả hai cụm camera đều tích hợp với công nghệ chụp ảnh AI (trí tuệ nhân tạo)"));
//        productDAO.insertProduct(new Product("ID07", "Điện thoại Iphone 8 Plus 128GB", "Phone",
//                100, 100, 15490000, deal_phone2,
//                "Smartphone iPhone 8 Plus giữ nguyên hoàn toàn những đường nét thiết kế đã hoàn thiện từ thế hệ trước nhưng sử dụng phong cách 2 mặt kính cường lực kết hợp bộ khung kim loại. Mặt lưng kính bo cong 2.5D thời thượng, khung kim loại được gia cố cứng cáp, bền bỉ hơn với 7 lớp xử lý màu sơn, hạn chế bong tróc"));
//        productDAO.insertProduct(new Product("ID08", "Điện thoại Samsung Galaxy M20", "Phone",
//                100, 100, 7490000, deal_phone3,
//                "Thiết bị chạy trên hệ điều hành Android 8.1 Oreo với giao diện Samsung Experience 9.5, cùng với chip mới, Galaxy M20 sẽ cho khả năng chơi game tốt với các tựa game nổi tiếng như Liên quân Moblile hay PUBG Mobile sau khi chỉnh lại cấu hình đồ hoạ xuống thấp."));
//        productDAO.insertProduct(new Product("ID09", "Điện thoại OPPO F9 6GB Sky", "Phone",
//                100, 100, 15900000, deal_phone4,
//                "Là chiếc điện thoại OPPO được nâng cấp cấu hình, cụ thể là RAM lên tới 6 GB, OPPO F9 6GB còn trang bị nhiều tính năng đột phá như sở hữu công nghệ sạc VOOC mới nhất, mặt lưng chuyển màu độc đáo, màn hình tràn viền giọt nước và camera chụp chân dung tích hợp trí tuệ nhân tạo A.I hoàn hảo"));
//        productDAO.insertProduct(new Product("ID10", "Điện thoại Samsung Galaxy A50 128GB", "Phone",
//                100, 100, 8900000, deal_phone5,
//                "Thiết kế màn hình Infinity-U độc đáo - Samsung Galaxy A50 là mẫu smartphone đầu tiên mà Samsung sử dụng màn hình Infinity-U với phần notch nhỏ gọn hình giọt nước.Trên chiếc smartphone Samsung mới này thì hãng sử dụng thiết kế gọi là \"3D Glasstic\" với bộ khung kim loại chắc chắn với các góc cạnh được bo cong nhẹ để mang lại cảm giác cầm nắm dễ chịu."));
//        productDAO.insertProduct(new Product("ID11", "Điện thoại iPhone 6s Plus 32GB", "Phone",
//                100, 100, 16900000, deal_phone6,
//                "Điện thoại iPhone 6s Plus 32 GB được nâng cấp độ phân giải camera sau lên 12 MP (thay vì 8 MP như trên iPhone 6 Plus), camera cho tốc độ lấy nét và chụp nhanh, thao tác chạm để chụp nhẹ nhàng. Chất lượng ảnh trong các điều kiện chụp khác nhau tốt."));
//        productDAO.insertProduct(new Product("ID12", "Điện thoại Oppo F11 Pro Đen Thạch Anh", "Phone",
//                100, 100, 22490000, deal_phone7,
//                "Với việc trang bị camera selfie trượt độc đáo, F11 pro sở hữu màn hình toàn cảnh Panoramic hoàn hảo với khung viền siêu mỏng, kích thước màn hình 6.5 inch, tỉ lệ hiển thị 90,9% mang đến trải nghiệm hình ảnh cực chất"));


        //LAPTOP
//        Bitmap laptop = convertDrawabletoBitmap(R.drawable.laptop_macbookpro);
//        Bitmap laptop1 = convertDrawabletoBitmap(R.drawable.laptop_asuss15);
//        Bitmap laptop2 = convertDrawabletoBitmap(R.drawable.laptop_hp);
//        Bitmap laptop3 = convertDrawabletoBitmap(R.drawable.laptop_macbookgold);
//
//        byte[] deal_lap = setByteArray(laptop);
//        byte[] deal_lap1 = setByteArray(laptop1);
//        byte[] deal_lap2 = setByteArray(laptop2);
//        byte[] deal_lap3 = setByteArray(laptop3);

//        productDAO.insertProduct(new Product("ID13", "Macbook Pro 13 inch 128GB (2017)", "Laptop",
//                100, 100, 33990000, deal_lap,
//                "Thế hệ MacBook Pro 13 inch 2017 ngoài việc cập nhật bộ vi xử lý Intel thế hệ thứ 7 (Kaby Lake) thì còn được nâng cấp gấp đôi dung lượng bộ nhớ. Ngoài ra thiết kế cũng như một số tính năng nổi bật vẫn không có thay đổi so với dòng MacBook 2016"));
//        productDAO.insertProduct(new Product("ID14", "Asus Vivobook S530UN-BQ026T i5", "Laptop",
//                100, 100, 18790000, deal_lap1,
//                "ASUS VivoBook S15 S530UN là mẫu máy tính xách tay nói lên cá tính riêng của bạn với thiết kế táo bạo, màu sắc độc đáo, màn hình NanoEdge viền mỏng và bản lề ErgoLift đột phá. ASUS VivoBook S15 có kiểu dáng thanh thoát, khác biệt so với các laptop trên thị trường"));
//        productDAO.insertProduct(new Product("ID15", "HP Pavilion 14-ce1008TU/Core i5-8265U", "Laptop",
//                100, 100, 15290000, deal_lap2,
//                "Được thừa hưởng nhiều đường nét thiết kế từ series laptop HP Envy cao cấp, HP Pavilion 14-ce1008TU tỏ ra hết sức cân đối khi sở hữu bộ khung vỏ chỉ tương tự như những dòng máy tính xách tay có màn hình 13 inch trên thị trường. HP đã trau chuốt từng chi tiết trong ngoại hình của sản phẩm, đặc biệt là ở phần bản lề và loa ngoài để tạo nên nét nhấn nhá về mặt thẩm mĩ"));
//        productDAO.insertProduct(new Product("ID16", "Macbook Air 13 128GB 2018 Pink", "Laptop",
//                100, 100, 28790000, deal_lap3,
//                "Tình yêu dành cho MacBook Air đã quay trở lại với thiết kế mới. Bạn sẽ có 3 phiên bản màu bạc, xám và vàng. MacBook Air mới mỏng hơn, nhẹ hơn, sở hữu màn hình Retina rực rỡ, cảm biến vân tay Touch ID, bàn phím cách bướm thế hệ mới nhất và bàn di chuột cảm ứng lực Force Touch. Với chất liệu làm từ 100% nhôm có thể tái chế, MacBook Air 2018 là chiếc laptop thân thiện nhất với môi trường"));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindDrawables(findViewById(R.id.container));
        System.gc();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }

}
