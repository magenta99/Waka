package com.wakaproject.waka;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.wakaproject.waka.adapter.WakaDealsAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ViewFlipper viewFlipper;
    private GridLayoutManager gridLayoutManager;
    private ProductDAO productDAO;
    private WakaDealsAdapter wakaDealsAdapter;
    private List<Product> productList;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewFlipper = view.findViewById(R.id.vpSlider);
        int images[] = {R.drawable.banner2,R.drawable.banner3,R.drawable.banner4};
        for (int image : images){
            flipperImages(image);
        }

        recyclerView = view.findViewById(R.id.rvWakaDeal);
        productList = new ArrayList<>();
        productList.clear();
        gridLayoutManager = new GridLayoutManager(getContext(),2);
        productDAO = new ProductDAO(getContext());
        productList = productDAO.getAllProduct();
        wakaDealsAdapter = new WakaDealsAdapter(getContext(),productList);
        recyclerView.setAdapter(wakaDealsAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        wakaDealsAdapter.notifyDataSetChanged();


        return view;
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval (2500);
        viewFlipper.setAutoStart(true);

        //
        viewFlipper.setInAnimation(getContext(),android.R.anim.fade_in);
    }



}
