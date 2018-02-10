package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.UCAsyncTask.c;
import com.uc.webview.export.internal.setup.UCSubSetupTask.a;

/* compiled from: ProGuard */
final class ax implements ValueCallback<q> {
    final /* synthetic */ aw a;

    ax(aw awVar) {
        this.a = awVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        try {
            this.a.b.a.setLoadedUCM(new UCMRunningInfo(this.a.b.a.getContext(), this.a.a.mUCM, this.a.a.mCL, this.a.a.mShellCL, this.a.a.a, this.a.a.b, SDKFactory.d, ((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue()));
            this.a.b.a.callback("init");
            this.a.b.a.callback("switch");
            Boolean bool = (Boolean) this.a.b.a.getOption(UCCore.OPTION_PRECREATE_WEBVIEW);
            if (bool != null && bool.booleanValue() && !z.b()) {
                z zVar = new z();
                Object[] objArr = new Object[]{this.a.b.a};
                UCSubSetupTask uCSubSetupTask = this.a.b.a;
                uCSubSetupTask.getClass();
                UCAsyncTask uCAsyncTask = this.a.b.a;
                uCAsyncTask.getClass();
                ((z) ((z) ((z) ((z) ((z) ((z) ((z) ((z) zVar.invoke(10001, objArr)).setOptions(this.a.b.a.mOptions)).setUCM(this.a.a.mUCM)).setClassLoader(this.a.a.mCL)).onEvent("stat", new a(uCSubSetupTask))).onEvent("stop", new c(uCAsyncTask))).onEvent("success", new az(this))).onEvent("exception", new ay(this))).start();
            }
        } catch (UCSetupException e) {
            this.a.b.a.setException(e);
        } catch (Throwable th) {
            this.a.b.a.setException(new UCSetupException(4018, th));
        }
    }
}
