package com.alibaba.analytics.core.db;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: ProGuard */
final class b implements DatabaseErrorHandler {
    b() {
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        c.e = true;
    }
}
