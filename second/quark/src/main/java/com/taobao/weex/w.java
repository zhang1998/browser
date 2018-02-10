package com.taobao.weex;

import com.taobao.weex.utils.Trace;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ ac a;

    w(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        if (this.a.c != null && this.a.d != null) {
            Trace.beginSection("onFirstScreen");
            this.a.c.b();
            Trace.endSection();
        }
    }
}
