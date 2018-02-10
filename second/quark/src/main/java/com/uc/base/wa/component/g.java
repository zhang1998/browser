package com.uc.base.wa.component;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
public final class g extends SQLiteOpenHelper {
    final /* synthetic */ h a;

    public g(h hVar, Context context) {
        this.a = hVar;
        super(context, "WaValue.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("Create table tb_str (_id integer primary key autoincrement,key TEXT,value TEXT );");
        sQLiteDatabase.execSQL("Create table tb_int (_id integer primary key autoincrement,key TEXT,value INTEGER );");
        sQLiteDatabase.execSQL("Create table tb_long (_id integer primary key autoincrement,key TEXT,value BIGINT );");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
