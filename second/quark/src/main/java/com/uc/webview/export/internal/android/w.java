package com.uc.webview.export.internal.android;

import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.Utils;
import java.util.Iterator;

/* compiled from: ProGuard */
final class w implements Runnable {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        Object obj;
        Iterator it = v.a.iterator();
        while (it.hasNext()) {
            if (((IWebView) it.next()).getView().getWindowVisibility() == 0) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null && v.d == 1) {
            if (Utils.sWAPrintLog) {
                Log.d("SDKWaStat", "WebViewDetector:onPause");
            }
            WaStat.saveData();
            v.d = 0;
        }
    }
}
