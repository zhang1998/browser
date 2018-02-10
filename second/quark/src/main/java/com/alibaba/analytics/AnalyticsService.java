package com.alibaba.analytics;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: ProGuard */
public class AnalyticsService extends Service {
    h a = null;

    public IBinder onBind(Intent intent) {
        if (this.a == null) {
            this.a = new o(getApplication());
        }
        return (IBinder) this.a;
    }

    public void onDestroy() {
        if (this.a != null) {
            try {
                this.a.h();
            } catch (RemoteException e) {
            }
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        if (this.a != null) {
            try {
                this.a.h();
            } catch (RemoteException e) {
            }
        }
        super.onLowMemory();
    }
}
