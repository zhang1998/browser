package com.uc.webview.export.internal.setup;

import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.d;

/* compiled from: ProGuard */
final class aa implements Runnable {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public final void run() {
        IWebView a;
        try {
            if (!z.b()) {
                a = z.a(this.a);
                Log.d("PrecreateWebViewTask", "main run mWebView:" + a);
                if (a != null) {
                    a.getSettingsInner().setJavaScriptEnabled(true);
                    a.setWebViewClient(new WebViewClient());
                    a.setWebChromeClient(new WebChromeClient());
                    String str = (String) this.a.getOption(UCCore.OPTION_PRECREATE_WEBVIEW_URL);
                    Log.d("PrecreateWebViewTask", "main run precreateWebViewUrl:" + str);
                    if (d.a(str)) {
                        a.loadData("<html><head></head><body onload=\"console.log(\"WebView init\");\"></body></html>", "text/html", null);
                    } else {
                        a.loadUrl(str);
                    }
                    Log.d("PrecreateWebViewTask", "main run finally destroy webview.");
                    a.destroy();
                }
            }
        } catch (Throwable th) {
        }
    }
}
