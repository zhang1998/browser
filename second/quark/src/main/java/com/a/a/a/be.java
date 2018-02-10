package com.a.a.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;

/* compiled from: ProGuard */
final class be implements HostnameVerifier {
    final /* synthetic */ bg a;

    be(bg bgVar) {
        this.a = bgVar;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return new BrowserCompatHostnameVerifier().verify("cmnsguider.yunos.com", sSLSession);
    }
}
