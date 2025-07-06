package com.vitor.myclient.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderController;
import com.vitor.myclient.controller.OrderDbController;
import com.vitor.myclient.model.Order;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {

    private ImageView homePage;
    private TextView makeOrder, noOrders;
    private RecyclerView recyclerList;
    private SearchView searchView;
    private OrderDbController orderDbController;
    private List<Order> orderList;
    private Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);

        homePage = findViewById(R.id.homePage);
        makeOrder = findViewById(R.id.makeOrderPage);
        recyclerList = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchview);
        editBtn = findViewById(R.id.editBtn);
        orderDbController = new OrderDbController(this);
        noOrders = findViewById(R.id.noItensTxt);

        orderList = orderDbController.getAllOrders();
        OrderAdapter adapter = new OrderAdapter(orderList);

        recyclerList.setLayoutManager(new LinearLayoutManager(this));
        recyclerList.setAdapter(adapter);

        if (orderList.isEmpty()){
            noOrders.setText("No orders yet!");
        } else {
            noOrders.setText("");
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });

        if (!orderList.isEmpty()) {
            editBtn.setOnClickListener(v -> {
                Intent intent = new Intent(FourthActivity.this, SixthActivity.class);
                startActivity(intent);
            });
        }

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