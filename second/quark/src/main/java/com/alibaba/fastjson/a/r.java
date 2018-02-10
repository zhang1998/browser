package com.alibaba.fastjson.a;

/* compiled from: ProGuard */
public final class r extends f {
    public r(n nVar, Class<?> cls) {
        super(nVar, cls, cls);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.alibaba.fastjson.a.c r16, java.lang.reflect.Type r17, java.lang.Object r18) {
        /*
        r15 = this;
        r0 = r16;
        r6 = r0.e;
        r1 = r6.a;
        r2 = 8;
        if (r1 != r2) goto L_0x000f;
    L_0x000a:
        r6.g();
        r1 = 0;
    L_0x000e:
        return r1;
    L_0x000f:
        r0 = r16;
        r1 = r0.g;
        r2 = 2;
        if (r1 != r2) goto L_0x0061;
    L_0x0016:
        r1 = 0;
        r0 = r16;
        r0.g = r1;
    L_0x001b:
        r4 = 0;
        r1 = 0;
        if (r17 == 0) goto L_0x01cb;
    L_0x001f:
        r0 = r17;
        r2 = r0 instanceof java.lang.Class;
        if (r2 == 0) goto L_0x01cb;
    L_0x0025:
        r17 = (java.lang.Class) r17;
        r2 = java.lang.Throwable.class;
        r0 = r17;
        r2 = r2.isAssignableFrom(r0);
        if (r2 == 0) goto L_0x01cb;
    L_0x0031:
        r5 = 0;
        r2 = 0;
        r7 = new java.util.HashMap;
        r7.<init>();
        r3 = r17;
    L_0x003a:
        r0 = r16;
        r1 = r0.a;
        r1 = r6.a(r1);
        if (r1 != 0) goto L_0x007e;
    L_0x0044:
        r8 = r6.a;
        r9 = 13;
        if (r8 != r9) goto L_0x006f;
    L_0x004a:
        r1 = 16;
        r6.a(r1);
        r7 = r2;
        r1 = r3;
        r8 = r4;
        r9 = r5;
    L_0x0053:
        r5 = 0;
        if (r1 != 0) goto L_0x012d;
    L_0x0056:
        r1 = new java.lang.Exception;
        r1.<init>(r9, r8);
    L_0x005b:
        if (r7 == 0) goto L_0x000e;
    L_0x005d:
        r1.setStackTrace(r7);
        goto L_0x000e;
    L_0x0061:
        r1 = r6.a;
        r2 = 12;
        if (r1 == r2) goto L_0x001b;
    L_0x0067:
        r1 = new com.alibaba.fastjson.d;
        r2 = "syntax error";
        r1.<init>(r2);
        throw r1;
    L_0x006f:
        r8 = r6.a;
        r9 = 16;
        if (r8 != r9) goto L_0x007e;
    L_0x0075:
        r8 = r6.c;
        r9 = com.alibaba.fastjson.a.e.AllowArbitraryCommas;
        r9 = r9.q;
        r8 = r8 & r9;
        if (r8 != 0) goto L_0x003a;
    L_0x007e:
        r6.d();
        r8 = "@type";
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x00be;
    L_0x0089:
        r1 = r6.a;
        r3 = 4;
        if (r1 != r3) goto L_0x00b6;
    L_0x008e:
        r1 = r6.p();
        r0 = r16;
        r3 = r0.b;
        r3 = r3.c;
        r1 = com.alibaba.fastjson.c.e.a(r1, r3);
        r3 = 16;
        r6.a(r3);
        r3 = r4;
        r4 = r5;
        r14 = r2;
        r2 = r1;
        r1 = r14;
    L_0x00a6:
        r5 = r6.a;
        r8 = 13;
        if (r5 != r8) goto L_0x0127;
    L_0x00ac:
        r5 = 16;
        r6.a(r5);
        r7 = r1;
        r8 = r3;
        r9 = r4;
        r1 = r2;
        goto L_0x0053;
    L_0x00b6:
        r1 = new com.alibaba.fastjson.d;
        r2 = "syntax error";
        r1.<init>(r2);
        throw r1;
    L_0x00be:
        r8 = "message";
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x00e8;
    L_0x00c6:
        r1 = r6.a;
        r5 = 8;
        if (r1 != r5) goto L_0x00d6;
    L_0x00cc:
        r1 = 0;
    L_0x00cd:
        r6.g();
        r14 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r1;
        r1 = r14;
        goto L_0x00a6;
    L_0x00d6:
        r1 = r6.a;
        r5 = 4;
        if (r1 != r5) goto L_0x00e0;
    L_0x00db:
        r1 = r6.p();
        goto L_0x00cd;
    L_0x00e0:
        r1 = new com.alibaba.fastjson.d;
        r2 = "syntax error";
        r1.<init>(r2);
        throw r1;
    L_0x00e8:
        r8 = "cause";
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x0101;
    L_0x00f0:
        r1 = 0;
        r4 = "cause";
        r0 = r16;
        r1 = r15.a(r0, r1, r4);
        r1 = (java.lang.Throwable) r1;
        r4 = r5;
        r14 = r3;
        r3 = r1;
        r1 = r2;
        r2 = r14;
        goto L_0x00a6;
    L_0x0101:
        r8 = "stackTrace";
        r8 = r8.equals(r1);
        if (r8 == 0) goto L_0x0118;
    L_0x0109:
        r1 = java.lang.StackTraceElement[].class;
        r2 = 0;
        r0 = r16;
        r1 = r0.a(r1, r2);
        r1 = (java.lang.StackTraceElement[]) r1;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x00a6;
    L_0x0118:
        r8 = 0;
        r0 = r16;
        r8 = r0.a(r8);
        r7.put(r1, r8);
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x00a6;
    L_0x0127:
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x003a;
    L_0x012d:
        r2 = 0;
        r4 = 0;
        r3 = 0;
        r10 = r1.getConstructors();	 Catch:{ Exception -> 0x01a0 }
        r11 = r10.length;	 Catch:{ Exception -> 0x01a0 }
        r1 = 0;
        r6 = r1;
    L_0x0137:
        if (r6 >= r11) goto L_0x0186;
    L_0x0139:
        r1 = r10[r6];	 Catch:{ Exception -> 0x01a0 }
        r12 = r1.getParameterTypes();	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.length;	 Catch:{ Exception -> 0x01a0 }
        if (r12 != 0) goto L_0x014b;
    L_0x0142:
        r2 = r3;
        r3 = r4;
    L_0x0144:
        r4 = r6 + 1;
        r6 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x0137;
    L_0x014b:
        r12 = r1.getParameterTypes();	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.length;	 Catch:{ Exception -> 0x01a0 }
        r13 = 1;
        if (r12 != r13) goto L_0x0163;
    L_0x0153:
        r12 = r1.getParameterTypes();	 Catch:{ Exception -> 0x01a0 }
        r13 = 0;
        r12 = r12[r13];	 Catch:{ Exception -> 0x01a0 }
        r13 = java.lang.String.class;
        if (r12 != r13) goto L_0x0163;
    L_0x015e:
        r14 = r2;
        r2 = r3;
        r3 = r1;
        r1 = r14;
        goto L_0x0144;
    L_0x0163:
        r12 = r1.getParameterTypes();	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.length;	 Catch:{ Exception -> 0x01a0 }
        r13 = 2;
        if (r12 != r13) goto L_0x01c6;
    L_0x016b:
        r12 = r1.getParameterTypes();	 Catch:{ Exception -> 0x01a0 }
        r13 = 0;
        r12 = r12[r13];	 Catch:{ Exception -> 0x01a0 }
        r13 = java.lang.String.class;
        if (r12 != r13) goto L_0x01c6;
    L_0x0176:
        r12 = r1.getParameterTypes();	 Catch:{ Exception -> 0x01a0 }
        r13 = 1;
        r12 = r12[r13];	 Catch:{ Exception -> 0x01a0 }
        r13 = java.lang.Throwable.class;
        if (r12 != r13) goto L_0x01c6;
    L_0x0181:
        r3 = r4;
        r14 = r1;
        r1 = r2;
        r2 = r14;
        goto L_0x0144;
    L_0x0186:
        if (r3 == 0) goto L_0x01a9;
    L_0x0188:
        r1 = 2;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x01a0 }
        r2 = 0;
        r1[r2] = r9;	 Catch:{ Exception -> 0x01a0 }
        r2 = 1;
        r1[r2] = r8;	 Catch:{ Exception -> 0x01a0 }
        r1 = r3.newInstance(r1);	 Catch:{ Exception -> 0x01a0 }
        r1 = (java.lang.Throwable) r1;	 Catch:{ Exception -> 0x01a0 }
    L_0x0197:
        if (r1 != 0) goto L_0x005b;
    L_0x0199:
        r1 = new java.lang.Exception;	 Catch:{ Exception -> 0x01a0 }
        r1.<init>(r9, r8);	 Catch:{ Exception -> 0x01a0 }
        goto L_0x005b;
    L_0x01a0:
        r1 = move-exception;
        r2 = new com.alibaba.fastjson.d;
        r3 = "create instance error";
        r2.<init>(r3, r1);
        throw r2;
    L_0x01a9:
        if (r4 == 0) goto L_0x01b8;
    L_0x01ab:
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x01a0 }
        r2 = 0;
        r1[r2] = r9;	 Catch:{ Exception -> 0x01a0 }
        r1 = r4.newInstance(r1);	 Catch:{ Exception -> 0x01a0 }
        r1 = (java.lang.Throwable) r1;	 Catch:{ Exception -> 0x01a0 }
        goto L_0x0197;
    L_0x01b8:
        if (r2 == 0) goto L_0x01c4;
    L_0x01ba:
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x01a0 }
        r1 = r2.newInstance(r1);	 Catch:{ Exception -> 0x01a0 }
        r1 = (java.lang.Throwable) r1;	 Catch:{ Exception -> 0x01a0 }
        goto L_0x0197;
    L_0x01c4:
        r1 = r5;
        goto L_0x0197;
    L_0x01c6:
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0144;
    L_0x01cb:
        r17 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.r.a(com.alibaba.fastjson.a.c, java.lang.reflect.Type, java.lang.Object):T");
    }
}
