package com.uc.sync.f;

import com.uc.sync.a.a;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ h a;

    d(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        a.a();
        this.a.a.sendEmptyMessage(65537);
    }
}
