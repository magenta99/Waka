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
import android.widget.ImageView;
import android.widget.TextView;

import com.wakaproject.waka.Product;
import com.wakaproject.waka.ProductDetailActivity;
import com.wakaproject.waka.R;

import java.io.ByteArrayInputStream;
import java.util.List;

public class WakaDealsAdapter extends RecyclerView.Adapter<WakaDealsAdapter.WakaDealsHolder> {
    public Context context;
    public List<Product> productList;

    public WakaDealsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public WakaDealsAdapter.WakaDealsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item,viewGroup,false);
        WakaDealsHolder wakaDealsHolder = new WakaDealsHolder(view);
        return wakaDealsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WakaDealsAdapter.WakaDealsHolder wakaDealsHolder, final int i) {
        wakaDealsHolder.product = productList.get(i);
        wakaDealsHolder.tvNameProduct.setText(wakaDealsHolder.product.PRODUCT_NAME);
        wakaDealsHolder.tvPriceProduct.setText(String.valueOf(wakaDealsHolder.product.PRODUCT_PRICE));
        wakaDealsHolder.imgProduct.setImageBitmap(ByteArrayToBitmap(wakaDealsHolder.product.PRODUCT_IMAGE));
        wakaDealsHolder.imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                Product p = productList.get(i);
                intent.putExtra("image",p.PRODUCT_IMAGE);
                intent.putExtra("name",p.PRODUCT_NAME);
                intent.putExtra("price",String.valueOf(p.PRODUCT_PRICE));
                intent.putExtra("description",p.PRODUCT_DESCRIPTION);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (productList == null) return 0;
        else
            return productList.size();
    }


    public class WakaDealsHolder extends RecyclerView.ViewHolder {
        private TextView tvNameProduct;
        private TextView tvPriceProduct;
        private ImageView imgProduct;
        private Product product;

        public WakaDealsHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvNameProduct = itemView.findViewById(R.id.tvNameProduct);
            tvPriceProduct = itemView.findViewById(R.id.tvPriceProduct);
        }
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
