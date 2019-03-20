package com.wakaproject.waka.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.wakaproject.waka.HomeFragment;
import com.wakaproject.waka.MallFragment;
import com.wakaproject.waka.NotificationFragment;
import com.wakaproject.waka.Product;
import com.wakaproject.waka.ProductDAO;
import com.wakaproject.waka.ProfileFragment;
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

        Bitmap waka = convertDrawabletoBitmap(R.drawable.ipxr);
        Bitmap waka1 = convertDrawabletoBitmap(R.drawable.laptop1);
//        Bitmap waka2 = convertDrawabletoBitmap(R.drawable.wakadeal2);
//        Bitmap waka3 = convertDrawabletoBitmap(R.drawable.wakadeal3);
//        Bitmap waka4= convertDrawabletoBitmap(R.drawable.wakadeal4);
//        Bitmap waka5 = convertDrawabletoBitmap(R.drawable.wakadeal5);
//
//
          byte[] wakadeal = setByteArray(waka);
          byte[] wakadeal1 = setByteArray(waka1);
//        byte[] wakadeal2 = setByteArray(waka2);
//        byte[] wakadeal3 = setByteArray(waka3);
//        byte[] wakadeal4 = setByteArray(waka4);
//        byte[] wakadeal5 = setByteArray(waka5);


        productDAO.insertProduct(new Product("ID01", "Điện thoại iPhone Xr 256GB Gray", "WakaDeals",
                100, 100, 900000, wakadeal,"iPhone XR 256GB sử dụng màn hình LCD tiên tiến nhất hiện nay, hiển thị tuyệt đẹp với kích thước lớn 6,1 inch Liquid Retina sắc nét, tràn viền cạnh. Thiết kế tràn viền giúp cho dù màn hình lớn tới 6,1 inch nhưng iPhone XR vẫn nhỏ gọn hơn so với iPhone 8 Plus, dễ dàng cầm nắm thao tác bằng một tay"));
        productDAO.insertProduct(new Product("ID02", "Laptop Dell Inspiron 3576 i5 8250U", "WakaDeals",
                100, 100, 500000, wakadeal1,"Macbook Pro Retina 2018 MR9R2 là dòng sản phẩm được Apple nâng cấp bổ sung thêm nhiều tính năng mới tăng hiệu suất hoạt động cho người dùng. Macbook được bổ sung CPU thế hệ 8 với 4 nhân, màn hình Retina với công"));
//        productDAO.insertProduct(new Product("ID03", "Ổ Cứng Di Động WD My Passport 1TB", "WakaDeals",
//                100, 100, 600000, wakadeal2,"Ổ Cứng Di Động WD My Passport 1TB (ver 2016) có thể sao lưu liên tục, tự động khi bạn thực hiện các thao tác thay đổi dữ liệu. Chế độ lập lịch cho phép thiết bị chạy sao lưu theo giờ, ngày, tháng tạo sự tiện dụng cho bạn khi quản lý dữ liệu"));
//        productDAO.insertProduct(new Product("ID04", "Di Động WD My Passport 1TB", "WakaDeals",
//                100, 100, 799000, wakadeal1,"Ba Lô Ronal BL60 được thiết kế đẹp mắt với kiểu trang trí dấu chéo độc đáo phối cùng 1 túi lớn ở mặt trước sẽ mang đến dáng vẻ năng động và thời trang cho bạn khi sử dụng. Ba lô được may bằng chất liệu vải dù nhập cao cấp"));
//        productDAO.insertProduct(new Product("ID05", "Đồng Hồ Thông Minh Apple Watch Series 4 GPS", "WakaDeals",
//                100, 100, 11990000, wakadeal4,"Đồng Hồ Thông Minh Apple Watch Series 4 GPS Sport band VN/A sở hữu thiết kế không viền nhờ phần màn hình lớn hơn và được bo cong ở các góc. Nhờ vậy, kích thước của màn hình đã tăng 30%"));
//        productDAO.insertProduct(new Product("ID06", "Chuột Chơi Game Có Dây Logitech G102", "WakaDeals",
//                100, 100, 399000, wakadeal5,"Ngoài ra, sản phẩm còn có điểm nổi bật là được trang bị công nghệ LED RGB 16.8 triệu màu. Với 6 nút, giúp bạn có thể lập trình thông qua phần mềm Logitech Gaming Software, người dùng có thể dễ dàng thiết lập các thao tác Macro"));

    }



}
