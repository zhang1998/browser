package com.a.a.a;

/* compiled from: ProGuard */
public final class fm extends fd {
    private dz a;
    private ec b;

    public fm(ec ecVar, dz dzVar) {
        this.b = ecVar;
        this.a = dzVar;
    }

    public final boolean a(boolean z) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        switch (this.a.a) {
            case 1:
                j = 14400000;
                break;
            case 2:
                j = 28800000;
                break;
            case 3:
                j = 86400000;
                break;
            default:
                j = 0;
                break;
        }
        if (currentTimeMillis - this.b.c >= j) {
            return true;
        }
        return false;
    }

    public final boolean a() {
        return this.a.a();
    }
}
