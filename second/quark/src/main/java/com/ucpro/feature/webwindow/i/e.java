package com.ucpro.feature.webwindow.i;

import android.graphics.Bitmap;

/* compiled from: ProGuard */
public final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ a c;

    public e(a aVar, String str, Bitmap bitmap) {
        this.c = aVar;
        this.a = str;
        this.b = bitmap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r1 = 0;
        r0 = r10.a;
        r0 = com.ucweb.common.util.n.a.a(r0);
        if (r0 != 0) goto L_0x002a;
    L_0x0009:
        r0 = r10.b;
        if (r0 == 0) goto L_0x002a;
    L_0x000d:
        r0 = r10.a;
        r2 = com.ucpro.feature.webwindow.i.a.a(r0);
        r0 = com.ucweb.common.util.n.a.a(r2);
        if (r0 != 0) goto L_0x002a;
    L_0x0019:
        r0 = r10.c;
        r0 = r0.a;
        r0 = r0.containsKey(r2);
        if (r0 != 0) goto L_0x002b;
    L_0x0023:
        r0 = r10.c;
        r3 = r10.b;
        com.ucpro.feature.webwindow.i.a.a(r0, r2, r3, r1);
    L_0x002a:
        return;
    L_0x002b:
        r0 = r10.c;
        r0 = r0.a;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = com.ucweb.common.util.k.a.h(r0);
        if (r3 == 0) goto L_0x0095;
    L_0x003b:
        r3 = new java.io.File;
        r3.<init>(r0);
        r4 = new java.lang.StringBuilder;
        r5 = "currentTimeMillis: ";
        r4.<init>(r5);
        r6 = java.lang.System.currentTimeMillis();
        r4 = r4.append(r6);
        r5 = "\n lastModified: ";
        r4 = r4.append(r5);
        r6 = r3.lastModified();
        r4 = r4.append(r6);
        r5 = "\n interval time: ";
        r4 = r4.append(r5);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r3.lastModified();
        r6 = r6 - r8;
        r4 = r4.append(r6);
        r5 = "\n MONTH_IN_MILLIS: 2592000000";
        r4.append(r5);
        r4 = java.lang.System.currentTimeMillis();
        r6 = r3.lastModified();
        r4 = r4 - r6;
        r6 = 2592000000; // 0x9a7ec800 float:-5.2687528E-23 double:1.280618154E-314;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x0095;
    L_0x0087:
        if (r1 == 0) goto L_0x002a;
    L_0x0089:
        r1 = r10.c;
        r3 = r10.b;
        r0 = com.ucweb.common.util.k.a.h(r0);
        com.ucpro.feature.webwindow.i.a.a(r1, r2, r3, r0);
        goto L_0x002a;
    L_0x0095:
        r1 = 1;
        goto L_0x0087;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.webwindow.i.e.run():void");
    }
}
