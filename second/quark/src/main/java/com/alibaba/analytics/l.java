package com.alibaba.analytics;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ Map a;

    l(Map map) {
        this.a = map;
    }

    public final void run() {
        try {
            c.a.b(this.a);
        } catch (RemoteException e) {
        }
    }
}
