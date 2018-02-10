package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
final class al extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ am d;

    al(am amVar, Context context, String str, String str2) {
        this.d = amVar;
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public final void run() {
        try {
            this.d.a(this.a, this.b, this.c);
        } catch (Throwable th) {
            es.a(th, "DynamicClassLoader", "run()");
        }
    }
}
