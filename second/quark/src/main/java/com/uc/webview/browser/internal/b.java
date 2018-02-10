package com.uc.webview.browser.internal;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.browser.interfaces.BrowserPreloader;

/* compiled from: ProGuard */
final class b implements ValueCallback<Pair<Integer, String>> {
    final /* synthetic */ String a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ String c;
    final /* synthetic */ PreloadManager d;

    b(PreloadManager preloadManager, String str, ValueCallback valueCallback, String str2) {
        this.d = preloadManager;
        this.a = str;
        this.b = valueCallback;
        this.c = str2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Pair pair = (Pair) obj;
        if (((Integer) pair.first).intValue() == 0) {
            this.d.a(this.a, "sir_del_cmd_succ");
        }
        this.d.callback(this.a, this.b, Boolean.valueOf(((Integer) pair.first).intValue() == 0), (String) pair.second, ((Integer) pair.first).intValue(), this.c, BrowserPreloader.CDKEY_SIR_DELETE, true, false, false, false, 0, 0);
    }
}
