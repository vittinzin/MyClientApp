package com.vitor.myclient.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vitor.myclient.R;
import com.vitor.myclient.controller.OrderDbController;
import com.vitor.myclient.model.Order;

import java.util.List;

public class SixthActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private ImageView homePage, orderPage;
    private OrderDbController orderDbController;
    private List<Order> orderList;
    private EditOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth);

        recyclerView = findViewById(R.id.reciclerView2);
        orderDbController = new OrderDbController(this);
        searchView = findViewById(R.id.search);
        homePage = findViewById(R.id.homePage5);
        orderPage = findViewById(R.id.orderPage5);

        orderList = orderDbController.getAllOrders();
        adapter = new EditOrderAdapter(orderList, new EditOrderAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(Order order) {
                Intent intent = new Intent(SixthActivity.this, SeventhActivity.class);
                intent.putExtra("name", order.getClientName());
                intent.putExtra("phone", order.getClientPhone());
                intent.putExtra("date", order.getOrderDate());
                intent.putExtra("price", order.getOrderPrice());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(Order order) {
                new AlertDialog.Builder(SixthActivity.this)
                        .setTitle("Delete Order")
                        .setMessage("Are you sure you want to delete this order?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            orderDbController.deleteOrder(Integer.valueOf(order.getClientPhone()));
                            refreshOrders();
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });

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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        homePage.setOnClickListener(v -> {
            Intent intent = new Intent(SixthActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        orderPage.setOnClickListener(v ->{
            Intent intent = new Intent(SixthActivity.this, FourthActivity.class);
            startActivity(intent);
        });
    }
    private void refreshOrders() {
        orderList = orderDbController.getAllOrders();
        adapter.updateList(orderList);

        if (orderList.isEmpty()){
            Intent intent = new Intent(SixthActivity.this, FourthActivity.class);
            startActivity(intent);
        }
    }
}