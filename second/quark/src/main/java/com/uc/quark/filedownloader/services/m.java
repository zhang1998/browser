package com.uc.quark.filedownloader.services;

import com.uc.quark.filedownloader.e.f;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ProGuard */
public final class m {
    private final ThreadPoolExecutor a;

    private m() {
        this.a = f.a(7, "EventPool");
    }

    public final void a(Runnable runnable) {
        if (runnable != null) {
            this.a.execute(runnable);
        }
    }
}
