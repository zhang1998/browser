package com.uc.apollo.preload;

import java.util.Map;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ Map c;
    final /* synthetic */ PreloadListener d;

    k(String str, String str2, Map map, PreloadListener preloadListener) {
        this.a = str;
        this.b = str2;
        this.c = map;
        this.d = preloadListener;
    }

    public final void run() {
        i.a(this.a, this.b, this.c, this.d);
    }
}
