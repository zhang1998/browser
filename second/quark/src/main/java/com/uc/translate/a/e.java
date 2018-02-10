package com.uc.translate.a;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: ProGuard */
public final class e implements X509TrustManager {
    public final X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }
}
