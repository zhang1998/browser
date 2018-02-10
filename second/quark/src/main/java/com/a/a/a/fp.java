package com.a.a.a;

/* compiled from: ProGuard */
public final class fp extends fd {
    private static long a = 90000;
    private static long b = 86400000;
    private long c;
    private ec d;

    public fp(ec ecVar, long j) {
        this.d = ecVar;
        a(j);
    }

    public final boolean a(boolean z) {
        if (System.currentTimeMillis() - this.d.c >= this.c) {
            return true;
        }
        return false;
    }

    public final void a(long j) {
        if (j < a || j > b) {
            this.c = a;
        } else {
            this.c = j;
        }
    }
}
