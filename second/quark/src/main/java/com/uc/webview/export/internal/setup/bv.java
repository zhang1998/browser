package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;

/* compiled from: ProGuard */
final class bv implements ValueCallback<s> {
    final /* synthetic */ bu a;

    bv(bu buVar) {
        this.a = buVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        s sVar = (s) obj;
        UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
        if (totalLoadedUCM == null) {
            return;
        }
        if (totalLoadedUCM.coreType != 2 || !SDKFactory.k) {
            sVar.stop();
        }
    }
}
