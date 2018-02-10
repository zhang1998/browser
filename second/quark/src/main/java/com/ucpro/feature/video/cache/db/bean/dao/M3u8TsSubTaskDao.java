package com.ucpro.feature.video.cache.db.bean.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ucpro.feature.video.cache.db.bean.a;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/* compiled from: ProGuard */
public class M3u8TsSubTaskDao extends AbstractDao<a, Long> {
    public static final String TABLENAME = "M3U8_TS_SUB_TASK";

    /* compiled from: ProGuard */
    public class Properties {
        public static final Property a = new Property(0, Long.class, "tsDownloadId", true, "TS_DOWNLOAD_ID");
        public static final Property b = new Property(1, Long.class, "videoCacheTaskId", false, "VIDEO_CACHE_TASK_ID");
        public static final Property c = new Property(2, String.class, "tsTaskUrl", false, "TS_TASK_URL");
        public static final Property d = new Property(3, String.class, "tsTaskPath", false, "TS_TASK_PATH");
        public static final Property e = new Property(4, Integer.class, "tsTaskStatus", false, "TS_TASK_STATUS");
        public static final Property f = new Property(5, String.class, "tsTaskErrorMsg", false, "TS_TASK_ERROR_MSG");
    }

    public M3u8TsSubTaskDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public M3u8TsSubTaskDao(DaoConfig daoConfig, c cVar) {
        super(daoConfig, cVar);
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "'M3U8_TS_SUB_TASK' ('TS_DOWNLOAD_ID' INTEGER PRIMARY KEY UNIQUE ,'VIDEO_CACHE_TASK_ID' INTEGER,'TS_TASK_URL' TEXT NOT NULL ,'TS_TASK_PATH' TEXT NOT NULL ,'TS_TASK_STATUS' INTEGER,'TS_TASK_ERROR_MSG' TEXT);");
    }

    public static void dropTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "'M3U8_TS_SUB_TASK'");
    }

    protected void bindValues(SQLiteStatement sQLiteStatement, a aVar) {
        sQLiteStatement.clearBindings();
        Long l = aVar.a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        l = aVar.b;
        if (l != null) {
            sQLiteStatement.bindLong(2, l.longValue());
        }
        sQLiteStatement.bindString(3, aVar.c);
        sQLiteStatement.bindString(4, aVar.d);
        Integer valueOf = Integer.valueOf(aVar.a());
        if (valueOf != null) {
            sQLiteStatement.bindLong(5, (long) valueOf.intValue());
        }
        String str = aVar.f;
        if (str != null) {
            sQLiteStatement.bindString(6, str);
        }
    }

    public Long readKey(Cursor cursor, int i) {
        return cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
    }

    public a readEntity(Cursor cursor, int i) {
        String str = null;
        Long valueOf = cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
        Long valueOf2 = cursor.isNull(i + 1) ? null : Long.valueOf(cursor.getLong(i + 1));
        String string = cursor.getString(i + 2);
        String string2 = cursor.getString(i + 3);
        Integer valueOf3 = cursor.isNull(i + 4) ? null : Integer.valueOf(cursor.getInt(i + 4));
        if (!cursor.isNull(i + 5)) {
            str = cursor.getString(i + 5);
        }
        return new a(valueOf, valueOf2, string, string2, valueOf3, str);
    }

    public void readEntity(Cursor cursor, a aVar, int i) {
        Long l;
        Integer num;
        String str = null;
        if (cursor.isNull(i + 0)) {
            l = null;
        } else {
            l = Long.valueOf(cursor.getLong(i + 0));
        }
        aVar.a = l;
        if (cursor.isNull(i + 1)) {
            l = null;
        } else {
            l = Long.valueOf(cursor.getLong(i + 1));
        }
        aVar.b = l;
        aVar.c = cursor.getString(i + 2);
        aVar.d = cursor.getString(i + 3);
        if (cursor.isNull(i + 4)) {
            num = null;
        } else {
            num = Integer.valueOf(cursor.getInt(i + 4));
        }
        aVar.e = num;
        if (!cursor.isNull(i + 5)) {
            str = cursor.getString(i + 5);
        }
        aVar.f = str;
    }

    protected Long updateKeyAfterInsert(a aVar, long j) {
        aVar.a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(a aVar) {
        if (aVar != null) {
            return aVar.a;
        }
        return null;
    }

    protected boolean isEntityUpdateable() {
        return true;
    }
}
