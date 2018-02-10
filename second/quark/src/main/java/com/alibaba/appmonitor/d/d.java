package com.alibaba.appmonitor.d;

import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.a.c;
import com.alibaba.appmonitor.f.h;
import com.alibaba.appmonitor.model.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.List;

/* compiled from: ProGuard */
public final class d {
    public static void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) {
        try {
            if (f.b) {
                b.l();
                if (h.STAT.e && f.a) {
                    af.a("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                    com.alibaba.appmonitor.model.b a = a.a().a(str, str2);
                    if (a != null) {
                        List list = a.d().a;
                        if (list.size() == 1) {
                            a(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.appmonitor.e.b.a().a(MeasureValueSet.class, new Object[0])).a(((Measure) list.get(0)).a, d));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            af.c("log discard !", "");
        } catch (Throwable th) {
            c.a(com.alibaba.analytics.core.c.a.b.b, th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r9, java.lang.String r10, com.alibaba.mtl.appmonitor.model.DimensionValueSet r11, com.alibaba.mtl.appmonitor.model.MeasureValueSet r12) {
        /*
        r7 = 1;
        r6 = 0;
        r0 = com.alibaba.analytics.core.c.a.a();	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r0 = r0.a(r1, r9, r10);	 Catch:{ Throwable -> 0x00e6 }
        if (r0 == 0) goto L_0x0042;
    L_0x000e:
        r0 = com.alibaba.appmonitor.d.f.c;	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.analytics.core.c.i.a;	 Catch:{ Throwable -> 0x00e6 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e6 }
        r2.<init>();	 Catch:{ Throwable -> 0x00e6 }
        r3 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00e6 }
        r3 = ":";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00e6 }
        r2 = r2.append(r9);	 Catch:{ Throwable -> 0x00e6 }
        r3 = ":";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00e6 }
        r2 = r2.append(r10);	 Catch:{ Throwable -> 0x00e6 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00e6 }
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = java.lang.Double.valueOf(r4);	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.analytics.core.c.i.a(r1, r2, r3);	 Catch:{ Throwable -> 0x00e6 }
        r0.a(r1);	 Catch:{ Throwable -> 0x00e6 }
    L_0x0042:
        r0 = com.alibaba.appmonitor.d.f.b;	 Catch:{ Throwable -> 0x00e6 }
        if (r0 == 0) goto L_0x00ef;
    L_0x0046:
        com.alibaba.analytics.core.b.l();	 Catch:{ Throwable -> 0x00e6 }
        r0 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r0 = r0.e;	 Catch:{ Throwable -> 0x00e6 }
        if (r0 == 0) goto L_0x00ef;
    L_0x004f:
        r0 = com.alibaba.appmonitor.d.f.a;	 Catch:{ Throwable -> 0x00e6 }
        if (r0 != 0) goto L_0x0063;
    L_0x0053:
        r0 = com.alibaba.appmonitor.a.d.a();	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        if (r11 == 0) goto L_0x005d;
    L_0x005b:
        r2 = r11.a;	 Catch:{ Throwable -> 0x00e6 }
    L_0x005d:
        r0 = r0.a(r1, r9, r10);	 Catch:{ Throwable -> 0x00e6 }
        if (r0 == 0) goto L_0x00ef;
    L_0x0063:
        r0 = "statEvent commit";
        r1 = 4;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e6 }
        r2 = 0;
        r3 = "module";
        r1[r2] = r3;	 Catch:{ Throwable -> 0x00e6 }
        r2 = 1;
        r1[r2] = r9;	 Catch:{ Throwable -> 0x00e6 }
        r2 = 2;
        r3 = "monitorPoint";
        r1[r2] = r3;	 Catch:{ Throwable -> 0x00e6 }
        r2 = 3;
        r1[r2] = r10;	 Catch:{ Throwable -> 0x00e6 }
        com.alibaba.analytics.a.af.a(r0, r1);	 Catch:{ Throwable -> 0x00e6 }
        r0 = com.alibaba.appmonitor.a.d.a();	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r0 = r0.b(r1, r9, r10);	 Catch:{ Throwable -> 0x00e6 }
        if (r0 == 0) goto L_0x00a8;
    L_0x0087:
        r0 = com.alibaba.analytics.core.b.a();	 Catch:{ Throwable -> 0x00e6 }
        r0 = r0.b;	 Catch:{ Throwable -> 0x00e6 }
        r7 = com.alibaba.appmonitor.b.f.a();	 Catch:{ Throwable -> 0x00e6 }
        r8 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r0 = new com.alibaba.appmonitor.b.h;	 Catch:{ Throwable -> 0x00e6 }
        r5 = com.alibaba.analytics.core.d.e.c();	 Catch:{ Throwable -> 0x00e6 }
        r6 = com.alibaba.analytics.core.d.e.d();	 Catch:{ Throwable -> 0x00e6 }
        r1 = r9;
        r2 = r10;
        r3 = r11;
        r4 = r12;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00e6 }
        r7.a(r8, r0);	 Catch:{ Throwable -> 0x00e6 }
    L_0x00a7:
        return;
    L_0x00a8:
        r0 = com.alibaba.appmonitor.f.d.a();	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r1 = r1.d;	 Catch:{ Throwable -> 0x00e6 }
        r2 = r9;
        r3 = r10;
        r4 = r12;
        r5 = r11;
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00e6 }
        r0 = com.alibaba.analytics.core.c.a.a();	 Catch:{ Throwable -> 0x00e6 }
        r0 = r0.a(r9, r10);	 Catch:{ Throwable -> 0x00e6 }
        if (r0 != 0) goto L_0x00ed;
    L_0x00c1:
        r0 = r6;
    L_0x00c2:
        if (r0 == 0) goto L_0x00a7;
    L_0x00c4:
        r0 = com.alibaba.appmonitor.f.d.a();	 Catch:{ Throwable -> 0x00e6 }
        r1 = com.alibaba.appmonitor.f.h.STAT;	 Catch:{ Throwable -> 0x00e6 }
        r1 = r1.d;	 Catch:{ Throwable -> 0x00e6 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e6 }
        r2.<init>();	 Catch:{ Throwable -> 0x00e6 }
        r2 = r2.append(r9);	 Catch:{ Throwable -> 0x00e6 }
        r3 = "_abtest";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00e6 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00e6 }
        r3 = r10;
        r4 = r12;
        r5 = r11;
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00e6 }
        goto L_0x00a7;
    L_0x00e6:
        r0 = move-exception;
        r1 = com.alibaba.analytics.core.c.a.b.b;
        com.alibaba.analytics.core.c.a.c.a(r1, r0);
        goto L_0x00a7;
    L_0x00ed:
        r0 = r7;
        goto L_0x00c2;
    L_0x00ef:
        r0 = "log discard !";
        r1 = 4;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00e6 }
        r2 = 0;
        r3 = "module";
        r1[r2] = r3;	 Catch:{ Throwable -> 0x00e6 }
        r2 = 1;
        r1[r2] = r9;	 Catch:{ Throwable -> 0x00e6 }
        r2 = 2;
        r3 = "monitorPoint";
        r1[r2] = r3;	 Catch:{ Throwable -> 0x00e6 }
        r2 = 3;
        r1[r2] = r10;	 Catch:{ Throwable -> 0x00e6 }
        com.alibaba.analytics.a.af.c(r0, r1);	 Catch:{ Throwable -> 0x00e6 }
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.appmonitor.d.d.a(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet):void");
    }
}
