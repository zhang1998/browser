package com.uc.weex.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class m {
    private static java.lang.String b(byte[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        if (r5 == 0) goto L_0x0006;
    L_0x0003:
        r0 = r5.length;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        return r0;
    L_0x0008:
        r2 = new java.io.BufferedReader;
        r0 = new java.io.InputStreamReader;
        r3 = new java.io.ByteArrayInputStream;
        r3.<init>(r5);
        r0.<init>(r3);
        r2.<init>(r0);
    L_0x0017:
        r0 = r2.readLine();	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
    L_0x001d:
        r3 = "//WeexBundleInfo:";	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
        r3 = r0.startsWith(r3);	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
        if (r3 == 0) goto L_0x0017;	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
    L_0x0025:
        if (r0 == 0) goto L_0x002f;	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
    L_0x0027:
        r3 = "//WeexBundleInfo:";	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
        r4 = "";	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
        r0 = r0.replace(r3, r4);	 Catch:{ IOException -> 0x0033, all -> 0x0039 }
    L_0x002f:
        com.uc.weex.j.b.a(r2);
        goto L_0x0007;
    L_0x0033:
        r0 = move-exception;
        com.uc.weex.j.b.a(r2);
        r0 = r1;
        goto L_0x0007;
    L_0x0039:
        r0 = move-exception;
        com.uc.weex.j.b.a(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.weex.a.m.b(byte[]):java.lang.String");
    }

    public static n a(byte[] bArr) {
        String b = b(bArr);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(b)) {
            return null;
        }
        JSONObject a = ad.a(b);
        if (a != null) {
            return ad.a(a);
        }
        return null;
    }

    public static n a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(str.getBytes());
    }
}
