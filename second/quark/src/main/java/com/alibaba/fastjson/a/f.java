package com.alibaba.fastjson.a;

import com.alibaba.fastjson.a.a.b;
import com.alibaba.fastjson.a.a.c;
import com.alibaba.fastjson.a.a.e;
import com.alibaba.fastjson.c.a;
import com.alibaba.fastjson.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class f implements e {
    public final g a;
    private final c[] b;
    private final c[] c;
    private final Class<?> d;

    public f(n nVar, Class<?> cls, Type type) {
        this(cls, g.a(cls, cls.getModifiers(), type, nVar.d));
    }

    private f(Class<?> cls, g gVar) {
        int i;
        int i2 = 0;
        this.d = cls;
        this.a = gVar;
        this.c = new c[gVar.f.length];
        int length = gVar.f.length;
        for (i = 0; i < length; i++) {
            this.c[i] = n.a((Class) cls, gVar.f[i]);
        }
        this.b = new c[gVar.e.length];
        i = gVar.e.length;
        while (i2 < i) {
            this.b[i2] = a(gVar.e[i2].a);
            i2++;
        }
    }

    protected final Object a(c cVar, Type type) {
        int i = 0;
        if ((type instanceof Class) && this.d.isInterface()) {
            Class cls = (Class) type;
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new com.alibaba.fastjson.e((cVar.e.c & e.OrderedField.q) != 0));
        } else if (this.a.a == null) {
            return null;
        } else {
            try {
                Object newInstance;
                Constructor constructor = this.a.a;
                if (this.a.b == 0) {
                    newInstance = constructor.newInstance(new Object[0]);
                } else {
                    newInstance = constructor.newInstance(new Object[]{cVar.f.a});
                }
                if (cVar == null || (cVar.e.c & e.InitStringFieldAsEmpty.q) == 0) {
                    return newInstance;
                }
                a[] aVarArr = this.a.e;
                int length = aVarArr.length;
                while (i < length) {
                    a aVar = aVarArr[i];
                    if (aVar.f == String.class) {
                        String str = "";
                        if (aVar.b != null) {
                            aVar.b.invoke(newInstance, new Object[]{str});
                        } else {
                            aVar.c.set(newInstance, str);
                        }
                    }
                    i++;
                }
                return newInstance;
            } catch (Throwable e) {
                throw new d("create instance error, class " + this.d.getName(), e);
            }
        }
    }

    public <T> T a(c cVar, Type type, Object obj) {
        return a(cVar, type, obj, null);
    }

    private <T> T b(c cVar, Type type, Object obj) {
        i iVar = cVar.e;
        T a = a(cVar, type);
        int length = this.c.length;
        int i = 0;
        while (i < length) {
            char c;
            int i2 = i == length + -1 ? 93 : 44;
            c cVar2 = this.c[i];
            a aVar = cVar2.b;
            Class cls = aVar.f;
            if (cls == Integer.TYPE) {
                i2 = (int) iVar.v();
                if (aVar.d) {
                    aVar.c.setInt(a, i2);
                } else {
                    cVar2.a(a, new Integer(i2));
                }
                if (iVar.d == ',') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        try {
                            c = iVar.o.charAt(i2);
                        } catch (Throwable e) {
                            throw new d("set " + aVar.a + "error", e);
                        }
                    }
                    iVar.d = c;
                    iVar.a = 16;
                } else if (iVar.d == ']') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 15;
                } else {
                    iVar.g();
                }
            } else if (cls == String.class) {
                if (iVar.d == '\"') {
                    r2 = iVar.l();
                } else if (iVar.d == 'n' && iVar.o.startsWith("null", iVar.e)) {
                    iVar.e += 4;
                    i2 = iVar.e;
                    if (iVar.e >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    r2 = null;
                } else {
                    throw new d("not match string. feild : " + obj);
                }
                if (aVar.d) {
                    aVar.c.set(a, r2);
                } else {
                    cVar2.a(a, r2);
                }
                if (iVar.d == ',') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 16;
                } else if (iVar.d == ']') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 15;
                } else {
                    iVar.g();
                }
            } else if (cls == Long.TYPE) {
                long v = iVar.v();
                if (aVar.d) {
                    aVar.c.setLong(a, v);
                } else {
                    cVar2.a(a, new Long(v));
                }
                if (iVar.d == ',') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 16;
                } else if (iVar.d == ']') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 15;
                } else {
                    iVar.g();
                }
            } else if (cls == Boolean.TYPE) {
                boolean t = iVar.t();
                if (aVar.d) {
                    aVar.c.setBoolean(a, t);
                } else {
                    cVar2.a(a, Boolean.valueOf(t));
                }
                if (iVar.d == ',') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 16;
                } else if (iVar.d == ']') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 15;
                } else {
                    iVar.g();
                }
            } else if (cls.isEnum()) {
                c = iVar.d;
                if (c == '\"') {
                    String a2 = iVar.a(cVar.a);
                    if (a2 == null) {
                        r2 = null;
                    } else {
                        r2 = Enum.valueOf(cls, a2);
                    }
                } else if (c < '0' || c > '9') {
                    throw new d("illegal enum." + iVar.j());
                } else {
                    r2 = ((d) ((a) cVar2).a(cVar.b)).a[(int) iVar.v()];
                }
                cVar2.a(a, r2);
                if (iVar.d == ',') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 16;
                } else if (iVar.d == ']') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 15;
                } else {
                    iVar.g();
                }
            } else if (cls == Date.class && iVar.d == '1') {
                cVar2.a(a, new Date(iVar.v()));
                if (iVar.d == ',') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 16;
                } else if (iVar.d == ']') {
                    i2 = iVar.e + 1;
                    iVar.e = i2;
                    if (i2 >= iVar.p) {
                        c = '\u001a';
                    } else {
                        c = iVar.o.charAt(i2);
                    }
                    iVar.d = c;
                    iVar.a = 15;
                } else {
                    iVar.g();
                }
            } else {
                int i3;
                char c2;
                if (iVar.d == '[') {
                    i3 = iVar.e + 1;
                    iVar.e = i3;
                    if (i3 >= iVar.p) {
                        c2 = '\u001a';
                    } else {
                        c2 = iVar.o.charAt(i3);
                    }
                    iVar.d = c2;
                    iVar.a = 14;
                } else if (iVar.d == '{') {
                    i3 = iVar.e + 1;
                    iVar.e = i3;
                    if (i3 >= iVar.p) {
                        c2 = '\u001a';
                    } else {
                        c2 = iVar.o.charAt(i3);
                    }
                    iVar.d = c2;
                    iVar.a = 12;
                } else {
                    iVar.g();
                }
                cVar2.a(cVar, a, aVar.g, null);
                if (i2 == 93) {
                    if (iVar.a != 15) {
                        throw new d("syntax error");
                    }
                } else if (i2 == 44 && iVar.a != 16) {
                    throw new d("syntax error");
                }
            }
            i++;
        }
        if (iVar.d == ',') {
            i2 = iVar.e + 1;
            iVar.e = i2;
            if (i2 >= iVar.p) {
                c = '\u001a';
            } else {
                c = iVar.o.charAt(i2);
            }
            iVar.d = c;
            iVar.a = 16;
        } else {
            iVar.g();
        }
        return a;
    }

    private <T> T a(com.alibaba.fastjson.a.c r28, java.lang.reflect.Type r29, java.lang.Object r30, java.lang.Object r31) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.alibaba.fastjson.a.f.a(com.alibaba.fastjson.a.c, java.lang.reflect.Type, java.lang.Object, java.lang.Object):T. bs: [B:82:0x016a, B:352:0x06b8, B:366:0x06fb]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r27 = this;
        r4 = com.alibaba.fastjson.a.class;
        r0 = r29;
        if (r0 == r4) goto L_0x000c;
    L_0x0006:
        r4 = com.alibaba.fastjson.e.class;
        r0 = r29;
        if (r0 != r4) goto L_0x0014;
    L_0x000c:
        r4 = 0;
        r0 = r28;
        r5 = r0.a(r4);
    L_0x0013:
        return r5;
    L_0x0014:
        r0 = r28;
        r0 = r0.e;
        r23 = r0;
        r0 = r23;
        r6 = r0.a;
        r4 = 8;
        if (r6 != r4) goto L_0x002b;
    L_0x0022:
        r4 = 16;
        r0 = r23;
        r0.a(r4);
        r5 = 0;
        goto L_0x0013;
    L_0x002b:
        r0 = r23;
        r0 = r0.r;
        r24 = r0;
        r0 = r28;
        r11 = r0.f;
        r5 = 0;
        r9 = 0;
        r4 = 13;
        if (r6 != r4) goto L_0x004c;
    L_0x003b:
        r4 = 16;
        r0 = r23;	 Catch:{ all -> 0x00c9 }
        r0.a(r4);	 Catch:{ all -> 0x00c9 }
        r5 = r27.a(r28, r29);	 Catch:{ all -> 0x00c9 }
        r0 = r28;
        r0.a(r11);
        goto L_0x0013;
    L_0x004c:
        r4 = 14;
        if (r6 != r4) goto L_0x0072;
    L_0x0050:
        r0 = r27;	 Catch:{ all -> 0x00c9 }
        r4 = r0.a;	 Catch:{ all -> 0x00c9 }
        r4 = r4.i;	 Catch:{ all -> 0x00c9 }
        if (r4 != 0) goto L_0x0063;	 Catch:{ all -> 0x00c9 }
    L_0x0058:
        r0 = r23;	 Catch:{ all -> 0x00c9 }
        r4 = r0.c;	 Catch:{ all -> 0x00c9 }
        r7 = com.alibaba.fastjson.a.e.SupportArrayToBean;	 Catch:{ all -> 0x00c9 }
        r7 = r7.q;	 Catch:{ all -> 0x00c9 }
        r4 = r4 & r7;	 Catch:{ all -> 0x00c9 }
        if (r4 == 0) goto L_0x0070;	 Catch:{ all -> 0x00c9 }
    L_0x0063:
        r4 = 1;	 Catch:{ all -> 0x00c9 }
    L_0x0064:
        if (r4 == 0) goto L_0x0072;	 Catch:{ all -> 0x00c9 }
    L_0x0066:
        r5 = r27.b(r28, r29, r30);	 Catch:{ all -> 0x00c9 }
        r0 = r28;
        r0.a(r11);
        goto L_0x0013;
    L_0x0070:
        r4 = 0;
        goto L_0x0064;
    L_0x0072:
        r4 = 12;
        if (r6 == r4) goto L_0x00d6;
    L_0x0076:
        r4 = 16;
        if (r6 == r4) goto L_0x00d6;
    L_0x007a:
        r4 = r23.q();	 Catch:{ all -> 0x00c9 }
        if (r4 == 0) goto L_0x0087;
    L_0x0080:
        r0 = r28;
        r0.a(r11);
        r5 = 0;
        goto L_0x0013;
    L_0x0087:
        r4 = 4;
        if (r6 != r4) goto L_0x009f;
    L_0x008a:
        r4 = r23.p();	 Catch:{ all -> 0x00c9 }
        r4 = r4.length();	 Catch:{ all -> 0x00c9 }
        if (r4 != 0) goto L_0x009f;	 Catch:{ all -> 0x00c9 }
    L_0x0094:
        r23.g();	 Catch:{ all -> 0x00c9 }
        r0 = r28;
        r0.a(r11);
        r5 = 0;
        goto L_0x0013;
    L_0x009f:
        r4 = new java.lang.StringBuffer;	 Catch:{ all -> 0x00c9 }
        r6 = "syntax error, expect {, actual ";	 Catch:{ all -> 0x00c9 }
        r4.<init>(r6);	 Catch:{ all -> 0x00c9 }
        r6 = r23.j();	 Catch:{ all -> 0x00c9 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x00c9 }
        r0 = r30;	 Catch:{ all -> 0x00c9 }
        r6 = r0 instanceof java.lang.String;	 Catch:{ all -> 0x00c9 }
        if (r6 == 0) goto L_0x00bf;	 Catch:{ all -> 0x00c9 }
    L_0x00b4:
        r6 = ", fieldName ";	 Catch:{ all -> 0x00c9 }
        r6 = r4.append(r6);	 Catch:{ all -> 0x00c9 }
        r0 = r30;	 Catch:{ all -> 0x00c9 }
        r6.append(r0);	 Catch:{ all -> 0x00c9 }
    L_0x00bf:
        r6 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x00c9 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c9 }
        r6.<init>(r4);	 Catch:{ all -> 0x00c9 }
        throw r6;	 Catch:{ all -> 0x00c9 }
    L_0x00c9:
        r4 = move-exception;
        r7 = r31;
    L_0x00cc:
        if (r5 == 0) goto L_0x00d0;
    L_0x00ce:
        r5.a = r7;
    L_0x00d0:
        r0 = r28;
        r0.a(r11);
        throw r4;
    L_0x00d6:
        r0 = r28;	 Catch:{ all -> 0x00c9 }
        r4 = r0.g;	 Catch:{ all -> 0x00c9 }
        r6 = 2;	 Catch:{ all -> 0x00c9 }
        if (r4 != r6) goto L_0x00e2;	 Catch:{ all -> 0x00c9 }
    L_0x00dd:
        r4 = 0;	 Catch:{ all -> 0x00c9 }
        r0 = r28;	 Catch:{ all -> 0x00c9 }
        r0.g = r4;	 Catch:{ all -> 0x00c9 }
    L_0x00e2:
        r4 = 0;	 Catch:{ all -> 0x00c9 }
        r0 = r27;	 Catch:{ all -> 0x00c9 }
        r6 = r0.c;	 Catch:{ all -> 0x00c9 }
        r0 = r6.length;	 Catch:{ all -> 0x00c9 }
        r25 = r0;	 Catch:{ all -> 0x00c9 }
        r22 = r4;
        r7 = r31;
    L_0x00ee:
        r6 = 0;
        r10 = 0;
        r8 = 0;
        r4 = 0;
        r0 = r22;
        r1 = r25;
        if (r0 >= r1) goto L_0x0745;
    L_0x00f8:
        r0 = r27;	 Catch:{ all -> 0x03fc }
        r4 = r0.c;	 Catch:{ all -> 0x03fc }
        r10 = r4[r22];	 Catch:{ all -> 0x03fc }
        r8 = r10.b;	 Catch:{ all -> 0x03fc }
        r4 = r8.f;	 Catch:{ all -> 0x03fc }
        r19 = r4;	 Catch:{ all -> 0x03fc }
        r20 = r8;	 Catch:{ all -> 0x03fc }
        r21 = r10;	 Catch:{ all -> 0x03fc }
    L_0x0108:
        r17 = 0;	 Catch:{ all -> 0x03fc }
        r16 = 0;	 Catch:{ all -> 0x03fc }
        r10 = 0;	 Catch:{ all -> 0x03fc }
        r8 = 0;	 Catch:{ all -> 0x03fc }
        r14 = 0;	 Catch:{ all -> 0x03fc }
        r4 = 0;	 Catch:{ all -> 0x03fc }
        r12 = 0;	 Catch:{ all -> 0x03fc }
        if (r21 == 0) goto L_0x072d;	 Catch:{ all -> 0x03fc }
    L_0x0115:
        r0 = r20;	 Catch:{ all -> 0x03fc }
        r0 = r0.j;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = java.lang.Integer.TYPE;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 == r1) goto L_0x012b;	 Catch:{ all -> 0x03fc }
    L_0x0123:
        r26 = java.lang.Integer.class;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x0199;	 Catch:{ all -> 0x03fc }
    L_0x012b:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r8 = r0.b(r1);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        if (r18 <= 0) goto L_0x0183;	 Catch:{ all -> 0x03fc }
    L_0x013b:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
    L_0x0145:
        if (r18 != 0) goto L_0x04ab;	 Catch:{ all -> 0x03fc }
    L_0x0147:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r6 = r0.a;	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r6 = r0.a(r6);	 Catch:{ all -> 0x03fc }
        if (r6 != 0) goto L_0x034d;	 Catch:{ all -> 0x03fc }
    L_0x0153:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r10 = r0.a;	 Catch:{ all -> 0x03fc }
        r26 = 13;	 Catch:{ all -> 0x03fc }
        r0 = r26;	 Catch:{ all -> 0x03fc }
        if (r10 != r0) goto L_0x0337;	 Catch:{ all -> 0x03fc }
    L_0x015d:
        r4 = 16;	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0.a(r4);	 Catch:{ all -> 0x03fc }
        r4 = r5;
        r5 = r7;
    L_0x0166:
        if (r5 != 0) goto L_0x06c2;
    L_0x0168:
        if (r9 != 0) goto L_0x0693;
    L_0x016a:
        r5 = r27.a(r28, r29);	 Catch:{ all -> 0x06ed }
        if (r4 != 0) goto L_0x0178;	 Catch:{ all -> 0x06ed }
    L_0x0170:
        r0 = r28;	 Catch:{ all -> 0x06ed }
        r1 = r30;	 Catch:{ all -> 0x06ed }
        r4 = r0.a(r11, r5, r1);	 Catch:{ all -> 0x06ed }
    L_0x0178:
        if (r4 == 0) goto L_0x017c;
    L_0x017a:
        r4.a = r5;
    L_0x017c:
        r0 = r28;
        r0.a(r11);
        goto L_0x0013;
    L_0x0183:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x072d;	 Catch:{ all -> 0x03fc }
    L_0x0191:
        r4 = r5;	 Catch:{ all -> 0x03fc }
    L_0x0192:
        r5 = r22 + 1;	 Catch:{ all -> 0x03fc }
        r22 = r5;	 Catch:{ all -> 0x03fc }
        r5 = r4;	 Catch:{ all -> 0x03fc }
        goto L_0x00ee;	 Catch:{ all -> 0x03fc }
    L_0x0199:
        r26 = java.lang.Long.TYPE;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 == r1) goto L_0x01a9;	 Catch:{ all -> 0x03fc }
    L_0x01a1:
        r26 = java.lang.Long.class;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x01d4;	 Catch:{ all -> 0x03fc }
    L_0x01a9:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r14 = r0.c(r1);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        if (r18 <= 0) goto L_0x01c4;	 Catch:{ all -> 0x03fc }
    L_0x01b9:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x01c4:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x072d;	 Catch:{ all -> 0x03fc }
    L_0x01d2:
        r4 = r5;	 Catch:{ all -> 0x03fc }
        goto L_0x0192;	 Catch:{ all -> 0x03fc }
    L_0x01d4:
        r26 = java.lang.String.class;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x0208;	 Catch:{ all -> 0x03fc }
    L_0x01dc:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r10 = r0.d(r1);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        if (r18 <= 0) goto L_0x01f8;	 Catch:{ all -> 0x03fc }
    L_0x01ec:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x01f8:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x073d;	 Catch:{ all -> 0x03fc }
    L_0x0206:
        r4 = r5;	 Catch:{ all -> 0x03fc }
        goto L_0x0192;	 Catch:{ all -> 0x03fc }
    L_0x0208:
        r26 = java.lang.Boolean.TYPE;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 == r1) goto L_0x0218;	 Catch:{ all -> 0x03fc }
    L_0x0210:
        r26 = java.lang.Boolean.class;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x0249;	 Catch:{ all -> 0x03fc }
    L_0x0218:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r10 = r0.e(r1);	 Catch:{ all -> 0x03fc }
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        if (r18 <= 0) goto L_0x0238;	 Catch:{ all -> 0x03fc }
    L_0x022c:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x0238:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x0735;	 Catch:{ all -> 0x03fc }
    L_0x0246:
        r4 = r5;	 Catch:{ all -> 0x03fc }
        goto L_0x0192;	 Catch:{ all -> 0x03fc }
    L_0x0249:
        r26 = java.lang.Float.TYPE;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 == r1) goto L_0x0259;	 Catch:{ all -> 0x03fc }
    L_0x0251:
        r26 = java.lang.Float.class;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x0286;	 Catch:{ all -> 0x03fc }
    L_0x0259:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r4 = r0.f(r1);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        if (r18 <= 0) goto L_0x0275;	 Catch:{ all -> 0x03fc }
    L_0x0269:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x0275:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x072d;	 Catch:{ all -> 0x03fc }
    L_0x0283:
        r4 = r5;	 Catch:{ all -> 0x03fc }
        goto L_0x0192;	 Catch:{ all -> 0x03fc }
    L_0x0286:
        r26 = java.lang.Double.TYPE;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 == r1) goto L_0x0296;	 Catch:{ all -> 0x03fc }
    L_0x028e:
        r26 = java.lang.Double.class;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x02c3;	 Catch:{ all -> 0x03fc }
    L_0x0296:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r12 = r0.g(r1);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        if (r18 <= 0) goto L_0x02b2;	 Catch:{ all -> 0x03fc }
    L_0x02a6:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x02b2:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 != r1) goto L_0x072d;	 Catch:{ all -> 0x03fc }
    L_0x02c0:
        r4 = r5;	 Catch:{ all -> 0x03fc }
        goto L_0x0192;	 Catch:{ all -> 0x03fc }
    L_0x02c3:
        r0 = r20;	 Catch:{ all -> 0x03fc }
        r0 = r0.k;	 Catch:{ all -> 0x03fc }
        r26 = r0;	 Catch:{ all -> 0x03fc }
        if (r26 == 0) goto L_0x0323;	 Catch:{ all -> 0x03fc }
    L_0x02cb:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0 = r0.b;	 Catch:{ all -> 0x03fc }
        r26 = r0;	 Catch:{ all -> 0x03fc }
        r0 = r26;	 Catch:{ all -> 0x03fc }
        r1 = r19;	 Catch:{ all -> 0x03fc }
        r26 = r0.a(r1);	 Catch:{ all -> 0x03fc }
        r0 = r26;	 Catch:{ all -> 0x03fc }
        r0 = r0 instanceof com.alibaba.fastjson.a.d;	 Catch:{ all -> 0x03fc }
        r26 = r0;	 Catch:{ all -> 0x03fc }
        if (r26 == 0) goto L_0x0323;	 Catch:{ all -> 0x03fc }
    L_0x02e1:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0 = r0.a;	 Catch:{ all -> 0x03fc }
        r26 = r0;	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r2 = r26;	 Catch:{ all -> 0x03fc }
        r18 = r0.a(r1, r2);	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r26 = r0;	 Catch:{ all -> 0x03fc }
        if (r26 <= 0) goto L_0x030d;	 Catch:{ all -> 0x03fc }
    L_0x02f9:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r16 = 1;	 Catch:{ all -> 0x03fc }
        r0 = r19;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r10 = java.lang.Enum.valueOf(r0, r1);	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x030d:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0 = r0.n;	 Catch:{ all -> 0x03fc }
        r18 = r0;	 Catch:{ all -> 0x03fc }
        r26 = -2;	 Catch:{ all -> 0x03fc }
        r0 = r18;	 Catch:{ all -> 0x03fc }
        r1 = r26;	 Catch:{ all -> 0x03fc }
        if (r0 == r1) goto L_0x072a;	 Catch:{ all -> 0x03fc }
    L_0x031b:
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x0323:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r1 = r18;	 Catch:{ all -> 0x03fc }
        r17 = r0.a(r1);	 Catch:{ all -> 0x03fc }
        if (r17 == 0) goto L_0x072a;	 Catch:{ all -> 0x03fc }
    L_0x032d:
        r17 = 1;	 Catch:{ all -> 0x03fc }
        r18 = r17;	 Catch:{ all -> 0x03fc }
        r17 = r16;	 Catch:{ all -> 0x03fc }
        r16 = r10;	 Catch:{ all -> 0x03fc }
        goto L_0x0145;	 Catch:{ all -> 0x03fc }
    L_0x0337:
        r26 = 16;	 Catch:{ all -> 0x03fc }
        r0 = r26;	 Catch:{ all -> 0x03fc }
        if (r10 != r0) goto L_0x034d;	 Catch:{ all -> 0x03fc }
    L_0x033d:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r10 = r0.c;	 Catch:{ all -> 0x03fc }
        r26 = com.alibaba.fastjson.a.e.AllowArbitraryCommas;	 Catch:{ all -> 0x03fc }
        r0 = r26;	 Catch:{ all -> 0x03fc }
        r0 = r0.q;	 Catch:{ all -> 0x03fc }
        r26 = r0;	 Catch:{ all -> 0x03fc }
        r10 = r10 & r26;	 Catch:{ all -> 0x03fc }
        if (r10 != 0) goto L_0x072a;	 Catch:{ all -> 0x03fc }
    L_0x034d:
        r10 = "$ref";	 Catch:{ all -> 0x03fc }
        if (r10 != r6) goto L_0x0419;	 Catch:{ all -> 0x03fc }
    L_0x0351:
        r23.d();	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r4 = r0.a;	 Catch:{ all -> 0x03fc }
        r6 = 4;	 Catch:{ all -> 0x03fc }
        if (r4 != r6) goto L_0x03e3;	 Catch:{ all -> 0x03fc }
    L_0x035b:
        r6 = r23.p();	 Catch:{ all -> 0x03fc }
        r4 = "@";	 Catch:{ all -> 0x03fc }
        r4 = r4.equals(r6);	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x0386;	 Catch:{ all -> 0x03fc }
    L_0x0367:
        r7 = r11.a;	 Catch:{ all -> 0x03fc }
        r4 = r7;
    L_0x036a:
        r6 = 13;
        r0 = r23;	 Catch:{ all -> 0x0381 }
        r0.a(r6);	 Catch:{ all -> 0x0381 }
        r0 = r23;	 Catch:{ all -> 0x0381 }
        r6 = r0.a;	 Catch:{ all -> 0x0381 }
        r7 = 13;	 Catch:{ all -> 0x0381 }
        if (r6 == r7) goto L_0x03ff;	 Catch:{ all -> 0x0381 }
    L_0x0379:
        r6 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x0381 }
        r7 = "illegal ref";	 Catch:{ all -> 0x0381 }
        r6.<init>(r7);	 Catch:{ all -> 0x0381 }
        throw r6;	 Catch:{ all -> 0x0381 }
    L_0x0381:
        r6 = move-exception;
        r7 = r4;
        r4 = r6;
        goto L_0x00cc;
    L_0x0386:
        r4 = "..";	 Catch:{ all -> 0x03fc }
        r4 = r4.equals(r6);	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x03a9;	 Catch:{ all -> 0x03fc }
    L_0x038e:
        r4 = r11.b;	 Catch:{ all -> 0x03fc }
        r8 = r4.a;	 Catch:{ all -> 0x03fc }
        if (r8 == 0) goto L_0x0398;	 Catch:{ all -> 0x03fc }
    L_0x0394:
        r7 = r4.a;	 Catch:{ all -> 0x03fc }
        r4 = r7;	 Catch:{ all -> 0x03fc }
        goto L_0x036a;	 Catch:{ all -> 0x03fc }
    L_0x0398:
        r8 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x03fc }
        r8.<init>(r4, r6);	 Catch:{ all -> 0x03fc }
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0.a(r8);	 Catch:{ all -> 0x03fc }
        r4 = 1;	 Catch:{ all -> 0x03fc }
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0.g = r4;	 Catch:{ all -> 0x03fc }
        r4 = r7;	 Catch:{ all -> 0x03fc }
        goto L_0x036a;	 Catch:{ all -> 0x03fc }
    L_0x03a9:
        r4 = "$";	 Catch:{ all -> 0x03fc }
        r4 = r4.equals(r6);	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x03d2;	 Catch:{ all -> 0x03fc }
    L_0x03b1:
        r4 = r11;	 Catch:{ all -> 0x03fc }
    L_0x03b2:
        r8 = r4.b;	 Catch:{ all -> 0x03fc }
        if (r8 == 0) goto L_0x03b9;	 Catch:{ all -> 0x03fc }
    L_0x03b6:
        r4 = r4.b;	 Catch:{ all -> 0x03fc }
        goto L_0x03b2;	 Catch:{ all -> 0x03fc }
    L_0x03b9:
        r8 = r4.a;	 Catch:{ all -> 0x03fc }
        if (r8 == 0) goto L_0x03c1;	 Catch:{ all -> 0x03fc }
    L_0x03bd:
        r7 = r4.a;	 Catch:{ all -> 0x03fc }
        r4 = r7;	 Catch:{ all -> 0x03fc }
        goto L_0x036a;	 Catch:{ all -> 0x03fc }
    L_0x03c1:
        r8 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x03fc }
        r8.<init>(r4, r6);	 Catch:{ all -> 0x03fc }
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0.a(r8);	 Catch:{ all -> 0x03fc }
        r4 = 1;	 Catch:{ all -> 0x03fc }
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0.g = r4;	 Catch:{ all -> 0x03fc }
        r4 = r7;	 Catch:{ all -> 0x03fc }
        goto L_0x036a;	 Catch:{ all -> 0x03fc }
    L_0x03d2:
        r4 = new com.alibaba.fastjson.a.b;	 Catch:{ all -> 0x03fc }
        r4.<init>(r11, r6);	 Catch:{ all -> 0x03fc }
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0.a(r4);	 Catch:{ all -> 0x03fc }
        r4 = 1;	 Catch:{ all -> 0x03fc }
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r0.g = r4;	 Catch:{ all -> 0x03fc }
        r4 = r7;	 Catch:{ all -> 0x03fc }
        goto L_0x036a;	 Catch:{ all -> 0x03fc }
    L_0x03e3:
        r6 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x03fc }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x03fc }
        r9 = "illegal ref, ";	 Catch:{ all -> 0x03fc }
        r8.<init>(r9);	 Catch:{ all -> 0x03fc }
        r4 = com.alibaba.fastjson.a.j.a(r4);	 Catch:{ all -> 0x03fc }
        r4 = r8.append(r4);	 Catch:{ all -> 0x03fc }
        r4 = r4.toString();	 Catch:{ all -> 0x03fc }
        r6.<init>(r4);	 Catch:{ all -> 0x03fc }
        throw r6;	 Catch:{ all -> 0x03fc }
    L_0x03fc:
        r4 = move-exception;
        goto L_0x00cc;
    L_0x03ff:
        r6 = 16;
        r0 = r23;	 Catch:{ all -> 0x0381 }
        r0.a(r6);	 Catch:{ all -> 0x0381 }
        r0 = r28;	 Catch:{ all -> 0x0381 }
        r1 = r30;	 Catch:{ all -> 0x0381 }
        r0.a(r11, r4, r1);	 Catch:{ all -> 0x0381 }
        if (r5 == 0) goto L_0x0411;
    L_0x040f:
        r5.a = r4;
    L_0x0411:
        r0 = r28;
        r0.a(r11);
        r5 = r4;
        goto L_0x0013;
    L_0x0419:
        r10 = "@type";	 Catch:{ all -> 0x03fc }
        if (r10 != r6) goto L_0x04ab;	 Catch:{ all -> 0x03fc }
    L_0x041d:
        r23.d();	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r4 = r0.a;	 Catch:{ all -> 0x03fc }
        r6 = 4;	 Catch:{ all -> 0x03fc }
        if (r4 != r6) goto L_0x04a3;	 Catch:{ all -> 0x03fc }
    L_0x0427:
        r8 = r23.p();	 Catch:{ all -> 0x03fc }
        r4 = 16;	 Catch:{ all -> 0x03fc }
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r0.a(r4);	 Catch:{ all -> 0x03fc }
        r0 = r29;	 Catch:{ all -> 0x03fc }
        r4 = r0 instanceof java.lang.Class;	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x0456;	 Catch:{ all -> 0x03fc }
    L_0x0438:
        r0 = r29;	 Catch:{ all -> 0x03fc }
        r0 = (java.lang.Class) r0;	 Catch:{ all -> 0x03fc }
        r4 = r0;	 Catch:{ all -> 0x03fc }
        r4 = r4.getName();	 Catch:{ all -> 0x03fc }
        r4 = r8.equals(r4);	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x0456;	 Catch:{ all -> 0x03fc }
    L_0x0447:
        r0 = r23;	 Catch:{ all -> 0x03fc }
        r4 = r0.a;	 Catch:{ all -> 0x03fc }
        r6 = 13;	 Catch:{ all -> 0x03fc }
        if (r4 != r6) goto L_0x072a;	 Catch:{ all -> 0x03fc }
    L_0x044f:
        r23.g();	 Catch:{ all -> 0x03fc }
        r4 = r5;	 Catch:{ all -> 0x03fc }
        r5 = r7;	 Catch:{ all -> 0x03fc }
        goto L_0x0166;	 Catch:{ all -> 0x03fc }
    L_0x0456:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r4 = r0.b;	 Catch:{ all -> 0x03fc }
        r0 = r27;	 Catch:{ all -> 0x03fc }
        r6 = r0.a;	 Catch:{ all -> 0x03fc }
        r0 = r27;	 Catch:{ all -> 0x03fc }
        r4 = r0.a(r4, r6, r8);	 Catch:{ all -> 0x03fc }
        r6 = 0;	 Catch:{ all -> 0x03fc }
        if (r4 != 0) goto L_0x0487;	 Catch:{ all -> 0x03fc }
    L_0x0467:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r4 = r0.b;	 Catch:{ all -> 0x03fc }
        r4 = r4.c;	 Catch:{ all -> 0x03fc }
        r6 = com.alibaba.fastjson.c.e.a(r8, r4);	 Catch:{ all -> 0x03fc }
        r4 = com.alibaba.fastjson.c.e.c(r29);	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x047f;	 Catch:{ all -> 0x03fc }
    L_0x0477:
        if (r6 == 0) goto L_0x049b;	 Catch:{ all -> 0x03fc }
    L_0x0479:
        r4 = r4.isAssignableFrom(r6);	 Catch:{ all -> 0x03fc }
        if (r4 == 0) goto L_0x049b;	 Catch:{ all -> 0x03fc }
    L_0x047f:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r4 = r0.b;	 Catch:{ all -> 0x03fc }
        r4 = r4.a(r6);	 Catch:{ all -> 0x03fc }
    L_0x0487:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r1 = r30;	 Catch:{ all -> 0x03fc }
        r4 = r4.a(r0, r6, r1);	 Catch:{ all -> 0x03fc }
        if (r5 == 0) goto L_0x0493;
    L_0x0491:
        r5.a = r7;
    L_0x0493:
        r0 = r28;
        r0.a(r11);
        r5 = r4;
        goto L_0x0013;
    L_0x049b:
        r4 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x03fc }
        r6 = "type not match";	 Catch:{ all -> 0x03fc }
        r4.<init>(r6);	 Catch:{ all -> 0x03fc }
        throw r4;	 Catch:{ all -> 0x03fc }
    L_0x04a3:
        r4 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x03fc }
        r6 = "syntax error";	 Catch:{ all -> 0x03fc }
        r4.<init>(r6);	 Catch:{ all -> 0x03fc }
        throw r4;	 Catch:{ all -> 0x03fc }
    L_0x04ab:
        if (r7 != 0) goto L_0x0727;	 Catch:{ all -> 0x03fc }
    L_0x04ad:
        if (r9 != 0) goto L_0x0727;	 Catch:{ all -> 0x03fc }
    L_0x04af:
        r7 = r27.a(r28, r29);	 Catch:{ all -> 0x03fc }
        if (r7 != 0) goto L_0x04bf;	 Catch:{ all -> 0x03fc }
    L_0x04b5:
        r9 = new java.util.HashMap;	 Catch:{ all -> 0x03fc }
        r0 = r27;	 Catch:{ all -> 0x03fc }
        r10 = r0.b;	 Catch:{ all -> 0x03fc }
        r10 = r10.length;	 Catch:{ all -> 0x03fc }
        r9.<init>(r10);	 Catch:{ all -> 0x03fc }
    L_0x04bf:
        if (r24 != 0) goto L_0x0727;	 Catch:{ all -> 0x03fc }
    L_0x04c1:
        r0 = r28;	 Catch:{ all -> 0x03fc }
        r1 = r30;	 Catch:{ all -> 0x03fc }
        r5 = r0.a(r11, r7, r1);	 Catch:{ all -> 0x03fc }
        r10 = r5;
    L_0x04ca:
        if (r18 == 0) goto L_0x063c;
    L_0x04cc:
        if (r17 != 0) goto L_0x04f2;
    L_0x04ce:
        r0 = r21;	 Catch:{ all -> 0x053d }
        r1 = r28;	 Catch:{ all -> 0x053d }
        r2 = r29;	 Catch:{ all -> 0x053d }
        r0.a(r1, r7, r2, r9);	 Catch:{ all -> 0x053d }
    L_0x04d7:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r5 = 16;	 Catch:{ all -> 0x053d }
        if (r4 == r5) goto L_0x074d;	 Catch:{ all -> 0x053d }
    L_0x04df:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r5 = 13;	 Catch:{ all -> 0x053d }
        if (r4 != r5) goto L_0x0667;	 Catch:{ all -> 0x053d }
    L_0x04e7:
        r4 = 16;	 Catch:{ all -> 0x053d }
        r0 = r23;	 Catch:{ all -> 0x053d }
        r0.a(r4);	 Catch:{ all -> 0x053d }
        r4 = r10;	 Catch:{ all -> 0x053d }
        r5 = r7;	 Catch:{ all -> 0x053d }
        goto L_0x0166;	 Catch:{ all -> 0x053d }
    L_0x04f2:
        if (r7 != 0) goto L_0x0555;	 Catch:{ all -> 0x053d }
    L_0x04f4:
        r5 = java.lang.Integer.TYPE;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 == r5) goto L_0x0500;	 Catch:{ all -> 0x053d }
    L_0x04fa:
        r5 = java.lang.Integer.class;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 != r5) goto L_0x0518;	 Catch:{ all -> 0x053d }
    L_0x0500:
        r16 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x053d }
    L_0x0504:
        r0 = r20;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r0 = r16;	 Catch:{ all -> 0x053d }
        r9.put(r4, r0);	 Catch:{ all -> 0x053d }
    L_0x050d:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.n;	 Catch:{ all -> 0x053d }
        r5 = 4;	 Catch:{ all -> 0x053d }
        if (r4 != r5) goto L_0x04d7;	 Catch:{ all -> 0x053d }
    L_0x0514:
        r4 = r10;	 Catch:{ all -> 0x053d }
        r5 = r7;	 Catch:{ all -> 0x053d }
        goto L_0x0166;	 Catch:{ all -> 0x053d }
    L_0x0518:
        r5 = java.lang.Long.TYPE;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 == r5) goto L_0x0524;	 Catch:{ all -> 0x053d }
    L_0x051e:
        r5 = java.lang.Long.class;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 != r5) goto L_0x0529;	 Catch:{ all -> 0x053d }
    L_0x0524:
        r16 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x053d }
        goto L_0x0504;	 Catch:{ all -> 0x053d }
    L_0x0529:
        r5 = java.lang.Float.TYPE;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 == r5) goto L_0x0535;	 Catch:{ all -> 0x053d }
    L_0x052f:
        r5 = java.lang.Float.class;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 != r5) goto L_0x0541;	 Catch:{ all -> 0x053d }
    L_0x0535:
        r16 = new java.lang.Float;	 Catch:{ all -> 0x053d }
        r0 = r16;	 Catch:{ all -> 0x053d }
        r0.<init>(r4);	 Catch:{ all -> 0x053d }
        goto L_0x0504;	 Catch:{ all -> 0x053d }
    L_0x053d:
        r4 = move-exception;	 Catch:{ all -> 0x053d }
        r5 = r10;	 Catch:{ all -> 0x053d }
        goto L_0x00cc;	 Catch:{ all -> 0x053d }
    L_0x0541:
        r4 = java.lang.Double.TYPE;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 == r4) goto L_0x054d;	 Catch:{ all -> 0x053d }
    L_0x0547:
        r4 = java.lang.Double.class;	 Catch:{ all -> 0x053d }
        r0 = r19;	 Catch:{ all -> 0x053d }
        if (r0 != r4) goto L_0x0504;	 Catch:{ all -> 0x053d }
    L_0x054d:
        r16 = new java.lang.Double;	 Catch:{ all -> 0x053d }
        r0 = r16;	 Catch:{ all -> 0x053d }
        r0.<init>(r12);	 Catch:{ all -> 0x053d }
        goto L_0x0504;
    L_0x0555:
        if (r16 != 0) goto L_0x0633;
    L_0x0557:
        r5 = java.lang.Integer.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 == r5) goto L_0x0563;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x055d:
        r5 = java.lang.Integer.class;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r5) goto L_0x059e;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x0563:
        r0 = r20;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r0.d;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r4 == 0) goto L_0x0593;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x0569:
        r4 = java.lang.Integer.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r4) goto L_0x0593;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x056f:
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r0.b;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r4.c;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4.setInt(r7, r8);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;
    L_0x0579:
        r4 = move-exception;
        r5 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x053d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x053d }
        r8 = "set property error, ";	 Catch:{ all -> 0x053d }
        r6.<init>(r8);	 Catch:{ all -> 0x053d }
        r0 = r20;	 Catch:{ all -> 0x053d }
        r8 = r0.a;	 Catch:{ all -> 0x053d }
        r6 = r6.append(r8);	 Catch:{ all -> 0x053d }
        r6 = r6.toString();	 Catch:{ all -> 0x053d }
        r5.<init>(r6, r4);	 Catch:{ all -> 0x053d }
        throw r5;	 Catch:{ all -> 0x053d }
    L_0x0593:
        r4 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0.a(r7, r4);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x059e:
        r5 = java.lang.Long.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 == r5) goto L_0x05aa;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05a4:
        r5 = java.lang.Long.class;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r5) goto L_0x05cc;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05aa:
        r0 = r20;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r0.d;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r4 == 0) goto L_0x05c1;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05b0:
        r4 = java.lang.Long.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r4) goto L_0x05c1;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05b6:
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r0.b;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r4.c;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4.setLong(r7, r14);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05c1:
        r4 = java.lang.Long.valueOf(r14);	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0.a(r7, r4);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05cc:
        r5 = java.lang.Float.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 == r5) goto L_0x05d8;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05d2:
        r5 = java.lang.Float.class;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r5) goto L_0x05fb;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05d8:
        r0 = r20;	 Catch:{ IllegalAccessException -> 0x0579 }
        r5 = r0.d;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r5 == 0) goto L_0x05ef;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05de:
        r5 = java.lang.Float.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r5) goto L_0x05ef;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05e4:
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r5 = r0.b;	 Catch:{ IllegalAccessException -> 0x0579 }
        r5 = r5.c;	 Catch:{ IllegalAccessException -> 0x0579 }
        r5.setFloat(r7, r4);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05ef:
        r5 = new java.lang.Float;	 Catch:{ IllegalAccessException -> 0x0579 }
        r5.<init>(r4);	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0.a(r7, r5);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x05fb:
        r4 = java.lang.Double.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 == r4) goto L_0x0607;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x0601:
        r4 = java.lang.Double.class;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r4) goto L_0x062a;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x0607:
        r0 = r20;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r0.d;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r4 == 0) goto L_0x061e;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x060d:
        r4 = java.lang.Double.TYPE;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r19;	 Catch:{ IllegalAccessException -> 0x0579 }
        if (r0 != r4) goto L_0x061e;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x0613:
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r0.b;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4 = r4.c;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4.setDouble(r7, r12);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x061e:
        r4 = new java.lang.Double;	 Catch:{ IllegalAccessException -> 0x0579 }
        r4.<init>(r12);	 Catch:{ IllegalAccessException -> 0x0579 }
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0.a(r7, r4);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;	 Catch:{ IllegalAccessException -> 0x0579 }
    L_0x062a:
        r0 = r21;	 Catch:{ IllegalAccessException -> 0x0579 }
        r1 = r16;	 Catch:{ IllegalAccessException -> 0x0579 }
        r0.a(r7, r1);	 Catch:{ IllegalAccessException -> 0x0579 }
        goto L_0x050d;
    L_0x0633:
        r0 = r21;	 Catch:{ all -> 0x053d }
        r1 = r16;	 Catch:{ all -> 0x053d }
        r0.a(r7, r1);	 Catch:{ all -> 0x053d }
        goto L_0x050d;	 Catch:{ all -> 0x053d }
    L_0x063c:
        r4 = r27;	 Catch:{ all -> 0x053d }
        r5 = r28;	 Catch:{ all -> 0x053d }
        r8 = r29;	 Catch:{ all -> 0x053d }
        r4 = r4.a(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x053d }
        if (r4 != 0) goto L_0x0657;	 Catch:{ all -> 0x053d }
    L_0x0648:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r5 = 13;	 Catch:{ all -> 0x053d }
        if (r4 != r5) goto L_0x074d;	 Catch:{ all -> 0x053d }
    L_0x0650:
        r23.g();	 Catch:{ all -> 0x053d }
        r4 = r10;	 Catch:{ all -> 0x053d }
        r5 = r7;	 Catch:{ all -> 0x053d }
        goto L_0x0166;	 Catch:{ all -> 0x053d }
    L_0x0657:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r5 = 17;	 Catch:{ all -> 0x053d }
        if (r4 != r5) goto L_0x04d7;	 Catch:{ all -> 0x053d }
    L_0x065f:
        r4 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x053d }
        r5 = "syntax error, unexpect token ':'";	 Catch:{ all -> 0x053d }
        r4.<init>(r5);	 Catch:{ all -> 0x053d }
        throw r4;	 Catch:{ all -> 0x053d }
    L_0x0667:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r5 = 18;	 Catch:{ all -> 0x053d }
        if (r4 == r5) goto L_0x0676;	 Catch:{ all -> 0x053d }
    L_0x066f:
        r0 = r23;	 Catch:{ all -> 0x053d }
        r4 = r0.a;	 Catch:{ all -> 0x053d }
        r5 = 1;	 Catch:{ all -> 0x053d }
        if (r4 != r5) goto L_0x074d;	 Catch:{ all -> 0x053d }
    L_0x0676:
        r4 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x053d }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x053d }
        r6 = "syntax error, unexpect token ";	 Catch:{ all -> 0x053d }
        r5.<init>(r6);	 Catch:{ all -> 0x053d }
        r0 = r23;	 Catch:{ all -> 0x053d }
        r6 = r0.a;	 Catch:{ all -> 0x053d }
        r6 = com.alibaba.fastjson.a.j.a(r6);	 Catch:{ all -> 0x053d }
        r5 = r5.append(r6);	 Catch:{ all -> 0x053d }
        r5 = r5.toString();	 Catch:{ all -> 0x053d }
        r4.<init>(r5);	 Catch:{ all -> 0x053d }
        throw r4;	 Catch:{ all -> 0x053d }
    L_0x0693:
        r0 = r27;	 Catch:{ all -> 0x06ed }
        r6 = r0.b;	 Catch:{ all -> 0x06ed }
        r7 = r6.length;	 Catch:{ all -> 0x06ed }
        r8 = new java.lang.Object[r7];	 Catch:{ all -> 0x06ed }
        r6 = 0;	 Catch:{ all -> 0x06ed }
    L_0x069b:
        if (r6 >= r7) goto L_0x06b0;	 Catch:{ all -> 0x06ed }
    L_0x069d:
        r0 = r27;	 Catch:{ all -> 0x06ed }
        r10 = r0.b;	 Catch:{ all -> 0x06ed }
        r10 = r10[r6];	 Catch:{ all -> 0x06ed }
        r10 = r10.b;	 Catch:{ all -> 0x06ed }
        r10 = r10.a;	 Catch:{ all -> 0x06ed }
        r10 = r9.get(r10);	 Catch:{ all -> 0x06ed }
        r8[r6] = r10;	 Catch:{ all -> 0x06ed }
        r6 = r6 + 1;	 Catch:{ all -> 0x06ed }
        goto L_0x069b;	 Catch:{ all -> 0x06ed }
    L_0x06b0:
        r0 = r27;	 Catch:{ all -> 0x06ed }
        r6 = r0.a;	 Catch:{ all -> 0x06ed }
        r6 = r6.c;	 Catch:{ all -> 0x06ed }
        if (r6 == 0) goto L_0x06f3;
    L_0x06b8:
        r0 = r27;	 Catch:{ Exception -> 0x06cd }
        r6 = r0.a;	 Catch:{ Exception -> 0x06cd }
        r6 = r6.c;	 Catch:{ Exception -> 0x06cd }
        r5 = r6.newInstance(r8);	 Catch:{ Exception -> 0x06cd }
    L_0x06c2:
        if (r4 == 0) goto L_0x06c6;
    L_0x06c4:
        r4.a = r5;
    L_0x06c6:
        r0 = r28;
        r0.a(r11);
        goto L_0x0013;
    L_0x06cd:
        r6 = move-exception;
        r7 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x06ed }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x06ed }
        r9 = "create instance error, ";	 Catch:{ all -> 0x06ed }
        r8.<init>(r9);	 Catch:{ all -> 0x06ed }
        r0 = r27;	 Catch:{ all -> 0x06ed }
        r9 = r0.a;	 Catch:{ all -> 0x06ed }
        r9 = r9.c;	 Catch:{ all -> 0x06ed }
        r9 = r9.toGenericString();	 Catch:{ all -> 0x06ed }
        r8 = r8.append(r9);	 Catch:{ all -> 0x06ed }
        r8 = r8.toString();	 Catch:{ all -> 0x06ed }
        r7.<init>(r8, r6);	 Catch:{ all -> 0x06ed }
        throw r7;	 Catch:{ all -> 0x06ed }
    L_0x06ed:
        r6 = move-exception;	 Catch:{ all -> 0x06ed }
        r7 = r5;	 Catch:{ all -> 0x06ed }
        r5 = r4;	 Catch:{ all -> 0x06ed }
        r4 = r6;	 Catch:{ all -> 0x06ed }
        goto L_0x00cc;	 Catch:{ all -> 0x06ed }
    L_0x06f3:
        r0 = r27;	 Catch:{ all -> 0x06ed }
        r6 = r0.a;	 Catch:{ all -> 0x06ed }
        r6 = r6.d;	 Catch:{ all -> 0x06ed }
        if (r6 == 0) goto L_0x06c2;
    L_0x06fb:
        r0 = r27;	 Catch:{ Exception -> 0x0707 }
        r6 = r0.a;	 Catch:{ Exception -> 0x0707 }
        r6 = r6.d;	 Catch:{ Exception -> 0x0707 }
        r7 = 0;	 Catch:{ Exception -> 0x0707 }
        r5 = r6.invoke(r7, r8);	 Catch:{ Exception -> 0x0707 }
        goto L_0x06c2;
    L_0x0707:
        r6 = move-exception;
        r7 = new com.alibaba.fastjson.d;	 Catch:{ all -> 0x06ed }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x06ed }
        r9 = "create factory method error, ";	 Catch:{ all -> 0x06ed }
        r8.<init>(r9);	 Catch:{ all -> 0x06ed }
        r0 = r27;	 Catch:{ all -> 0x06ed }
        r9 = r0.a;	 Catch:{ all -> 0x06ed }
        r9 = r9.d;	 Catch:{ all -> 0x06ed }
        r9 = r9.toString();	 Catch:{ all -> 0x06ed }
        r8 = r8.append(r9);	 Catch:{ all -> 0x06ed }
        r8 = r8.toString();	 Catch:{ all -> 0x06ed }
        r7.<init>(r8, r6);	 Catch:{ all -> 0x06ed }
        throw r7;	 Catch:{ all -> 0x06ed }
    L_0x0727:
        r10 = r5;
        goto L_0x04ca;
    L_0x072a:
        r4 = r5;
        goto L_0x0192;
    L_0x072d:
        r18 = r17;
        r17 = r16;
        r16 = r10;
        goto L_0x0145;
    L_0x0735:
        r18 = r17;
        r17 = r16;
        r16 = r10;
        goto L_0x0145;
    L_0x073d:
        r18 = r17;
        r17 = r16;
        r16 = r10;
        goto L_0x0145;
    L_0x0745:
        r19 = r4;
        r20 = r8;
        r21 = r10;
        goto L_0x0108;
    L_0x074d:
        r4 = r10;
        goto L_0x0192;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.a.f.a(com.alibaba.fastjson.a.c, java.lang.reflect.Type, java.lang.Object, java.lang.Object):T");
    }

    protected final c a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        if (this.a.h) {
            while (i < this.c.length) {
                if (this.c[i].b.a.equalsIgnoreCase(str)) {
                    return this.c[i];
                }
                i++;
            }
            return null;
        }
        int i2 = 0;
        i = this.c.length - 1;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            int compareTo = this.c[i3].b.a.compareTo(str);
            if (compareTo < 0) {
                i2 = i3 + 1;
            } else if (compareTo <= 0) {
                return this.c[i3];
            } else {
                i = i3 - 1;
            }
        }
        return null;
    }

    private boolean a(c cVar, String str, Object obj, Type type, Map<String, Object> map) {
        i iVar = cVar.e;
        c a = a(str);
        if (a == null) {
            boolean startsWith = str.startsWith("is");
            for (c cVar2 : this.c) {
                a aVar = cVar2.b;
                Class cls = aVar.f;
                String str2 = aVar.a;
                if (str2.equalsIgnoreCase(str) || (startsWith && ((cls == Boolean.TYPE || cls == Boolean.class) && str2.equalsIgnoreCase(str.substring(2))))) {
                    break;
                }
            }
        }
        c cVar22 = a;
        if (cVar22 == null) {
            i iVar2 = cVar.e;
            if ((cVar.e.c & e.IgnoreNotMatch.q) == 0) {
                throw new d("setter not found, class " + this.d.getName() + ", property " + str);
            }
            iVar2.d();
            Type type2 = null;
            List<b> list = cVar.h;
            if (list != null) {
                for (b a2 : list) {
                    type2 = a2.a();
                }
            }
            if (type2 == null) {
                cVar.a(null);
            } else {
                cVar.a(type2, null);
            }
            if (!(obj instanceof com.alibaba.fastjson.a.a.a)) {
                List list2 = cVar.i;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            }
            return false;
        }
        iVar.d();
        cVar22.a(cVar, obj, type, map);
        return true;
    }

    public final Object a(Map<String, Object> map, n nVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.a.c == null) {
            Object a = a(null, this.d);
            for (Entry entry : map.entrySet()) {
                c a2 = a((String) entry.getKey());
                if (a2 != null) {
                    Object value = entry.getValue();
                    Method method = a2.b.b;
                    if (method != null) {
                        value = com.alibaba.fastjson.c.e.a(value, method.getGenericParameterTypes()[0], nVar);
                        method.invoke(a, new Object[]{value});
                    } else {
                        a2.b.c.set(a, com.alibaba.fastjson.c.e.a(value, a2.b.g, nVar));
                    }
                }
            }
            return a;
        }
        a[] aVarArr = this.a.e;
        int length = aVarArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = map.get(aVarArr[i].a);
        }
        if (this.a.c == null) {
            return null;
        }
        try {
            return this.a.c.newInstance(objArr);
        } catch (Throwable e) {
            throw new d("create instance error, " + this.a.c.toGenericString(), e);
        }
    }

    private f a(n nVar, g gVar, String str) {
        if (gVar.g == null) {
            return null;
        }
        for (Type a : gVar.g.seeAlso()) {
            e a2 = nVar.a(a);
            if (a2 instanceof f) {
                f fVar = (f) a2;
                g gVar2 = fVar.a;
                if (gVar2.j.equals(str)) {
                    return fVar;
                }
                fVar = a(nVar, gVar2, str);
                if (fVar != null) {
                    return fVar;
                }
            }
        }
        return null;
    }
}
