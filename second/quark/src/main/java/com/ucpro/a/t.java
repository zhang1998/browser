package com.ucpro.a;

import android.webkit.ValueCallback;
import com.uc.a.b.e;

/* compiled from: ProGuard */
final class t implements ValueCallback<byte[]> {
    final /* synthetic */ e a;
    final /* synthetic */ String b;
    final /* synthetic */ am c;

    t(am amVar, e eVar, String str) {
        this.c = amVar;
        this.a = eVar;
        this.b = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onReceiveValue(java.lang.Object r6) {
        /*
        r5 = this;
        r2 = 1;
        r0 = 0;
        r6 = (byte[]) r6;
        r1 = r5.a;
        r1 = r1.a;
        if (r2 != r1) goto L_0x0012;
    L_0x000a:
        r1 = new com.ucpro.a.ba;
        r1.<init>(r5, r6);
        com.ucweb.common.util.h.m.a(r0, r1);
    L_0x0012:
        r3 = r5.b;
        r1 = -1;
        r4 = r3.hashCode();
        switch(r4) {
            case -1364243148: goto L_0x002a;
            case -128790353: goto L_0x0034;
            case 1344568959: goto L_0x003e;
            case 1616107473: goto L_0x0021;
            case 1843795505: goto L_0x0048;
            default: goto L_0x001c;
        };
    L_0x001c:
        r0 = r1;
    L_0x001d:
        switch(r0) {
            case 0: goto L_0x0052;
            case 1: goto L_0x0058;
            case 2: goto L_0x005e;
            case 3: goto L_0x0064;
            case 4: goto L_0x006a;
            default: goto L_0x0020;
        };
    L_0x0020:
        return;
    L_0x0021:
        r2 = "adblock_rule";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x001c;
    L_0x0029:
        goto L_0x001d;
    L_0x002a:
        r0 = "adv_dnlist";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x001c;
    L_0x0032:
        r0 = r2;
        goto L_0x001d;
    L_0x0034:
        r0 = "adblock_app_rule";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x001c;
    L_0x003c:
        r0 = 2;
        goto L_0x001d;
    L_0x003e:
        r0 = "hide_domainlist";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x001c;
    L_0x0046:
        r0 = 3;
        goto L_0x001d;
    L_0x0048:
        r0 = "crpb_uadbjs";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x001c;
    L_0x0050:
        r0 = 4;
        goto L_0x001d;
    L_0x0052:
        r0 = r5.c;
        com.ucweb.common.util.h.m.a(0, new com.ucpro.a.v(r0, r6));
        goto L_0x0020;
    L_0x0058:
        r0 = r5.c;
        com.ucweb.common.util.h.m.a(0, new com.ucpro.a.aj(r0, r6));
        goto L_0x0020;
    L_0x005e:
        r0 = r5.c;
        com.ucweb.common.util.h.m.a(0, new com.ucpro.a.ar(r0, r6));
        goto L_0x0020;
    L_0x0064:
        r0 = r5.c;
        com.ucweb.common.util.h.m.a(0, new com.ucpro.a.an(r0, r6));
        goto L_0x0020;
    L_0x006a:
        r0 = r5.c;
        com.ucweb.common.util.h.m.a(0, new com.ucpro.a.aa(r0, r6));
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.a.t.onReceiveValue(java.lang.Object):void");
    }
}
