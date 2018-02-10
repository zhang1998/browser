package com.uc.base.wa.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
public final class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "WaSession.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table tb_session (_id integer primary key autoincrement,name text,token text,status integer,config integer);");
        sQLiteDatabase.execSQL("create table tb_session_step (_id integer primary key autoincrement,sid integer,value blob,step integer,time_start integer,time_duration integer);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
