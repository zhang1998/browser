package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCAsyncTask.b;
import com.uc.webview.export.internal.setup.UCAsyncTask.c;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;

/* compiled from: ProGuard */
final class au implements ValueCallback<p> {
    final /* synthetic */ at a;

    au(at atVar) {
        this.a = atVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        p pVar = (p) obj;
        this.a.callback("setup");
        UCCore.getCurrentLoadClassTask().setUCM(pVar.mUCM).setClassLoader(pVar.mCL).setup(UCCore.OPTION_SETUP_THREAD_PRIORITY, Integer.valueOf(Thread.currentThread().getPriority())).onEvent("success", new av(this)).start();
        t tVar = new t();
        Object[] objArr = new Object[]{this.a};
        UCSubSetupTask uCSubSetupTask = this.a;
        uCSubSetupTask.getClass();
        UCAsyncTask uCAsyncTask = this.a;
        uCAsyncTask.getClass();
        uCAsyncTask = this.a;
        uCAsyncTask.getClass();
        ((t) ((t) ((t) ((t) ((t) ((t) ((t) ((t) tVar.invoke(10001, objArr)).setOptions(this.a.mOptions)).setUCM(pVar.mUCM)).setClassLoader(pVar.mCL)).onEvent("stat", new a(uCSubSetupTask))).onEvent("exception", new b(uCAsyncTask))).onEvent("stop", new c(uCAsyncTask))).onEvent("success", new aw(this, pVar))).start();
    }
}
