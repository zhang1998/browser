package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
final class eu implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ Throwable c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    eu(Context context, int i, Throwable th, String str, String str2) {
        this.a = context;
        this.b = i;
        this.c = th;
        this.d = str;
        this.e = str2;
    }

    public final void run() {
        try {
            l d = ew.d(this.b);
            if (d != null) {
                d.a(this.a, this.c, this.d, this.e);
            }
        } catch (Throwable th) {
        }
    }
}
