package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCAsyncTask.b;
import com.uc.webview.export.internal.setup.UCAsyncTask.c;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;

/* compiled from: ProGuard */
final class aw implements ValueCallback<t> {
    final /* synthetic */ p a;
    final /* synthetic */ au b;

    aw(au auVar, p pVar) {
        this.b = auVar;
        this.a = pVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.b.a.callback(UCCore.OPTION_LOAD_KERNEL_TYPE);
        q qVar = new q();
        Object[] objArr = new Object[]{this.b.a};
        UCSubSetupTask uCSubSetupTask = this.b.a;
        uCSubSetupTask.getClass();
        UCAsyncTask uCAsyncTask = this.b.a;
        uCAsyncTask.getClass();
        uCAsyncTask = this.b.a;
        uCAsyncTask.getClass();
        ((q) ((q) ((q) ((q) ((q) ((q) ((q) ((q) qVar.invoke(10001, objArr)).setOptions(this.b.a.mOptions)).setUCM(this.a.mUCM)).setClassLoader(this.a.mCL)).onEvent("stat", new a(uCSubSetupTask))).onEvent("exception", new b(uCAsyncTask))).onEvent("stop", new c(uCAsyncTask))).onEvent("success", new ax(this))).start();
    }
}
