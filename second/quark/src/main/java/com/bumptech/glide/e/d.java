package com.bumptech.glide.e;

import android.support.annotation.Nullable;
import android.support.v4.d.b;
import com.bumptech.glide.b.b.ar;
import com.bumptech.glide.util.i;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ProGuard */
public final class d {
    public final b<i, ar<?, ?, ?>> a = new b();
    private final AtomicReference<i> b = new AtomicReference();

    public final boolean a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        boolean containsKey;
        i c = c(cls, cls2, cls3);
        synchronized (this.a) {
            containsKey = this.a.containsKey(c);
        }
        this.b.set(c);
        return containsKey;
    }

    @Nullable
    public final <Data, TResource, Transcode> ar<Data, TResource, Transcode> b(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ar<Data, TResource, Transcode> arVar;
        i c = c(cls, cls2, cls3);
        synchronized (this.a) {
            arVar = (ar) this.a.get(c);
        }
        this.b.set(c);
        return arVar;
    }

    private i c(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i iVar = (i) this.b.getAndSet(null);
        if (iVar == null) {
            iVar = new i();
        }
        iVar.a(cls, cls2, cls3);
        return iVar;
    }
}
