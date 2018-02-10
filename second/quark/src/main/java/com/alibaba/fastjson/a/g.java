package com.alibaba.fastjson.a;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.c.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
final class g {
    final Constructor<?> a;
    final int b;
    final Constructor<?> c;
    final Method d;
    final a[] e;
    final a[] f;
    final JSONType g;
    boolean h = false;
    final boolean i;
    public final String j;

    private g(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, a[] aVarArr, a[] aVarArr2, JSONType jSONType) {
        boolean z;
        int i = 0;
        this.a = constructor;
        this.c = constructor2;
        this.d = method;
        this.e = aVarArr;
        this.g = jSONType;
        if (jSONType != null) {
            String typeName = jSONType.typeName();
            if (typeName.length() != 0) {
                this.j = typeName;
            } else {
                this.j = cls.getName();
            }
        } else {
            this.j = cls.getName();
        }
        if (jSONType != null) {
            z = false;
            for (e eVar : jSONType.parseFeatures()) {
                if (eVar == e.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.i = z;
        a[] a = a(aVarArr, aVarArr2);
        if (!Arrays.equals(aVarArr, a)) {
            aVarArr = a;
        }
        this.f = aVarArr;
        if (constructor != null) {
            i = constructor.getParameterTypes().length;
        }
        this.b = i;
    }

    private a[] a(a[] aVarArr, a[] aVarArr2) {
        if (this.g == null) {
            return aVarArr2;
        }
        String[] orders = this.g.orders();
        if (orders == null || orders.length == 0) {
            return aVarArr2;
        }
        int i;
        int i2;
        boolean z;
        for (Object equals : orders) {
            boolean z2;
            for (a aVar : aVarArr2) {
                if (aVar.a.equals(equals)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (!z2) {
                z = false;
                break;
            }
        }
        z = true;
        if (!z) {
            return aVarArr2;
        }
        if (orders.length == aVarArr.length) {
            for (i = 0; i < orders.length; i++) {
                if (!aVarArr2[i].a.equals(orders[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return aVarArr2;
            }
            a[] aVarArr3 = new a[aVarArr2.length];
            for (i2 = 0; i2 < orders.length; i2++) {
                for (i = 0; i < aVarArr2.length; i++) {
                    if (aVarArr2[i].a.equals(orders[i2])) {
                        aVarArr3[i2] = aVarArr2[i];
                        break;
                    }
                }
            }
            this.h = true;
            return aVarArr3;
        }
        a[] aVarArr4 = new a[aVarArr2.length];
        for (i = 0; i < orders.length; i++) {
            for (i2 = 0; i2 < aVarArr2.length; i2++) {
                if (aVarArr2[i2].a.equals(orders[i])) {
                    aVarArr4[i] = aVarArr2[i2];
                    break;
                }
            }
        }
        i2 = orders.length;
        int i3 = 0;
        while (i3 < aVarArr2.length) {
            i = 0;
            while (i < aVarArr4.length && i < i2) {
                a aVar2 = aVarArr4[i3];
                a aVar3 = aVarArr2[i];
                boolean z3 = aVar3 == aVar2 ? true : aVar2.a(aVar3) == 0;
                if (z3) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
            if (z) {
                i = i2;
            } else {
                aVarArr4[i2] = aVarArr2[i3];
                i = i2 + 1;
            }
            i3++;
            i2 = i;
        }
        this.h = true;
        return aVarArr2;
    }

    private static boolean a(List<a> list, a aVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = (a) list.get(i);
            if (aVar2.a.equals(aVar.a) && (!aVar2.i || aVar.i)) {
                return false;
            }
        }
        list.add(aVar);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.a.g a(java.lang.Class<?> r18, int r19, java.lang.reflect.Type r20, com.alibaba.fastjson.h r21) {
        /*
        r14 = new java.util.ArrayList;
        r14.<init>();
        r2 = 0;
        r0 = r19;
        r3 = r0 & 1024;
        if (r3 != 0) goto L_0x0572;
    L_0x000c:
        r3 = 0;
        r3 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x00a4 }
        r0 = r18;
        r3 = r0.getDeclaredConstructor(r3);	 Catch:{ Exception -> 0x00a4 }
    L_0x0015:
        if (r3 != 0) goto L_0x056f;
    L_0x0017:
        r2 = r18.isMemberClass();
        if (r2 == 0) goto L_0x056f;
    L_0x001d:
        r2 = r19 & 8;
        if (r2 != 0) goto L_0x056f;
    L_0x0021:
        r5 = r18.getDeclaredConstructors();
        r6 = r5.length;
        r2 = 0;
        r4 = r2;
    L_0x0028:
        if (r4 >= r6) goto L_0x056f;
    L_0x002a:
        r2 = r5[r4];
        r7 = r2.getParameterTypes();
        r8 = r7.length;
        r9 = 1;
        if (r8 != r9) goto L_0x00a8;
    L_0x0034:
        r8 = 0;
        r7 = r7[r8];
        r8 = r18.getDeclaringClass();
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x00a8;
    L_0x0041:
        r12 = r2;
    L_0x0042:
        r15 = r18.getMethods();
        r16 = r18.getDeclaredFields();
        if (r12 != 0) goto L_0x01f1;
    L_0x004c:
        r2 = r18.isInterface();
        if (r2 != 0) goto L_0x01f1;
    L_0x0052:
        r0 = r19;
        r2 = r0 & 1024;
        if (r2 != 0) goto L_0x01f1;
    L_0x0058:
        r4 = 0;
        r6 = r18.getDeclaredConstructors();
        r7 = r6.length;
        r2 = 0;
        r5 = r2;
    L_0x0060:
        if (r5 >= r7) goto L_0x056c;
    L_0x0062:
        r3 = r6[r5];
        r2 = com.alibaba.fastjson.annotation.JSONCreator.class;
        r2 = r3.getAnnotation(r2);
        r2 = (com.alibaba.fastjson.annotation.JSONCreator) r2;
        if (r2 == 0) goto L_0x00ad;
    L_0x006e:
        r10 = r3;
    L_0x006f:
        if (r10 == 0) goto L_0x0115;
    L_0x0071:
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r10, r1);
        r11 = r10.getParameterTypes();
        r12 = r10.getGenericParameterTypes();
        r2 = 0;
        r9 = r2;
    L_0x0082:
        r2 = r11.length;
        if (r9 >= r2) goto L_0x00eb;
    L_0x0085:
        r2 = r10.getParameterAnnotations();
        r5 = r2[r9];
        r3 = 0;
        r6 = r5.length;
        r2 = 0;
        r4 = r2;
    L_0x008f:
        if (r4 >= r6) goto L_0x009a;
    L_0x0091:
        r2 = r5[r4];
        r7 = r2 instanceof com.alibaba.fastjson.annotation.JSONField;
        if (r7 == 0) goto L_0x00b1;
    L_0x0097:
        r2 = (com.alibaba.fastjson.annotation.JSONField) r2;
        r3 = r2;
    L_0x009a:
        if (r3 != 0) goto L_0x00b5;
    L_0x009c:
        r2 = new com.alibaba.fastjson.d;
        r3 = "illegal json creator";
        r2.<init>(r3);
        throw r2;
    L_0x00a4:
        r3 = move-exception;
        r3 = r2;
        goto L_0x0015;
    L_0x00a8:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x0028;
    L_0x00ad:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x0060;
    L_0x00b1:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x008f;
    L_0x00b5:
        r5 = r11[r9];
        r6 = r12[r9];
        r2 = r3.name();
        r0 = r18;
        r1 = r16;
        r7 = com.alibaba.fastjson.c.e.a(r0, r2, r1);
        if (r7 == 0) goto L_0x00ce;
    L_0x00c7:
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r7, r1);
    L_0x00ce:
        r8 = r3.ordinal();
        r2 = r3.serialzeFeatures();
        com.alibaba.fastjson.b.z.a(r2);
        r2 = new com.alibaba.fastjson.c.a;
        r3 = r3.name();
        r4 = r18;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        a(r14, r2);
        r2 = r9 + 1;
        r9 = r2;
        goto L_0x0082;
    L_0x00eb:
        r2 = r14.size();
        r7 = new com.alibaba.fastjson.c.a[r2];
        r14.toArray(r7);
        r2 = r7.length;
        r8 = new com.alibaba.fastjson.c.a[r2];
        r2 = 0;
        r3 = 0;
        r4 = r7.length;
        java.lang.System.arraycopy(r7, r2, r8, r3, r4);
        java.util.Arrays.sort(r8);
        r2 = com.alibaba.fastjson.annotation.JSONType.class;
        r0 = r18;
        r9 = r0.getAnnotation(r2);
        r9 = (com.alibaba.fastjson.annotation.JSONType) r9;
        r2 = new com.alibaba.fastjson.a.g;
        r4 = 0;
        r6 = 0;
        r3 = r18;
        r5 = r10;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
    L_0x0114:
        return r2;
    L_0x0115:
        r4 = 0;
        r6 = r15.length;
        r2 = 0;
        r5 = r2;
    L_0x0119:
        if (r5 >= r6) goto L_0x0569;
    L_0x011b:
        r3 = r15[r5];
        r2 = r3.getModifiers();
        r2 = java.lang.reflect.Modifier.isStatic(r2);
        if (r2 == 0) goto L_0x0173;
    L_0x0127:
        r2 = r3.getReturnType();
        r0 = r18;
        r2 = r0.isAssignableFrom(r2);
        if (r2 == 0) goto L_0x0173;
    L_0x0133:
        r2 = com.alibaba.fastjson.annotation.JSONCreator.class;
        r2 = r3.getAnnotation(r2);
        r2 = (com.alibaba.fastjson.annotation.JSONCreator) r2;
        if (r2 == 0) goto L_0x0173;
    L_0x013d:
        r10 = r3;
    L_0x013e:
        if (r10 == 0) goto L_0x01da;
    L_0x0140:
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r10, r1);
        r11 = r10.getParameterTypes();
        r12 = r10.getGenericParameterTypes();
        r2 = 0;
        r9 = r2;
    L_0x0151:
        r2 = r11.length;
        if (r9 >= r2) goto L_0x01a8;
    L_0x0154:
        r2 = r10.getParameterAnnotations();
        r5 = r2[r9];
        r3 = 0;
        r6 = r5.length;
        r2 = 0;
        r4 = r2;
    L_0x015e:
        if (r4 >= r6) goto L_0x0169;
    L_0x0160:
        r2 = r5[r4];
        r7 = r2 instanceof com.alibaba.fastjson.annotation.JSONField;
        if (r7 == 0) goto L_0x0177;
    L_0x0166:
        r2 = (com.alibaba.fastjson.annotation.JSONField) r2;
        r3 = r2;
    L_0x0169:
        if (r3 != 0) goto L_0x017b;
    L_0x016b:
        r2 = new com.alibaba.fastjson.d;
        r3 = "illegal json creator";
        r2.<init>(r3);
        throw r2;
    L_0x0173:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x0119;
    L_0x0177:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x015e;
    L_0x017b:
        r5 = r11[r9];
        r6 = r12[r9];
        r2 = r3.name();
        r0 = r18;
        r1 = r16;
        r7 = com.alibaba.fastjson.c.e.a(r0, r2, r1);
        r8 = r3.ordinal();
        r2 = r3.serialzeFeatures();
        com.alibaba.fastjson.b.z.a(r2);
        r2 = new com.alibaba.fastjson.c.a;
        r3 = r3.name();
        r4 = r18;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        a(r14, r2);
        r2 = r9 + 1;
        r9 = r2;
        goto L_0x0151;
    L_0x01a8:
        r2 = r14.size();
        r7 = new com.alibaba.fastjson.c.a[r2];
        r14.toArray(r7);
        r2 = r7.length;
        r8 = new com.alibaba.fastjson.c.a[r2];
        r2 = 0;
        r3 = 0;
        r4 = r7.length;
        java.lang.System.arraycopy(r7, r2, r8, r3, r4);
        java.util.Arrays.sort(r8);
        r2 = java.util.Arrays.equals(r7, r8);
        if (r2 == 0) goto L_0x01c4;
    L_0x01c3:
        r8 = r7;
    L_0x01c4:
        r2 = com.alibaba.fastjson.annotation.JSONType.class;
        r0 = r18;
        r9 = r0.getAnnotation(r2);
        r9 = (com.alibaba.fastjson.annotation.JSONType) r9;
        r2 = new com.alibaba.fastjson.a.g;
        r4 = 0;
        r5 = 0;
        r3 = r18;
        r6 = r10;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
        goto L_0x0114;
    L_0x01da:
        r2 = new com.alibaba.fastjson.d;
        r3 = new java.lang.StringBuilder;
        r4 = "default constructor not found. ";
        r3.<init>(r4);
        r0 = r18;
        r3 = r3.append(r0);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x01f1:
        if (r12 == 0) goto L_0x01fa;
    L_0x01f3:
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r12, r1);
    L_0x01fa:
        r0 = r15.length;
        r17 = r0;
        r2 = 0;
        r13 = r2;
    L_0x01ff:
        r0 = r17;
        if (r13 >= r0) goto L_0x038e;
    L_0x0203:
        r4 = r15[r13];
        r8 = 0;
        r3 = r4.getName();
        r2 = r3.length();
        r5 = 4;
        if (r2 < r5) goto L_0x0280;
    L_0x0211:
        r2 = r4.getModifiers();
        r2 = java.lang.reflect.Modifier.isStatic(r2);
        if (r2 != 0) goto L_0x0280;
    L_0x021b:
        r2 = r4.getReturnType();
        r5 = java.lang.Void.TYPE;
        if (r2 == r5) goto L_0x0229;
    L_0x0223:
        r5 = r4.getDeclaringClass();
        if (r2 != r5) goto L_0x0280;
    L_0x0229:
        r2 = r4.getParameterTypes();
        r2 = r2.length;
        r5 = 1;
        if (r2 != r5) goto L_0x0280;
    L_0x0231:
        r2 = r4.getDeclaringClass();
        r5 = java.lang.Object.class;
        if (r2 == r5) goto L_0x0280;
    L_0x0239:
        r2 = com.alibaba.fastjson.annotation.JSONField.class;
        r2 = r4.getAnnotation(r2);
        r2 = (com.alibaba.fastjson.annotation.JSONField) r2;
        if (r2 != 0) goto L_0x0563;
    L_0x0243:
        r0 = r18;
        r9 = com.alibaba.fastjson.c.e.a(r0, r4);
    L_0x0249:
        if (r9 == 0) goto L_0x0285;
    L_0x024b:
        r2 = r9.deserialize();
        if (r2 == 0) goto L_0x0280;
    L_0x0251:
        r8 = r9.ordinal();
        r2 = r9.serialzeFeatures();
        com.alibaba.fastjson.b.z.a(r2);
        r2 = r9.name();
        r2 = r2.length();
        if (r2 == 0) goto L_0x0285;
    L_0x0266:
        r3 = r9.name();
        r2 = new com.alibaba.fastjson.c.a;
        r5 = 0;
        r10 = 0;
        r11 = 1;
        r6 = r18;
        r7 = r20;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        a(r14, r2);
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r4, r1);
    L_0x0280:
        r2 = r13 + 1;
        r13 = r2;
        goto L_0x01ff;
    L_0x0285:
        r2 = "set";
        r2 = r3.startsWith(r2);
        if (r2 == 0) goto L_0x0280;
    L_0x028d:
        r2 = 3;
        r2 = r3.charAt(r2);
        r5 = java.lang.Character.isUpperCase(r2);
        if (r5 == 0) goto L_0x0338;
    L_0x0298:
        r2 = com.alibaba.fastjson.c.e.a;
        if (r2 == 0) goto L_0x0317;
    L_0x029c:
        r2 = 3;
        r2 = r3.substring(r2);
        r2 = com.alibaba.fastjson.c.e.a(r2);
    L_0x02a5:
        r0 = r18;
        r1 = r16;
        r5 = com.alibaba.fastjson.c.e.a(r0, r2, r1);
        if (r5 != 0) goto L_0x02e3;
    L_0x02af:
        r3 = r4.getParameterTypes();
        r6 = 0;
        r3 = r3[r6];
        r6 = java.lang.Boolean.TYPE;
        if (r3 != r6) goto L_0x02e3;
    L_0x02ba:
        r3 = new java.lang.StringBuilder;
        r5 = "is";
        r3.<init>(r5);
        r5 = 0;
        r5 = r2.charAt(r5);
        r5 = java.lang.Character.toUpperCase(r5);
        r3 = r3.append(r5);
        r5 = 1;
        r5 = r2.substring(r5);
        r3 = r3.append(r5);
        r3 = r3.toString();
        r0 = r18;
        r1 = r16;
        r5 = com.alibaba.fastjson.c.e.a(r0, r3, r1);
    L_0x02e3:
        if (r5 == 0) goto L_0x036e;
    L_0x02e5:
        r3 = com.alibaba.fastjson.annotation.JSONField.class;
        r10 = r5.getAnnotation(r3);
        r10 = (com.alibaba.fastjson.annotation.JSONField) r10;
        if (r10 == 0) goto L_0x036e;
    L_0x02ef:
        r8 = r10.ordinal();
        r3 = r10.serialzeFeatures();
        com.alibaba.fastjson.b.z.a(r3);
        r3 = r10.name();
        r3 = r3.length();
        if (r3 == 0) goto L_0x036b;
    L_0x0304:
        r3 = r10.name();
        r2 = new com.alibaba.fastjson.c.a;
        r11 = 1;
        r6 = r18;
        r7 = r20;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        a(r14, r2);
        goto L_0x0280;
    L_0x0317:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = 3;
        r5 = r3.charAt(r5);
        r5 = java.lang.Character.toLowerCase(r5);
        r2 = r2.append(r5);
        r5 = 4;
        r3 = r3.substring(r5);
        r2 = r2.append(r3);
        r2 = r2.toString();
        goto L_0x02a5;
    L_0x0338:
        r5 = 95;
        if (r2 != r5) goto L_0x0343;
    L_0x033c:
        r2 = 4;
        r2 = r3.substring(r2);
        goto L_0x02a5;
    L_0x0343:
        r5 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r2 != r5) goto L_0x034e;
    L_0x0347:
        r2 = 3;
        r2 = r3.substring(r2);
        goto L_0x02a5;
    L_0x034e:
        r2 = r3.length();
        r5 = 5;
        if (r2 < r5) goto L_0x0280;
    L_0x0355:
        r2 = 4;
        r2 = r3.charAt(r2);
        r2 = java.lang.Character.isUpperCase(r2);
        if (r2 == 0) goto L_0x0280;
    L_0x0360:
        r2 = 3;
        r2 = r3.substring(r2);
        r2 = com.alibaba.fastjson.c.e.a(r2);
        goto L_0x02a5;
    L_0x036b:
        if (r9 != 0) goto L_0x036e;
    L_0x036d:
        r9 = r10;
    L_0x036e:
        if (r21 == 0) goto L_0x0566;
    L_0x0370:
        r0 = r21;
        r3 = r0.a(r2);
    L_0x0376:
        r2 = new com.alibaba.fastjson.c.a;
        r5 = 0;
        r10 = 0;
        r11 = 1;
        r6 = r18;
        r7 = r20;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        a(r14, r2);
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r4, r1);
        goto L_0x0280;
    L_0x038e:
        r5 = new java.util.ArrayList;
        r0 = r16;
        r2 = r0.length;
        r5.<init>(r2);
        r0 = r16;
        r4 = r0.length;
        r2 = 0;
    L_0x039a:
        if (r2 >= r4) goto L_0x03d1;
    L_0x039c:
        r6 = r16[r2];
        r3 = r6.getModifiers();
        r7 = r3 & 8;
        if (r7 != 0) goto L_0x03cc;
    L_0x03a6:
        r3 = r3 & 16;
        if (r3 == 0) goto L_0x03c1;
    L_0x03aa:
        r3 = r6.getType();
        r7 = java.util.Map.class;
        r7 = r7.isAssignableFrom(r3);
        if (r7 != 0) goto L_0x03be;
    L_0x03b6:
        r7 = java.util.Collection.class;
        r3 = r7.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x03cf;
    L_0x03be:
        r3 = 1;
    L_0x03bf:
        if (r3 == 0) goto L_0x03cc;
    L_0x03c1:
        r3 = r6.getModifiers();
        r3 = r3 & 1;
        if (r3 == 0) goto L_0x03cc;
    L_0x03c9:
        r5.add(r6);
    L_0x03cc:
        r2 = r2 + 1;
        goto L_0x039a;
    L_0x03cf:
        r3 = 0;
        goto L_0x03bf;
    L_0x03d1:
        r2 = r18.getSuperclass();
    L_0x03d5:
        if (r2 == 0) goto L_0x041b;
    L_0x03d7:
        r3 = java.lang.Object.class;
        if (r2 == r3) goto L_0x041b;
    L_0x03db:
        r6 = r2.getDeclaredFields();
        r7 = r6.length;
        r3 = 0;
        r4 = r3;
    L_0x03e2:
        if (r4 >= r7) goto L_0x0416;
    L_0x03e4:
        r8 = r6[r4];
        r9 = r8.getModifiers();
        r3 = r9 & 8;
        if (r3 != 0) goto L_0x0410;
    L_0x03ee:
        r3 = r9 & 16;
        if (r3 == 0) goto L_0x0409;
    L_0x03f2:
        r3 = r8.getType();
        r10 = java.util.Map.class;
        r10 = r10.isAssignableFrom(r3);
        if (r10 != 0) goto L_0x0406;
    L_0x03fe:
        r10 = java.util.Collection.class;
        r3 = r10.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x0414;
    L_0x0406:
        r3 = 1;
    L_0x0407:
        if (r3 == 0) goto L_0x0410;
    L_0x0409:
        r3 = r9 & 1;
        if (r3 == 0) goto L_0x0410;
    L_0x040d:
        r5.add(r8);
    L_0x0410:
        r3 = r4 + 1;
        r4 = r3;
        goto L_0x03e2;
    L_0x0414:
        r3 = 0;
        goto L_0x0407;
    L_0x0416:
        r2 = r2.getSuperclass();
        goto L_0x03d5;
    L_0x041b:
        r13 = r5.iterator();
    L_0x041f:
        r2 = r13.hasNext();
        if (r2 == 0) goto L_0x0491;
    L_0x0425:
        r5 = r13.next();
        r5 = (java.lang.reflect.Field) r5;
        r4 = r5.getName();
        r3 = 0;
        r2 = 0;
        r7 = r14.size();
        r6 = r2;
    L_0x0436:
        if (r6 >= r7) goto L_0x044c;
    L_0x0438:
        r2 = r14.get(r6);
        r2 = (com.alibaba.fastjson.c.a) r2;
        r2 = r2.a;
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x0560;
    L_0x0446:
        r2 = 1;
    L_0x0447:
        r3 = r6 + 1;
        r6 = r3;
        r3 = r2;
        goto L_0x0436;
    L_0x044c:
        if (r3 != 0) goto L_0x041f;
    L_0x044e:
        r8 = 0;
        r2 = com.alibaba.fastjson.annotation.JSONField.class;
        r10 = r5.getAnnotation(r2);
        r10 = (com.alibaba.fastjson.annotation.JSONField) r10;
        if (r10 == 0) goto L_0x055d;
    L_0x0459:
        r8 = r10.ordinal();
        r2 = r10.serialzeFeatures();
        com.alibaba.fastjson.b.z.a(r2);
        r2 = r10.name();
        r2 = r2.length();
        if (r2 == 0) goto L_0x055d;
    L_0x046e:
        r3 = r10.name();
    L_0x0472:
        if (r21 == 0) goto L_0x047a;
    L_0x0474:
        r0 = r21;
        r3 = r0.a(r3);
    L_0x047a:
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r5, r1);
        r2 = new com.alibaba.fastjson.c.a;
        r4 = 0;
        r9 = 0;
        r11 = 1;
        r6 = r18;
        r7 = r20;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        a(r14, r2);
        goto L_0x041f;
    L_0x0491:
        r15 = r18.getMethods();
        r0 = r15.length;
        r16 = r0;
        r2 = 0;
        r13 = r2;
    L_0x049a:
        r0 = r16;
        if (r13 >= r0) goto L_0x0532;
    L_0x049e:
        r4 = r15[r13];
        r2 = r4.getName();
        r3 = r2.length();
        r5 = 4;
        if (r3 < r5) goto L_0x050e;
    L_0x04ab:
        r3 = r4.getModifiers();
        r3 = java.lang.reflect.Modifier.isStatic(r3);
        if (r3 != 0) goto L_0x050e;
    L_0x04b5:
        r3 = "get";
        r3 = r2.startsWith(r3);
        if (r3 == 0) goto L_0x050e;
    L_0x04bd:
        r3 = 3;
        r3 = r2.charAt(r3);
        r3 = java.lang.Character.isUpperCase(r3);
        if (r3 == 0) goto L_0x050e;
    L_0x04c8:
        r3 = r4.getParameterTypes();
        r3 = r3.length;
        if (r3 != 0) goto L_0x050e;
    L_0x04cf:
        r3 = r4.getReturnType();
        r5 = java.util.Collection.class;
        r5 = r5.isAssignableFrom(r3);
        if (r5 != 0) goto L_0x04e3;
    L_0x04db:
        r5 = java.util.Map.class;
        r3 = r5.isAssignableFrom(r3);
        if (r3 == 0) goto L_0x050e;
    L_0x04e3:
        r3 = com.alibaba.fastjson.annotation.JSONField.class;
        r9 = r4.getAnnotation(r3);
        r9 = (com.alibaba.fastjson.annotation.JSONField) r9;
        if (r9 == 0) goto L_0x0512;
    L_0x04ed:
        r3 = r9.name();
        r5 = r3.length();
        if (r5 <= 0) goto L_0x0512;
    L_0x04f7:
        r2 = new com.alibaba.fastjson.c.a;
        r5 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 1;
        r6 = r18;
        r7 = r20;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        a(r14, r2);
        r0 = r18;
        r1 = r19;
        com.alibaba.fastjson.c.e.a(r0, r4, r1);
    L_0x050e:
        r2 = r13 + 1;
        r13 = r2;
        goto L_0x049a;
    L_0x0512:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = 3;
        r5 = r2.charAt(r5);
        r5 = java.lang.Character.toLowerCase(r5);
        r3 = r3.append(r5);
        r5 = 4;
        r2 = r2.substring(r5);
        r2 = r3.append(r2);
        r3 = r2.toString();
        goto L_0x04f7;
    L_0x0532:
        r2 = r14.size();
        r7 = new com.alibaba.fastjson.c.a[r2];
        r14.toArray(r7);
        r2 = r7.length;
        r8 = new com.alibaba.fastjson.c.a[r2];
        r2 = 0;
        r3 = 0;
        r4 = r7.length;
        java.lang.System.arraycopy(r7, r2, r8, r3, r4);
        java.util.Arrays.sort(r8);
        r2 = com.alibaba.fastjson.annotation.JSONType.class;
        r0 = r18;
        r9 = r0.getAnnotation(r2);
        r9 = (com.alibaba.fastjson.annotation.JSONType) r9;
        r2 = new com.alibaba.fastjson.a.g;
        r5 = 0;
        r6 = 0;
        r3 = r18;
        r4 = r12;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
        goto L_0x0114;
    L_0x055d:
        r3 = r4;
        goto L_0x0472;
    L_0x0560:
        r2 = r3;
        goto L_0x0447;
    L_0x0563:
        r9 = r2;
        goto L_0x0249;
    L_0x0566:
        r3 = r2;
        goto L_0x0376;
    L_0x0569:
        r10 = r4;
        goto L_0x013e;
    L_0x056c:
        r10 = r4;
        goto L_0x006f;
    L_0x056f:
        r12 = r3;
        goto L_0x0042;
    L_0x0572:
        r12 = r2;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.g.a(java.lang.Class, int, java.lang.reflect.Type, com.alibaba.fastjson.h):com.alibaba.fastjson.a.g");
    }
}
