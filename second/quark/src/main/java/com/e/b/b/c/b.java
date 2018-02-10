package com.e.b.b.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.alibaba.analytics.a.i;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@TargetApi(14)
/* compiled from: ProGuard */
public final class b implements ActivityLifecycleCallbacks {
    private static b g = new b();
    List<d> a = new LinkedList();
    Object b = new Object();
    private int c = 0;
    private boolean d = false;
    private ScheduledFuture<?> e = null;
    private Object f = new Object();

    private b() {
    }

    public static b a() {
        return g;
    }

    private void b() {
        synchronized (this.f) {
            if (this.e != null) {
                this.e.cancel(true);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.b) {
            for (int i = 0; i < this.a.size(); i++) {
                ((d) this.a.get(i)).a(activity);
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.b) {
            for (int i = 0; i < this.a.size(); i++) {
                ((d) this.a.get(i)).b(activity);
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        synchronized (this.b) {
            for (int i = 0; i < this.a.size(); i++) {
                ((d) this.a.get(i)).c(activity);
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        synchronized (this.b) {
            for (int i = 0; i < this.a.size(); i++) {
                ((d) this.a.get(i)).d(activity);
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.b) {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i);
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
        b();
        this.c++;
        if (!this.d) {
            synchronized (this.b) {
                for (int i = 0; i < this.a.size(); i++) {
                    ((d) this.a.get(i)).d();
                }
            }
        }
        this.d = true;
    }

    public final void onActivityStopped(Activity activity) {
        this.c--;
        if (this.c == 0) {
            b();
            i.a();
            this.e = i.a(null, new a(), 1000);
        }
    }
}
