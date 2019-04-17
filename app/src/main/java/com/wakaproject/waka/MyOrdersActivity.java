package com.wakaproject.waka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wakaproject.waka.adapter.CartProductAdapter;
import com.wakaproject.waka.adapter.MyOrdersAdapter;
import com.wakaproject.waka.dao.ProductCartDAO;
import com.wakaproject.waka.model.ProductCart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {
    private RecyclerView rvMyOrders;
    private MyOrdersAdapter myOrdersAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<MyOrders> myOrdersList;
    private ProductCartDAO productCartDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        getSupportActionBar().setTitle("Đơn hàng của bạn");
        initView();
    }

    public void initView(){
        rvMyOrders = findViewById(R.id.rvMyOrders);
        myOrdersList = new ArrayList<>();
        productCartDAO = new ProductCartDAO(this);
        myOrdersList = productCartDAO.getAllMyOrders(getRootUsername());
        Toast.makeText(this, String.valueOf(myOrdersList.size()), Toast.LENGTH_SHORT).show();
        linearLayoutManager = new LinearLayoutManager(this);
        myOrdersAdapter = new MyOrdersAdapter(this,myOrdersList);
        rvMyOrders.setLayoutManager(linearLayoutManager);
        rvMyOrders.setAdapter(myOrdersAdapter);
        myOrdersAdapter.notifyDataSetChanged();
    }

    private String getRootUsername(){
        String name ;
        name = getSharedPreferences("USER",MODE_PRIVATE).getString("NAME",null);
        return name;
    }
}
