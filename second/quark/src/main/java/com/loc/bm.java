package com.loc;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: ProGuard */
final class bm implements HostnameVerifier {
    final /* synthetic */ bn a;

    bm(bn bnVar) {
        this.a = bnVar;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        return defaultHostnameVerifier.verify("*.amap.com", sSLSession) || defaultHostnameVerifier.verify("*.apilocate.amap.com", sSLSession);
    }
}
