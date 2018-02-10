package com.alibaba.analytics.a;

import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.i;
import com.alibaba.analytics.core.g.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionExtraCb;
import org.android.spdy.SpdySession;
import org.android.spdy.SuperviseConnectInfo;

/* compiled from: ProGuard */
final class ao implements SessionCb, SessionExtraCb {
    private byte[] a;

    private ao() {
    }

    public final void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        if (spdySession == d.o) {
            d.b(spdySession);
        }
    }

    public final void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
    }

    public final void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        if (spdySession == d.o) {
            if (d.p == null) {
                d.p = new ByteArrayOutputStream(1024);
                d.r = d.b(bArr);
            }
            if (d.r != -1) {
                try {
                    d.p.write(bArr);
                } catch (IOException e) {
                }
                d.b((long) bArr.length);
                if (d.r == d.q - 8) {
                    try {
                        d.p.flush();
                    } catch (IOException e2) {
                    }
                    byte[] toByteArray = d.p.toByteArray();
                    try {
                        d.p.close();
                    } catch (IOException e3) {
                    }
                    d.e = d.c(toByteArray);
                    if (d.e != 0) {
                        d.k();
                    }
                    d.l();
                    return;
                }
                return;
            }
            d.e = -1;
            d.k();
            d.l();
            return;
        }
        af.c("[spdyCustomControlFrameRecvCallback]", " session != spdySessionUT");
    }

    public final void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
    }

    public final void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (b.a().t) {
            d.a.a(i.a(i.j, null, Double.valueOf(1.0d)));
        }
        if (spdySession == d.o) {
            d.e = i;
            d.k();
        }
    }

    public final void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        if (spdySession == d.o) {
            d.e = i;
            synchronized (d.d) {
                d.o = null;
            }
        }
    }

    public final void bioPingRecvCallback(SpdySession spdySession, int i) {
    }

    public final byte[] getSSLMeta(SpdySession spdySession) {
        if (!a.a().a) {
            return this.a;
        }
        byte[] a = a.a().a("accs_ssl_key2_adashx.m.taobao.com");
        return a != null ? a : new byte[0];
    }

    public final int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (a.a().a) {
            return d.d(bArr);
        }
        this.a = bArr;
        return 0;
    }

    public final void spdySessionOnWritable(SpdySession spdySession, Object obj, int i) {
        if (spdySession == d.o) {
            d.b(spdySession);
        }
    }
}
