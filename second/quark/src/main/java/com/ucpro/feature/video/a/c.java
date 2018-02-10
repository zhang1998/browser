package com.ucpro.feature.video.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.uc.apollo.android.GuideDialog;

/* compiled from: ProGuard */
public final class c extends SQLiteOpenHelper {
    public c(Context context) {
        super(context, "video.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS video_history" + String.format("(%s INTEGER PRIMARY KEY, %s INTEGER, %s VARCHAR, %s VARCHAR, %s VARCHAR, %s INTEGER DEFAULT 0, %s INTEGER DEFAULT 0, %s INTEGER DEFAULT 0, %s VARCHAR)", new Object[]{"id", "video_type", "page_url", "video_uri", GuideDialog.TITLE, "current_pos", "duration", "visit_time", "quality"}));
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
