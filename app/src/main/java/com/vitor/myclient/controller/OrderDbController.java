package com.vitor.myclient.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vitor.myclient.db.OrderDb;

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


    }
}