package com.ucpro.services.networkstate;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class c {
    List<WeakReference<a>> a;

    private c() {
        this.a = null;
        this.a = new ArrayList();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.a.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            int size = this.a.size() - 1;
            while (size >= 0) {
                if (((a) ((WeakReference) this.a.get(size)).get()) == aVar && size < this.a.size()) {
                    this.a.remove(size);
                }
                size--;
            }
        }
    }
}
