package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.d;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ProGuard */
final class l implements e {
    public static l a = new l();

    l() {
    }

    public final <T> T a(c cVar, Type type, Object obj) {
        Map eVar;
        if (type == com.alibaba.fastjson.e.class && cVar.j == null) {
            if ((cVar.e.c & e.OrderedField.q) != 0) {
                eVar = new com.alibaba.fastjson.e(new LinkedHashMap());
            } else {
                eVar = new com.alibaba.fastjson.e();
            }
            return (com.alibaba.fastjson.e) cVar.a(eVar, null);
        }
        i iVar = cVar.e;
        if (iVar.a == 8) {
            iVar.a(16);
            return null;
        }
        eVar = a(type);
        m mVar = cVar.f;
        try {
            cVar.a(mVar, (Object) eVar, obj);
            T a;
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    a = a(cVar, eVar, type3, obj);
                    return a;
                }
                a = a(cVar, eVar, type2, type3);
                cVar.a(mVar);
                return a;
            }
            a = cVar.a(eVar, obj);
            cVar.a(mVar);
            return a;
        } finally {
            cVar.a(mVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map a(com.alibaba.fastjson.a.c r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.reflect.Type r11, java.lang.Object r12) {
        /*
        r8 = 13;
        r7 = 58;
        r6 = 34;
        r2 = r9.e;
        r0 = r2.a;
        r1 = 12;
        if (r0 == r1) goto L_0x0025;
    L_0x000e:
        r0 = new com.alibaba.fastjson.d;
        r1 = new java.lang.StringBuilder;
        r3 = "syntax error, expect {, actual ";
        r1.<init>(r3);
        r2 = r2.a;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0025:
        r3 = r9.f;
    L_0x0027:
        r2.r();	 Catch:{ all -> 0x006c }
        r0 = r2.d;	 Catch:{ all -> 0x006c }
        r1 = r2.c;	 Catch:{ all -> 0x006c }
        r4 = com.alibaba.fastjson.a.e.AllowArbitraryCommas;	 Catch:{ all -> 0x006c }
        r4 = r4.q;	 Catch:{ all -> 0x006c }
        r1 = r1 & r4;
        if (r1 == 0) goto L_0x0042;
    L_0x0035:
        r1 = 44;
        if (r0 != r1) goto L_0x0042;
    L_0x0039:
        r2.c();	 Catch:{ all -> 0x006c }
        r2.r();	 Catch:{ all -> 0x006c }
        r0 = r2.d;	 Catch:{ all -> 0x006c }
        goto L_0x0035;
    L_0x0042:
        if (r0 != r6) goto L_0x0071;
    L_0x0044:
        r0 = r9.a;	 Catch:{ all -> 0x006c }
        r1 = 34;
        r0 = r2.a(r0, r1);	 Catch:{ all -> 0x006c }
        r2.r();	 Catch:{ all -> 0x006c }
        r1 = r2.d;	 Catch:{ all -> 0x006c }
        if (r1 == r7) goto L_0x0111;
    L_0x0053:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x006c }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r4 = "syntax error, ";
        r1.<init>(r4);	 Catch:{ all -> 0x006c }
        r2 = r2.j();	 Catch:{ all -> 0x006c }
        r1 = r1.append(r2);	 Catch:{ all -> 0x006c }
        r1 = r1.toString();	 Catch:{ all -> 0x006c }
        r0.<init>(r1);	 Catch:{ all -> 0x006c }
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r0 = move-exception;
        r9.a(r3);
        throw r0;
    L_0x0071:
        r1 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r0 != r1) goto L_0x0084;
    L_0x0075:
        r2.c();	 Catch:{ all -> 0x006c }
        r0 = 0;
        r2.h = r0;	 Catch:{ all -> 0x006c }
        r0 = 16;
        r2.a(r0);	 Catch:{ all -> 0x006c }
        r9.a(r3);
    L_0x0083:
        return r10;
    L_0x0084:
        r1 = 39;
        if (r0 != r1) goto L_0x00d2;
    L_0x0088:
        r0 = r2.c;	 Catch:{ all -> 0x006c }
        r1 = com.alibaba.fastjson.a.e.AllowSingleQuotes;	 Catch:{ all -> 0x006c }
        r1 = r1.q;	 Catch:{ all -> 0x006c }
        r0 = r0 & r1;
        if (r0 != 0) goto L_0x00aa;
    L_0x0091:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x006c }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r4 = "syntax error, ";
        r1.<init>(r4);	 Catch:{ all -> 0x006c }
        r2 = r2.j();	 Catch:{ all -> 0x006c }
        r1 = r1.append(r2);	 Catch:{ all -> 0x006c }
        r1 = r1.toString();	 Catch:{ all -> 0x006c }
        r0.<init>(r1);	 Catch:{ all -> 0x006c }
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x00aa:
        r0 = r9.a;	 Catch:{ all -> 0x006c }
        r1 = 39;
        r0 = r2.a(r0, r1);	 Catch:{ all -> 0x006c }
        r2.r();	 Catch:{ all -> 0x006c }
        r1 = r2.d;	 Catch:{ all -> 0x006c }
        if (r1 == r7) goto L_0x0111;
    L_0x00b9:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x006c }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r4 = "syntax error, ";
        r1.<init>(r4);	 Catch:{ all -> 0x006c }
        r2 = r2.j();	 Catch:{ all -> 0x006c }
        r1 = r1.append(r2);	 Catch:{ all -> 0x006c }
        r1 = r1.toString();	 Catch:{ all -> 0x006c }
        r0.<init>(r1);	 Catch:{ all -> 0x006c }
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x00d2:
        r0 = r2.c;	 Catch:{ all -> 0x006c }
        r1 = com.alibaba.fastjson.a.e.AllowUnQuotedFieldNames;	 Catch:{ all -> 0x006c }
        r1 = r1.q;	 Catch:{ all -> 0x006c }
        r0 = r0 & r1;
        if (r0 != 0) goto L_0x00e3;
    L_0x00db:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x006c }
        r1 = "syntax error";
        r0.<init>(r1);	 Catch:{ all -> 0x006c }
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x00e3:
        r0 = r9.a;	 Catch:{ all -> 0x006c }
        r0 = r2.b(r0);	 Catch:{ all -> 0x006c }
        r2.r();	 Catch:{ all -> 0x006c }
        r1 = r2.d;	 Catch:{ all -> 0x006c }
        if (r1 == r7) goto L_0x0111;
    L_0x00f0:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x006c }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r5 = "expect ':' at ";
        r4.<init>(r5);	 Catch:{ all -> 0x006c }
        r2 = r2.b;	 Catch:{ all -> 0x006c }
        r2 = r4.append(r2);	 Catch:{ all -> 0x006c }
        r4 = ", actual ";
        r2 = r2.append(r4);	 Catch:{ all -> 0x006c }
        r1 = r2.append(r1);	 Catch:{ all -> 0x006c }
        r1 = r1.toString();	 Catch:{ all -> 0x006c }
        r0.<init>(r1);	 Catch:{ all -> 0x006c }
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x0111:
        r1 = r0;
        r2.c();	 Catch:{ all -> 0x006c }
        r2.r();	 Catch:{ all -> 0x006c }
        r0 = r2.d;	 Catch:{ all -> 0x006c }
        r0 = 0;
        r2.h = r0;	 Catch:{ all -> 0x006c }
        r0 = "@type";
        if (r1 != r0) goto L_0x0175;
    L_0x0121:
        r0 = com.alibaba.fastjson.a.e.DisableSpecialKeyDetect;	 Catch:{ all -> 0x006c }
        r0 = r2.a(r0);	 Catch:{ all -> 0x006c }
        if (r0 != 0) goto L_0x0175;
    L_0x0129:
        r0 = r9.a;	 Catch:{ all -> 0x006c }
        r1 = 34;
        r0 = r2.a(r0, r1);	 Catch:{ all -> 0x006c }
        r1 = r9.b;	 Catch:{ all -> 0x006c }
        r1 = r1.c;	 Catch:{ all -> 0x006c }
        r0 = com.alibaba.fastjson.c.e.a(r0, r1);	 Catch:{ all -> 0x006c }
        r1 = r10.getClass();	 Catch:{ all -> 0x006c }
        if (r0 != r1) goto L_0x0152;
    L_0x013f:
        r0 = 16;
        r2.a(r0);	 Catch:{ all -> 0x006c }
        r0 = r2.a;	 Catch:{ all -> 0x006c }
        if (r0 != r8) goto L_0x0027;
    L_0x0148:
        r0 = 16;
        r2.a(r0);	 Catch:{ all -> 0x006c }
        r9.a(r3);
        goto L_0x0083;
    L_0x0152:
        r1 = r9.b;	 Catch:{ all -> 0x006c }
        r1 = r1.a(r0);	 Catch:{ all -> 0x006c }
        r4 = 16;
        r2.a(r4);	 Catch:{ all -> 0x006c }
        r2 = 2;
        r9.g = r2;	 Catch:{ all -> 0x006c }
        if (r3 == 0) goto L_0x0169;
    L_0x0162:
        r2 = r12 instanceof java.lang.Integer;	 Catch:{ all -> 0x006c }
        if (r2 != 0) goto L_0x0169;
    L_0x0166:
        r9.b();	 Catch:{ all -> 0x006c }
    L_0x0169:
        r0 = r1.a(r9, r0, r12);	 Catch:{ all -> 0x006c }
        r0 = (java.util.Map) r0;	 Catch:{ all -> 0x006c }
        r9.a(r3);
        r10 = r0;
        goto L_0x0083;
    L_0x0175:
        r2.g();	 Catch:{ all -> 0x006c }
        r9.a(r3);	 Catch:{ all -> 0x006c }
        r0 = r2.a;	 Catch:{ all -> 0x006c }
        r4 = 8;
        if (r0 != r4) goto L_0x01a2;
    L_0x0181:
        r0 = 0;
        r2.g();	 Catch:{ all -> 0x006c }
    L_0x0185:
        r10.put(r1, r0);	 Catch:{ all -> 0x006c }
        r4 = r9.g;	 Catch:{ all -> 0x006c }
        r5 = 1;
        if (r4 != r5) goto L_0x0190;
    L_0x018d:
        r9.b(r10, r1);	 Catch:{ all -> 0x006c }
    L_0x0190:
        r9.a(r3, r0, r1);	 Catch:{ all -> 0x006c }
        r0 = r2.a;	 Catch:{ all -> 0x006c }
        r1 = 20;
        if (r0 == r1) goto L_0x019d;
    L_0x0199:
        r1 = 15;
        if (r0 != r1) goto L_0x01a7;
    L_0x019d:
        r9.a(r3);
        goto L_0x0083;
    L_0x01a2:
        r0 = r9.a(r11, r1);	 Catch:{ all -> 0x006c }
        goto L_0x0185;
    L_0x01a7:
        if (r0 != r8) goto L_0x0027;
    L_0x01a9:
        r2.g();	 Catch:{ all -> 0x006c }
        r9.a(r3);
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.l.a(com.alibaba.fastjson.a.c, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object a(com.alibaba.fastjson.a.c r12, java.util.Map<java.lang.Object, java.lang.Object> r13, java.lang.reflect.Type r14, java.lang.reflect.Type r15) {
        /*
        r0 = 0;
        r11 = 1;
        r10 = 4;
        r9 = 13;
        r8 = 16;
        r2 = r12.e;
        r1 = r2.a;
        r3 = 12;
        if (r1 == r3) goto L_0x002a;
    L_0x000f:
        if (r1 == r8) goto L_0x002a;
    L_0x0011:
        r0 = new com.alibaba.fastjson.d;
        r2 = new java.lang.StringBuilder;
        r3 = "syntax error, expect {, actual ";
        r2.<init>(r3);
        r1 = com.alibaba.fastjson.a.j.a(r1);
        r1 = r2.append(r1);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x002a:
        r1 = r12.b;
        r3 = r1.a(r14);
        r1 = r12.b;
        r4 = r1.a(r15);
        r2.g();
        r1 = r12.f;
    L_0x003b:
        r5 = r2.a;	 Catch:{ all -> 0x0080 }
        if (r5 != r9) goto L_0x0048;
    L_0x003f:
        r0 = 16;
        r2.a(r0);	 Catch:{ all -> 0x0080 }
        r12.a(r1);
    L_0x0047:
        return r13;
    L_0x0048:
        if (r5 != r10) goto L_0x00c7;
    L_0x004a:
        r6 = r2.e();	 Catch:{ all -> 0x0080 }
        if (r6 == 0) goto L_0x00c7;
    L_0x0050:
        r6 = com.alibaba.fastjson.a.e.DisableSpecialKeyDetect;	 Catch:{ all -> 0x0080 }
        r6 = r2.a(r6);	 Catch:{ all -> 0x0080 }
        if (r6 != 0) goto L_0x00c7;
    L_0x0058:
        r2.d();	 Catch:{ all -> 0x0080 }
        r3 = r2.a;	 Catch:{ all -> 0x0080 }
        if (r3 != r10) goto L_0x00a5;
    L_0x005f:
        r3 = r2.p();	 Catch:{ all -> 0x0080 }
        r4 = "..";
        r4 = r4.equals(r3);	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0085;
    L_0x006b:
        r0 = r1.b;	 Catch:{ all -> 0x0080 }
        r13 = r0.a;	 Catch:{ all -> 0x0080 }
    L_0x006f:
        r0 = 13;
        r2.a(r0);	 Catch:{ all -> 0x0080 }
        r0 = r2.a;	 Catch:{ all -> 0x0080 }
        if (r0 == r9) goto L_0x00be;
    L_0x0078:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x0080 }
        r2 = "illegal ref";
        r0.<init>(r2);	 Catch:{ all -> 0x0080 }
        throw r0;	 Catch:{ all -> 0x0080 }
    L_0x0080:
        r0 = move-exception;
        r12.a(r1);
        throw r0;
    L_0x0085:
        r4 = "$";
        r4 = r4.equals(r3);	 Catch:{ all -> 0x0080 }
        if (r4 == 0) goto L_0x0098;
    L_0x008d:
        r0 = r1;
    L_0x008e:
        r3 = r0.b;	 Catch:{ all -> 0x0080 }
        if (r3 == 0) goto L_0x0095;
    L_0x0092:
        r0 = r0.b;	 Catch:{ all -> 0x0080 }
        goto L_0x008e;
    L_0x0095:
        r13 = r0.a;	 Catch:{ all -> 0x0080 }
        goto L_0x006f;
    L_0x0098:
        r4 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x0080 }
        r4.<init>(r1, r3);	 Catch:{ all -> 0x0080 }
        r12.a(r4);	 Catch:{ all -> 0x0080 }
        r3 = 1;
        r12.g = r3;	 Catch:{ all -> 0x0080 }
        r13 = r0;
        goto L_0x006f;
    L_0x00a5:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x0080 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r3 = "illegal ref, ";
        r2.<init>(r3);	 Catch:{ all -> 0x0080 }
        r3 = com.alibaba.fastjson.a.j.a(r5);	 Catch:{ all -> 0x0080 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0080 }
        r2 = r2.toString();	 Catch:{ all -> 0x0080 }
        r0.<init>(r2);	 Catch:{ all -> 0x0080 }
        throw r0;	 Catch:{ all -> 0x0080 }
    L_0x00be:
        r0 = 16;
        r2.a(r0);	 Catch:{ all -> 0x0080 }
        r12.a(r1);
        goto L_0x0047;
    L_0x00c7:
        r6 = r13.size();	 Catch:{ all -> 0x0080 }
        if (r6 != 0) goto L_0x00fa;
    L_0x00cd:
        if (r5 != r10) goto L_0x00fa;
    L_0x00cf:
        r5 = "@type";
        r6 = r2.p();	 Catch:{ all -> 0x0080 }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0080 }
        if (r5 == 0) goto L_0x00fa;
    L_0x00db:
        r5 = com.alibaba.fastjson.a.e.DisableSpecialKeyDetect;	 Catch:{ all -> 0x0080 }
        r5 = r2.a(r5);	 Catch:{ all -> 0x0080 }
        if (r5 != 0) goto L_0x00fa;
    L_0x00e3:
        r2.d();	 Catch:{ all -> 0x0080 }
        r5 = 16;
        r2.a(r5);	 Catch:{ all -> 0x0080 }
        r5 = r2.a;	 Catch:{ all -> 0x0080 }
        if (r5 != r9) goto L_0x00f7;
    L_0x00ef:
        r2.g();	 Catch:{ all -> 0x0080 }
        r12.a(r1);
        goto L_0x0047;
    L_0x00f7:
        r2.g();	 Catch:{ all -> 0x0080 }
    L_0x00fa:
        r5 = 0;
        r5 = r3.a(r12, r14, r5);	 Catch:{ all -> 0x0080 }
        r6 = r2.a;	 Catch:{ all -> 0x0080 }
        r7 = 17;
        if (r6 == r7) goto L_0x011c;
    L_0x0105:
        r0 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x0080 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r4 = "syntax error, expect :, actual ";
        r3.<init>(r4);	 Catch:{ all -> 0x0080 }
        r2 = r2.a;	 Catch:{ all -> 0x0080 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0080 }
        r2 = r2.toString();	 Catch:{ all -> 0x0080 }
        r0.<init>(r2);	 Catch:{ all -> 0x0080 }
        throw r0;	 Catch:{ all -> 0x0080 }
    L_0x011c:
        r2.g();	 Catch:{ all -> 0x0080 }
        r6 = r4.a(r12, r15, r5);	 Catch:{ all -> 0x0080 }
        r7 = r12.g;	 Catch:{ all -> 0x0080 }
        if (r7 != r11) goto L_0x012a;
    L_0x0127:
        r12.b(r13, r5);	 Catch:{ all -> 0x0080 }
    L_0x012a:
        r13.put(r5, r6);	 Catch:{ all -> 0x0080 }
        r5 = r2.a;	 Catch:{ all -> 0x0080 }
        if (r5 != r8) goto L_0x003b;
    L_0x0131:
        r2.g();	 Catch:{ all -> 0x0080 }
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.l.a(com.alibaba.fastjson.a.c, java.util.Map, java.lang.reflect.Type, java.lang.reflect.Type):java.lang.Object");
    }

    private static Map<?, ?> a(Type type) {
        Class cls = type;
        while (cls != Properties.class) {
            if (cls == Hashtable.class) {
                return new Hashtable();
            }
            if (cls == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (cls == SortedMap.class || cls == TreeMap.class) {
                return new TreeMap();
            }
            if (cls == ConcurrentMap.class || cls == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (cls == Map.class || cls == HashMap.class) {
                return new HashMap();
            }
            if (cls == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (cls == com.alibaba.fastjson.e.class) {
                return new com.alibaba.fastjson.e();
            }
            if (cls instanceof ParameterizedType) {
                cls = ((ParameterizedType) cls).getRawType();
            } else {
                Class cls2 = cls;
                if (cls2.isInterface()) {
                    throw new d("unsupport type " + cls);
                }
                try {
                    return (Map) cls2.newInstance();
                } catch (Throwable e) {
                    throw new d("unsupport type " + cls, e);
                }
            }
        }
        return new Properties();
    }
}
