package com.taobao.weex.c;

import com.alibaba.fastjson.b;
import com.taobao.weex.ad;
import com.taobao.weex.common.o;

/* compiled from: ProGuard */
public final class ac extends o {
    public static final String[] a = new String[]{"createBody", "updateAttrs", "updateStyle", "removeElement", "addElement", "moveElement", "addEvent", "removeEvent", "createFinish", "refreshFinish", "updateFinish", "scrollToElement", "addRule", "getComponentRect", "domErrorJSON", "invokeMethod"};

    public ac(com.taobao.weex.ac acVar) {
        this.b = acVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r7, com.alibaba.fastjson.b r8) {
        /*
        r6 = this;
        r2 = 0;
        r4 = 2;
        r3 = 1;
        r0 = 0;
        if (r7 != 0) goto L_0x0007;
    L_0x0006:
        return r2;
    L_0x0007:
        r1 = "domErrorJSON";
        r1 = r7.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x0025;
    L_0x000f:
        if (r8 == 0) goto L_0x0006;
    L_0x0011:
        r0 = r8.a(r0);
        if (r0 == 0) goto L_0x0006;
    L_0x0017:
        r1 = r6.b;
        r3 = "domModule";
        r4 = com.taobao.weex.common.g.WX_ERR_DOM_ADDELEMENT;
        r0 = r0.n_();
        r1.a(r3, r4, r0);
        goto L_0x0006;
    L_0x0025:
        r1 = -1;
        r5 = r7.hashCode();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        switch(r5) {
            case -1531593237: goto L_0x0081;
            case -1322699076: goto L_0x00b6;
            case -1259780487: goto L_0x008b;
            case -1148630211: goto L_0x00ce;
            case -748746828: goto L_0x00c2;
            case -658126983: goto L_0x00e6;
            case -601140903: goto L_0x0059;
            case -584512920: goto L_0x0063;
            case -467344936: goto L_0x006d;
            case -317506442: goto L_0x0095;
            case 245397275: goto L_0x0077;
            case 588570827: goto L_0x00da;
            case 1153330351: goto L_0x009f;
            case 1368682686: goto L_0x0050;
            case 2137013070: goto L_0x00aa;
            default: goto L_0x002d;
        };	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
    L_0x002d:
        r0 = r1;
    L_0x002e:
        switch(r0) {
            case 0: goto L_0x00f2;
            case 1: goto L_0x0108;
            case 2: goto L_0x011b;
            case 3: goto L_0x012e;
            case 4: goto L_0x013c;
            case 5: goto L_0x0158;
            case 6: goto L_0x0174;
            case 7: goto L_0x0187;
            case 8: goto L_0x019a;
            case 9: goto L_0x01a1;
            case 10: goto L_0x01a8;
            case 11: goto L_0x01af;
            case 12: goto L_0x01c2;
            case 13: goto L_0x01d5;
            case 14: goto L_0x01e8;
            default: goto L_0x0031;
        };	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
    L_0x0031:
        r0 = r2;
    L_0x0032:
        if (r0 != 0) goto L_0x0039;
    L_0x0034:
        r1 = "Unknown dom action.";
        com.taobao.weex.utils.WXLogUtils.e(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
    L_0x0039:
        r1 = r0 instanceof com.taobao.weex.c.d;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r1 == 0) goto L_0x0210;
    L_0x003d:
        r0 = (com.taobao.weex.c.d) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = "createBody";
        r1 = r1.equals(r7);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r6.a(r0, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0006;
    L_0x0049:
        r0 = move-exception;
        r0 = "Dom module call miss arguments.";
        com.taobao.weex.utils.WXLogUtils.e(r0);
        goto L_0x0006;
    L_0x0050:
        r3 = "createBody";
        r3 = r7.equals(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r3 == 0) goto L_0x002d;
    L_0x0058:
        goto L_0x002e;
    L_0x0059:
        r0 = "updateAttrs";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x0061:
        r0 = r3;
        goto L_0x002e;
    L_0x0063:
        r0 = "updateStyle";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x006b:
        r0 = r4;
        goto L_0x002e;
    L_0x006d:
        r0 = "removeElement";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x0075:
        r0 = 3;
        goto L_0x002e;
    L_0x0077:
        r0 = "addElement";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x007f:
        r0 = 4;
        goto L_0x002e;
    L_0x0081:
        r0 = "moveElement";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x0089:
        r0 = 5;
        goto L_0x002e;
    L_0x008b:
        r0 = "addEvent";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x0093:
        r0 = 6;
        goto L_0x002e;
    L_0x0095:
        r0 = "removeEvent";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x009d:
        r0 = 7;
        goto L_0x002e;
    L_0x009f:
        r0 = "createFinish";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00a7:
        r0 = 8;
        goto L_0x002e;
    L_0x00aa:
        r0 = "refreshFinish";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00b2:
        r0 = 9;
        goto L_0x002e;
    L_0x00b6:
        r0 = "updateFinish";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00be:
        r0 = 10;
        goto L_0x002e;
    L_0x00c2:
        r0 = "scrollToElement";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00ca:
        r0 = 11;
        goto L_0x002e;
    L_0x00ce:
        r0 = "addRule";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00d6:
        r0 = 12;
        goto L_0x002e;
    L_0x00da:
        r0 = "getComponentRect";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00e2:
        r0 = 13;
        goto L_0x002e;
    L_0x00e6:
        r0 = "invokeMethod";
        r0 = r7.equals(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r0 == 0) goto L_0x002d;
    L_0x00ee:
        r0 = 14;
        goto L_0x002e;
    L_0x00f2:
        if (r8 == 0) goto L_0x0031;
    L_0x00f4:
        r0 = new com.taobao.weex.c.a.j;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.a(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x0100:
        r0 = move-exception;
        r0 = "Dom module call arguments format error!!";
        com.taobao.weex.utils.WXLogUtils.e(r0);
        goto L_0x0006;
    L_0x0108:
        if (r8 == 0) goto L_0x0031;
    L_0x010a:
        r0 = new com.taobao.weex.c.a.v;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.a(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x011b:
        if (r8 == 0) goto L_0x0031;
    L_0x011d:
        r0 = new com.taobao.weex.c.a.x;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.a(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x012e:
        if (r8 == 0) goto L_0x0031;
    L_0x0130:
        r0 = new com.taobao.weex.c.a.s;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x013c:
        if (r8 == 0) goto L_0x0031;
    L_0x013e:
        r0 = new com.taobao.weex.c.a.d;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 1;
        r1 = r8.a(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 0;
        r3 = r8.c(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r4 = 2;
        r4 = r8.b(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r4 = r4.intValue();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3, r4);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x0158:
        if (r8 == 0) goto L_0x0031;
    L_0x015a:
        r0 = new com.taobao.weex.c.a.q;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.c(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r4 = 2;
        r4 = r8.b(r4);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r4 = r4.intValue();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3, r4);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x0174:
        if (r8 == 0) goto L_0x0031;
    L_0x0176:
        r0 = new com.taobao.weex.c.a.e;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.c(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x0187:
        if (r8 == 0) goto L_0x0031;
    L_0x0189:
        r0 = new com.taobao.weex.c.a.t;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.c(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x019a:
        r0 = new com.taobao.weex.c.a.l;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x01a1:
        r0 = new com.taobao.weex.c.a.r;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x01a8:
        r0 = new com.taobao.weex.c.a.w;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x01af:
        if (r8 == 0) goto L_0x0031;
    L_0x01b1:
        r0 = new com.taobao.weex.c.a.u;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.a(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x01c2:
        if (r8 == 0) goto L_0x0031;
    L_0x01c4:
        r0 = new com.taobao.weex.c.a.f;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.a(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x01d5:
        if (r8 == 0) goto L_0x0031;
    L_0x01d7:
        r0 = new com.taobao.weex.c.a.n;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = 0;
        r1 = r8.c(r1);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = 1;
        r3 = r8.c(r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0.<init>(r1, r3);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0032;
    L_0x01e8:
        if (r8 == 0) goto L_0x0031;
    L_0x01ea:
        r1 = new com.taobao.weex.c.a.o;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0 = 0;
        r3 = r8.c(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0 = 1;
        r4 = r8.c(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0 = r8.f;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r5 = 2;
        r0 = r0.get(r5);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r5 = r0 instanceof com.alibaba.fastjson.b;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        if (r5 == 0) goto L_0x0209;
    L_0x0201:
        r0 = (com.alibaba.fastjson.b) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
    L_0x0203:
        r1.<init>(r3, r4, r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0 = r1;
        goto L_0x0032;
    L_0x0209:
        r0 = com.alibaba.fastjson.a.b(r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r0 = (com.alibaba.fastjson.b) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0203;
    L_0x0210:
        r0 = (com.taobao.weex.c.p) r0;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = com.taobao.weex.ad.a();	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1 = r1.c;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = r6.b;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r3 = r3.e;	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        r1.a(r3, r0);	 Catch:{ IndexOutOfBoundsException -> 0x0049, ClassCastException -> 0x0100 }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.c.ac.a(java.lang.String, com.alibaba.fastjson.b):java.lang.Object");
    }

    public final void a(String str, String str2, b bVar) {
        if (str != null && str2 != null) {
            a(new com.taobao.weex.c.a.o(str, str2, bVar), false);
        }
    }

    public final void a(d dVar, boolean z) {
        ad.a().a.a(this.b.e, dVar, z);
    }
}
