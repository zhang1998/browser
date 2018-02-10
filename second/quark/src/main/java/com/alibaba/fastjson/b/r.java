package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.c;
import com.alibaba.fastjson.f;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class r implements e, u {
    public static final r a = new r();

    private r() {
    }

    public final void a(o oVar, Object obj, Object obj2, Type type) throws IOException {
        int i = 0;
        aa aaVar = oVar.b;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                oVar.a("");
                return;
            }
            if ((aaVar.c & z.WriteNullListAsEmpty.x) != 0) {
                if (Enumeration.class.isAssignableFrom(com.alibaba.fastjson.c.e.c(type))) {
                    aaVar.write("[]");
                    return;
                }
            }
            aaVar.write("null");
        } else if (obj instanceof Pattern) {
            oVar.a(((Pattern) obj).pattern());
        } else if (obj instanceof TimeZone) {
            oVar.a(((TimeZone) obj).getID());
        } else if (obj instanceof Currency) {
            oVar.a(((Currency) obj).getCurrencyCode());
        } else if (obj instanceof Class) {
            oVar.a(((Class) obj).getName());
        } else if (obj instanceof Character) {
            Character ch = (Character) obj;
            if (ch.charValue() == '\u0000') {
                oVar.a("\u0000");
            } else {
                oVar.a(ch.toString());
            }
        } else if (obj instanceof SimpleDateFormat) {
            String toPattern = ((SimpleDateFormat) obj).toPattern();
            if ((aaVar.c & z.WriteClassName.x) == 0 || obj.getClass() == type) {
                aaVar.a(toPattern);
                return;
            }
            aaVar.write(123);
            aaVar.a("@type", false);
            oVar.a(obj.getClass().getName());
            aaVar.write(44);
            aaVar.a("val", false);
            aaVar.a(toPattern);
            aaVar.write(125);
        } else if (obj instanceof f) {
            ((f) obj).a(oVar.b);
        } else if (obj instanceof c) {
            aaVar.write(((c) obj).n_());
        } else if (!(obj instanceof n)) {
            if (obj instanceof Enumeration) {
                Type type2;
                if ((aaVar.c & z.WriteClassName.x) == 0 || !(type instanceof ParameterizedType)) {
                    type2 = null;
                } else {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                }
                Enumeration enumeration = (Enumeration) obj;
                x xVar = oVar.j;
                oVar.a(xVar, obj, obj2);
                try {
                    aaVar.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object nextElement = enumeration.nextElement();
                        int i2 = i + 1;
                        if (i != 0) {
                            aaVar.write(44);
                        }
                        if (nextElement == null) {
                            aaVar.write("null");
                            i = i2;
                        } else {
                            oVar.a.a(nextElement.getClass()).a(oVar, nextElement, Integer.valueOf(i2 - 1), type2);
                            i = i2;
                        }
                    }
                    aaVar.write(93);
                } finally {
                    oVar.j = xVar;
                }
            } else {
                oVar.a(obj.toString());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.alibaba.fastjson.a.c r9, java.lang.reflect.Type r10, java.lang.Object r11) {
        /*
        r8 = this;
        r0 = java.lang.StackTraceElement.class;
        if (r10 != r0) goto L_0x01a6;
    L_0x0004:
        r4 = r9.e;
        r0 = r4.a();
        r1 = 8;
        if (r0 != r1) goto L_0x0013;
    L_0x000e:
        r4.g();
        r0 = 0;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r4.a();
        r1 = 12;
        if (r0 == r1) goto L_0x0040;
    L_0x001b:
        r0 = r4.a();
        r1 = 16;
        if (r0 == r1) goto L_0x0040;
    L_0x0023:
        r0 = new com.alibaba.fastjson.d;
        r1 = new java.lang.StringBuilder;
        r2 = "syntax error: ";
        r1.<init>(r2);
        r2 = r4.a();
        r2 = com.alibaba.fastjson.a.j.a(r2);
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0040:
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = 0;
    L_0x0044:
        r5 = r9.a;
        r5 = r4.a(r5);
        if (r5 != 0) goto L_0x0071;
    L_0x004c:
        r6 = r4.a();
        r7 = 13;
        if (r6 != r7) goto L_0x0060;
    L_0x0054:
        r5 = 16;
        r4.a(r5);
    L_0x0059:
        r4 = new java.lang.StackTraceElement;
        r4.<init>(r3, r2, r1, r0);
        r0 = r4;
        goto L_0x0012;
    L_0x0060:
        r6 = r4.a();
        r7 = 16;
        if (r6 != r7) goto L_0x0071;
    L_0x0068:
        r6 = r4.c;
        r7 = com.alibaba.fastjson.a.e.AllowArbitraryCommas;
        r7 = r7.q;
        r6 = r6 & r7;
        if (r6 != 0) goto L_0x0044;
    L_0x0071:
        r4.d();
        r6 = "className";
        r6 = r6.equals(r5);
        if (r6 == 0) goto L_0x00a7;
    L_0x007c:
        r3 = r4.a();
        r5 = 8;
        if (r3 != r5) goto L_0x0093;
    L_0x0084:
        r3 = 0;
    L_0x0085:
        r5 = r4.a();
        r6 = 13;
        if (r5 != r6) goto L_0x0044;
    L_0x008d:
        r5 = 16;
        r4.a(r5);
        goto L_0x0059;
    L_0x0093:
        r3 = r4.a();
        r5 = 4;
        if (r3 != r5) goto L_0x009f;
    L_0x009a:
        r3 = r4.p();
        goto L_0x0085;
    L_0x009f:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x00a7:
        r6 = "methodName";
        r6 = r6.equals(r5);
        if (r6 == 0) goto L_0x00cd;
    L_0x00af:
        r2 = r4.a();
        r5 = 8;
        if (r2 != r5) goto L_0x00b9;
    L_0x00b7:
        r2 = 0;
        goto L_0x0085;
    L_0x00b9:
        r2 = r4.a();
        r5 = 4;
        if (r2 != r5) goto L_0x00c5;
    L_0x00c0:
        r2 = r4.p();
        goto L_0x0085;
    L_0x00c5:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x00cd:
        r6 = "fileName";
        r6 = r6.equals(r5);
        if (r6 == 0) goto L_0x00f3;
    L_0x00d5:
        r1 = r4.a();
        r5 = 8;
        if (r1 != r5) goto L_0x00df;
    L_0x00dd:
        r1 = 0;
        goto L_0x0085;
    L_0x00df:
        r1 = r4.a();
        r5 = 4;
        if (r1 != r5) goto L_0x00eb;
    L_0x00e6:
        r1 = r4.p();
        goto L_0x0085;
    L_0x00eb:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x00f3:
        r6 = "lineNumber";
        r6 = r6.equals(r5);
        if (r6 == 0) goto L_0x011a;
    L_0x00fb:
        r0 = r4.a();
        r5 = 8;
        if (r0 != r5) goto L_0x0105;
    L_0x0103:
        r0 = 0;
        goto L_0x0085;
    L_0x0105:
        r0 = r4.a();
        r5 = 2;
        if (r0 != r5) goto L_0x0112;
    L_0x010c:
        r0 = r4.n();
        goto L_0x0085;
    L_0x0112:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x011a:
        r6 = "nativeMethod";
        r6 = r6.equals(r5);
        if (r6 == 0) goto L_0x0155;
    L_0x0122:
        r5 = r4.a();
        r6 = 8;
        if (r5 != r6) goto L_0x0131;
    L_0x012a:
        r5 = 16;
        r4.a(r5);
        goto L_0x0085;
    L_0x0131:
        r5 = r4.a();
        r6 = 6;
        if (r5 != r6) goto L_0x013f;
    L_0x0138:
        r5 = 16;
        r4.a(r5);
        goto L_0x0085;
    L_0x013f:
        r5 = r4.a();
        r6 = 7;
        if (r5 != r6) goto L_0x014d;
    L_0x0146:
        r5 = 16;
        r4.a(r5);
        goto L_0x0085;
    L_0x014d:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x0155:
        r6 = "@type";
        if (r5 != r6) goto L_0x0191;
    L_0x0159:
        r5 = r4.a();
        r6 = 4;
        if (r5 != r6) goto L_0x0181;
    L_0x0160:
        r5 = r4.p();
        r6 = "java.lang.StackTraceElement";
        r6 = r5.equals(r6);
        if (r6 != 0) goto L_0x0085;
    L_0x016c:
        r0 = new com.alibaba.fastjson.d;
        r1 = new java.lang.StringBuilder;
        r2 = "syntax error : ";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0181:
        r5 = r4.a();
        r6 = 8;
        if (r5 == r6) goto L_0x0085;
    L_0x0189:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x0191:
        r0 = new com.alibaba.fastjson.d;
        r1 = new java.lang.StringBuilder;
        r2 = "syntax error : ";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x01a6:
        r0 = r9.e;
        r1 = r9.g;
        r2 = 2;
        if (r1 != r2) goto L_0x01ef;
    L_0x01ad:
        r1 = 0;
        r9.g = r1;
        r1 = 16;
        r9.a(r1);
        r1 = r0.a();
        r2 = 4;
        if (r1 != r2) goto L_0x01e7;
    L_0x01bc:
        r1 = "val";
        r2 = r0.p();
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01d0;
    L_0x01c8:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x01d0:
        r0.g();
        r0 = 17;
        r9.a(r0);
        r0 = 0;
        r0 = r9.a(r0);
        r1 = 13;
        r9.a(r1);
    L_0x01e2:
        if (r0 != 0) goto L_0x01f5;
    L_0x01e4:
        r0 = 0;
        goto L_0x0012;
    L_0x01e7:
        r0 = new com.alibaba.fastjson.d;
        r1 = "syntax error";
        r0.<init>(r1);
        throw r0;
    L_0x01ef:
        r0 = 0;
        r0 = r9.a(r0);
        goto L_0x01e2;
    L_0x01f5:
        r1 = r0 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0204;
    L_0x01f9:
        r0 = (java.lang.String) r0;
        r1 = r0.length();
        if (r1 != 0) goto L_0x020c;
    L_0x0201:
        r0 = 0;
        goto L_0x0012;
    L_0x0204:
        r0 = new com.alibaba.fastjson.d;
        r1 = "except string value";
        r0.<init>(r1);
        throw r0;
    L_0x020c:
        r1 = java.util.UUID.class;
        if (r10 != r1) goto L_0x0216;
    L_0x0210:
        r0 = java.util.UUID.fromString(r0);
        goto L_0x0012;
    L_0x0216:
        r1 = java.lang.Class.class;
        if (r10 != r1) goto L_0x0224;
    L_0x021a:
        r1 = r9.b;
        r1 = r1.c;
        r0 = com.alibaba.fastjson.c.e.a(r0, r1);
        goto L_0x0012;
    L_0x0224:
        r1 = java.util.Locale.class;
        if (r10 != r1) goto L_0x025d;
    L_0x0228:
        r1 = "_";
        r1 = r0.split(r1);
        r0 = r1.length;
        r2 = 1;
        if (r0 != r2) goto L_0x023c;
    L_0x0232:
        r0 = new java.util.Locale;
        r2 = 0;
        r1 = r1[r2];
        r0.<init>(r1);
        goto L_0x0012;
    L_0x023c:
        r0 = r1.length;
        r2 = 2;
        if (r0 != r2) goto L_0x024d;
    L_0x0240:
        r0 = new java.util.Locale;
        r2 = 0;
        r2 = r1[r2];
        r3 = 1;
        r1 = r1[r3];
        r0.<init>(r2, r1);
        goto L_0x0012;
    L_0x024d:
        r0 = new java.util.Locale;
        r2 = 0;
        r2 = r1[r2];
        r3 = 1;
        r3 = r1[r3];
        r4 = 2;
        r1 = r1[r4];
        r0.<init>(r2, r3, r1);
        goto L_0x0012;
    L_0x025d:
        r1 = java.net.URI.class;
        if (r10 != r1) goto L_0x0267;
    L_0x0261:
        r0 = java.net.URI.create(r0);
        goto L_0x0012;
    L_0x0267:
        r1 = java.net.URL.class;
        if (r10 != r1) goto L_0x027c;
    L_0x026b:
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0273 }
        r1.<init>(r0);	 Catch:{ MalformedURLException -> 0x0273 }
        r0 = r1;
        goto L_0x0012;
    L_0x0273:
        r0 = move-exception;
        r1 = new com.alibaba.fastjson.d;
        r2 = "create url error";
        r1.<init>(r2, r0);
        throw r1;
    L_0x027c:
        r1 = java.util.regex.Pattern.class;
        if (r10 != r1) goto L_0x0286;
    L_0x0280:
        r0 = java.util.regex.Pattern.compile(r0);
        goto L_0x0012;
    L_0x0286:
        r1 = java.nio.charset.Charset.class;
        if (r10 != r1) goto L_0x0290;
    L_0x028a:
        r0 = java.nio.charset.Charset.forName(r0);
        goto L_0x0012;
    L_0x0290:
        r1 = java.util.Currency.class;
        if (r10 != r1) goto L_0x029a;
    L_0x0294:
        r0 = java.util.Currency.getInstance(r0);
        goto L_0x0012;
    L_0x029a:
        r1 = java.text.SimpleDateFormat.class;
        if (r10 != r1) goto L_0x02b1;
    L_0x029e:
        r1 = new java.text.SimpleDateFormat;
        r2 = r9.e;
        r2 = r2.l;
        r1.<init>(r0, r2);
        r0 = r9.e;
        r0 = r0.k;
        r1.setTimeZone(r0);
        r0 = r1;
        goto L_0x0012;
    L_0x02b1:
        r1 = java.lang.Character.TYPE;
        if (r10 == r1) goto L_0x02b9;
    L_0x02b5:
        r1 = java.lang.Character.class;
        if (r10 != r1) goto L_0x02bf;
    L_0x02b9:
        r0 = com.alibaba.fastjson.c.e.c(r0);
        goto L_0x0012;
    L_0x02bf:
        r0 = java.util.TimeZone.getTimeZone(r0);
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.b.r.a(com.alibaba.fastjson.a.c, java.lang.reflect.Type, java.lang.Object):T");
    }
}
