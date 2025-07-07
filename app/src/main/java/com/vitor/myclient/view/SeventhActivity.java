package com.vitor.myclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderDbController;
import com.vitor.myclient.model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SeventhActivity extends AppCompatActivity {

    Button saveOrder;
    EditText clientName, clientPhone, orderPrice, orderDate;
    OrderDbController orderDbController;
    private ImageView orderPage, homePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventh);

        orderPage = findViewById(R.id.orderPage5);
        homePage = findViewById(R.id.homePage5);
        clientName = findViewById(R.id.clientName);
        clientPhone = findViewById(R.id.clientPhone);
        orderDate = findViewById(R.id.orderDate);
        orderPrice = findViewById(R.id.orderPrice);
        saveOrder = findViewById(R.id.saveBtn);

        orderDbController = new OrderDbController(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String date = intent.getStringExtra("date");
        Float price = intent.getFloatExtra("price", 0.0F);

        clientName.setText(name);
        clientPhone.setText(phone);
        orderDate.setText(date);
        orderPrice.setText(String.valueOf(price));

        saveOrder.setOnClickListener(v -> {
            String orderDateStr = orderDate.getText().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date parsedDate;

            try {
                parsedDate = sdf.parse(orderDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                orderDate.setError("Data inválida. Use dd/MM/yyyy");
                return;
            }

            SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            Order updatedOrder = new Order(
                    clientName.getText().toString(),
                    clientPhone.getText().toString(),
                    Float.valueOf(orderPrice.getText().toString()),
                    orderDateStr
            );

            orderDbController.editOrder(updatedOrder);
            finish();

            Intent intent1 = new Intent(SeventhActivity.this, SixthActivity.class);
            startActivity(intent1);
        });

        homePage.setOnClickListener(v -> {
            Intent intent2 = new Intent(SeventhActivity.this, ThirdActivity.class);
            startActivity(intent2);
        });

        orderPage.setOnClickListener(v ->{
            Intent intent3 = new Intent(SeventhActivity.this, FourthActivity.class);
            startActivity(intent3);
        });
    }
}