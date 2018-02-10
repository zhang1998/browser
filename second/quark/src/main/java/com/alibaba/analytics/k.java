package com.alibaba.analytics;

import android.os.RemoteException;

/* compiled from: ProGuard */
final class k implements Runnable {
    k() {
    }

    public final void run() {
        try {
            c.a.c();
        } catch (RemoteException e) {
        }
    }
}
