package com.ucpro.feature.video.cache.db.bean.dao;

import android.database.sqlite.SQLiteDatabase;
import com.ucpro.feature.video.cache.db.bean.a;
import com.ucpro.feature.video.cache.db.bean.b;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

/* compiled from: ProGuard */
public final class c extends AbstractDaoSession {
    public final VideoCacheTaskDao a = new VideoCacheTaskDao(this.c, this);
    public final M3u8TsSubTaskDao b = new M3u8TsSubTaskDao(this.d, this);
    private final DaoConfig c;
    private final DaoConfig d;

    public c(SQLiteDatabase sQLiteDatabase, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(sQLiteDatabase);
        this.c = ((DaoConfig) map.get(VideoCacheTaskDao.class)).clone();
        this.c.initIdentityScope(identityScopeType);
        this.d = ((DaoConfig) map.get(M3u8TsSubTaskDao.class)).clone();
        this.d.initIdentityScope(identityScopeType);
        registerDao(b.class, this.a);
        registerDao(a.class, this.b);
    }
}
