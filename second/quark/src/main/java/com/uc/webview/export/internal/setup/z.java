package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: ProGuard */
public final class z extends UCSubSetupTask<z, z> {
    private static boolean a = false;
    private static final Object b = new Object();

    static /* synthetic */ IWebView a(z zVar) {
        Log.d("PrecreateWebViewTask", "createUCWebView");
        int[] iArr = new int[1];
        return (IWebView) SDKFactory.invoke(10012, (Context) zVar.mOptions.get(UCCore.OPTION_CONTEXT), null, null, Boolean.valueOf(false), iArr);
    }

    public static void a() {
        synchronized (b) {
            a = true;
        }
    }

    public static boolean b() {
        boolean z = true;
        synchronized (b) {
            if (!a) {
                z = false;
            }
        }
        return z;
    }

    public final void run() {
        Log.d("PrecreateWebViewTask", "run --begin--");
        if (!b()) {
            SDKFactory.invoke(UCMPackageInfo.compareVersion, new aa(this));
        }
    }
}
