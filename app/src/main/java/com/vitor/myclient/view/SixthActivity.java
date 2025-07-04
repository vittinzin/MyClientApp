package com.vitor.myclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderController;

public class SixthActivity extends AppCompatActivity {

    TextView nameTxt, phoneTxt, priceTxt, dateTxt;
    ImageView arrowBack, homePage, orderPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth);

        nameTxt = findViewById(R.id.clientNameOrder);
        phoneTxt = findViewById(R.id.clientPhoneOrder);
        priceTxt = findViewById(R.id.clientPriceOrder);
        dateTxt = findViewById(R.id.clientDateOrder);
        arrowBack = findViewById(R.id.arrowImg);
        homePage = findViewById(R.id.homePage);
        orderPage = findViewById(R.id.orderPage);

        arrowBack.setOnClickListener(v ->{
            Intent intent = new Intent(SixthActivity.this, FourthActivity.class);
            startActivity(intent);
        });

        homePage.setOnClickListener(v -> {
            Intent intent = new Intent(SixthActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        orderPage.setOnClickListener(v -> {
            Intent intent = new Intent(SixthActivity.this, FourthActivity.class);
            startActivity(intent);
        });

        String clientName = getIntent().getStringExtra("clientName");

        OrderController controller = new OrderController(this);

        String phone = controller.getPhone(clientName);
        float price = controller.getPrice(clientName);
        String date = controller.getDate(clientName);

        nameTxt.setText("Cliente: " + clientName);
        phoneTxt.setText("Telefone: " + phone);
        priceTxt.setText("Valor: R$" + price);
        dateTxt.setText("Data: " + date);
    }
}