package com.ucpro.services.location;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: ProGuard */
final class i extends Handler {
    final /* synthetic */ k a;

    i(k kVar, Looper looper) {
        this.a = kVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.a.b.stopLocation();
                this.a.a("network");
                this.a.e.sendEmptyMessageDelayed(1, 10000);
                return;
            case 1:
                try {
                    this.a.a.removeUpdates(this.a.d);
                } catch (Exception e) {
                    Log.e("LocationClientWrapper", "Invoke AndroidLocationManager.removeUpdates failed");
                }
                this.a.c.a();
                return;
            default:
                return;
        }
    }
}
