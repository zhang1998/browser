package com.a.a.a;

/* compiled from: ProGuard */
public final class fr extends fd {
    private final long a = 10800000;
    private ec b;

    public fr(ec ecVar) {
        this.b = ecVar;
    }

    public final boolean a(boolean z) {
        if (System.currentTimeMillis() - this.b.c >= 10800000) {
            return true;
        }
        return false;
    }
}
