package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;

/* compiled from: ProGuard */
final class bo implements ValueCallback {
    bo() {
    }

    public final void onReceiveValue(Object obj) {
        SDKFactory.p = false;
        SDKFactory.invoke(UCMPackageInfo.sortByLastModified, new Object[0]);
    }
}
