package com.uc.apollo.preload;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    m(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        i.a(this.a, this.b);
    }
}
