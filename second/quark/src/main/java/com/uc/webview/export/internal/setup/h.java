package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;

/* compiled from: ProGuard */
final class h implements ValueCallback<s> {
    final /* synthetic */ BrowserSetupTask a;

    h(BrowserSetupTask browserSetupTask) {
        this.a = browserSetupTask;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.callStatException(IWaStat.SETUP_DEFAULT_EXCEPTION, ((s) obj).getException());
        ad adVar = new ad();
        Object[] objArr = new Object[]{this.a};
        UCSubSetupTask uCSubSetupTask = this.a;
        uCSubSetupTask.getClass();
        ((s) ((s) ((s) ((s) ((s) adVar.invoke(10001, objArr)).setOptions(this.a.b.mOptions)).onEvent("stat", new a(uCSubSetupTask))).onEvent("success", this.a.m)).onEvent("exception", this.a.n)).start();
    }
}
