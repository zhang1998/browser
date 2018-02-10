package com.alibaba.analytics.core.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alibaba.analytics.a.i;

/* compiled from: ProGuard */
final class d extends BroadcastReceiver {
    private d() {
    }

    public final void onReceive(Context context, Intent intent) {
        i.a();
        Runnable e = e.c;
        e.a = context;
        i.a(e);
    }
}
