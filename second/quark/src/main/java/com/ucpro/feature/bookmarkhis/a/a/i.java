package com.ucpro.feature.bookmarkhis.a.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class i extends SQLiteOpenHelper {
    public static final String[] a = new String[]{"name", "url", "original_url", "visited_time", "visited_count", "state", "media_type", "from_type", "source", "daoliu_type", "article_id", "channel_id", "icon_url"};

    private i(String str) {
        super(d.a(), str, null, 1);
    }

    public i() {
        this("history");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS history");
        stringBuilder.append("(");
        stringBuilder.append("id  INTEGER PRIMARY KEY AUTOINCREMENT,");
        stringBuilder.append("name TEXT,");
        stringBuilder.append("url TEXT,");
        stringBuilder.append("original_url TEXT,");
        stringBuilder.append("visited_time INTEGER,");
        stringBuilder.append("host TEXT,");
        stringBuilder.append("visited_count INTEGER,");
        stringBuilder.append("state INTEGER,");
        stringBuilder.append("media_type INTEGER,");
        stringBuilder.append("url_hashcode INTEGER,");
        stringBuilder.append("from_type INTEGER,");
        stringBuilder.append("source TEXT,");
        stringBuilder.append("daoliu_type INTEGER,");
        stringBuilder.append("article_id TEXT,");
        stringBuilder.append("channel_id INTEGER,");
        stringBuilder.append("icon_url TEXT,");
        stringBuilder.append("temp_1 TEXT,");
        stringBuilder.append("temp_2 TEXT,");
        stringBuilder.append("temp_3 TEXT");
        stringBuilder.append(");");
        try {
            sQLiteDatabase.execSQL(stringBuilder.toString());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
