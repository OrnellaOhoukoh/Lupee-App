package com.ornella.lupee_accounting.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ornella.lupee_accounting.entities.Item;
import com.ornella.lupee_accounting.service.ConnexionBd;

import java.util.ArrayList;

public class ItemManager {
    @SuppressLint("Range")
    public static ArrayList<Item> getAll(Context ctx){

        ArrayList<Item> items = null;
        SQLiteDatabase bd = ConnexionBd.getBd(ctx);
        String query = "select * from items";
        Cursor cursor = bd.rawQuery(query, null);
        if(cursor.isBeforeFirst()){
            items =new ArrayList<>();
            while(cursor.moveToNext()){
            Item item = new Item();
            item.setId(cursor.getInt(cursor.getColumnIndex(" id")));
            item.setName(cursor.getString(cursor.getColumnIndex("name")));
            items.add(item);
            }
        ConnexionBd.close();
        }
        return items;

    }


}
