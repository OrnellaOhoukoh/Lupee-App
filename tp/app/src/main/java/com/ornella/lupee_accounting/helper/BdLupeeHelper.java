package com.ornella.lupee_accounting.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BdLupeeHelper extends SQLiteOpenHelper {

    public BdLupeeHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table user ( id integer primary key AUTOINCREMENT," +
                "login text," + "password text," + "acct_balance real," + "user_category_id integer NOT NULL,"+ "FOREIGN KEY (user_category_id) REFERENCES user_category(id));";

        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL("insert into user (login, password,acct_balance, user_category_id) values ('lili', 'lala',500, 1);");
        sqLiteDatabase.execSQL("insert into user (login, password,acct_balance, user_category_id) values ('toto', 'titi',4000, 2);");
        sqLiteDatabase.execSQL("insert into user (login, password,acct_balance, user_category_id) values ('john', 'doe',10000, 2);");

        String query2 = "create table user_category (id integer primary key," +
                "name text);";
        sqLiteDatabase.execSQL(query2);
        sqLiteDatabase.execSQL("insert into user_category(id, name) values (1, 'Admin')");
        sqLiteDatabase.execSQL("insert into user_category(id, name) values (2, 'User')");

        String query3 = "create table items (id integer primary key AUTOINCREMENT," +
                "name text);";
        sqLiteDatabase.execSQL(query3);

        sqLiteDatabase.execSQL("insert into items(name) values ('Groceries')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Electricity')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Rent')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Transportation')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Beauty')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Health')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Savings')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Investment')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Business Capital')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Education')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Internet')");
        sqLiteDatabase.execSQL("insert into items(name) values ('Others')");

        String query4 = "create table operation (id integer primary key AUTOINCREMENT," +
                "name text," + "amount real," + "id_user integer," +"FOREIGN KEY (id_user) REFERENCES user(id));";

        sqLiteDatabase.execSQL(query4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
