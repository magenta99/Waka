package com.wakaproject.waka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wakaproject.waka.adapter.CartProductAdapter;
import com.wakaproject.waka.adapter.MyOrdersAdapter;
import com.wakaproject.waka.adapter.PaymentAdapter;
import com.wakaproject.waka.base.BaseActivity;
import com.wakaproject.waka.dao.ProductCartDAO;
import com.wakaproject.waka.dao.UserDAO;
import com.wakaproject.waka.model.ProductCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class PaymentActivity extends BaseActivity {
    private TextView tvFullNamePayment;
    private TextView tvAddressPayment;
    private TextView tvPhonePayment;
    private RecyclerView rvPayment;
    private TextView tvSumPricePayment;
    private PaymentAdapter paymentAdapter;
    private Button btnOrder;
    private List<ProductCart> productCartList;
    private LinearLayoutManager linearLayoutManager;
    private ProductCartDAO productCartDAO;
    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thanh toán");
        initView();
    }

    private void initView() {
        final DecimalFormat f = new DecimalFormat("###,###,###");
        userDAO = new UserDAO(this);
        productCartDAO = new ProductCartDAO(this);
        tvFullNamePayment = findViewById(R.id.tvFullNamePayment);
        tvAddressPayment = findViewById(R.id.tvAddressPayment);
        tvPhonePayment = findViewById(R.id.tvPhonePayment);
        tvSumPricePayment = findViewById(R.id.tvSumPricePayment);

        double tongtien = productCartDAO.getTongTien(getRootUsername());
        if (tvSumPricePayment != null)
            tvSumPricePayment.setText(f.format(tongtien));

        try {
            tvFullNamePayment.setText(userDAO.getFullName(getRootUsername()));
            tvAddressPayment.setText(userDAO.getAddress(getRootUsername()));
            tvPhonePayment.setText(userDAO.getPhoneNumber(getRootUsername()));
        } catch (NullPointerException e) {
            showMessegeSuccess("Lỗi " + e);
        }

        rvPayment = findViewById(R.id.rvPayment);
        tvSumPricePayment = findViewById(R.id.tvSumPricePayment);
        btnOrder = findViewById(R.id.btnOrder);
        productCartList = new ArrayList<>();
        productCartList = productCartDAO.getAllProductCart(getRootUsername());
        linearLayoutManager = new LinearLayoutManager(this);
        paymentAdapter = new PaymentAdapter(this, productCartList);
        rvPayment.setLayoutManager(linearLayoutManager);
        rvPayment.setAdapter(paymentAdapter);
        paymentAdapter.notifyDataSetChanged();
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productCartDAO.insertMyOrders(getRootUsername());
                productCartDAO.deleteCart(getRootUsername());
                sendBroadcast(new Intent("update"));
                startNewActivity(SuccessOrderActivity.class);

            }
        });
    }

    private String getRootUsername() {
        String name;
        name = getSharedPreferences("USER", MODE_PRIVATE).getString("NAME", null);
        return name;
    }
}
