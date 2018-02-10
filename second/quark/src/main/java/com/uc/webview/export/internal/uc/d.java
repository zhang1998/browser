package com.uc.webview.export.internal.uc;

import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.Utils;
import java.util.Iterator;

/* compiled from: ProGuard */
final class d implements Runnable {
    d() {
    }

    public final void run() {
        try {
            Object obj;
            Iterator it = c.a.iterator();
            while (it.hasNext()) {
                if (((IWebView) it.next()).getView().getWindowVisibility() == 0) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null && c.d == 1) {
                if (Utils.sWAPrintLog) {
                    Log.d("WebViewDetector", "WebViewDetector:onPause");
                }
                WaStat.saveData();
                if (!(SDKFactory.f || SDKFactory.d == null)) {
                    SDKFactory.d.onPause();
                }
                c.d = 0;
            }
        } catch (Throwable th) {
        }
    }
}
