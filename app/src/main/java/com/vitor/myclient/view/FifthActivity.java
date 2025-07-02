package com.vitor.myclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderDbController;
import com.vitor.myclient.model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FifthActivity extends AppCompatActivity {

    ImageView homePage, orderPage;
    Order order;
    Button orderBtn;
    EditText clientName, clientPhone, orderValue, orderDate;
    OrderDbController orderDbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);

        homePage = findViewById(R.id.homePage5);
        orderPage = findViewById(R.id.orderPage5);
        orderBtn = findViewById(R.id.orderBtn);
        clientName = findViewById(R.id.clientName);
        clientPhone = findViewById(R.id.clientPhone);
        orderValue = findViewById(R.id.orderPrice);
        orderDate = findViewById(R.id.orderDate);

       homePage.setOnClickListener(v -> {
           Intent intent = new Intent(FifthActivity.this, ThirdActivity.class);
            startActivity(intent);
       });

        orderPage.setOnClickListener(v -> {
            Intent intent = new Intent(FifthActivity.this, FourthActivity.class);
            startActivity(intent);
       });

        orderBtn.setOnClickListener(v -> {
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
            String dateForDb = dbDateFormat.format(parsedDate);

            order = new Order(
                    clientName.getText().toString(),
                    clientPhone.getText().toString(),
                    Double.valueOf(orderValue.getText().toString()),
                    parsedDate
            );

            orderDbController = new OrderDbController(this);

            orderDbController.insert(
                    order.getClientName(),
                    order.getClientPhone(),
                    String.valueOf(order.getOrderPrice()),
                    dateForDb
            );

            clientName.setText("");
            clientPhone.setText("");
            orderValue.setText("");
            orderDate.setText("");
        });
    }
}