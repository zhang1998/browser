package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.os.Handler;
import com.uc.webview.export.WebMessage;
import com.uc.webview.export.WebMessagePort;
import com.uc.webview.export.WebMessagePort.a;

@TargetApi(23)
/* compiled from: ProGuard */
public final class n extends WebMessagePort {
    android.webkit.WebMessagePort a;

    n(android.webkit.WebMessagePort webMessagePort) {
        this.a = webMessagePort;
    }

    public final void postMessage(WebMessage webMessage) {
    }

    public final void close() {
        this.a.close();
    }

    public final void setWebMessageCallback(a aVar) {
        setWebMessageCallback(aVar, null);
    }

    public final void setWebMessageCallback(a aVar, Handler handler) {
        this.a.setWebMessageCallback(new o(this));
    }
}
