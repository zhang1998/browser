package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: ProGuard */
final class c implements ValueCallback<s> {
    final /* synthetic */ BrowserSetupTask a;

    c(BrowserSetupTask browserSetupTask) {
        this.a = browserSetupTask;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        if (SDKFactory.x != null) {
            SDKFactory.x.onReceiveValue(sVar.getException());
        }
        if (this.a.c != null) {
            this.a.callStatException(IWaStat.SETUP_REPAIR_EXCEPTION, sVar.getException());
            ((s) ((s) ((s) this.a.c.invoke(10001, this.a)).onEvent("success", this.a.m)).onEvent("exception", this.a.n)).start();
            this.a.c = null;
            return;
        }
        if (Boolean.valueOf(false).booleanValue()) {
            UCSetupException exception = sVar.getException();
            if (this.a.isNoDiskSpaceError(exception.errCode()) || this.a.isNeedRestartError(exception.errCode())) {
                BrowserSetupTask.i(this.a);
            }
        }
        this.a.setException(sVar.getException());
    }
}
