package com.tencent.wxop.stat.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class d {
    ExecutorService a;

    public d() {
        this.a = null;
        this.a = Executors.newSingleThreadExecutor();
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
