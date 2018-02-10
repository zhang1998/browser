package com.ucpro.feature.z.h.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ProGuard */
final class b extends Handler {
    final /* synthetic */ i a;

    b(i iVar, Looper looper) {
        this.a = iVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        if (this.a.u) {
            this.a.v.removeMessages(1);
            return;
        }
        this.a.d();
        i iVar = this.a;
        iVar.s++;
        if (this.a.s <= this.a.r) {
            this.a.v.sendEmptyMessageDelayed(1, this.a.t);
        }
    }
}
