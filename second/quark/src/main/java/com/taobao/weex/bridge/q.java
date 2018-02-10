package com.taobao.weex.bridge;

/* compiled from: ProGuard */
public final class q implements Runnable {
    final /* synthetic */ s a;

    public q(s sVar) {
        this.a = sVar;
    }

    public final void run() {
        if (this.a.d) {
            this.a.a("", "notifySerializeCodeCache", new WXJSObject[0]);
        }
    }
}
