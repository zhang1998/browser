package com.uc.translate.a;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: ProGuard */
final class c implements HostnameVerifier {
    c() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
