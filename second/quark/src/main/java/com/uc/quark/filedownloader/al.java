package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.message.c;

/* compiled from: ProGuard */
public final class al implements c {
    private volatile Object a = new Object();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.uc.quark.filedownloader.message.MessageSnapshot r12) {
        /*
        r11 = this;
        r5 = 2;
        r10 = -3;
        r9 = -4;
        r2 = 0;
        r1 = 1;
        r3 = r11.a;
        monitor-enter(r3);
        r0 = com.uc.quark.filedownloader.ak.a;	 Catch:{ all -> 0x0180 }
        r4 = r12.a;	 Catch:{ all -> 0x0180 }
        r4 = r0.c(r4);	 Catch:{ all -> 0x0180 }
        r0 = r4.size();	 Catch:{ all -> 0x0180 }
        if (r0 <= 0) goto L_0x0150;
    L_0x0018:
        r0 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x0059;
    L_0x001c:
        r0 = 0;
        r0 = r4.get(r0);	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.at) r0;	 Catch:{ all -> 0x0180 }
        r0 = r0.M();	 Catch:{ all -> 0x0180 }
        r5 = "~~~callback %s old[%s] new[%s] %d";
        r6 = 4;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0180 }
        r7 = 0;
        r8 = r12.a;	 Catch:{ all -> 0x0180 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0180 }
        r6[r7] = r8;	 Catch:{ all -> 0x0180 }
        r7 = 1;
        r0 = r0.s();	 Catch:{ all -> 0x0180 }
        r0 = java.lang.Byte.valueOf(r0);	 Catch:{ all -> 0x0180 }
        r6[r7] = r0;	 Catch:{ all -> 0x0180 }
        r0 = 2;
        r7 = r12.i();	 Catch:{ all -> 0x0180 }
        r7 = java.lang.Byte.valueOf(r7);	 Catch:{ all -> 0x0180 }
        r6[r0] = r7;	 Catch:{ all -> 0x0180 }
        r0 = 3;
        r7 = r4.size();	 Catch:{ all -> 0x0180 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x0180 }
        r6[r0] = r7;	 Catch:{ all -> 0x0180 }
        com.uc.quark.filedownloader.e.j.d(r11, r5, r6);	 Catch:{ all -> 0x0180 }
    L_0x0059:
        r0 = r4.size();	 Catch:{ all -> 0x0180 }
        if (r0 <= r1) goto L_0x00ee;
    L_0x005f:
        r0 = r12.i();	 Catch:{ all -> 0x0180 }
        if (r0 != r10) goto L_0x00ee;
    L_0x0065:
        r5 = r4.iterator();	 Catch:{ all -> 0x0180 }
    L_0x0069:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x00ee;
    L_0x006f:
        r0 = r5.next();	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.at) r0;	 Catch:{ all -> 0x0180 }
        r0 = r0.N();	 Catch:{ all -> 0x0180 }
        r0 = r0.c(r12);	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x0069;
    L_0x007f:
        r0 = r1;
    L_0x0080:
        if (r0 != 0) goto L_0x014e;
    L_0x0082:
        r0 = com.uc.quark.filedownloader.e.j.a;	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x014e;
    L_0x0086:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0180 }
        r1 = "The flow callback did not consumed, id:";
        r0.<init>(r1);	 Catch:{ all -> 0x0180 }
        r1 = r12.a;	 Catch:{ all -> 0x0180 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r1 = " status:";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r1 = r12.i();	 Catch:{ all -> 0x0180 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r1 = " task-count:";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r1 = r4.size();	 Catch:{ all -> 0x0180 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0180 }
        r0 = r0.toString();	 Catch:{ all -> 0x0180 }
        r2 = r4.iterator();	 Catch:{ all -> 0x0180 }
        r1 = r0;
    L_0x00b8:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x0148;
    L_0x00be:
        r0 = r2.next();	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.at) r0;	 Catch:{ all -> 0x0180 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0180 }
        r5 = " | ";
        r4.<init>(r5);	 Catch:{ all -> 0x0180 }
        r0 = r0.M();	 Catch:{ all -> 0x0180 }
        r0 = r0.s();	 Catch:{ all -> 0x0180 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x0180 }
        r0 = r0.toString();	 Catch:{ all -> 0x0180 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0180 }
        r4.<init>();	 Catch:{ all -> 0x0180 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0180 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0180 }
        r0 = r0.toString();	 Catch:{ all -> 0x0180 }
        r1 = r0;
        goto L_0x00b8;
    L_0x00ee:
        r5 = r4.iterator();	 Catch:{ all -> 0x0180 }
    L_0x00f2:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x010b;
    L_0x00f8:
        r0 = r5.next();	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.at) r0;	 Catch:{ all -> 0x0180 }
        r0 = r0.N();	 Catch:{ all -> 0x0180 }
        r0 = r0.b(r12);	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x00f2;
    L_0x0108:
        r0 = r1;
        goto L_0x0080;
    L_0x010b:
        r0 = r12.i();	 Catch:{ all -> 0x0180 }
        if (r9 != r0) goto L_0x012e;
    L_0x0111:
        r5 = r4.iterator();	 Catch:{ all -> 0x0180 }
    L_0x0115:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x012e;
    L_0x011b:
        r0 = r5.next();	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.at) r0;	 Catch:{ all -> 0x0180 }
        r0 = r0.N();	 Catch:{ all -> 0x0180 }
        r0 = r0.d(r12);	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x0115;
    L_0x012b:
        r0 = r1;
        goto L_0x0080;
    L_0x012e:
        r0 = r4.size();	 Catch:{ all -> 0x0180 }
        if (r0 != r1) goto L_0x0145;
    L_0x0134:
        r0 = 0;
        r0 = r4.get(r0);	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.at) r0;	 Catch:{ all -> 0x0180 }
        r0 = r0.N();	 Catch:{ all -> 0x0180 }
        r0 = r0.a(r12);	 Catch:{ all -> 0x0180 }
        goto L_0x0080;
    L_0x0145:
        r0 = r2;
        goto L_0x0080;
    L_0x0148:
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x0180 }
        com.uc.quark.filedownloader.e.j.e(r11, r1, r0);	 Catch:{ all -> 0x0180 }
    L_0x014e:
        monitor-exit(r3);	 Catch:{ all -> 0x0180 }
    L_0x014f:
        return;
    L_0x0150:
        r0 = com.uc.quark.filedownloader.n.a;	 Catch:{ all -> 0x0180 }
        r0 = r0.d();	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x014e;
    L_0x015a:
        r0 = r12.i();	 Catch:{ all -> 0x0180 }
        r1 = 3;
        if (r0 != r1) goto L_0x014e;
    L_0x0161:
        r0 = r12.a;	 Catch:{ all -> 0x0180 }
        r0 = com.uc.quark.filedownloader.contentprovider.a.e(r0);	 Catch:{ all -> 0x0180 }
        if (r0 == 0) goto L_0x014e;
    L_0x0169:
        r1 = r0.length;	 Catch:{ all -> 0x0180 }
        if (r1 != r5) goto L_0x014e;
    L_0x016c:
        r1 = 0;
        r1 = r0[r1];	 Catch:{ all -> 0x0180 }
        r2 = 1;
        r0 = r0[r2];	 Catch:{ all -> 0x0180 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0180 }
        if (r2 != 0) goto L_0x017e;
    L_0x0178:
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0180 }
        if (r2 == 0) goto L_0x0183;
    L_0x017e:
        monitor-exit(r3);	 Catch:{ all -> 0x0180 }
        goto L_0x014f;
    L_0x0180:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0180 }
        throw r0;
    L_0x0183:
        com.uc.quark.filedownloader.as.a();	 Catch:{ all -> 0x0180 }
        r1 = com.uc.quark.filedownloader.as.a(r1);	 Catch:{ all -> 0x0180 }
        r0 = r1.a(r0);	 Catch:{ all -> 0x0180 }
        r1 = com.uc.quark.filedownloader.p.a;	 Catch:{ all -> 0x0180 }
        r1 = r1.a;	 Catch:{ all -> 0x0180 }
        r0 = r0.a(r1);	 Catch:{ all -> 0x0180 }
        r0 = (com.uc.quark.filedownloader.s) r0;	 Catch:{ all -> 0x0180 }
        r1 = r12.j();	 Catch:{ all -> 0x0180 }
        r0.b = r1;	 Catch:{ all -> 0x0180 }
        r1 = r12.a;	 Catch:{ all -> 0x0180 }
        r0.a = r1;	 Catch:{ all -> 0x0180 }
        r1 = com.uc.quark.filedownloader.ak.a;	 Catch:{ all -> 0x0180 }
        r1.b(r0);	 Catch:{ all -> 0x0180 }
        r1 = r12.i();	 Catch:{ all -> 0x0180 }
        if (r1 != r10) goto L_0x01bb;
    L_0x01b1:
        r1 = r0.N();	 Catch:{ all -> 0x0180 }
        r1 = r1.c(r12);	 Catch:{ all -> 0x0180 }
        if (r1 != 0) goto L_0x014e;
    L_0x01bb:
        r1 = r0.N();	 Catch:{ all -> 0x0180 }
        r1 = r1.b(r12);	 Catch:{ all -> 0x0180 }
        if (r1 != 0) goto L_0x014e;
    L_0x01c5:
        r1 = r12.i();	 Catch:{ all -> 0x0180 }
        if (r9 != r1) goto L_0x01d5;
    L_0x01cb:
        r1 = r0.N();	 Catch:{ all -> 0x0180 }
        r1 = r1.d(r12);	 Catch:{ all -> 0x0180 }
        if (r1 != 0) goto L_0x014e;
    L_0x01d5:
        r0 = r0.N();	 Catch:{ all -> 0x0180 }
        r0.a(r12);	 Catch:{ all -> 0x0180 }
        goto L_0x014e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.al.a(com.uc.quark.filedownloader.message.MessageSnapshot):void");
    }
}
