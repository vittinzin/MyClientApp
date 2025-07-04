package com.vitor.myclient.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderController;
import com.vitor.myclient.controller.OrderDbController;
import com.vitor.myclient.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {

    private ImageView homePage;
    private TextView makeOrder;
    private ListView orderList;
    private ArrayAdapter<String> adapter;
    private OrderController orderController;
    private ArrayList<String> orderArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);

        homePage = findViewById(R.id.homePage);
        makeOrder = findViewById(R.id.makeOrderPage);
        orderList = findViewById(R.id.listTxt);

        orderController = new OrderController(this);

        orderArrayList = orderController.getOrderItens();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderArrayList);
        orderList.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        orderList.setOnItemClickListener((parent, view, position, id) -> {
            String order = orderArrayList.get(position);
            Intent intent = new Intent(FourthActivity.this, SixthActivity.class);
            intent.putExtra("clientName", order);
            startActivity(intent);
            Log.d("ListClick", "Item clicado: " + order);
        });

        homePage.setOnClickListener(v -> {
            Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        makeOrder.setOnClickListener(v -> {
            Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
            startActivity(intent);
        });
    }

}