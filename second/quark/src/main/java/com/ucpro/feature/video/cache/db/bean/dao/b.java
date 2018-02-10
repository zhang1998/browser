package com.ucpro.feature.video.cache.db.bean.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ProGuard */
public abstract class b extends SQLiteOpenHelper {
    public b(Context context, String str) {
        super(context, str, null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a.a(sQLiteDatabase);
    }
}
