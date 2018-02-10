package com.uc.quark.filedownloader.networkstate;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b {
    public List<WeakReference<c>> a;

    private b() {
        this.a = null;
        this.a = new ArrayList();
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.a.add(new WeakReference(cVar));
        }
    }
}
