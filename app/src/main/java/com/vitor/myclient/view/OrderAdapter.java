package com.vitor.myclient.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.vitor.myclient.R;
import com.vitor.myclient.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<Order> orders;
    private final List<Order> orderListFull;

    public OrderAdapter(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
        this.orderListFull = new ArrayList<>(orders);
    }

    public void filter(String text) {
        List<Order> filteredList = new ArrayList<>();
        if (text.isEmpty()) {
            filteredList.addAll(orderListFull);
        } else {
            text = text.toLowerCase();
            for (Order order : orderListFull) {
                if (order.getClientName().toLowerCase().contains(text)) {
                    filteredList.add(order);
                }
            }
        }
        orders = filteredList;
        notifyDataSetChanged();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView clientName, orderPhone, date, price;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            clientName = itemView.findViewById(R.id.orderName);
            orderPhone = itemView.findViewById(R.id.orderPhone);
            date = itemView.findViewById(R.id.orderDate);
            price = itemView.findViewById(R.id.orderValue);
        }
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.clientName.setText("\uD83D\uDC64 " + order.getClientName());
        holder.orderPhone.setText("\uD83D\uDCDE " + order.getClientPhone());
        holder.date.setText(order.getOrderDate());
        holder.price.setText("R$ " + order.getOrderPrice());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

}