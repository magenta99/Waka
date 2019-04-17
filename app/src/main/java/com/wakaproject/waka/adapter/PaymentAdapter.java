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

import com.wakaproject.waka.PaymentActivity;
import com.wakaproject.waka.R;
import com.wakaproject.waka.activity.CartActivity;
import com.wakaproject.waka.dao.ProductCartDAO;
import com.wakaproject.waka.model.ProductCart;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static com.wakaproject.waka.database.Constant.decimalFormat;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.CartProductHolder> {

    Context context;
    List<ProductCart> productCartList;

    public PaymentAdapter(Context context, List<ProductCart> productCartList) {
        this.context = context;
        this.productCartList = productCartList;
    }

    @NonNull
    @Override
    public CartProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.payment_item, viewGroup, false);
        return new CartProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartProductHolder cartProductHolder, final int i) {

        cartProductHolder.productCart = productCartList.get(i);
        cartProductHolder.tvNameCartProduct.setText(cartProductHolder.productCart.PRODUCT_CART_NAME);
        cartProductHolder.tvNumber.setText(String.valueOf(cartProductHolder.productCart.PRODUCT_CART_NUMBER));
        cartProductHolder.tvPriceCartProduct.setText(decimalFormat.format(cartProductHolder.productCart.PRODUCT_CART_PRICE));
        cartProductHolder.imgImageCartProduct.setImageBitmap(ByteArrayToBitmap(cartProductHolder.productCart.PRODUCT_CART_IMAGE));

        cartProductHolder.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductCartDAO productCartDAO = new ProductCartDAO(context);
                cartProductHolder.productCart.PRODUCT_CART_NUMBER++;
                productCartDAO.updateProductCartAmount(new ProductCart("", "", "", cartProductHolder.productCart.PRODUCT_CART_NUMBER, 0, null), cartProductHolder.productCart.PRODUCT_CART_ID);
                cartProductHolder.tvNumber.setText(Integer.toString(cartProductHolder.productCart.PRODUCT_CART_NUMBER));
                ((PaymentActivity) context).recreate();
            }
        });

        cartProductHolder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductCartDAO productCartDAO = new ProductCartDAO(context);
                if (cartProductHolder.productCart.PRODUCT_CART_NUMBER > 0) {
                    cartProductHolder.productCart.PRODUCT_CART_NUMBER--;
                    productCartDAO.updateProductCartAmount(new ProductCart("", "", "", cartProductHolder.productCart.PRODUCT_CART_NUMBER, 0, null), cartProductHolder.productCart.PRODUCT_CART_ID);
                    cartProductHolder.tvNumber.setText(Integer.toString(cartProductHolder.productCart.PRODUCT_CART_NUMBER));
                    ((PaymentActivity) context).recreate();

                } else {
                    Toasty.warning(context, "Số lượng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        if (productCartList == null) return 0;
        else
            return productCartList.size();
    }


    public class CartProductHolder extends RecyclerView.ViewHolder {
        private ImageView imgImageCartProduct;
        private TextView tvNameCartProduct;
        private TextView tvPriceCartProduct;
        private Button btnDecrease;
        private TextView tvNumber;
        private Button btnIncrease;
        private ProductCart productCart;

        public CartProductHolder(@NonNull View itemView) {
            super(itemView);
            imgImageCartProduct = itemView.findViewById(R.id.imgImageCartProduct);
            tvNameCartProduct = itemView.findViewById(R.id.tvNameCartProduct);
            tvPriceCartProduct = itemView.findViewById(R.id.tvPriceCartProduct);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);

        }
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
