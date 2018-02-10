package com.alibaba.appmonitor.d;

import android.annotation.TargetApi;
import android.app.Application;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.a.r;
import com.alibaba.appmonitor.a.d;
import com.alibaba.appmonitor.f.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* compiled from: ProGuard */
public final class b implements Runnable {
    private static boolean a = false;
    private static boolean d = false;
    private static ScheduledFuture e;
    private static List<e> f = Collections.synchronizedList(new ArrayList());
    private Application b;
    private boolean c = true;

    @TargetApi(14)
    public static void a(Application application) {
        if (!a) {
            af.a("init BackgroundTrigger", new Object[0]);
            Runnable bVar = new b(application);
            i.a();
            e = i.b(e, bVar, 60000);
            a = true;
        }
    }

    public static void a(e eVar) {
        f.add(eVar);
    }

    private b(Application application) {
        this.b = application;
    }

    public final void run() {
        af.b();
        boolean a = r.a(this.b.getApplicationContext());
        if (this.c != a) {
            int i;
            this.c = a;
            if (a) {
                d.a().b();
                for (h hVar : h.values()) {
                    f.a(hVar, hVar.h);
                }
            } else {
                for (h hVar2 : h.values()) {
                    f.a(hVar2, hVar2.i);
                }
                f.b();
            }
            for (i = 0; i < f.size(); i++) {
                if (a) {
                    ((e) f.get(i)).d();
                } else {
                    ((e) f.get(i)).c();
                }
            }
        }
    }
}
