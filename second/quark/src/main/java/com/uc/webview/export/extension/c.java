package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.s;

/* compiled from: ProGuard */
final class c implements ValueCallback<s> {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        UCCore.a("downloadException", (s) obj, this.a.b);
    }
}
