package com.alibaba.analytics;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ Map a;

    r(Map map) {
        this.a = map;
    }

    public final void run() {
        try {
            c.a.d(this.a);
        } catch (RemoteException e) {
        }
    }
}
