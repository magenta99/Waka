package com.wakaproject.waka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wakaproject.waka.base.BaseActivity;

public class SuccessOrderActivity extends BaseActivity {
    private Button btnMyOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_order);
        btnMyOrders = (Button) findViewById(R.id.btnMyOrders);
        btnMyOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(MyOrdersActivity.class);
            }
        });

    }
}
