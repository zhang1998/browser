package com.bumptech.glide.c;

import com.bumptech.glide.f.b;
import com.bumptech.glide.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
public final class s {
    public final Set<b> a = Collections.newSetFromMap(new WeakHashMap());
    public final List<b> b = new ArrayList();
    public boolean c;

    public final boolean a(b bVar) {
        boolean z = false;
        if (bVar != null) {
            boolean remove = this.a.remove(bVar);
            if (this.b.remove(bVar) || remove) {
                z = true;
            }
            if (z) {
                bVar.d();
                bVar.i();
            }
        }
        return z;
    }

    public final void a() {
        for (b a : l.a(this.a)) {
            a(a);
        }
        this.b.clear();
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
