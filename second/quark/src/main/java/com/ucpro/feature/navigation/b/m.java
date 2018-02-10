package com.ucpro.feature.navigation.b;

import com.uc.encrypt.a;
import com.uc.encrypt.f;
import com.ucpro.services.f.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class m extends i {
    public String a;
    public u b;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return SpdyRequest.POST_METHOD;
    }

    public final HashMap<String, String> c() {
        return null;
    }

    public final byte[] d() {
        if (this.b == null) {
            return null;
        }
        u uVar = this.b;
        a aVar = new a();
        aVar.b = uVar.b;
        aVar.a = uVar.c;
        aVar.d = 90;
        aVar.c = 90;
        aVar.e = "png".getBytes();
        if (uVar.e != null) {
            ArrayList arrayList = aVar.f;
            for (String str : uVar.e) {
                if (str != null) {
                    arrayList.add(str.getBytes());
                }
            }
        }
        byte[] l_ = aVar.l_();
        if (l_ != null) {
            Object a = f.a(l_, a.c);
            if (a != null) {
                Object obj = new byte[(a.length + 16)];
                Object obj2 = new byte[16];
                Arrays.fill(obj2, (byte) 0);
                obj2[0] = (byte) 97;
                obj2[2] = (byte) 31;
                obj2[3] = null;
                System.arraycopy(obj2, 0, obj, 0, 16);
                System.arraycopy(a, 0, obj, 16, a.length);
                return obj;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(byte[] r11) {
        /*
        r10 = this;
        r9 = 31;
        r8 = 16;
        r7 = 11;
        r2 = 0;
        r1 = 1;
        if (r11 == 0) goto L_0x005b;
    L_0x000a:
        r0 = r11.length;
        if (r0 < r8) goto L_0x005b;
    L_0x000d:
        r0 = r11[r2];
        r3 = 98;
        if (r0 != r3) goto L_0x005b;
    L_0x0013:
        r0 = r11[r1];
        if (r0 != r1) goto L_0x0050;
    L_0x0017:
        r0 = r1;
    L_0x0018:
        r3 = 2;
        r5 = r11[r3];
        if (r5 == r1) goto L_0x0021;
    L_0x001d:
        if (r5 == r7) goto L_0x0021;
    L_0x001f:
        if (r5 != r9) goto L_0x0052;
    L_0x0021:
        r3 = r1;
    L_0x0022:
        r4 = r11.length;
        r4 = r4 + -16;
        r4 = new byte[r4];
        r6 = r4.length;
        java.lang.System.arraycopy(r11, r8, r4, r2, r6);
        if (r3 == 0) goto L_0x0061;
    L_0x002d:
        if (r5 == r1) goto L_0x0031;
    L_0x002f:
        if (r5 != r7) goto L_0x0054;
    L_0x0031:
        r1 = com.uc.encrypt.a.b;
        r2 = com.uc.encrypt.f.b(r4, r1);
    L_0x0037:
        if (r2 == 0) goto L_0x005b;
    L_0x0039:
        if (r0 == 0) goto L_0x005d;
    L_0x003b:
        r0 = com.ucweb.common.util.e.a.b(r2);
        r1 = r0;
    L_0x0040:
        if (r1 == 0) goto L_0x005b;
    L_0x0042:
        if (r2 == 0) goto L_0x005b;
    L_0x0044:
        r0 = new com.ucpro.feature.navigation.b.k;
        r0.<init>();
        r1 = r0.a(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = r2;
        goto L_0x0018;
    L_0x0052:
        r3 = r2;
        goto L_0x0022;
    L_0x0054:
        if (r5 != r9) goto L_0x005f;
    L_0x0056:
        r2 = com.uc.encrypt.f.b(r4);
        goto L_0x0037;
    L_0x005b:
        r0 = 0;
        goto L_0x004f;
    L_0x005d:
        r1 = r2;
        goto L_0x0040;
    L_0x005f:
        r2 = r4;
        goto L_0x0037;
    L_0x0061:
        r2 = r4;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.navigation.b.m.a(byte[]):java.lang.Object");
    }

    public final void a(Object obj) {
        if (this.b != null && (obj instanceof k)) {
            k kVar = (k) obj;
            if (this.b.a != null) {
                Iterator it = kVar.a.iterator();
                while (it.hasNext()) {
                    p pVar = (p) it.next();
                    if (pVar != null) {
                        String str = new String(pVar.a);
                        n nVar = this.b.a;
                        this.b.d.get(str);
                        nVar.a(pVar, str);
                    }
                }
            }
        }
    }
}
