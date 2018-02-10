package com.uc.quark.p2p.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.uc.m;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class P2pVideoPlayService extends Service {
    private b a;

    public void onCreate() {
        super.onCreate();
        m.a = getApplicationContext();
        this.a = new e(new WeakReference(this));
    }

    public IBinder onBind(Intent intent) {
        return this.a.b();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
