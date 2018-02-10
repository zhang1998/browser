package com.loc;

import android.content.Context;

/* compiled from: ProGuard */
final class ab implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    ab(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final void run() {
        try {
            ak.a(new n(this.a, ao.b()), this.a, this.b);
        } catch (Throwable th) {
            es.a(th, "InstanceFactory", "rollBack");
        }
    }
}
