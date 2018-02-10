package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: ProGuard */
public class cx implements m {
    public final String a() {
        return "als.db";
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a2 varchar(100), a3 LONG );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS b (_id integer primary key autoincrement, b1 integer );");
        } catch (Throwable th) {
            cq.a(th, "SdCardDBCreator", "onCreate");
        }
    }
}
