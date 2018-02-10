package com.alibaba.analytics.core.f;

import android.content.Context;
import android.util.Log;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.c.g;
import com.alibaba.analytics.core.model.b;
import com.alibaba.appmonitor.d.e;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
public final class f implements e {
    public static g c = new g();
    private static f d = new f();
    public h a;
    public List<b> b = new CopyOnWriteArrayList();
    private List<g> e = Collections.synchronizedList(new ArrayList());
    private ScheduledFuture f = null;
    private ScheduledFuture g = null;
    private ScheduledFuture h = null;
    private Runnable i = new i(this);

    private f() {
        Context context = com.alibaba.analytics.core.b.a().b;
        this.a = new a();
        i.a();
        i.a(new c(this));
        com.alibaba.appmonitor.d.b.a((e) this);
    }

    public static f a() {
        return d;
    }

    public final void a(b bVar) {
        af.b("LogStoreMgr", "Log", bVar.a());
        this.b.add(bVar);
        if (this.b.size() >= 100 || com.alibaba.analytics.core.b.a().h()) {
            i.a();
            this.f = i.a(null, this.i, 0);
        } else if (this.f == null || (this.f != null && this.f.isDone())) {
            i.a();
            this.f = i.a(this.f, this.i, 5000);
        }
    }

    public final int a(List<b> list) {
        af.a("LogStoreMgr", list);
        return this.a.b(list);
    }

    public final synchronized void b() {
        af.b();
        List list = null;
        try {
            synchronized (this.b) {
                if (this.b.size() > 0) {
                    list = new ArrayList(this.b);
                    this.b.clear();
                }
            }
            if (list != null) {
                if (list.size() > 0) {
                    this.a.a(list);
                    a(b.a, list.size());
                }
            }
        } catch (Throwable th) {
            Log.w("LogStoreMgr", "", th);
        }
    }

    private long e() {
        return (long) this.a.a();
    }

    public final void a(g gVar) {
        this.e.add(gVar);
    }

    public final void b(g gVar) {
        this.e.remove(gVar);
    }

    private void a(int i, int i2) {
        af.b();
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            g gVar = (g) this.e.get(i3);
            if (gVar != null) {
                switch (e.a[i - 1]) {
                    case 1:
                        e();
                        break;
                    case 2:
                        gVar.a((long) i2, e());
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public final void c() {
        i.a();
        this.f = i.a(null, this.i, 0);
        i.a();
        ScheduledFuture scheduledFuture = this.g;
        Runnable dVar = new d(this);
        dVar.a = 1;
        this.g = i.a(scheduledFuture, dVar, 60000);
        i.a();
        scheduledFuture = this.h;
        dVar = new d(this);
        dVar.a = 30;
        this.h = i.a(scheduledFuture, dVar, 1800000);
    }

    public final void d() {
    }

    static /* synthetic */ int a(f fVar) {
        af.b();
        Calendar instance = Calendar.getInstance();
        instance.add(5, -3);
        return fVar.a.a("time", String.valueOf(instance.getTimeInMillis()));
    }
}
