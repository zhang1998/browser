package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: ProGuard */
final class et implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ ep c;
    final /* synthetic */ String d;

    et(Context context, String str, ep epVar, String str2) {
        this.a = context;
        this.b = str;
        this.c = epVar;
        this.d = str2;
    }

    public final void run() {
        try {
            l d = ew.d(1);
            if (TextUtils.isEmpty(this.b)) {
                d.a(this.c, this.a, new Throwable("gpsstatistics"), this.d, null, null);
            } else {
                d.a(this.c, this.a, this.b, this.d, null, null);
            }
        } catch (Throwable th) {
        }
    }
}
