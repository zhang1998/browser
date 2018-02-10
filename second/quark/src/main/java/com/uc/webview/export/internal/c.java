package com.uc.webview.export.internal;

import com.uc.webview.export.internal.setup.UCSetupException;

/* compiled from: ProGuard */
final class c implements Runnable {
    c() {
    }

    public final void run() {
        while (true) {
            try {
                Runnable runnable = (Runnable) b.a.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    return;
                }
            } catch (Throwable e) {
                b.a.clear();
                b.b = new UCSetupException(4008, e);
                return;
            }
        }
    }
}
