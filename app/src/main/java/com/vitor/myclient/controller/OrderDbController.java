package com.vitor.myclient.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vitor.myclient.db.OrderDb;
import com.vitor.myclient.model.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrderDbController {

    private SQLiteDatabase db;
    private final OrderDb odb;

    public OrderDbController(Context context) {
        odb = new OrderDb(context);
    }

    public void insert(String name, String phone, String value, String date) {
        db = odb.getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put(OrderDb.CLIENT_NAME, name);
        data.put(OrderDb.CLIENT_PHONE, phone);
        data.put(OrderDb.VALUE, value);
        data.put(OrderDb.DATE, date);
        db.insert(OrderDb.TABLE, null, data);

    }
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        db = odb.getReadableDatabase();
        Cursor cursor = db.query(OrderDb.TABLE, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(OrderDb.CLIENT_NAME));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(OrderDb.CLIENT_PHONE));
                float value = cursor.getFloat(cursor.getColumnIndexOrThrow(OrderDb.VALUE));
                String date = cursor.getString(cursor.getColumnIndexOrThrow(OrderDb.DATE));

                orderList.add(new Order(name, phone, value, date));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return orderList;
    }

    public List<String> getNames() {
        List<String> namesList = new ArrayList<>();
        db = odb.getReadableDatabase();
        Cursor cursor = db.query(OrderDb.TABLE, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(OrderDb.CLIENT_NAME));

                namesList.add(name);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return namesList;
    }

    public void deleteOrder(int id) {
        SQLiteDatabase db = odb.getWritableDatabase();
        db.delete("orderData", "clientPhone = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void editOrder(Order order) {
        SQLiteDatabase db = odb.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(OrderDb.CLIENT_NAME, order.getClientName());
        data.put(OrderDb.CLIENT_PHONE, order.getClientPhone());
        data.put(OrderDb.VALUE, order.getOrderPrice());
        data.put(OrderDb.DATE, order.getOrderDate());

        db.update("orderData", data, "clientPhone = ?", new String[]{String.valueOf(order.getClientPhone())});
        db.close();
    }
}