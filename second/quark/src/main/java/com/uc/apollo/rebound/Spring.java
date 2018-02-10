package com.uc.apollo.rebound;

import com.uc.apollo.annotation.KeepForRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ProGuard */
public class Spring {
    private static int a = 0;
    private SpringConfig b;
    private boolean c;
    private final String d;
    private final a e = new a();
    private final a f = new a();
    private final a g = new a();
    private double h;
    private double i;
    private boolean j = true;
    private double k = 0.005d;
    private double l = 0.005d;
    private CopyOnWriteArraySet<e> m = new CopyOnWriteArraySet();
    private double n = 0.0d;
    private final BaseSpringSystem o;

    /* compiled from: ProGuard */
    final class a {
        double a;
        double b;

        private a() {
        }
    }

    Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        }
        this.o = baseSpringSystem;
        StringBuilder stringBuilder = new StringBuilder("spring:");
        int i = a;
        a = i + 1;
        this.d = stringBuilder.append(i).toString();
        a(SpringConfig.c);
    }

    public final String a() {
        return this.d;
    }

    public final Spring a(SpringConfig springConfig) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.b = springConfig;
        return this;
    }

    @KeepForRuntime
    public Spring setSpringConfig(Object obj) {
        if (obj instanceof SpringConfig) {
            a((SpringConfig) obj);
        }
        return this;
    }

    @KeepForRuntime
    public double getCurrentValue() {
        return this.e.a;
    }

    @KeepForRuntime
    public Spring setEndValue(double d) {
        if (!(this.i == d && c())) {
            this.h = getCurrentValue();
            this.i = d;
            this.o.a(this.d);
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onSpringEndStateChange(this);
            }
        }
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(double r34) {
        /*
        r33 = this;
        r10 = r33.c();
        if (r10 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r33;
        r2 = r0.j;
        if (r2 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r2 = 4589276106681592316; // 0x3fb0624dd2f1a9fc float:-5.18969491E11 double:0.064;
        r2 = (r34 > r2 ? 1 : (r34 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x001b;
    L_0x0016:
        r34 = 4589276106681592316; // 0x3fb0624dd2f1a9fc float:-5.18969491E11 double:0.064;
    L_0x001b:
        r0 = r33;
        r2 = r0.n;
        r2 = r2 + r34;
        r0 = r33;
        r0.n = r2;
        r0 = r33;
        r2 = r0.b;
        r12 = r2.b;
        r0 = r33;
        r2 = r0.b;
        r14 = r2.a;
        r0 = r33;
        r2 = r0.e;
        r8 = r2.a;
        r0 = r33;
        r2 = r0.e;
        r6 = r2.b;
        r0 = r33;
        r2 = r0.g;
        r4 = r2.a;
        r0 = r33;
        r2 = r0.g;
        r2 = r2.b;
    L_0x0049:
        r0 = r33;
        r0 = r0.n;
        r16 = r0;
        r18 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r11 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r11 < 0) goto L_0x0124;
    L_0x0058:
        r0 = r33;
        r2 = r0.n;
        r16 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = r2 - r16;
        r0 = r33;
        r0.n = r2;
        r0 = r33;
        r2 = r0.n;
        r16 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1));
        if (r2 >= 0) goto L_0x0080;
    L_0x0074:
        r0 = r33;
        r2 = r0.f;
        r2.a = r8;
        r0 = r33;
        r2 = r0.f;
        r2.b = r6;
    L_0x0080:
        r0 = r33;
        r2 = r0.i;
        r2 = r2 - r4;
        r2 = r2 * r12;
        r4 = r14 * r6;
        r16 = r2 - r4;
        r2 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = r2 * r6;
        r4 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r2 = r2 * r4;
        r2 = r2 + r8;
        r4 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r4 = r4 * r16;
        r18 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r4 = r4 * r18;
        r18 = r6 + r4;
        r0 = r33;
        r4 = r0.i;
        r2 = r4 - r2;
        r2 = r2 * r12;
        r4 = r14 * r18;
        r20 = r2 - r4;
        r2 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = r2 * r18;
        r4 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r2 = r2 * r4;
        r2 = r2 + r8;
        r4 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r4 = r4 * r20;
        r22 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r4 = r4 * r22;
        r22 = r6 + r4;
        r0 = r33;
        r4 = r0.i;
        r2 = r4 - r2;
        r2 = r2 * r12;
        r4 = r14 * r22;
        r24 = r2 - r4;
        r2 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = r2 * r22;
        r4 = r8 + r2;
        r2 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = r2 * r24;
        r2 = r2 + r6;
        r0 = r33;
        r0 = r0.i;
        r26 = r0;
        r26 = r26 - r4;
        r26 = r26 * r12;
        r28 = r14 * r2;
        r26 = r26 - r28;
        r28 = 4595172819793696085; // 0x3fc5555555555555 float:1.46601547E13 double:0.16666666666666666;
        r30 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r18 = r18 + r22;
        r18 = r18 * r30;
        r18 = r18 + r6;
        r18 = r18 + r2;
        r18 = r18 * r28;
        r22 = 4595172819793696085; // 0x3fc5555555555555 float:1.46601547E13 double:0.16666666666666666;
        r28 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r20 = r20 + r24;
        r20 = r20 * r28;
        r16 = r16 + r20;
        r16 = r16 + r26;
        r16 = r16 * r22;
        r20 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r18 = r18 * r20;
        r8 = r8 + r18;
        r18 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r16 = r16 * r18;
        r6 = r6 + r16;
        goto L_0x0049;
    L_0x0124:
        r0 = r33;
        r11 = r0.g;
        r11.a = r4;
        r0 = r33;
        r4 = r0.g;
        r4.b = r2;
        r0 = r33;
        r2 = r0.e;
        r2.a = r8;
        r0 = r33;
        r2 = r0.e;
        r2.b = r6;
        r0 = r33;
        r2 = r0.n;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0181;
    L_0x0146:
        r0 = r33;
        r2 = r0.n;
        r4 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;
        r2 = r2 / r4;
        r0 = r33;
        r4 = r0.e;
        r0 = r33;
        r5 = r0.e;
        r6 = r5.a;
        r6 = r6 * r2;
        r0 = r33;
        r5 = r0.f;
        r8 = r5.a;
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r14 = r14 - r2;
        r8 = r8 * r14;
        r6 = r6 + r8;
        r4.a = r6;
        r0 = r33;
        r4 = r0.e;
        r0 = r33;
        r5 = r0.e;
        r6 = r5.b;
        r6 = r6 * r2;
        r0 = r33;
        r5 = r0.f;
        r8 = r5.b;
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r2 = r14 - r2;
        r2 = r2 * r8;
        r2 = r2 + r6;
        r4.b = r2;
    L_0x0181:
        r2 = r33.c();
        if (r2 != 0) goto L_0x01cc;
    L_0x0187:
        r0 = r33;
        r2 = r0.c;
        if (r2 == 0) goto L_0x025b;
    L_0x018d:
        r0 = r33;
        r2 = r0.b;
        r2 = r2.b;
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0244;
    L_0x0199:
        r0 = r33;
        r2 = r0.h;
        r0 = r33;
        r4 = r0.i;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x01b1;
    L_0x01a5:
        r2 = r33.getCurrentValue();
        r0 = r33;
        r4 = r0.i;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x01c9;
    L_0x01b1:
        r0 = r33;
        r2 = r0.h;
        r0 = r33;
        r4 = r0.i;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0244;
    L_0x01bd:
        r2 = r33.getCurrentValue();
        r0 = r33;
        r4 = r0.i;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0244;
    L_0x01c9:
        r2 = 1;
    L_0x01ca:
        if (r2 == 0) goto L_0x025b;
    L_0x01cc:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0246;
    L_0x01d2:
        r0 = r33;
        r2 = r0.i;
        r0 = r33;
        r0.h = r2;
        r0 = r33;
        r2 = r0.e;
        r0 = r33;
        r4 = r0.i;
        r2.a = r4;
    L_0x01e4:
        r2 = 0;
        r0 = r33;
        r4 = r0.e;
        r4 = r4.b;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0203;
    L_0x01f0:
        r0 = r33;
        r2 = r0.e;
        r4 = 0;
        r2.b = r4;
        r0 = r33;
        r2 = r0.o;
        r0 = r33;
        r3 = r0.d;
        r2.a(r3);
    L_0x0203:
        r2 = 1;
    L_0x0204:
        r3 = 0;
        r0 = r33;
        r4 = r0.j;
        if (r4 == 0) goto L_0x0259;
    L_0x020b:
        r3 = 0;
        r0 = r33;
        r0.j = r3;
        r3 = 1;
        r4 = r3;
    L_0x0212:
        r3 = 0;
        if (r2 == 0) goto L_0x021c;
    L_0x0215:
        r2 = 1;
        r0 = r33;
        r0.j = r2;
        r2 = 1;
        r3 = r2;
    L_0x021c:
        r0 = r33;
        r2 = r0.m;
        r5 = r2.iterator();
    L_0x0224:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x000c;
    L_0x022a:
        r2 = r5.next();
        r2 = (com.uc.apollo.rebound.e) r2;
        if (r4 == 0) goto L_0x0237;
    L_0x0232:
        r0 = r33;
        r2.onSpringActivate(r0);
    L_0x0237:
        r0 = r33;
        r2.onSpringUpdate(r0);
        if (r3 == 0) goto L_0x0224;
    L_0x023e:
        r0 = r33;
        r2.onSpringAtRest(r0);
        goto L_0x0224;
    L_0x0244:
        r2 = 0;
        goto L_0x01ca;
    L_0x0246:
        r0 = r33;
        r2 = r0.e;
        r2 = r2.a;
        r0 = r33;
        r0.i = r2;
        r0 = r33;
        r2 = r0.i;
        r0 = r33;
        r0.h = r2;
        goto L_0x01e4;
    L_0x0259:
        r4 = r3;
        goto L_0x0212;
    L_0x025b:
        r2 = r10;
        goto L_0x0204;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.apollo.rebound.Spring.a(double):void");
    }

    public final boolean b() {
        return this.j;
    }

    public final boolean c() {
        if (Math.abs(this.e.b) <= this.k) {
            if (Math.abs(this.i - this.e.a) <= this.l || this.b.b == 0.0d) {
                return true;
            }
        }
        return false;
    }

    public final Spring a(e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.m.add(eVar);
        return this;
    }

    @KeepForRuntime
    public void addListener(Object obj) {
        if (obj instanceof e) {
            a((e) obj);
        } else {
            a(d.a(obj));
        }
    }

    @KeepForRuntime
    public Spring setCurrentValue(double d) {
        this.h = d;
        this.e.a = d;
        this.o.a(this.d);
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onSpringUpdate(this);
        }
        this.i = this.e.a;
        this.g.a = this.e.a;
        this.e.b = 0.0d;
        return this;
    }
}
