package com.a.a.a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
final class an extends SQLiteOpenHelper {
    private static Context b = null;
    private String a;

    public static synchronized an a(Context context) {
        an a;
        synchronized (an.class) {
            b = context;
            a = am.a;
        }
        return a;
    }

    private an(Context context, String str, String str2) {
        this(new ao(context, str), str2, null, 1);
    }

    private an(Context context, String str, CursorFactory cursorFactory, int i) {
        if (str == null || str.equals("")) {
            str = "ua.db";
        }
        super(context, str, null, 1);
        this.a = null;
        a();
    }

    public final void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!ap.a("__sd", writableDatabase)) {
                c(writableDatabase);
            }
            if (!ap.a("__et", writableDatabase)) {
                b(writableDatabase);
            }
            if (!ap.a("__er", writableDatabase)) {
                a(writableDatabase);
            }
        } catch (Exception e) {
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            c(sQLiteDatabase);
            b(sQLiteDatabase);
            a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                }
            }
        } catch (SQLiteDatabaseCorruptException e) {
            ap.a(b);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th2) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT)";
            sQLiteDatabase.execSQL(this.a);
        } catch (SQLException e) {
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
