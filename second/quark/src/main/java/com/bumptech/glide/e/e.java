package com.bumptech.glide.e;

import android.support.annotation.Nullable;
import android.support.v4.d.b;
import com.bumptech.glide.util.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ProGuard */
public final class e {
    public final b<i, List<Class<?>>> a = new b();
    private final AtomicReference<i> b = new AtomicReference();

    @Nullable
    public final List<Class<?>> a(Class<?> cls, Class<?> cls2) {
        Object iVar;
        List<Class<?>> list;
        i iVar2 = (i) this.b.getAndSet(null);
        if (iVar2 == null) {
            iVar = new i(cls, cls2);
        } else {
            iVar2.a(cls, cls2, null);
            i iVar3 = iVar2;
        }
        synchronized (this.a) {
            list = (List) this.a.get(iVar);
        }
        this.b.set(iVar);
        return list;
    }
}
