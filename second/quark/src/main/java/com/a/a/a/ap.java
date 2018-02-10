package com.a.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: ProGuard */
final class ap {
    public static boolean a(String str, SQLiteDatabase sQLiteDatabase) {
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

    public static void a(Context context) {
        if (context != null) {
            try {
                File file = new File("/data/data/" + context.getPackageName() + "/databases/ua.db");
                if (file.exists()) {
                    file.delete();
                }
                an.a(context).a();
            } catch (Throwable th) {
            }
        }
    }
}
