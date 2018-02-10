package com.ucweb.common.util;

import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public abstract class b<T> extends e {
    private WeakReference<T> a;

    public abstract void a(Message message, T t);

    public final void handleMessage(Message message) {
        Object obj = this.a.get();
        if (obj != null) {
            a(message, obj);
        }
    }

    public String toString() {
        return "WeakHandlerEx (" + this.b + ") {}";
    }
}
