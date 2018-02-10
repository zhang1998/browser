package com.alibaba.analytics;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alibaba.analytics.a.af;

/* compiled from: ProGuard */
final class d implements ServiceConnection {
    d() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        af.a("onServiceConnected", "this", c.y);
        if (m.b == c.e) {
            c.a = q.a(iBinder);
            af.b("onServiceConnected", "iAnalytics", c.a);
        }
        synchronized (c.c) {
            c.c.notifyAll();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        af.a("AnalyticsMgr", "[onServiceDisconnected]");
        synchronized (c.c) {
            c.c.notifyAll();
        }
        c.k = true;
    }
}
