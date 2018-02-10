package com.ucpro.feature.z.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ucpro.base.system.b;
import com.ucpro.feature.inputenhance.a.a;

/* compiled from: ProGuard */
final class j extends BroadcastReceiver {
    final /* synthetic */ i a;
    private String b = null;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onReceive(Context context, Intent intent) {
        this.b = intent.getAction();
        if (!"android.intent.action.SCREEN_ON".equals(this.b) && "android.intent.action.SCREEN_OFF".equals(this.b)) {
            if ((((float) a.a(this.a.b).height()) < ((float) b.a.g()) * 0.8f ? 1 : null) != null) {
                this.a.c.a.c();
            }
        }
    }
}
