package com.ucpro.feature.video.c.b;

import com.uc.encrypt.f;
import com.ucpro.business.e.d.g;
import com.ucpro.feature.video.c.e.b.a;
import com.ucpro.feature.video.c.e.c.c;
import com.ucpro.feature.video.e.b;
import okhttp3.Headers.Builder;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class d {
    private static final byte[] a = new byte[]{(byte) 0, (byte) 0, (byte) 31, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};

    public static void a(a aVar, c cVar) {
        byte[] l_ = aVar.l_();
        Object obj = a;
        if (l_ == null || l_.length == 0 || obj == null || obj.length == 0) {
            l_ = null;
        } else {
            Object a = f.a(l_);
            if (a == null) {
                l_ = null;
            } else {
                l_ = new byte[(obj.length + a.length)];
                System.arraycopy(obj, 0, l_, 0, obj.length);
                System.arraycopy(a, 0, l_, obj.length, a.length);
            }
        }
        if (l_ != null) {
            String a2 = g.a().a("v_flvcd_url", "http://vps.uc.cn/");
            RequestBody create = RequestBody.create(null, l_);
            Builder builder = new Builder();
            builder.add("X-Version", "2.0");
            builder.add("Accept-Encoding", "gzip");
            b.a().a(new Request.Builder().url(a2).method(SpdyRequest.POST_METHOD, create).headers(builder.build()).build(), new a(cVar, aVar));
        }
    }

    private static c b(byte[] bArr, int i) {
        try {
            byte[] bArr2;
            byte[] bArr3 = a;
            if (bArr == null || bArr.length == 0 || bArr3 == null || bArr3.length == 0 || i <= bArr3.length) {
                bArr2 = null;
            } else {
                bArr2 = new byte[(i - bArr3.length)];
                System.arraycopy(bArr, bArr3.length, bArr2, 0, bArr2.length);
                bArr2 = f.b(bArr2);
            }
            c cVar = new c();
            cVar.a(bArr2);
            return cVar;
        } catch (Exception e) {
            com.ucweb.common.util.c.a(e.getMessage());
            return null;
        }
    }
}
