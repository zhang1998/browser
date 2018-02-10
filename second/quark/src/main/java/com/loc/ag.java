package com.loc;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class ag {
    private static final ag a = new ag();
    private final Map<String, af> b = new HashMap();

    private ag() {
    }

    public static ag a() {
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.loc.af a(android.content.Context r6, com.loc.ep r7) throws java.lang.Exception {
        /*
        r5 = this;
        r0 = 1;
        monitor-enter(r5);
        if (r7 == 0) goto L_0x0027;
    L_0x0004:
        r1 = r7.b();	 Catch:{ all -> 0x0024 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0027;
    L_0x000e:
        r1 = r7.a();	 Catch:{ all -> 0x0024 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0027;
    L_0x0018:
        if (r0 == 0) goto L_0x001c;
    L_0x001a:
        if (r6 != 0) goto L_0x0029;
    L_0x001c:
        r0 = new java.lang.Exception;	 Catch:{ all -> 0x0024 }
        r1 = "sdkInfo or context referance is null";
        r0.<init>(r1);	 Catch:{ all -> 0x0024 }
        throw r0;	 Catch:{ all -> 0x0024 }
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0027:
        r0 = 0;
        goto L_0x0018;
    L_0x0029:
        r2 = r7.a();	 Catch:{ all -> 0x0024 }
        r0 = r5.b;	 Catch:{ all -> 0x0024 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0024 }
        r0 = (com.loc.af) r0;	 Catch:{ all -> 0x0024 }
        if (r0 != 0) goto L_0x004a;
    L_0x0037:
        r1 = new com.loc.am;	 Catch:{ Throwable -> 0x004c }
        r3 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x004c }
        r4 = 1;
        r1.<init>(r3, r7, r4);	 Catch:{ Throwable -> 0x004c }
        r0 = r5.b;	 Catch:{ Throwable -> 0x004e }
        r0.put(r2, r1);	 Catch:{ Throwable -> 0x004e }
        com.loc.an.a(r6, r7);	 Catch:{ Throwable -> 0x004e }
        r0 = r1;
    L_0x004a:
        monitor-exit(r5);
        return r0;
    L_0x004c:
        r1 = move-exception;
        goto L_0x004a;
    L_0x004e:
        r0 = move-exception;
        r0 = r1;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ag.a(android.content.Context, com.loc.ep):com.loc.af");
    }

    public final af b(Context context, ep epVar) throws Exception {
        af afVar = (af) this.b.get(epVar.a());
        if (afVar != null) {
            afVar.a(context, epVar);
            return afVar;
        }
        afVar = new am(context.getApplicationContext(), epVar, false);
        afVar.a(context, epVar);
        this.b.put(epVar.a(), afVar);
        an.a(context, epVar);
        return afVar;
    }
}
