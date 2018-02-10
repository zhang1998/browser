package com.ucpro.feature.webwindow;

import android.os.Looper;
import com.uc.webview.export.JavascriptInterface;
import com.ucpro.business.stat.m;
import com.ucpro.feature.webwindow.e.f;

/* compiled from: ProGuard */
public class WebPageStatInterface {
    private f a;

    public WebPageStatInterface(f fVar) {
        this.a = fVar;
    }

    @JavascriptInterface
    public void onPageStat(String str) {
        boolean z;
        StringBuilder stringBuilder = new StringBuilder("is inMainThread: ");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z = true;
        } else {
            z = false;
        }
        stringBuilder.append(String.valueOf(z));
        new StringBuilder("currentUrl: ").append(this.a.getUrl()).append("\npushUrl: ").append(str);
        String url = this.a.getUrl();
        m.a("page_stat", "pushstate", "currentUrl", url, "pushUrl", str);
    }
}
