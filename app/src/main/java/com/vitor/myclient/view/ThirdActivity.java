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
import com.vitor.myclient.controller.RegisterController;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    TextView helloTxt, newOrder, listOrdersPage;
    ListView lastOrders;
    ImageView orderPage;
    private ArrayAdapter<String> adapter;
    private OrderController orderController;
    private ArrayList<String> orderArrayList;
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

        orderController = new OrderController(this);

        orderArrayList = orderController.getOrderItens();
        twoOrders = orderArrayList.subList(0, Math.min(2, orderArrayList.size()));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, twoOrders);
        lastOrders.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        RegisterController registerController = new RegisterController(this);
        String name = registerController.getSavedName();

        helloTxt.setText("Hello, " + name + "!");

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