package kotlin.b;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.a.b;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "startIndex", "invoke"}, k = 3, mv = {1, 1, 6})
/* compiled from: ProGuard */
public final class m extends b implements kotlin.jvm.b.b<CharSequence, Integer, kotlin.b<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b = false;

    public m(List list) {
        this.a = list;
        super(2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(java.lang.Object r12, java.lang.Object r13) {
        /*
        r11 = this;
        r1 = 0;
        r5 = 0;
        r12 = (java.lang.CharSequence) r12;
        r13 = (java.lang.Number) r13;
        r2 = r13.intValue();
        r0 = "$receiver";
        kotlin.jvm.a.f.b(r12, r0);
        r0 = r11.a;
        r0 = (java.util.Collection) r0;
        r6 = r11.b;
        if (r6 != 0) goto L_0x009d;
    L_0x0017:
        r3 = r0.size();
        r4 = 1;
        if (r3 != r4) goto L_0x009d;
    L_0x001e:
        r0 = (java.lang.Iterable) r0;
        r3 = "$receiver";
        kotlin.jvm.a.f.b(r0, r3);
        r3 = r0 instanceof java.util.List;
        if (r3 == 0) goto L_0x0075;
    L_0x0029:
        r0 = (java.util.List) r0;
        r3 = "$receiver";
        kotlin.jvm.a.f.b(r0, r3);
        r3 = r0.size();
        switch(r3) {
            case 0: goto L_0x0041;
            case 1: goto L_0x004b;
            default: goto L_0x0037;
        };
    L_0x0037:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "List has more than one element.";
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0041:
        r0 = new java.util.NoSuchElementException;
        r1 = "List is empty.";
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x004b:
        r0 = r0.get(r1);
    L_0x004f:
        r0 = (java.lang.String) r0;
        r1 = 4;
        r1 = kotlin.b.a.a(r12, r0, r2, r1);
        if (r1 < 0) goto L_0x013d;
    L_0x0058:
        r1 = java.lang.Integer.valueOf(r1);
        r0 = kotlin.a.a(r1, r0);
    L_0x0060:
        if (r0 == 0) goto L_0x0074;
    L_0x0062:
        r1 = r0.a;
        r0 = r0.b;
        r0 = (java.lang.String) r0;
        r0 = r0.length();
        r0 = java.lang.Integer.valueOf(r0);
        r5 = kotlin.a.a(r1, r0);
    L_0x0074:
        return r5;
    L_0x0075:
        r1 = r0.iterator();
        r0 = r1.hasNext();
        if (r0 != 0) goto L_0x0089;
    L_0x007f:
        r0 = new java.util.NoSuchElementException;
        r1 = "Collection is empty.";
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0089:
        r0 = r1.next();
        r1 = r1.hasNext();
        if (r1 == 0) goto L_0x004f;
    L_0x0093:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Collection has more than one element.";
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x009d:
        if (r2 >= 0) goto L_0x00a0;
    L_0x009f:
        r2 = r1;
    L_0x00a0:
        r1 = new kotlin.e.a;
        r3 = r12.length();
        r1.<init>(r2, r3);
        r1 = (kotlin.e.e) r1;
        r2 = r12 instanceof java.lang.String;
        if (r2 == 0) goto L_0x00f6;
    L_0x00af:
        r2 = r1.b;
        r7 = r1.c;
        r8 = r1.d;
        if (r8 <= 0) goto L_0x00ea;
    L_0x00b7:
        if (r2 > r7) goto L_0x013d;
    L_0x00b9:
        r4 = r2;
    L_0x00ba:
        r1 = r0;
        r1 = (java.lang.Iterable) r1;
        r9 = r1.iterator();
    L_0x00c1:
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x00ee;
    L_0x00c7:
        r2 = r9.next();
        r1 = r2;
        r1 = (java.lang.String) r1;
        r3 = r12;
        r3 = (java.lang.String) r3;
        r10 = r1.length();
        r1 = kotlin.b.e.a(r1, r3, r4, r10, r6);
        if (r1 == 0) goto L_0x00c1;
    L_0x00db:
        r1 = r2;
    L_0x00dc:
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x00f0;
    L_0x00e0:
        r0 = java.lang.Integer.valueOf(r4);
        r0 = kotlin.a.a(r0, r1);
        goto L_0x0060;
    L_0x00ea:
        if (r2 < r7) goto L_0x013d;
    L_0x00ec:
        r4 = r2;
        goto L_0x00ba;
    L_0x00ee:
        r1 = r5;
        goto L_0x00dc;
    L_0x00f0:
        if (r4 == r7) goto L_0x013d;
    L_0x00f2:
        r1 = r4 + r8;
        r4 = r1;
        goto L_0x00ba;
    L_0x00f6:
        r2 = r1.b;
        r7 = r1.c;
        r8 = r1.d;
        if (r8 <= 0) goto L_0x0131;
    L_0x00fe:
        if (r2 > r7) goto L_0x013d;
    L_0x0100:
        r4 = r2;
    L_0x0101:
        r1 = r0;
        r1 = (java.lang.Iterable) r1;
        r9 = r1.iterator();
    L_0x0108:
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x0135;
    L_0x010e:
        r2 = r9.next();
        r1 = r2;
        r1 = (java.lang.String) r1;
        r3 = r1;
        r3 = (java.lang.CharSequence) r3;
        r1 = r1.length();
        r1 = kotlin.b.a.a(r3, r12, r4, r1, r6);
        if (r1 == 0) goto L_0x0108;
    L_0x0122:
        r1 = r2;
    L_0x0123:
        r1 = (java.lang.String) r1;
        if (r1 == 0) goto L_0x0137;
    L_0x0127:
        r0 = java.lang.Integer.valueOf(r4);
        r0 = kotlin.a.a(r0, r1);
        goto L_0x0060;
    L_0x0131:
        if (r2 < r7) goto L_0x013d;
    L_0x0133:
        r4 = r2;
        goto L_0x0101;
    L_0x0135:
        r1 = r5;
        goto L_0x0123;
    L_0x0137:
        if (r4 == r7) goto L_0x013d;
    L_0x0139:
        r1 = r4 + r8;
        r4 = r1;
        goto L_0x0101;
    L_0x013d:
        r0 = r5;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.b.m.a(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
