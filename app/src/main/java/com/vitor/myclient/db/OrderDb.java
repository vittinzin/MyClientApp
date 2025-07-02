package com.vitor.myclient.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class OrderDb extends SQLiteOpenHelper implements BaseColumns {

    public static final String DB_NAME = "Orders";
    public static final String TABLE = "OrderData";
    public static final String ID = "id";
    public static final String CLIENT_NAME = "clientName";
    public static final String CLIENT_PHONE = "clientPhone";
    public static final String VALUE = "value";
    public static final String DATE = "date";
    public static final int VERSION = 2;

    public OrderDb(Context context){
        super(context, DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String DB = "CREATE TABLE " + OrderDb.TABLE + " ( "
                + OrderDb.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OrderDb.CLIENT_NAME + " text, " +
                OrderDb.CLIENT_PHONE + " text, " +
                OrderDb.VALUE + " text, " +
                OrderDb.DATE + " text) ";

        sqLiteDatabase.execSQL(DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
