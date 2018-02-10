package com.bumptech.glide.b.b;

import android.os.MessageQueue.IdleHandler;
import com.bumptech.glide.b.i;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: ProGuard */
final class ad implements IdleHandler {
    private final Map<i, WeakReference<an<?>>> a;
    private final ReferenceQueue<an<?>> b;

    public ad(Map<i, WeakReference<an<?>>> map, ReferenceQueue<an<?>> referenceQueue) {
        this.a = map;
        this.b = referenceQueue;
    }

    public final boolean queueIdle() {
        ae aeVar = (ae) this.b.poll();
        if (aeVar != null) {
            this.a.remove(aeVar.a);
        }
        return true;
    }
}
