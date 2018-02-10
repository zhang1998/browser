package com.bumptech.glide.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ProGuard */
final class f extends BroadcastReceiver {
    final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        boolean z = this.a.b;
        this.a.b = g.a(context);
        if (z != this.a.b) {
            this.a.a.a(this.a.b);
        }
    }
}
