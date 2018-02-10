package com.alibaba.analytics.core.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ProGuard */
final class f extends BroadcastReceiver {
    final /* synthetic */ g a;

    private f(g gVar) {
        this.a = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            if (this.a.a != null) {
                this.a.a.removeCallbacks(this.a.c);
                this.a.c.a = context;
                this.a.a.postDelayed(this.a.c, 1000);
            }
        } catch (Throwable th) {
        }
    }
}
