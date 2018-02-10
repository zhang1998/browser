package android.mini.support.v4.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class g {
    private static final Object f = new Object();
    private static g g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap();
    private final HashMap<String, ArrayList<f>> c = new HashMap();
    private final ArrayList<e> d = new ArrayList();
    private final Handler e;

    public static g a(Context context) {
        g gVar;
        synchronized (f) {
            if (g == null) {
                g = new g(context.getApplicationContext());
            }
            gVar = g;
        }
        return gVar;
    }

    private g(Context context) {
        this.a = context;
        this.e = new d(this, context.getMainLooper());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Intent r16) {
        /*
        r15 = this;
        r13 = r15.b;
        monitor-enter(r13);
        r2 = r16.getAction();	 Catch:{ all -> 0x00bd }
        r1 = r15.a;	 Catch:{ all -> 0x00bd }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x00bd }
        r0 = r16;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x00bd }
        r5 = r16.getData();	 Catch:{ all -> 0x00bd }
        r4 = r16.getScheme();	 Catch:{ all -> 0x00bd }
        r6 = r16.getCategories();	 Catch:{ all -> 0x00bd }
        r1 = r16.getFlags();	 Catch:{ all -> 0x00bd }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x0092;
    L_0x0027:
        r1 = 1;
        r12 = r1;
    L_0x0029:
        if (r12 == 0) goto L_0x004b;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r7 = "Resolving type ";
        r1.<init>(r7);	 Catch:{ all -> 0x00bd }
        r1 = r1.append(r3);	 Catch:{ all -> 0x00bd }
        r7 = " scheme ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00bd }
        r1 = r1.append(r4);	 Catch:{ all -> 0x00bd }
        r7 = " of intent ";
        r1 = r1.append(r7);	 Catch:{ all -> 0x00bd }
        r0 = r16;
        r1.append(r0);	 Catch:{ all -> 0x00bd }
    L_0x004b:
        r1 = r15.c;	 Catch:{ all -> 0x00bd }
        r7 = r16.getAction();	 Catch:{ all -> 0x00bd }
        r1 = r1.get(r7);	 Catch:{ all -> 0x00bd }
        r0 = r1;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x00bd }
        r8 = r0;
        if (r8 == 0) goto L_0x00f5;
    L_0x005b:
        if (r12 == 0) goto L_0x0067;
    L_0x005d:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r7 = "Action list: ";
        r1.<init>(r7);	 Catch:{ all -> 0x00bd }
        r1.append(r8);	 Catch:{ all -> 0x00bd }
    L_0x0067:
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x006a:
        r1 = r8.size();	 Catch:{ all -> 0x00bd }
        if (r11 >= r1) goto L_0x00c0;
    L_0x0070:
        r1 = r8.get(r11);	 Catch:{ all -> 0x00bd }
        r0 = r1;
        r0 = (android.mini.support.v4.b.f) r0;	 Catch:{ all -> 0x00bd }
        r9 = r0;
        if (r12 == 0) goto L_0x0086;
    L_0x007a:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r7 = "Matching against filter ";
        r1.<init>(r7);	 Catch:{ all -> 0x00bd }
        r7 = r9.a;	 Catch:{ all -> 0x00bd }
        r1.append(r7);	 Catch:{ all -> 0x00bd }
    L_0x0086:
        r1 = r9.c;	 Catch:{ all -> 0x00bd }
        if (r1 == 0) goto L_0x0095;
    L_0x008a:
        if (r12 == 0) goto L_0x00fa;
    L_0x008c:
        r1 = r10;
    L_0x008d:
        r7 = r11 + 1;
        r11 = r7;
        r10 = r1;
        goto L_0x006a;
    L_0x0092:
        r1 = 0;
        r12 = r1;
        goto L_0x0029;
    L_0x0095:
        r1 = r9.a;	 Catch:{ all -> 0x00bd }
        r7 = "LocalBroadcastManager";
        r1 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00bd }
        if (r1 < 0) goto L_0x00fa;
    L_0x009f:
        if (r12 == 0) goto L_0x00af;
    L_0x00a1:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00bd }
        r14 = "  Filter matched!  match=0x";
        r7.<init>(r14);	 Catch:{ all -> 0x00bd }
        r1 = java.lang.Integer.toHexString(r1);	 Catch:{ all -> 0x00bd }
        r7.append(r1);	 Catch:{ all -> 0x00bd }
    L_0x00af:
        if (r10 != 0) goto L_0x00f8;
    L_0x00b1:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00bd }
        r1.<init>();	 Catch:{ all -> 0x00bd }
    L_0x00b6:
        r1.add(r9);	 Catch:{ all -> 0x00bd }
        r7 = 1;
        r9.c = r7;	 Catch:{ all -> 0x00bd }
        goto L_0x008d;
    L_0x00bd:
        r1 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x00bd }
        throw r1;
    L_0x00c0:
        if (r10 == 0) goto L_0x00f5;
    L_0x00c2:
        r1 = 0;
        r2 = r1;
    L_0x00c4:
        r1 = r10.size();	 Catch:{ all -> 0x00bd }
        if (r2 >= r1) goto L_0x00d7;
    L_0x00ca:
        r1 = r10.get(r2);	 Catch:{ all -> 0x00bd }
        r1 = (android.mini.support.v4.b.f) r1;	 Catch:{ all -> 0x00bd }
        r3 = 0;
        r1.c = r3;	 Catch:{ all -> 0x00bd }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x00c4;
    L_0x00d7:
        r1 = r15.d;	 Catch:{ all -> 0x00bd }
        r2 = new android.mini.support.v4.b.e;	 Catch:{ all -> 0x00bd }
        r0 = r16;
        r2.<init>(r0, r10);	 Catch:{ all -> 0x00bd }
        r1.add(r2);	 Catch:{ all -> 0x00bd }
        r1 = r15.e;	 Catch:{ all -> 0x00bd }
        r2 = 1;
        r1 = r1.hasMessages(r2);	 Catch:{ all -> 0x00bd }
        if (r1 != 0) goto L_0x00f2;
    L_0x00ec:
        r1 = r15.e;	 Catch:{ all -> 0x00bd }
        r2 = 1;
        r1.sendEmptyMessage(r2);	 Catch:{ all -> 0x00bd }
    L_0x00f2:
        r1 = 1;
        monitor-exit(r13);	 Catch:{ all -> 0x00bd }
    L_0x00f4:
        return r1;
    L_0x00f5:
        monitor-exit(r13);	 Catch:{ all -> 0x00bd }
        r1 = 0;
        goto L_0x00f4;
    L_0x00f8:
        r1 = r10;
        goto L_0x00b6;
    L_0x00fa:
        r1 = r10;
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.b.g.a(android.content.Intent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(android.mini.support.v4.b.g r8) {
        /*
        r2 = 0;
    L_0x0001:
        r1 = r8.b;
        monitor-enter(r1);
        r0 = r8.d;	 Catch:{ all -> 0x003f }
        r0 = r0.size();	 Catch:{ all -> 0x003f }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        return;
    L_0x000e:
        r4 = new android.mini.support.v4.b.e[r0];	 Catch:{ all -> 0x003f }
        r0 = r8.d;	 Catch:{ all -> 0x003f }
        r0.toArray(r4);	 Catch:{ all -> 0x003f }
        r0 = r8.d;	 Catch:{ all -> 0x003f }
        r0.clear();	 Catch:{ all -> 0x003f }
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        r3 = r2;
    L_0x001c:
        r0 = r4.length;
        if (r3 >= r0) goto L_0x0001;
    L_0x001f:
        r5 = r4[r3];
        r1 = r2;
    L_0x0022:
        r0 = r5.b;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0042;
    L_0x002a:
        r0 = r5.b;
        r0 = r0.get(r1);
        r0 = (android.mini.support.v4.b.f) r0;
        r0 = r0.b;
        r6 = r8.a;
        r7 = r5.a;
        r0.onReceive(r6, r7);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0022;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003f }
        throw r0;
    L_0x0042:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.mini.support.v4.b.g.a(android.mini.support.v4.b.g):void");
    }
}
