package com.uc.quark.filedownloader.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
final class s extends SQLiteOpenHelper {
    public s(Context context) {
        super(context, "filedownloader.db", null, 6);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS threadids( id INTEGER PRIMARY KEY, url VARCHAR, download_length INTEGER, sofar INTEGER, normal_size INTEGER, ext_size INTEGER, thread_id INTEGER, status TINYINT(7), downloadfile_id INTEGER )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownloader( _id INTEGER PRIMARY KEY, url VARCHAR, path VARCHAR, status TINYINT(7), sofar INTEGER, total INTEGER, errMsg VARCHAR, etag VARCHAR, pathAsDirectory TINYINT(1) DEFAULT 0, filename VARCHAR, postBody VARCHAR, fileContinue  TINYINT(1) DEFAULT 0, isNeedRefer  TINYINT(1) DEFAULT 1, updateUrl VARCHAR )");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r2, int r3, int r4) {
        /*
        r1 = this;
        switch(r3) {
            case 1: goto L_0x0004;
            case 2: goto L_0x0009;
            case 3: goto L_0x000e;
            case 4: goto L_0x0013;
            case 5: goto L_0x0018;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r0 = "ALTER TABLE filedownloader ADD COLUMN postBody VARCHAR";
        r2.execSQL(r0);
    L_0x0009:
        r0 = "CREATE TABLE IF NOT EXISTS threadids( id INTEGER PRIMARY KEY, url VARCHAR, download_length INTEGER, sofar INTEGER, normal_size INTEGER, ext_size INTEGER, thread_id INTEGER, status TINYINT(7), downloadfile_id INTEGER )";
        r2.execSQL(r0);
    L_0x000e:
        r0 = "ALTER TABLE filedownloader ADD COLUMN fileContinue  TINYINT(1) DEFAULT 0";
        r2.execSQL(r0);
    L_0x0013:
        r0 = "ALTER TABLE filedownloader ADD COLUMN isNeedRefer  TINYINT(1) DEFAULT 1";
        r2.execSQL(r0);
    L_0x0018:
        r0 = "ALTER TABLE filedownloader ADD COLUMN updateUrl VARCHAR";
        r2.execSQL(r0);
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.services.s.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
