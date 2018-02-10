package com.alibaba.analytics;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    e(boolean z, boolean z2, String str, String str2) {
        this.a = z;
        this.b = z2;
        this.c = str;
        this.d = str2;
    }

    public final void run() {
        try {
            c.a.a(this.a, this.b, this.c, this.d);
        } catch (Throwable th) {
        }
    }
}
