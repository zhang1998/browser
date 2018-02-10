package com.taobao.weex.common;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: ProGuard */
final class u implements Callback {
    final Callback a;

    u(Callback callback) {
        this.a = callback;
    }

    public final boolean handleMessage(Message message) {
        boolean z = false;
        try {
            if (this.a != null) {
                z = this.a.handleMessage(message);
            }
        } catch (Throwable th) {
        }
        return z;
    }
}
