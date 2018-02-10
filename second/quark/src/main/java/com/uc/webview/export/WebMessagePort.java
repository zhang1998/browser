package com.uc.webview.export;

import android.os.Handler;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public abstract class WebMessagePort {

    /* compiled from: ProGuard */
    public abstract class a {
    }

    public abstract void close();

    public abstract void postMessage(WebMessage webMessage);

    public abstract void setWebMessageCallback(a aVar);

    public abstract void setWebMessageCallback(a aVar, Handler handler);
}
