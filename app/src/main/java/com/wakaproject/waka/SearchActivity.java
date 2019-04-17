package com.wakaproject.waka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

import com.wakaproject.waka.activity.HomeActivity;
import com.wakaproject.waka.adapter.WakaDealsAdapter;
import com.wakaproject.waka.base.BaseActivity;
import com.wakaproject.waka.dao.ProductDAO;
import com.wakaproject.waka.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {
    private GridLayoutManager gridLayoutManager;
    private ProductDAO productDAO;
    private WakaDealsAdapter wakaDealsAdapter;
    private List<Product> productList;
    private ImageButton btnBack;
    private AutoCompleteTextView actvNameProduct;
    private Button btnSearchProduct;
    private RecyclerView rvSearchProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, CATEGORY);
        actvNameProduct.setAdapter(adapter);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(HomeActivity.class);
            }
        });

        btnSearchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = actvNameProduct.getEditableText().toString();
                getProduct(category);
            }
        });

    }

    private void getProduct(String category) {
        productList = new ArrayList<>();
        productList.clear();
        gridLayoutManager = new GridLayoutManager(this, 2);
        productDAO = new ProductDAO(this);
        productList = productDAO.getAllProduct(category);
        wakaDealsAdapter = new WakaDealsAdapter(this, productList);
        rvSearchProduct.setAdapter(wakaDealsAdapter);
        rvSearchProduct.setLayoutManager(gridLayoutManager);
        rvSearchProduct.setHasFixedSize(true);
        rvSearchProduct.setNestedScrollingEnabled(false);
        wakaDealsAdapter.notifyDataSetChanged();
    }


    private void initView() {
        actvNameProduct = findViewById(R.id.actvNameProduct);
        btnBack = findViewById(R.id.btnBack);
        btnSearchProduct = findViewById(R.id.btnSearchProduct);
        rvSearchProduct = findViewById(R.id.rvSearchProduct);
    }

    private static final String[] CATEGORY = new String[]{"Accessories", "Laptop", "Tablet", "Phone", "Watch"};

}
