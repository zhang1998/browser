package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.s;

/* compiled from: ProGuard */
final class b implements ValueCallback<s> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        UCCore.a("updateProgress", (s) obj, this.a.b);
    }
}
