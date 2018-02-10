package com.ucpro.feature.z.g.a;

import com.ucpro.business.stat.f;
import com.ucpro.business.stat.m;
import com.ucpro.feature.h.b;
import com.ucweb.common.util.c;
import com.ucweb.common.util.o.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public class i extends com.ucpro.services.f.i implements d {
    private static final String a = i.class.getSimpleName();
    private static j d = new f();
    private a b;
    private k c;

    public final String b() {
        return SpdyRequest.POST_METHOD;
    }

    public final HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("User-Agent", b.a.c());
        return hashMap;
    }

    public final byte[] d() {
        Object a = a(this.c);
        c.a(a);
        if (a == null) {
            m.a(h.a, h.b, new String[0]);
        }
        return a;
    }

    public final Object a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int length = bArr.length;
        if (!(bArr == null || bArr.length == length)) {
            Object obj = new byte[length];
            System.arraycopy(bArr, 0, obj, 0, length);
            bArr = obj;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byteArrayInputStream.skip(16);
        } catch (IOException e) {
        }
        byte[] b = d.b(a.e(byteArrayInputStream));
        e eVar = new e();
        if (!eVar.a(b) || this.b == null) {
            return null;
        }
        List list = eVar.a;
        com.ucweb.common.util.n.a.a(list);
        new StringBuilder("收到云端返回:").append(list.size());
        return list;
    }

    public final void a(Object obj) {
        if (obj instanceof ArrayList) {
            String str;
            a aVar = this.b;
            k kVar = this.c;
            if (kVar.a == null) {
                str = null;
            } else {
                str = kVar.a.toString();
            }
            aVar.a(str, (ArrayList) obj);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(com.ucpro.feature.z.g.a.k r5) {
        /*
        r0 = 0;
        r1 = 0;
        if (r5 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = new com.ucweb.common.util.o.a.b;
        r2.<init>();
        r3 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r4 = 98;
        r3.writeByte(r4);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r4 = 99;
        r3.writeByte(r4);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r4 = 2;
        r3.writeByte(r4);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r4 = 2;
        r3.writeByte(r4);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r4 = 0;
        r3.writeByte(r4);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
    L_0x0025:
        r4 = 11;
        if (r1 >= r4) goto L_0x0030;
    L_0x0029:
        r4 = 0;
        r3.writeByte(r4);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r1 = r1 + 1;
        goto L_0x0025;
    L_0x0030:
        r3.close();	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r1 = d;	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r3 = r5.l_();	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r1 = r1.a(r3);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        com.ucweb.common.util.c.a(r1);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        if (r1 == 0) goto L_0x0049;
    L_0x0042:
        r2.write(r1);	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
        r0 = r2.a();	 Catch:{ IOException -> 0x004d, all -> 0x0052 }
    L_0x0049:
        com.ucweb.common.util.o.a.a(r2);
        goto L_0x0004;
    L_0x004d:
        r1 = move-exception;
        com.ucweb.common.util.o.a.a(r2);
        goto L_0x0004;
    L_0x0052:
        r0 = move-exception;
        com.ucweb.common.util.o.a.a(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.z.g.a.i.a(com.ucpro.feature.z.g.a.k):byte[]");
    }

    public final void a(String str, a aVar) {
        c.a((Object) str);
        c.a((Object) aVar);
        if (!com.ucweb.common.util.n.a.a(str)) {
            com.uc.base.b.c.c cVar;
            this.b = aVar;
            this.c = new k();
            k kVar = this.c;
            if (str == null) {
                cVar = null;
            } else {
                cVar = com.uc.base.b.c.c.a(str);
            }
            kVar.a = cVar;
            com.d.a.a.a aVar2 = new com.d.a.a.a();
            com.d.a.a.b bVar = new com.d.a.a.b();
            this.c.c = aVar2;
            bVar.a(f.b());
            bVar.b("android");
            bVar.a(f.b());
            bVar.c("2.4.1.985");
            bVar.d(com.ucpro.c.a.a());
            bVar.e("3300");
            bVar.f("180123054500");
            bVar.h("ucpro");
            bVar.i(Locale.getDefault().getLanguage());
            bVar.j("3.1");
            bVar.g(com.ucpro.c.a.b());
            this.c.b = bVar;
            e();
        }
    }

    public final String a() {
        return "http://sugs.m.sm.cn/ucinput?";
    }
}
