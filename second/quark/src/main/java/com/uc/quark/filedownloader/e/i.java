package com.uc.quark.filedownloader.e;

import java.io.IOException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: ProGuard */
final class i implements X509HostnameVerifier {
    i() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return true;
    }

    public final void verify(String str, SSLSocket sSLSocket) throws IOException {
    }

    public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
    }

    public final void verify(String str, X509Certificate x509Certificate) throws SSLException {
    }
}
