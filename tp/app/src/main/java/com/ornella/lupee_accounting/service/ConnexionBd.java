package com.ornella.lupee_accounting.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ornella.lupee_accounting.helper.BdLupeeHelper;

public class ConnexionBd {
    private static SQLiteDatabase bd;
    private static int version = 1;
    private static String name = "lupee.bd";

    public static SQLiteDatabase getBd(Context context){

        BdLupeeHelper bdLupeeHelper = new BdLupeeHelper(context, name, null, version);
        bd = bdLupeeHelper.getWritableDatabase();

        return bd;
    }

    public static void close(){
        bd.close();
    }
}
