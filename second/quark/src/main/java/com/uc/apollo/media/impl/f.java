package com.uc.apollo.media.impl;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: ProGuard */
final class f implements Runnable {
    private static final String a = (e.a + "MediaParser");
    private static int b = 1;
    private static Handler c;
    private int d;
    private String e;
    private Map<String, String> f;
    private WeakReference<a> g;
    private boolean h;

    /* compiled from: ProGuard */
    public interface a {
        void a(int i, O o, Object obj);

        void a(int i, String str);
    }

    /* compiled from: ProGuard */
    final class b extends Handler {
        private b() {
        }

        public final void handleMessage(Message message) {
            Object[] objArr = (Object[]) message.obj;
            a aVar = (a) ((WeakReference) objArr[0]).get();
            if (aVar != null) {
                switch (message.what) {
                    case 1:
                        aVar.a(message.arg1, (String) objArr[1]);
                        return;
                    case 2:
                        aVar.a(message.arg1, (O) objArr[1], objArr[2]);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private f() {
        int i = b;
        b = i + 1;
        this.d = i;
        if (b == 0) {
            b = 1;
        }
    }

    public static int a(String str, Map<String, String> map, a aVar, boolean z) {
        if (c == null) {
            c = new b();
        }
        Object fVar = new f();
        fVar.e = str;
        fVar.f = map;
        if (aVar != null) {
            fVar.g = new WeakReference(aVar);
        }
        fVar.h = z;
        new Thread(fVar).start();
        return fVar.d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r10 = this;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r2 = com.uc.apollo.media.impl.O.UNKNOWN;
        r1 = 0;
        r0 = r10.e;	 Catch:{ d -> 0x0051, Throwable -> 0x0090 }
        r3 = r10.f;	 Catch:{ d -> 0x0051, Throwable -> 0x0090 }
        r0 = com.uc.apollo.media.b.c.a(r0, r3);	 Catch:{ d -> 0x0051, Throwable -> 0x0090 }
        if (r0 == 0) goto L_0x004b;
    L_0x0010:
        r2 = com.uc.apollo.media.impl.O.M3U8;	 Catch:{ d -> 0x00cf, Throwable -> 0x0090 }
        r1 = r0.c();	 Catch:{ d -> 0x00cf, Throwable -> 0x0090 }
        if (r1 == 0) goto L_0x00db;
    L_0x0018:
        r1 = com.uc.apollo.media.impl.O.M3U8_LIVE;	 Catch:{ d -> 0x00cf, Throwable -> 0x0090 }
    L_0x001a:
        r2 = r10.h;	 Catch:{ d -> 0x00d5, Throwable -> 0x0090 }
        if (r2 == 0) goto L_0x0022;
    L_0x001e:
        r2 = 1;
        r0.a(r2);	 Catch:{ d -> 0x00d5, Throwable -> 0x0090 }
    L_0x0022:
        r2 = com.uc.apollo.media.impl.O.UNKNOWN;
        if (r1 == r2) goto L_0x0030;
    L_0x0026:
        r2 = new java.lang.StringBuilder;
        r3 = "content type is ";
        r2.<init>(r3);
        r2.append(r1);
    L_0x0030:
        r2 = r10.g;
        if (r2 == 0) goto L_0x004a;
    L_0x0034:
        r2 = c;
        r3 = r10.d;
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = r10.g;
        r4[r6] = r5;
        r4[r7] = r1;
        r4[r8] = r0;
        r0 = r2.obtainMessage(r8, r3, r6, r4);
        r0.sendToTarget();
    L_0x004a:
        return;
    L_0x004b:
        r0 = com.uc.apollo.media.impl.O.PARSE_FAILURE;	 Catch:{ d -> 0x0051, Throwable -> 0x0090 }
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0022;
    L_0x0051:
        r0 = move-exception;
        r9 = r0;
        r0 = r2;
        r2 = r9;
    L_0x0055:
        r3 = r2.a();
        if (r3 == 0) goto L_0x007e;
    L_0x005b:
        r4 = r3.length;
        r5 = 8;
        if (r4 < r5) goto L_0x007e;
    L_0x0060:
        r4 = 4;
        r4 = r3[r4];
        r5 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r4 == r5) goto L_0x007c;
    L_0x0067:
        r4 = 5;
        r4 = r3[r4];
        r5 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        if (r4 == r5) goto L_0x007c;
    L_0x006e:
        r4 = 6;
        r4 = r3[r4];
        r5 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        if (r4 == r5) goto L_0x007c;
    L_0x0075:
        r4 = 7;
        r3 = r3[r4];
        r4 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r3 != r4) goto L_0x007e;
    L_0x007c:
        r0 = com.uc.apollo.media.impl.O.MP4;
    L_0x007e:
        r3 = com.uc.apollo.media.impl.O.UNKNOWN;
        if (r0 != r3) goto L_0x008c;
    L_0x0082:
        r3 = new java.lang.StringBuilder;
        r4 = "parse failure, msg: ";
        r3.<init>(r4);
        r3.append(r2);
    L_0x008c:
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0022;
    L_0x0090:
        r0 = move-exception;
        r1 = com.uc.apollo.media.impl.O.PARSE_FAILURE;
        r1 = a;
        r2 = new java.lang.StringBuilder;
        r3 = "parse failure: ";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        android.util.Log.w(r1, r2);
        r1 = r10.g;
        if (r1 == 0) goto L_0x004a;
    L_0x00ab:
        r1 = c;
        r2 = r10.d;
        r3 = new java.lang.Object[r8];
        r4 = r10.g;
        r3[r6] = r4;
        r4 = new java.lang.StringBuilder;
        r5 = "parse failure: ";
        r4.<init>(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        r3[r7] = r0;
        r0 = r1.obtainMessage(r7, r2, r6, r3);
        r0.sendToTarget();
        goto L_0x004a;
    L_0x00cf:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r9;
        goto L_0x0055;
    L_0x00d5:
        r2 = move-exception;
        r9 = r0;
        r0 = r1;
        r1 = r9;
        goto L_0x0055;
    L_0x00db:
        r1 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.apollo.media.impl.f.run():void");
    }
}
