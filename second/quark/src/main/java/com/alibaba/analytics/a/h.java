package com.alibaba.analytics.a;

import com.alibaba.analytics.core.g.a;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class h implements AccsSSLCallback {
    h() {
    }

    public final byte[] getSSLPublicKey(int i, byte[] bArr) {
        return a.a().a(SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
    }
}
