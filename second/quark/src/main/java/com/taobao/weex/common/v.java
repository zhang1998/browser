package com.taobao.weex.common;

import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
final class v implements Runnable {
    final Runnable a;

    v(Runnable runnable) {
        this.a = runnable;
    }

    public final void run() {
        try {
            if (this.a != null) {
                this.a.run();
            }
        } catch (Throwable th) {
            if (i.c()) {
                WXLogUtils.e("SafeRunnable", "SafeRunnable run throw expection:" + th.getMessage());
            }
        }
    }
}
