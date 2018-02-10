package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: ProGuard */
final class f implements ValueCallback<s> {
    final /* synthetic */ BrowserSetupTask a;

    f(BrowserSetupTask browserSetupTask) {
        this.a = browserSetupTask;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        this.a.callStatException(IWaStat.SETUP_EXTRA_EXCEPTION, sVar.getException());
        if (Boolean.valueOf(false).booleanValue() && this.a.isNeedRestartError(sVar.getException().errCode())) {
            BrowserSetupTask.i(this.a);
        }
        this.a.b.start();
    }
}
