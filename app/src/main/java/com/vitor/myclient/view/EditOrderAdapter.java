package com.vitor.myclient.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vitor.myclient.R;
import com.vitor.myclient.model.Order;

import java.util.ArrayList;
import java.util.List;

public class EditOrderAdapter extends RecyclerView.Adapter<EditOrderAdapter.OrderViewHolder> {

    public interface OnItemClickListener {
        void onEditClick(Order order);
        void onDeleteClick(Order order);
    }

    private List<Order> orderList;
    private final List<Order> orderListFull;
    private final OnItemClickListener listener;

    public EditOrderAdapter(List<Order> orders, OnItemClickListener listener) {
        this.orderList = new ArrayList<>(orders);
        this.orderListFull = new ArrayList<>(orders);
        this.listener = listener;
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
        orderList = filteredList;
        notifyDataSetChanged();
    }
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView clientName, orderPhone, date, price;
        Button btnEdit, btnDelete;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            clientName = itemView.findViewById(R.id.orderName);
            orderPhone = itemView.findViewById(R.id.orderPhone);
            date = itemView.findViewById(R.id.orderDate);
            price = itemView.findViewById(R.id.orderValue);

            btnEdit = itemView.findViewById(R.id.editButton);
            btnDelete = itemView.findViewById(R.id.deleteButton);
        }
    }

    public EditOrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.edit_item, parent, false);
        return new EditOrderAdapter.OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditOrderAdapter.OrderViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.clientName.setText("\uD83D\uDC64 " + order.getClientName());
        holder.orderPhone.setText("\uD83D\uDCDE " + order.getClientPhone());
        holder.date.setText(order.getOrderDate());
        holder.price.setText("R$ " + order.getOrderPrice());

        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(order));
        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(order));

    }

    public void updateList(List<Order> newList) {
        orderList.clear();
        orderList.addAll(newList);

        orderListFull.clear();
        orderListFull.addAll(newList);

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}