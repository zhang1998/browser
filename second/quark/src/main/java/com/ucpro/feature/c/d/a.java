package com.ucpro.feature.c.d;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ h c;

    a(h hVar, boolean z, String str) {
        this.c = hVar;
        this.a = z;
        this.b = str;
    }

    public final void run() {
        if (this.a) {
            this.c.b.a(this.b, "");
        } else {
            this.c.b.a("online_search_error");
        }
    }
}
