package com.uc;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Runnable c;

    i(String str, String str2, Runnable runnable) {
        this.a = str;
        this.b = str2;
        this.c = runnable;
    }

    public final void run() {
        n.a.e(this.a);
        n.a.a(this.b);
        if (this.c != null) {
            this.c.run();
        }
    }
}
