package com.wakaproject.waka.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wakaproject.waka.MyOrders;
import com.wakaproject.waka.R;
import com.wakaproject.waka.activity.CartActivity;
import com.wakaproject.waka.dao.ProductCartDAO;
import com.wakaproject.waka.model.ProductCart;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static com.wakaproject.waka.database.Constant.decimalFormat;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersHolder> {

    Context context;
    List<MyOrders> myOrdersList;

    public MyOrdersAdapter(Context context, List<MyOrders> myOrdersList) {
        this.context = context;
        this.myOrdersList = myOrdersList;
    }

    @NonNull
    @Override
    public MyOrdersHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_orders_item, viewGroup, false);
        return new MyOrdersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyOrdersHolder myOrdersHolder, final int i) {
        myOrdersHolder.myOrders = myOrdersList.get(i);
        myOrdersHolder.tvNameMyOrders.setText(myOrdersHolder.myOrders.MY_ORDER_NAME);
        myOrdersHolder.tvPriceMyOrders.setText(decimalFormat.format(myOrdersHolder.myOrders.MY_ORDER_PRICE));
        myOrdersHolder.imgImageMyOrders.setImageBitmap(ByteArrayToBitmap(myOrdersHolder.myOrders.MY_ORDER_IMAGE));

    }

    @Override
    public int getItemCount() {
        if (myOrdersList == null) return 0;
        else
            return myOrdersList.size();
    }


    public class MyOrdersHolder extends RecyclerView.ViewHolder {
        private ImageView imgImageMyOrders;
        private TextView tvNameMyOrders;
        private TextView tvPriceMyOrders;
        private MyOrders myOrders;

        public MyOrdersHolder(@NonNull View itemView) {
            super(itemView);
            imgImageMyOrders = itemView.findViewById(R.id.imgImageMyOrders);
            tvNameMyOrders = itemView.findViewById(R.id.tvNameMyOrders);
            tvPriceMyOrders = itemView.findViewById(R.id.tvPriceMyOrders);

        }
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
