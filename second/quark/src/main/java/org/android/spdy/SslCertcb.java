package org.android.spdy;

/* compiled from: ProGuard */
public interface SslCertcb {
    void getPerformance(SpdySession spdySession, SslPermData sslPermData);

    SslPublickey getPublicKey(SpdySession spdySession);

    int putCertificate(SpdySession spdySession, byte[] bArr, int i);
}
