package com.taobao.weex.bridge;

import com.taobao.weex.common.o;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ e c;

    u(String str, boolean z, e eVar) {
        this.a = str;
        this.b = z;
        this.c = eVar;
    }

    public final void run() {
        if (v.a.containsKey(this.a)) {
            WXLogUtils.w("WXComponentRegistry Duplicate the Module name: " + this.a);
        }
        if (this.b) {
            try {
                o b = this.c.b();
                b.c = this.a;
                v.b.put(this.a, b);
            } catch (Throwable e) {
                WXLogUtils.e(this.a + " class must have a default constructor without params. ", e);
            }
        }
        try {
            v.a(this.a, this.c);
        } catch (Throwable e2) {
            WXLogUtils.e("", e2);
        }
        v.b(this.a, this.c);
    }
}
