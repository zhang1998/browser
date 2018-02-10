package com.bumptech.glide.e;

import android.support.annotation.Nullable;
import com.bumptech.glide.b.o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class i {
    final List<h<?>> a = new ArrayList();

    public final synchronized <Z> void a(Class<Z> cls, o<Z> oVar) {
        this.a.add(new h(cls, oVar));
    }

    @Nullable
    public final synchronized <Z> o<Z> a(Class<Z> cls) {
        o<Z> oVar;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.a.get(i);
            if (hVar.a.isAssignableFrom(cls)) {
                oVar = hVar.b;
                break;
            }
        }
        oVar = null;
        return oVar;
    }
}
