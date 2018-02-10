package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.UCAsyncTask.b;
import com.uc.webview.export.internal.setup.UCAsyncTask.c;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;

/* compiled from: ProGuard */
public abstract class at extends s {
    protected p a;

    protected abstract p a();

    public void run() {
        this.a = (p) ((p) ((p) ((p) ((p) ((p) ((p) a().invoke(10001, this)).setOptions(this.mOptions)).onEvent("stat", new a(this))).onEvent("exception", new b(this))).onEvent("stop", new c(this))).onEvent("success", new au(this))).start();
    }
}
