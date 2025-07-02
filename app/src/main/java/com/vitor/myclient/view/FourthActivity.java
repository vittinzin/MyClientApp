package com.vitor.myclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitor.myclient.R;

public class FourthActivity extends AppCompatActivity {

    ImageView homePage;
    TextView makeOrder;
    ListView orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);

        homePage = findViewById(R.id.homePage);
        makeOrder = findViewById(R.id.listTxt);

        homePage.setOnClickListener(v -> {
            Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        makeOrder.setOnClickListener(v ->{
            Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
            startActivity(intent);
        });
    }
}