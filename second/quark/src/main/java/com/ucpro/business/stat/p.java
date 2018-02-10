package com.ucpro.business.stat;

import android.content.Context;
import com.a.a.a.fj;
import com.a.a.a.fw;
import com.a.a.b;
import com.a.a.c;
import com.a.a.e;
import com.a.a.f;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class p implements Runnable {
    public final void run() {
        Context a = d.a();
        e a2 = c.a;
        if (a == null) {
            try {
                fw.d("unexpected null context in onPause");
                return;
            } catch (Throwable th) {
                if (fw.a) {
                    fw.a("Exception occurred in Mobclick.onRause(). ", th);
                    return;
                }
                return;
            }
        }
        if (b.e && a2.b != null) {
            a2.b.a(a.getClass().getName());
        }
        if (!(a2.e && a2.f)) {
            a2.a(a);
        }
        fj.a(new f(a2, a));
    }
}
