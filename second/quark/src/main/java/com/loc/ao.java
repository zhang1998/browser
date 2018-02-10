package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: ProGuard */
public final class ao implements m {
    private static ao a;

    private ao() {
    }

    public static synchronized ao b() {
        ao aoVar;
        synchronized (ao.class) {
            if (a == null) {
                a = new ao();
            }
            aoVar = a;
        }
        return aoVar;
    }

    public final String a() {
        return "dafile.db";
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            es.a(th, "DynamicFileDBCreator", "onCreate");
        }
    }
}
