package com.ucpro.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;

/* compiled from: ProGuard */
final class n extends BroadcastReceiver {
    final /* synthetic */ b a;

    n(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                f.a().a(j.p);
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                f.a().a(j.o);
            }
        }
    }
}
