package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;

/* compiled from: ProGuard */
final class j implements ValueCallback<s> {
    final /* synthetic */ BrowserSetupTask a;

    j(BrowserSetupTask browserSetupTask) {
        this.a = browserSetupTask;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        String message = sVar.getException().getRootCause().getMessage();
        if (sVar.getException().errCode() == 1001 || message.equals("Error on 7z decoding: 1")) {
            BrowserSetupTask.a(IWaStat.SETUP_DEFAULT_EXCEPTION, sVar);
            this.a.callStatException(IWaStat.SETUP_DEFAULT_EXCEPTION, sVar.getException());
            ab abVar = new ab();
            Object[] objArr = new Object[]{this.a};
            UCSubSetupTask uCSubSetupTask = this.a;
            uCSubSetupTask.getClass();
            ((s) ((s) ((s) ((s) ((s) abVar.invoke(10001, objArr)).setOptions(this.a.b.mOptions)).onEvent("stat", new a(uCSubSetupTask))).onEvent("success", this.a.m)).onEvent("exception", this.a.n)).start();
        } else if (sVar.getException().errCode() != SettingsConst.PRELOAD_CD_PARAMS) {
            BrowserSetupTask.a(IWaStat.SETUP_DEFAULT_EXCEPTION, sVar);
            this.a.callStatException(IWaStat.SETUP_DEFAULT_EXCEPTION, sVar.getException());
            BrowserSetupTask.i(this.a);
            ((s) ((s) ((s) ((s) ((s) ((s) am.a(this.a.mOptions).invoke(10001, this.a)).setup(UCCore.OPTION_UCM_ZIP_FILE, this.a.f.getAbsolutePath())).onEvent("success", this.a.m)).onEvent("exception", this.a.n)).onEvent("stat", new a(this.a))).onEvent("setup", new b(this.a))).start();
        } else {
            this.a.n.onReceiveValue(sVar);
        }
    }
}
