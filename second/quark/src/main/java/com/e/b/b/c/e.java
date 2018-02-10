package com.e.b.b.c;

import android.annotation.TargetApi;

/* compiled from: ProGuard */
public final class e {
    @TargetApi(14)
    public static void a(d dVar) {
        if (dVar != null) {
            b a = b.a();
            if (dVar != null) {
                synchronized (a.b) {
                    a.a.add(dVar);
                }
            }
        }
    }
}
