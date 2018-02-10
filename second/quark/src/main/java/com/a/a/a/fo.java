package com.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ProGuard */
final class fo implements ServiceConnection {
    boolean a;
    final LinkedBlockingQueue<IBinder> b;

    private fo() {
        this.a = false;
        this.b = new LinkedBlockingQueue(1);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
