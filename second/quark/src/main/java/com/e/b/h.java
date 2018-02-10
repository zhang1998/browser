package com.e.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.alibaba.analytics.a.af;
import com.e.b.b.b.c;
import com.e.b.b.c.d;
import com.e.b.c.b;
import java.util.List;

/* compiled from: ProGuard */
public final class h implements d {
    long a = 0;
    public c b = null;
    private long c = 0;
    private long d = 0;

    static boolean a() {
        try {
            Context context = com.alibaba.analytics.core.c.a().a;
            if (context != null) {
                String packageName = context.getPackageName();
                if (packageName != null) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    if (activityManager != null) {
                        try {
                            List runningTasks = activityManager.getRunningTasks(1);
                            if (runningTasks != null && runningTasks.size() > 0) {
                                ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
                                if (componentName != null && packageName.contains(componentName.getPackageName())) {
                                    return false;
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    final void a(long j) {
        if (!com.alibaba.analytics.core.c.a().b && j > 0) {
            long elapsedRealtime;
            if (0 != this.d) {
                elapsedRealtime = SystemClock.elapsedRealtime() - this.d;
            } else {
                elapsedRealtime = 0;
            }
            com.e.b.c.d dVar = new com.e.b.c.d("UT", 1010, String.valueOf(j), String.valueOf(elapsedRealtime), null, null);
            dVar.a("_priority", "5");
            if (this.b != null) {
                com.e.b.b.b.d a = this.b.a();
                long a2 = a.b.a() + a.a.a();
                elapsedRealtime = a.a.a();
                long a3 = a.b.a();
                long j2 = a.a.b;
                long j3 = a.a.a;
                long j4 = a.b.b;
                long j5 = a.b.a;
                dVar.a("_tftl", String.valueOf(a2));
                dVar.a("_tfmtl", String.valueOf(a3));
                dVar.a("_tfwtl", String.valueOf(elapsedRealtime));
                dVar.a("_tfmrx", String.valueOf(j4));
                dVar.a("_tfmtx", String.valueOf(j5));
                dVar.a("_tfwrx", String.valueOf(j2));
                dVar.a("_tfwtx", String.valueOf(j3));
            }
            l d = b.a().d();
            if (d != null) {
                d.a(dVar.a());
                return;
            }
            af.a("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
    }

    public final void c() {
        g a = g.a();
        if (a.a.containsKey(a.c)) {
            ((m) a.a.get(a.c)).f = true;
        }
        a(SystemClock.elapsedRealtime() - this.c);
        this.d = SystemClock.elapsedRealtime();
        b.a().b();
        com.alibaba.analytics.c.b();
    }

    public final void d() {
        this.c = SystemClock.elapsedRealtime();
    }

    public final void a(Activity activity) {
    }

    public final void b(Activity activity) {
        g a = g.a();
        String a2 = g.a((Object) activity);
        if (a.a.containsKey(a2)) {
            a.a.remove(a2);
        }
        if (a.b.contains(a2)) {
            a.b.remove(a2);
        }
        a.c();
    }

    public final void c(Activity activity) {
        g a = g.a();
        if (!a.d) {
            a.a((Object) activity, b.a().d());
        }
    }

    public final void d(Activity activity) {
        g a = g.a();
        if (!a.d) {
            a.b((Object) activity);
        }
    }
}
