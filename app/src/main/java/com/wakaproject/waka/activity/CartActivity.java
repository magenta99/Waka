package com.wakaproject.waka.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wakaproject.ProductCart;
import com.wakaproject.waka.R;
import com.wakaproject.waka.adapter.CartProductAdapter;
import com.wakaproject.waka.dao.ProductCartDAO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private CartProductAdapter cartProductAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<ProductCart> productCartList;
    private ProductCartDAO productCartDAO;
    private RecyclerView recyclerView;
    private TextView tvSumPrice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Giỏ hàng");

        final DecimalFormat f = new DecimalFormat("###,###,###");
        tvSumPrice = (TextView) findViewById(R.id.tvSumPrice);
        recyclerView = (RecyclerView)findViewById(R.id.rvProductCart);
        productCartList = new ArrayList<>();
        productCartDAO = new ProductCartDAO(this);
        productCartList = productCartDAO.getAllProductCart();
        linearLayoutManager = new LinearLayoutManager(this);
        cartProductAdapter = new CartProductAdapter(this,productCartList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartProductAdapter);
        cartProductAdapter.notifyDataSetChanged();

        double tongtien = productCartDAO.getTongTien();
        tvSumPrice.setText(f.format(tongtien));
    }
}
