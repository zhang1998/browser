package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class c extends BroadcastReceiver {
    final /* synthetic */ d a;

    c(d dVar) {
        this.a = dVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.h != null) {
            this.a.h.a(new b(this));
        }
    }
}
