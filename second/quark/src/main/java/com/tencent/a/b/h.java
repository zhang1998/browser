package com.tencent.a.b;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: ProGuard */
public final class h implements X509TrustManager {
    X509TrustManager a;

    h() throws Exception {
        KeyStore instance;
        Throwable th;
        try {
            instance = KeyStore.getInstance("JKS");
        } catch (Exception e) {
            instance = null;
        }
        if (instance != null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream("trustedCerts");
                try {
                    instance.load(fileInputStream, "passphrase".toCharArray());
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                    instance2.init(instance);
                    TrustManager[] trustManagers = instance2.getTrustManagers();
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance3.init(null);
        trustManagers = instance3.getTrustManagers();
        for (int i = 0; i < trustManagers.length; i++) {
            if (trustManagers[i] instanceof X509TrustManager) {
                this.a = (X509TrustManager) trustManagers[i];
                return;
            }
        }
        throw new Exception("Couldn't initialize");
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.a.checkServerTrusted(x509CertificateArr, str);
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
