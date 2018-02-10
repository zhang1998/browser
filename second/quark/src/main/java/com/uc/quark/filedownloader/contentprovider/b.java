package com.uc.quark.filedownloader.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;

/* compiled from: ProGuard */
public final class b extends SQLiteOpenHelper {
    private static final String a = ("CREATE TABLE IF NOT EXISTS threadnum" + com.uc.quark.filedownloader.e.b.a("(%s INTEGER PRIMARY KEY, %s INTEGER)", "id", "thread_num"));

    public b(Context context) {
        super(context, "filestatus.db", null, 3);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filestatus" + com.uc.quark.filedownloader.e.b.a("(%s INTEGER PRIMARY KEY, %s TINYINT, %s INTEGER, %s INTEGER, %s VARCHAR, %s VARCHAR)", "_id", INoCaptchaComponent.status, "sofar", "total", "url", "path"));
        sQLiteDatabase.execSQL(a);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("ALTER TABLE filestatus ADD COLUMN url VARCHAR");
                sQLiteDatabase.execSQL("ALTER TABLE filestatus ADD COLUMN path VARCHAR");
                break;
            case 2:
                break;
            default:
                return;
        }
        sQLiteDatabase.execSQL(a);
    }
}
