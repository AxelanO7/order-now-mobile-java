package com.dyon.pesanaja;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_pesenaja";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ORDER = "tb_order";
    private static final String KEY_ID = "id";
    private static final String KEY_CUSTOMER_NAME = "customer_name";
    private static final String KEY_RICE = "rice";
    private static final String KEY_CHICKEN = "chicken";
    private static final String KEY_CATFISH = "catfish";
    private static final String KEY_MINERAL = "water";
    private static final String KEY_TEA = "tea";
    private static final String KEY_ORANGE = "orange";
    private static final String KEY_NOTE = "note";

    private static final String CREATE_TABLE_ORDERS =
        "CREATE TABLE "
        + TABLE_ORDER + "(" + KEY_ID
        + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CUSTOMER_NAME + " TEXT, " + KEY_RICE + " INTEGER, " + KEY_CHICKEN + " INTEGER, " + KEY_CATFISH + " INTEGER, " + KEY_MINERAL + " INTEGER, " + KEY_TEA + " INTEGER, " + KEY_ORANGE + " INTEGER, " + KEY_NOTE + " TEXT );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ORDERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ORDER + "'");
        onCreate(db);
    }

    public long addOrderDetail(String name, Integer rice, Integer chicken, Integer catfish, Integer mineral, Integer tea, Integer orange, String note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CUSTOMER_NAME, name);
        values.put(KEY_RICE, rice);
        values.put(KEY_CHICKEN, chicken);
        values.put(KEY_CATFISH, catfish);
        values.put(KEY_MINERAL, mineral);
        values.put(KEY_TEA, tea);
        values.put(KEY_ORANGE, orange);
        values.put(KEY_NOTE, note);

        long insert = db.insert(TABLE_ORDER, null, values);

        return insert;
    }

    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orderModelArrayList = new ArrayList<Order>();

        String selectQuery = "SELECT * FROM " + TABLE_ORDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Order order = new Order();
                order.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                order.setNameCustomer(c.getString(c.getColumnIndex(KEY_CUSTOMER_NAME)));
                order.setRice(c.getInt(c.getColumnIndex(KEY_RICE)));
                order.setChicken(c.getInt(c.getColumnIndex(KEY_CHICKEN)));
                order.setCatfish(c.getInt(c.getColumnIndex(KEY_CATFISH)));
                order.setMineral(c.getInt(c.getColumnIndex(KEY_MINERAL)));
                order.setTea(c.getInt(c.getColumnIndex(KEY_TEA)));
                order.setOrange(c.getInt(c.getColumnIndex(KEY_ORANGE)));
                order.setNote(c.getString(c.getColumnIndex(KEY_NOTE)));
                orderModelArrayList.add(order);
            } while (c.moveToNext());
        }
        return orderModelArrayList;
    }

    public void deleteOrder(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORDER, KEY_ID + " = ?",
            new String[]{String.valueOf(id)});
    }

    public int updateOrder(Integer id, String name, Integer rice, Integer chicken, Integer
        catfish, Integer mineral, Integer tea, Integer orange, String note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CUSTOMER_NAME, name);
        values.put(KEY_RICE, rice);
        values.put(KEY_CHICKEN, chicken);
        values.put(KEY_CATFISH, catfish);
        values.put(KEY_MINERAL, mineral);
        values.put(KEY_TEA, tea);
        values.put(KEY_ORANGE, orange);
        values.put(KEY_NOTE, note);

        return db.update(TABLE_ORDER, values, KEY_ID + " = ?",
            new String[]{String.valueOf(id)});
    }
}
