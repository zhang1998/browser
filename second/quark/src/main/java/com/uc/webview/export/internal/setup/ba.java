package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.webkit.CookieSyncManager;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;

/* compiled from: ProGuard */
public final class ba extends s {
    public final void run() {
        try {
            CookieSyncManager.createInstance((Context) getOption(UCCore.OPTION_CONTEXT));
        } catch (RuntimeException e) {
        }
        callback("setup");
        callback(UCCore.OPTION_LOAD_KERNEL_TYPE);
        SDKFactory.invoke(10021, Integer.valueOf(2));
        setLoadedUCM(new UCMRunningInfo(getContext(), null, null, null, false, false, null, 2));
        callback("init");
        callback("switch");
    }
}
