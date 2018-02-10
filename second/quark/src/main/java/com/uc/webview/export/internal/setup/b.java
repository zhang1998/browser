package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class b implements ValueCallback<s> {
    final /* synthetic */ BrowserSetupTask a;

    b(BrowserSetupTask browserSetupTask) {
        this.a = browserSetupTask;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        if (UCSetupTask.getTotalLoadedUCM() != null) {
            sVar.stop();
        }
    }
}
