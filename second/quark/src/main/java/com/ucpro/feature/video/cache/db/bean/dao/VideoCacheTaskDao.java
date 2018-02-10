package com.ucpro.feature.video.cache.db.bean.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.apollo.android.GuideDialog;
import com.uc.media.interfaces.IProxyHandler;
import com.ucpro.feature.video.cache.db.bean.b;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Date;

/* compiled from: ProGuard */
public class VideoCacheTaskDao extends AbstractDao<b, Long> {
    public static final String TABLENAME = "VIDEO_CACHE_TASK";

    /* compiled from: ProGuard */
    public class Properties {
        public static final Property a = new Property(0, Long.class, "id", true, "_id");
        public static final Property b = new Property(1, String.class, "url", false, "URL");
        public static final Property c = new Property(2, String.class, GuideDialog.TITLE, false, "TITLE");
        public static final Property d = new Property(3, String.class, IProxyHandler.KEY_PAGE_URL, false, "PAGE_URL");
        public static final Property e = new Property(4, Integer.TYPE, "cacheType", false, "CACHE_TYPE");
        public static final Property f = new Property(5, String.class, INoCaptchaComponent.status, false, "STATUS");
        public static final Property g = new Property(6, String.class, "errorMsg", false, "ERROR_MSG");
        public static final Property h = new Property(7, String.class, "path", false, "PATH");
        public static final Property i = new Property(8, String.class, "metaDataPath", false, "META_DATA_PATH");
        public static final Property j = new Property(9, Boolean.class, "metaDataReRequest", false, "META_DATA_RE_REQUEST");
        public static final Property k = new Property(10, String.class, "reRequestMetaDataUrl", false, "RE_REQUEST_META_DATA_URL");
        public static final Property l = new Property(11, Long.class, "soFarBytes", false, "SO_FAR_BYTES");
        public static final Property m = new Property(12, Long.class, "totalBytes", false, "TOTAL_BYTES");
        public static final Property n = new Property(13, Integer.class, "speed", false, "SPEED");
        public static final Property o = new Property(14, Integer.class, "totalTsCount", false, "TOTAL_TS_COUNT");
        public static final Property p = new Property(15, Integer.class, "sofarTsCount", false, "SOFAR_TS_COUNT");
        public static final Property q = new Property(16, Integer.class, "sofarErrorTsCount", false, "SOFAR_ERROR_TS_COUNT");
        public static final Property r = new Property(17, Date.class, "taskCreatedTime", false, "TASK_CREATED_TIME");
        public static final Property s = new Property(18, Date.class, "taskLastUpdateTime", false, "TASK_LAST_UPDATE_TIME");
    }

    public VideoCacheTaskDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public VideoCacheTaskDao(DaoConfig daoConfig, c cVar) {
        super(daoConfig, cVar);
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("CREATE TABLE " + (z ? "IF NOT EXISTS " : "") + "'VIDEO_CACHE_TASK' ('_id' INTEGER PRIMARY KEY ,'URL' TEXT NOT NULL UNIQUE ,'TITLE' TEXT NOT NULL ,'PAGE_URL' TEXT,'CACHE_TYPE' INTEGER NOT NULL ,'STATUS' TEXT,'ERROR_MSG' TEXT,'PATH' TEXT,'META_DATA_PATH' TEXT,'META_DATA_RE_REQUEST' INTEGER,'RE_REQUEST_META_DATA_URL' TEXT,'SO_FAR_BYTES' INTEGER,'TOTAL_BYTES' INTEGER,'SPEED' INTEGER,'TOTAL_TS_COUNT' INTEGER,'SOFAR_TS_COUNT' INTEGER,'SOFAR_ERROR_TS_COUNT' INTEGER,'TASK_CREATED_TIME' INTEGER,'TASK_LAST_UPDATE_TIME' INTEGER);");
    }

    public static void dropTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        sQLiteDatabase.execSQL("DROP TABLE " + (z ? "IF EXISTS " : "") + "'VIDEO_CACHE_TASK'");
    }

    protected void bindValues(SQLiteStatement sQLiteStatement, b bVar) {
        int i;
        sQLiteStatement.clearBindings();
        Long l = bVar.a;
        if (l != null) {
            sQLiteStatement.bindLong(1, l.longValue());
        }
        sQLiteStatement.bindString(2, bVar.b);
        sQLiteStatement.bindString(3, bVar.c);
        String str = bVar.d;
        if (str != null) {
            sQLiteStatement.bindString(4, str);
        }
        sQLiteStatement.bindLong(5, (long) bVar.e);
        str = bVar.f;
        if (str != null) {
            sQLiteStatement.bindString(6, str);
        }
        str = bVar.g;
        if (str != null) {
            sQLiteStatement.bindString(7, str);
        }
        str = bVar.h;
        if (str != null) {
            sQLiteStatement.bindString(8, str);
        }
        str = bVar.i;
        if (str != null) {
            sQLiteStatement.bindString(9, str);
        }
        Boolean valueOf = Boolean.valueOf(bVar.a());
        if (valueOf != null) {
            long j;
            if (valueOf.booleanValue()) {
                j = 1;
            } else {
                j = 0;
            }
            sQLiteStatement.bindLong(10, j);
        }
        str = bVar.k;
        if (str != null) {
            sQLiteStatement.bindString(11, str);
        }
        l = Long.valueOf(bVar.b());
        if (l != null) {
            sQLiteStatement.bindLong(12, l.longValue());
        }
        l = Long.valueOf(bVar.c());
        if (l != null) {
            sQLiteStatement.bindLong(13, l.longValue());
        }
        Integer valueOf2 = Integer.valueOf(bVar.d());
        if (valueOf2 != null) {
            sQLiteStatement.bindLong(14, (long) valueOf2.intValue());
        }
        valueOf2 = Integer.valueOf(bVar.e());
        if (valueOf2 != null) {
            sQLiteStatement.bindLong(15, (long) valueOf2.intValue());
        }
        valueOf2 = Integer.valueOf(bVar.f());
        if (valueOf2 != null) {
            sQLiteStatement.bindLong(16, (long) valueOf2.intValue());
        }
        if (bVar.q == null) {
            i = 0;
        } else {
            i = bVar.q.intValue();
        }
        valueOf2 = Integer.valueOf(i);
        if (valueOf2 != null) {
            sQLiteStatement.bindLong(17, (long) valueOf2.intValue());
        }
        Date date = bVar.r;
        if (date != null) {
            sQLiteStatement.bindLong(18, date.getTime());
        }
        date = bVar.s;
        if (date != null) {
            sQLiteStatement.bindLong(19, date.getTime());
        }
    }

    public Long readKey(Cursor cursor, int i) {
        return cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
    }

    public b readEntity(Cursor cursor, int i) {
        Boolean bool;
        Date date;
        Long valueOf = cursor.isNull(i + 0) ? null : Long.valueOf(cursor.getLong(i + 0));
        String string = cursor.getString(i + 1);
        String string2 = cursor.getString(i + 2);
        String string3 = cursor.isNull(i + 3) ? null : cursor.getString(i + 3);
        int i2 = cursor.getInt(i + 4);
        String string4 = cursor.isNull(i + 5) ? null : cursor.getString(i + 5);
        String string5 = cursor.isNull(i + 6) ? null : cursor.getString(i + 6);
        String string6 = cursor.isNull(i + 7) ? null : cursor.getString(i + 7);
        String string7 = cursor.isNull(i + 8) ? null : cursor.getString(i + 8);
        if (cursor.isNull(i + 9)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(i + 9) != (short) 0);
        }
        String string8 = cursor.isNull(i + 10) ? null : cursor.getString(i + 10);
        Long valueOf2 = cursor.isNull(i + 11) ? null : Long.valueOf(cursor.getLong(i + 11));
        Long valueOf3 = cursor.isNull(i + 12) ? null : Long.valueOf(cursor.getLong(i + 12));
        Integer valueOf4 = cursor.isNull(i + 13) ? null : Integer.valueOf(cursor.getInt(i + 13));
        Integer valueOf5 = cursor.isNull(i + 14) ? null : Integer.valueOf(cursor.getInt(i + 14));
        Integer valueOf6 = cursor.isNull(i + 15) ? null : Integer.valueOf(cursor.getInt(i + 15));
        Integer valueOf7 = cursor.isNull(i + 16) ? null : Integer.valueOf(cursor.getInt(i + 16));
        if (cursor.isNull(i + 17)) {
            date = null;
        } else {
            Date date2 = new Date(cursor.getLong(i + 17));
        }
        return new b(valueOf, string, string2, string3, i2, string4, string5, string6, string7, bool, string8, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, valueOf7, date, cursor.isNull(i + 18) ? null : new Date(cursor.getLong(i + 18)));
    }

    public void readEntity(Cursor cursor, b bVar, int i) {
        Long l;
        String str;
        Boolean bool;
        Integer num;
        Date date;
        Date date2 = null;
        if (cursor.isNull(i + 0)) {
            l = null;
        } else {
            l = Long.valueOf(cursor.getLong(i + 0));
        }
        bVar.a = l;
        bVar.b = cursor.getString(i + 1);
        bVar.c = cursor.getString(i + 2);
        if (cursor.isNull(i + 3)) {
            str = null;
        } else {
            str = cursor.getString(i + 3);
        }
        bVar.d = str;
        bVar.e = cursor.getInt(i + 4);
        if (cursor.isNull(i + 5)) {
            str = null;
        } else {
            str = cursor.getString(i + 5);
        }
        bVar.f = str;
        if (cursor.isNull(i + 6)) {
            str = null;
        } else {
            str = cursor.getString(i + 6);
        }
        bVar.g = str;
        if (cursor.isNull(i + 7)) {
            str = null;
        } else {
            str = cursor.getString(i + 7);
        }
        bVar.h = str;
        if (cursor.isNull(i + 8)) {
            str = null;
        } else {
            str = cursor.getString(i + 8);
        }
        bVar.i = str;
        if (cursor.isNull(i + 9)) {
            bool = null;
        } else {
            bool = Boolean.valueOf(cursor.getShort(i + 9) != (short) 0);
        }
        bVar.j = bool;
        if (cursor.isNull(i + 10)) {
            str = null;
        } else {
            str = cursor.getString(i + 10);
        }
        bVar.k = str;
        if (cursor.isNull(i + 11)) {
            l = null;
        } else {
            l = Long.valueOf(cursor.getLong(i + 11));
        }
        bVar.l = l;
        if (cursor.isNull(i + 12)) {
            l = null;
        } else {
            l = Long.valueOf(cursor.getLong(i + 12));
        }
        bVar.m = l;
        if (cursor.isNull(i + 13)) {
            num = null;
        } else {
            num = Integer.valueOf(cursor.getInt(i + 13));
        }
        bVar.n = num;
        if (cursor.isNull(i + 14)) {
            num = null;
        } else {
            num = Integer.valueOf(cursor.getInt(i + 14));
        }
        bVar.o = num;
        if (cursor.isNull(i + 15)) {
            num = null;
        } else {
            num = Integer.valueOf(cursor.getInt(i + 15));
        }
        bVar.p = num;
        if (cursor.isNull(i + 16)) {
            num = null;
        } else {
            num = Integer.valueOf(cursor.getInt(i + 16));
        }
        bVar.q = num;
        if (cursor.isNull(i + 17)) {
            date = null;
        } else {
            date = new Date(cursor.getLong(i + 17));
        }
        bVar.r = date;
        if (!cursor.isNull(i + 18)) {
            date2 = new Date(cursor.getLong(i + 18));
        }
        bVar.s = date2;
    }

    protected Long updateKeyAfterInsert(b bVar, long j) {
        bVar.a = Long.valueOf(j);
        return Long.valueOf(j);
    }

    public Long getKey(b bVar) {
        if (bVar != null) {
            return bVar.a;
        }
        return null;
    }

    protected boolean isEntityUpdateable() {
        return true;
    }
}
