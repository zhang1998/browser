package com.a.a.a;

/* compiled from: ProGuard */
public final class fe extends fd {
    private final long a = 15000;
    private ec b;

    public fe(ec ecVar) {
        this.b = ecVar;
    }

    public final boolean a(boolean z) {
        if (System.currentTimeMillis() - this.b.c >= 15000) {
            return true;
        }
        return false;
    }
}
