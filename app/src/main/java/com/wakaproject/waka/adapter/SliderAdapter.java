package com.wakaproject.waka.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wakaproject.waka.R;
import com.wakaproject.waka.activity.HomeActivity;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slider_images = {
            R.drawable.color,
            R.drawable.deliverytruck,
            R.drawable.pay,
    };

    public String[] slider_headings = {
            "ĐA DẠNG SẢN PHẨM",
            "GIAO HÀNG NHANH CHÓNG",
            "ĐẶT HÀNG DỄ DÀNG"
    };

    public String[] slider_des = {
            "Waka cung cấp cho người dùng không chỉ đầy đủ những mặt hàng mà còn đảm bảo chất lượng luôn đi đầu so với thị trường.",
            "Waka hiện đang liên kết với những đối tác vận chuyển lớn nhất toàn quốc giúp cho việc giao hàng diễn ra rất nhanh chóng",
            "Với Waka bạn chỉ cần thêm hàng vào giỏ và có thể thanh toán dễ dàng tại bất cứ đâu, bất cứ lúc nào mà bạn mong muốn."
    };

    @Override
    public int getCount() {
        return slider_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView sliderImageView = (ImageView) view.findViewById(R.id.imgSlider);
        TextView tvHeading = (TextView) view.findViewById(R.id.tvHeading);
        TextView tvDes = (TextView) view.findViewById(R.id.tvDescription);
        Button btnDiscover = (Button)view.findViewById(R.id.btnSlider);

        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HomeActivity.class);
                context.startActivity(intent);
            }
        });

        sliderImageView.setImageResource(slider_images[position]);
        tvHeading.setText(slider_headings[position]);
        tvDes.setText(slider_des[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
