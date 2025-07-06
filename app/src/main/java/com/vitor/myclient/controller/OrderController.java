package com.vitor.myclient.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.vitor.myclient.model.Login;
import com.vitor.myclient.model.Order;
import com.vitor.myclient.model.Register;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderController {
    private static final String prefs = "prefs2";
    private static final String ITENS_KEY = "orders";
    private SharedPreferences sp;

    public OrderController(){
    }

    public OrderController (Context context){
        sp = context.getSharedPreferences(prefs, Context.MODE_PRIVATE);
    }

    public void saveOrder(Order order) {
        Set<String> itens = sp.getStringSet(ITENS_KEY, new HashSet<>());
        Set<String> novoSet = new HashSet<>(itens);
        novoSet.add(order.getClientName());

        SharedPreferences.Editor editor = sp.edit();
        editor.putStringSet(ITENS_KEY, novoSet);
        editor.putString("clientName", order.getClientName());
        editor.putString("clientPhone", order.getClientPhone());
        editor.putFloat("orderPrice", Float.valueOf(order.getOrderPrice()));
        editor.putString("orderDate", String.valueOf(order.getOrderDate()));
        editor.apply();
    }

    public ArrayList<String> getOrderItens() {
        Set<String> itens = sp.getStringSet(ITENS_KEY, new HashSet<>());
        return new ArrayList<>(itens);
    }

    public String getPhone(String name) {
        return sp.getString("clientPhone", "");
    }

    public float getPrice(String name) {
        return sp.getFloat("orderPrice", 0.0f);
    }

    public String getDate(String name) {
        return sp.getString("orderDate", "");
    }
}
