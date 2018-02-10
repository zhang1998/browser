package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.c;
import java.lang.Thread.UncaughtExceptionHandler;

final class ab implements UncaughtExceptionHandler {
    ab() {
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (i.c() && ah.t != null) {
            if (i.o()) {
                as.a(ah.t).a(new c(ah.t, ah.a(ah.t, false, null), th, thread), null, false, true);
                ah.q.f("MTA has caught the following uncaught exception:");
                ah.q.a(th);
            }
            ah.e(ah.t);
            if (ah.r != null) {
                ah.q.g("Call the original uncaught exception handler.");
                if (!(ah.r instanceof ab)) {
                    ah.r.uncaughtException(thread, th);
                }
            }
        }
    }
}
