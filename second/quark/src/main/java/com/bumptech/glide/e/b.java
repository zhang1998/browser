package com.bumptech.glide.e;

import android.support.annotation.Nullable;
import com.bumptech.glide.b.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    private final List<a<?>> a = new ArrayList();

    @Nullable
    public final synchronized <T> c<T> a(Class<T> cls) {
        c<T> cVar;
        for (a aVar : this.a) {
            if (aVar.a.isAssignableFrom(cls)) {
                cVar = aVar.b;
                break;
            }
        }
        cVar = null;
        return cVar;
    }

    public final synchronized <T> void a(Class<T> cls, c<T> cVar) {
        this.a.add(new a(cls, cVar));
    }
}
