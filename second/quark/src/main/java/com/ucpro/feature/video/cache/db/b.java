package com.ucpro.feature.video.cache.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import com.ucpro.feature.video.cache.db.bean.dao.M3u8TsSubTaskDao;
import com.ucpro.feature.video.cache.db.bean.dao.M3u8TsSubTaskDao.Properties;
import com.ucpro.feature.video.cache.db.bean.dao.VideoCacheTaskDao;
import com.ucpro.feature.video.cache.db.bean.dao.a;
import com.ucpro.feature.video.cache.db.bean.dao.c;
import com.ucpro.feature.video.cache.db.bean.dao.d;
import com.ucpro.feature.video.cache.e.a.h;
import com.ucweb.common.util.h.m;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.WhereCondition;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class b {
    private static b c = null;
    public VideoCacheTaskDao a = this.f.a;
    public M3u8TsSubTaskDao b = this.f.b;
    private SQLiteDatabase d = new d(com.ucweb.common.util.d.a(), "group-dl-db").getWritableDatabase();
    private a e = new a(this.d);
    private c f = this.e.a();
    private long g = 0;
    private HashMap<com.ucpro.feature.video.cache.e.a.c, h> h = new HashMap();
    private long i = 0;
    private com.ucweb.common.util.h.a j = new c(this);

    private b() {
        a();
    }

    public final void a() {
        m.a(3, new a(), 0);
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    public final synchronized void a(com.ucpro.feature.video.cache.e.a.c cVar) {
        if (cVar != null) {
            if (!this.h.containsKey(cVar)) {
                this.h.put(cVar, new h(cVar, Looper.myLooper()));
            }
        }
    }

    public final synchronized void b(com.ucpro.feature.video.cache.e.a.c cVar) {
        if (cVar != null) {
            if (this.h.containsKey(cVar)) {
                this.h.remove(cVar);
            }
        }
    }

    public final void a(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.a.insertOrReplace(bVar);
        d();
    }

    private synchronized void d() {
        m.c(this.j);
        if (System.currentTimeMillis() - this.i > 1000) {
            com.ucpro.feature.video.d.a.b();
            e();
        } else {
            m.a(3, this.j, 1000);
        }
    }

    private void e() {
        this.g = System.currentTimeMillis();
        com.ucpro.feature.video.d.a.b();
        for (Entry value : this.h.entrySet()) {
            ((h) value.getValue()).w_();
        }
    }

    public final void b(com.ucpro.feature.video.cache.db.bean.b bVar) {
        this.a.update(bVar);
        d();
    }

    public final com.ucpro.feature.video.cache.db.bean.b a(long j) {
        return (com.ucpro.feature.video.cache.db.bean.b) this.a.load(Long.valueOf(j));
    }

    public final void a(com.ucpro.feature.video.cache.db.bean.a aVar) {
        this.b.update(aVar);
    }

    public final void b(long j) {
        this.b.queryBuilder().where(Properties.b.eq(Long.valueOf(j)), new WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    public final com.ucpro.feature.video.cache.db.bean.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Query build = this.a.queryBuilder().where(VideoCacheTaskDao.Properties.b.eq(str), new WhereCondition[0]).build();
        List list = build.list();
        if (list.size() > 1) {
            com.ucpro.feature.video.d.a.b();
            com.ucweb.common.util.c.a("不应该查得出来两个task用同一个m3u8 mUrl");
        }
        if (list.size() != 0) {
            return (com.ucpro.feature.video.cache.db.bean.b) build.list().get(0);
        }
        return null;
    }

    public final List<com.ucpro.feature.video.cache.db.bean.a> c(long j) {
        return this.b.queryBuilder().where(Properties.b.eq(Long.valueOf(j)), new WhereCondition[0]).build().list();
    }

    public final List<com.ucpro.feature.video.cache.db.bean.b> c() {
        List<com.ucpro.feature.video.cache.db.bean.b> loadAll = this.a.loadAll();
        if (com.ucpro.c.b.b()) {
            new StringBuilder("getAllVideoCacheTasks size is:").append(loadAll.size());
        }
        return loadAll;
    }

    public final void d(long j) {
        this.a.deleteByKey(Long.valueOf(j));
        d();
    }
}
