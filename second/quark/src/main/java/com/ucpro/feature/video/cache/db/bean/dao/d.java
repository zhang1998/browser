package com.ucpro.feature.video.cache.db.bean.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: ProGuard */
public final class d extends b {
    public d(Context context, String str) {
        super(context, str);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        new StringBuilder("Upgrading schema from version ").append(i).append(" to ").append(i2).append(" by dropping all tables");
        a.b(sQLiteDatabase);
        onCreate(sQLiteDatabase);
    }
}
