package com.ucpro.feature.video.cache.db.bean.dao;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/* compiled from: ProGuard */
public final class a extends AbstractDaoMaster {
    public final /* synthetic */ AbstractDaoSession newSession() {
        return a();
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        VideoCacheTaskDao.createTable(sQLiteDatabase, false);
        M3u8TsSubTaskDao.createTable(sQLiteDatabase, false);
    }

    public static void b(SQLiteDatabase sQLiteDatabase) {
        VideoCacheTaskDao.dropTable(sQLiteDatabase, true);
        M3u8TsSubTaskDao.dropTable(sQLiteDatabase, true);
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase, 2);
        registerDaoClass(VideoCacheTaskDao.class);
        registerDaoClass(M3u8TsSubTaskDao.class);
    }

    public final c a() {
        return new c(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public final /* synthetic */ AbstractDaoSession newSession(IdentityScopeType identityScopeType) {
        return new c(this.db, identityScopeType, this.daoConfigMap);
    }
}
