package com.uc.a.d;

import com.uc.a.e.a;

/* compiled from: ProGuard */
public abstract class h {
    public static h a;

    public abstract a a();

    public abstract String a(String str);

    public abstract void a(Runnable runnable);

    public abstract String b();

    public static void b(Runnable runnable) {
        if (a != null) {
            a.a(runnable);
        }
    }
}
