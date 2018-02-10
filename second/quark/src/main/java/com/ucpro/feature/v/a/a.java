package com.ucpro.feature.v.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: ProGuard */
final class a implements HostnameVerifier {
    a() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
