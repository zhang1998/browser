package com.ucpro.feature.d.a;

import android.graphics.Bitmap;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Bitmap b;

    a(String str, Bitmap bitmap) {
        this.a = str;
        this.b = bitmap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r1 = r8.a;	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0055, all -> 0x0066 }
        r2 = r8.b;	 Catch:{ Exception -> 0x0086, all -> 0x007a }
        r2 = r2.getWidth();	 Catch:{ Exception -> 0x0086, all -> 0x007a }
        r3 = r8.b;	 Catch:{ Exception -> 0x0086, all -> 0x007a }
        r3 = r3.getHeight();	 Catch:{ Exception -> 0x0086, all -> 0x007a }
        r4 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x0086, all -> 0x007a }
        r0 = com.uc.util.b.a(r2, r3, r4);	 Catch:{ Exception -> 0x0086, all -> 0x007a }
        r2 = -1;
        r0.eraseColor(r2);	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r2 = new android.graphics.Canvas;	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r3 = r8.b;	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r4 = 0;
        r5 = 0;
        r6 = new android.graphics.Paint;	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r6.<init>();	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r2.drawBitmap(r3, r4, r5, r6);	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r2 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        r3 = 100;
        r2 = r0.compress(r2, r3, r1);	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
        if (r2 == 0) goto L_0x0046;
    L_0x0043:
        r1.flush();	 Catch:{ Exception -> 0x0086, all -> 0x0080 }
    L_0x0046:
        com.ucweb.common.util.o.a.a(r1);
        if (r0 == 0) goto L_0x0054;
    L_0x004b:
        r1 = r0.isRecycled();
        if (r1 != 0) goto L_0x0054;
    L_0x0051:
        r0.recycle();
    L_0x0054:
        return;
    L_0x0055:
        r1 = move-exception;
        r1 = r0;
    L_0x0057:
        com.ucweb.common.util.o.a.a(r1);
        if (r0 == 0) goto L_0x0054;
    L_0x005c:
        r1 = r0.isRecycled();
        if (r1 != 0) goto L_0x0054;
    L_0x0062:
        r0.recycle();
        goto L_0x0054;
    L_0x0066:
        r1 = move-exception;
        r2 = r0;
        r7 = r0;
        r0 = r1;
        r1 = r7;
    L_0x006b:
        com.ucweb.common.util.o.a.a(r2);
        if (r1 == 0) goto L_0x0079;
    L_0x0070:
        r2 = r1.isRecycled();
        if (r2 != 0) goto L_0x0079;
    L_0x0076:
        r1.recycle();
    L_0x0079:
        throw r0;
    L_0x007a:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x006b;
    L_0x0080:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x006b;
    L_0x0086:
        r2 = move-exception;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.d.a.a.run():void");
    }
}
