package com.uc.quark.filedownloader;

import java.util.ArrayList;

/* compiled from: ProGuard */
public final class i extends ai implements c {
    private volatile Object a = new Object();
    private final ArrayList<at> b = new ArrayList();

    public final void a() {
    }

    public final void b() {
    }

    public final boolean a(at atVar) {
        boolean z;
        synchronized (this.a) {
            z = !this.b.isEmpty() && this.b.contains(atVar);
        }
        return z;
    }

    public final void b(at atVar) {
        synchronized (this.a) {
            if (!this.b.isEmpty()) {
                this.b.remove(atVar);
            }
        }
    }
}
