package com.a.a.a;

/* compiled from: ProGuard */
public final class fl extends fd {
    private long a;
    private long b = 0;

    public fl(int i) {
        this.a = (long) i;
        this.b = System.currentTimeMillis();
    }

    public final boolean a(boolean z) {
        if (System.currentTimeMillis() - this.b >= this.a) {
            return true;
        }
        return false;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.b < this.a;
    }
}
