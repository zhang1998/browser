package com.uc.webview.export.internal;

import android.os.Handler;
import android.os.Looper;
import com.uc.webview.export.internal.interfaces.IWebView;
import java.util.LinkedHashSet;

/* compiled from: ProGuard */
public abstract class b {
    public static LinkedHashSet<IWebView> a = new LinkedHashSet();
    public static int b = -1;
    public static int c = -1;
    public static int d = -1;
    public static Handler e = new Handler(Looper.getMainLooper());

    public abstract void a(IWebView iWebView, int i);

    public abstract void b(IWebView iWebView);

    public static void a(IWebView iWebView) {
        a.add(iWebView);
    }

    public void a(int i, int i2) {
    }
}
