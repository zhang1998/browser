package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.e.f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: ProGuard */
final class ac {
    ThreadPoolExecutor a;
    LinkedBlockingQueue<Runnable> b;

    public ac() {
        a();
    }

    final void a() {
        this.b = new LinkedBlockingQueue();
        this.a = f.a(3, this.b, "LauncherTask");
    }
}
