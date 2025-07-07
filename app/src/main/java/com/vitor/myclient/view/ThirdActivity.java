package com.vitor.myclient.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderController;
import com.vitor.myclient.controller.OrderDbController;
import com.vitor.myclient.controller.RegisterController;
import com.vitor.myclient.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private TextView helloTxt, newOrder, listOrdersPage, noOrders, updateOrders;
    private ListView lastOrders;
    private ImageView orderPage;
    private ArrayAdapter<String> adapter;
    private OrderDbController orderDbController;
    private List<String> orderArrayList;
    private List<String> twoOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        helloTxt = findViewById(R.id.helloTxt);
        orderPage = findViewById(R.id.orderPage);
        lastOrders = findViewById(R.id.orderList);
        newOrder = findViewById(R.id.newOrderTxt);
        listOrdersPage = findViewById(R.id.listOrdersPageTxt);
        noOrders = findViewById(R.id.noOrders);
        updateOrders = findViewById(R.id.updateTxt);
        orderDbController = new OrderDbController(this);

        orderArrayList = orderDbController.getNames();

        twoOrders = orderArrayList.subList(0, Math.min(2, orderArrayList.size()));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, twoOrders);
        lastOrders.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        RegisterController registerController = new RegisterController(this);
        String name = registerController.getSavedName();

        helloTxt.setText("Hello, " + name + "!");

        if (orderArrayList.isEmpty()){
            noOrders.setText("No orders yet!");
        } else {
            noOrders.setText("");
        }

        updateOrders.setOnClickListener(v ->{
            Intent intent = new Intent(ThirdActivity.this, SixthActivity.class);
            startActivity(intent);
        });
        listOrdersPage.setOnClickListener(v ->{
            Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
            startActivity(intent);
        });
        newOrder.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FifthActivity.class);
            startActivity(intent);
        });
        orderPage.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
            startActivity(intent);
        });

    }
}