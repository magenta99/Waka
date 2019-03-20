package com.wakaproject.waka;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

public class ProductDetailActivity extends AppCompatActivity {
    private ImageView imgProductDetail;
    private TextView tvNameProductDetail;
    private TextView tvPriceProductDetail;
    private TextView tvDescriptionDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        imgProductDetail = (ImageView) findViewById(R.id.imgProductDetail);
        tvNameProductDetail = (TextView) findViewById(R.id.tvNameProductDetail);
        tvPriceProductDetail = (TextView) findViewById(R.id.tvPriceProductDetail);
        tvDescriptionDetail = (TextView) findViewById(R.id.tvDescriptionDetail);


        Intent intent = getIntent();
        byte[] image = intent.getByteArrayExtra("image");
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("description");

        imgProductDetail.setImageBitmap(ByteArrayToBitmap(image));
        tvNameProductDetail.setText(name);
        tvPriceProductDetail.setText(price);
        tvDescriptionDetail.setText(description);

    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }

}
