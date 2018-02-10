package com.a.a.a;

/* compiled from: ProGuard */
public final class fq extends fd {
    private long a = 86400000;
    private ec b;

    public fq(ec ecVar) {
        this.b = ecVar;
    }

    public final boolean a(boolean z) {
        if (System.currentTimeMillis() - this.b.c >= this.a) {
            return true;
        }
        return false;
    }
}
