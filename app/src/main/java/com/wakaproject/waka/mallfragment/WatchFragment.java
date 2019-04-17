package com.wakaproject.waka.mallfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wakaproject.waka.R;
import com.wakaproject.waka.adapter.WakaDealsAdapter;
import com.wakaproject.waka.dao.ProductDAO;
import com.wakaproject.waka.mainfragment.HomeFragment;
import com.wakaproject.waka.model.Product;

import java.util.ArrayList;
import java.util.List;

public class WatchFragment extends Fragment {
    private GridLayoutManager gridLayoutManager;
    private ProductDAO productDAO;
    private WakaDealsAdapter wakaDealsAdapter;
    private List<Product> productList;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watch, container, false);
        initView(view);
        return view;
    }

    public void initView(View view){
        recyclerView = view.findViewById(R.id.rvWatchDeals);
        productList = new ArrayList<>();
        productList.clear();
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        productDAO = new ProductDAO(getContext());
        productList = productDAO.getAllProduct("Watch");
        wakaDealsAdapter = new WakaDealsAdapter(getContext(), productList);
        recyclerView.setAdapter(wakaDealsAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        wakaDealsAdapter.notifyDataSetChanged();
    }
}
