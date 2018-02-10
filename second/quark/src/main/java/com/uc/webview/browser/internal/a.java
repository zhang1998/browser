package com.uc.webview.browser.internal;

import com.uc.webview.export.internal.interfaces.IPreloadManager;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ Method a;
    final /* synthetic */ Class b;
    final /* synthetic */ PreloadManager c;

    a(PreloadManager preloadManager, Method method, Class cls) {
        this.c = preloadManager;
        this.a = method;
        this.b = cls;
    }

    public final void run() {
        try {
            this.a.invoke(this.b, new Object[]{Integer.valueOf(1001), IPreloadManager.SIR_COMMON_TYPE});
        } catch (Throwable th) {
        }
    }
}
