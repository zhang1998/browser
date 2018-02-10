package com.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
final class bp extends SQLiteOpenHelper {
    private static Context b;
    private String a;

    public static synchronized bp a(Context context) {
        bp a;
        synchronized (bp.class) {
            b = context;
            a = bt.a;
        }
        return a;
    }

    private bp(Context context, String str, String str2) {
        this(new bq(context, str), str2, null, 1);
    }

    private bp(Context context, String str, CursorFactory cursorFactory, int i) {
        if (str == null || str.equals("")) {
            str = "cc.db";
        }
        super(context, str, null, 1);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!(a("aggregated", writableDatabase) && a("aggregated_cache", writableDatabase))) {
                c(writableDatabase);
            }
            if (!a("system", writableDatabase)) {
                b(writableDatabase);
            }
            if (!a("limitedck", writableDatabase)) {
                a(writableDatabase);
            }
        } catch (Exception e) {
        }
    }

    private static boolean a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type ='table' and name ='" + str.trim() + "' ", null);
            if (cursor.moveToNext() && cursor.getInt(0) > 0) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z;
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            c(sQLiteDatabase);
            b(sQLiteDatabase);
            a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
            sQLiteDatabase.execSQL(this.a);
            return true;
        } catch (SQLException e) {
            fw.d("create reference table error!");
            return false;
        }
    }

    private boolean b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
            sQLiteDatabase.execSQL(this.a);
            return true;
        } catch (SQLException e) {
            fw.d("create system table error!");
            return false;
        }
    }

    private boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a = "create table if not exists aggregated_cache(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.a);
            this.a = "create table if not exists aggregated(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.a);
            return true;
        } catch (SQLException e) {
            fw.d("create aggregated table error!");
            return false;
        }
    }
}
