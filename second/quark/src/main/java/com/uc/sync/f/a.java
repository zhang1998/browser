package com.uc.sync.f;

import android.os.Looper;

/* compiled from: ProGuard */
public final class a {
    k a;
    i b;

    public a(i iVar) {
        this.b = iVar;
        Looper f = iVar.f();
        if (f == null) {
            throw new IllegalArgumentException("looper cannot be null");
        }
        this.a = new k(f, this);
    }
}
