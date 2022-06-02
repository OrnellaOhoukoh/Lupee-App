package com.ornella.lupee_accounting.manager;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ornella.lupee_accounting.entities.User;
import com.ornella.lupee_accounting.service.ConnexionBd;

import java.util.ArrayList;

public class UserManager {

    @SuppressLint("Range")
    public static ArrayList<User> getAll(Context context){
        ArrayList<User> users = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        String query ="select * from user";
        Cursor cursor = bd.rawQuery(query, null);
        if(cursor.isBeforeFirst()){
            users = new ArrayList<>();
            while (cursor.moveToNext()){
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setLogin(cursor.getString(cursor.getColumnIndex("login")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                user.setUser_category(cursor.getInt(cursor.getColumnIndex("user_category")));
                user.setAcct_balance(cursor.getInt(cursor.getColumnIndex("acct_balance")));
                users.add(user);
            }
            ConnexionBd.close();
        }

        return users;
    }


    public static void add(Context context, User userToAdd){

        SQLiteDatabase bd = ConnexionBd.getBd(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", userToAdd.getLogin());
        contentValues.put("password", userToAdd.getPassword());
        bd.insert("user", null, contentValues);
        ConnexionBd.close();
    }
}
