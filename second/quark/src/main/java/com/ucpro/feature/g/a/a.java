package com.ucpro.feature.g.a;

import android.os.Message;
import android.os.SystemClock;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
final class a extends e {
    final /* synthetic */ b a;

    a(b bVar, String str) {
        this.a = bVar;
        super(str);
    }

    public final void handleMessage(Message message) {
        synchronized (this.a.a) {
            long elapsedRealtime = this.a.c - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.a.c();
            } else if (elapsedRealtime < this.a.b) {
                sendMessageDelayed(obtainMessage(1), elapsedRealtime);
            } else {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.a.a(elapsedRealtime);
                elapsedRealtime = (this.a.b + elapsedRealtime2) - SystemClock.elapsedRealtime();
                while (elapsedRealtime < 0) {
                    elapsedRealtime += this.a.b;
                }
                sendMessageDelayed(obtainMessage(1), elapsedRealtime);
            }
        }
    }
}
