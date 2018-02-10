package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;

/* compiled from: ProGuard */
final class bp implements ValueCallback {
    bp() {
    }

    public final void onReceiveValue(Object obj) {
        SDKFactory.p = true;
        SDKFactory.q = true;
    }
}
