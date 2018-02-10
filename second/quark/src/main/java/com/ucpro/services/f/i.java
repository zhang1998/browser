package com.ucpro.services.f;

import android.util.Log;
import com.ucpro.c.b;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public abstract class i implements a, b {
    private final h a = new h();

    public final void e() {
        h hVar = this.a;
        if (this != null) {
            hVar.a = this;
            if (a() != null) {
                if (b.b()) {
                    Log.e("vanda", "sendRequest thread name:" + Thread.currentThread().getName());
                }
                m.a(new d(hVar));
            }
        }
    }
}
