package com.uc.base.a.a.a;

import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;

    f(String str) {
        this.a = str;
    }

    public final void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://track.uc.cn/collect?" + this.a).openConnection();
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(1000);
            httpURLConnection.getResponseCode();
        } catch (Exception e) {
        }
    }
}
