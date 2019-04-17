package com.wakaproject.waka.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wakaproject.waka.PaymentActivity;
import com.wakaproject.waka.base.BaseActivity;
import com.wakaproject.waka.model.ProductCart;
import com.wakaproject.waka.R;
import com.wakaproject.waka.adapter.CartProductAdapter;
import com.wakaproject.waka.dao.ProductCartDAO;

import java.util.ArrayList;
import java.util.List;

import static com.wakaproject.waka.database.Constant.decimalFormat;

public class CartActivity extends BaseActivity {
    private CartProductAdapter cartProductAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<ProductCart> productCartList;
    private ProductCartDAO productCartDAO;
    private RecyclerView recyclerView;
    private TextView tvSumPrice;
    private Button btnPayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.acti_cart_title));
        initView();

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productCartList.size() <= 0) {
                    showMessegeWarning(getResources().getString(R.string.acti_cart_mesWarning));
                } else {
                    startNewActivity(PaymentActivity.class);
                }
            }
        });
    }

    private void initView() {
        btnPayment = findViewById(R.id.btnPayment);
        tvSumPrice = findViewById(R.id.tvSumPrice);
        recyclerView = findViewById(R.id.rvProductCart);
        productCartList = new ArrayList<>();
        productCartDAO = new ProductCartDAO(this);
        productCartList = productCartDAO.getAllProductCart(getRootUsername());
        linearLayoutManager = new LinearLayoutManager(this);
        cartProductAdapter = new CartProductAdapter(this, productCartList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartProductAdapter);
        cartProductAdapter.notifyDataSetChanged();
        double tongtien = productCartDAO.getTongTien(getRootUsername());
        if (tvSumPrice != null)
            tvSumPrice.setText(decimalFormat.format(tongtien));
    }

    private String getRootUsername() {
        String name;
        name = getSharedPreferences("USER", MODE_PRIVATE).getString("NAME", null);
        return name;
    }
}
