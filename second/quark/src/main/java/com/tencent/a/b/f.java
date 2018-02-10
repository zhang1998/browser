package com.tencent.a.b;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: ProGuard */
public final class f extends SSLSocketFactory {
    private final SSLContext a = SSLContext.getInstance("TLS");

    public f(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        h hVar;
        super(keyStore);
        try {
            hVar = new h();
        } catch (Exception e) {
            hVar = null;
        }
        this.a.init(null, new TrustManager[]{hVar}, null);
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }

    public final Socket createSocket() throws IOException {
        return this.a.getSocketFactory().createSocket();
    }
}
