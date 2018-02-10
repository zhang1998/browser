package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashSet;

/* compiled from: ProGuard */
public final class c {

    /* compiled from: ProGuard */
    final class a {
        public static Signature[] a(Context context, String str) {
            Signature[] signatureArr = null;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                if (packageInfo != null) {
                    signatureArr = packageInfo.signatures;
                }
            } catch (Exception e) {
                Log.e("SignatureVerifier", e.getMessage());
            }
            return signatureArr;
        }

        public static Signature[] b(Context context, String str) {
            Signature[] signatureArr;
            Throwable th;
            Log.d("SignatureVerifier", String.format("getUninstalledAPKSignature(): archiveApkFilePath = %1s", new Object[]{str}));
            try {
                Object newInstance;
                Object invoke;
                long currentTimeMillis = System.currentTimeMillis();
                Class cls = Class.forName("android.content.pm.PackageParser");
                if (VERSION.SDK_INT >= 21) {
                    newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                } else {
                    newInstance = cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{""});
                }
                if (VERSION.SDK_INT >= 21) {
                    invoke = cls.getMethod("parsePackage", new Class[]{File.class, Integer.TYPE}).invoke(newInstance, new Object[]{new File(str), Integer.valueOf(0)});
                } else {
                    invoke = cls.getMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE}).invoke(newInstance, new Object[]{new File(str), null, context.getResources().getDisplayMetrics(), Integer.valueOf(0)});
                }
                cls.getMethod("collectCertificates", new Class[]{Class.forName("android.content.pm.PackageParser$Package"), Integer.TYPE}).invoke(newInstance, new Object[]{invoke, Integer.valueOf(64)});
                signatureArr = (Signature[]) invoke.getClass().getField("mSignatures").get(invoke);
                if (signatureArr == null || signatureArr.length <= 0) {
                    Log.e("SignatureVerifier", "摘要校验失败");
                    signatureArr = null;
                } else {
                    try {
                        Log.d("SignatureVerifier", "摘要校验成功!");
                    } catch (Throwable th2) {
                        th = th2;
                        Log.e("SignatureVerifier", th.getMessage());
                        return signatureArr;
                    }
                }
                Log.i("SignatureVerifier", "耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            } catch (Throwable th3) {
                Throwable th4 = th3;
                signatureArr = null;
                th = th4;
                Log.e("SignatureVerifier", th.getMessage());
                return signatureArr;
            }
            return signatureArr;
        }

        public static PublicKey[] a(Signature[] signatureArr) {
            if (signatureArr != null) {
                try {
                    if (signatureArr.length != 0) {
                        int length = signatureArr.length;
                        PublicKey[] publicKeyArr = new PublicKey[length];
                        for (int i = 0; i < length; i++) {
                            publicKeyArr[i] = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i].toByteArray()))).getPublicKey();
                        }
                        return publicKeyArr;
                    }
                } catch (Exception e) {
                    Log.e("SignatureVerifier", "获取公钥异常：\n" + e.getMessage());
                    return null;
                }
            }
            return null;
        }

        public static final boolean a(PublicKey[] publicKeyArr) {
            return publicKeyArr == null || publicKeyArr.length <= 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r16, android.content.Context r17, android.content.Context r18, java.lang.String r19, android.webkit.ValueCallback<java.lang.Object[]> r20) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.uc.webview.export.internal.utility.c.a(java.lang.String, android.content.Context, android.content.Context, java.lang.String, android.webkit.ValueCallback):boolean. bs: [B:24:0x00c9, B:66:0x0276]
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
        r2 = new java.io.File;
        r0 = r16;
        r2.<init>(r0);
        r2 = r2.exists();
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        r2 = 0;
    L_0x000e:
        return r2;
    L_0x000f:
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "verify: file = ";
        r3.<init>(r4);
        r0 = r16;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        r6 = java.lang.System.currentTimeMillis();
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r0 = r17;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r1 = r16;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = com.uc.webview.export.internal.utility.c.a.b(r0, r1);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r3 == 0) goto L_0x003a;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x0037:
        r2 = r3.length;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r2 > 0) goto L_0x009a;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x003a:
        r2 = 1;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x003b:
        if (r2 == 0) goto L_0x009c;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x003d:
        r2 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = "verify: failed: Signatures of archive is empty. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3.<init>(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = r8 - r4;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r2, r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r20 == 0) goto L_0x0078;
    L_0x005f:
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r3 = 0;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r4 = 8;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r3 = 1;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r4 = 1;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r0 = r20;	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
        r0.onReceiveValue(r2);	 Catch:{ Throwable -> 0x03dd, all -> 0x03b0 }
    L_0x0078:
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        r2 = 0;
        goto L_0x000e;
    L_0x009a:
        r2 = 0;
        goto L_0x003b;
    L_0x009c:
        r8 = com.uc.webview.export.internal.utility.c.a.a(r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = com.uc.webview.export.internal.utility.c.a.a(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r2 == 0) goto L_0x0103;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x00a6:
        r2 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = "verify: failed: PublicKeys of archive is empty. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3.<init>(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = r8 - r4;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r2, r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r20 == 0) goto L_0x00e1;
    L_0x00c8:
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r3 = 0;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r4 = 8;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r3 = 1;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r4 = 2;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r0 = r20;	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
        r0.onReceiveValue(r2);	 Catch:{ Throwable -> 0x03da, all -> 0x03b0 }
    L_0x00e1:
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        r2 = 0;
        goto L_0x000e;
    L_0x0103:
        r2 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r9 = "verify: step 0: get PublicKeys of archive ok. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3.<init>(r9);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = r10 - r4;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r2, r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r18 == 0) goto L_0x019b;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x0125:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = r18.getPackageName();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r0 = r17;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = com.uc.webview.export.internal.utility.c.a.a(r0, r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = a(r8, r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r4 == 0) goto L_0x017b;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x0139:
        r4 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = "verify: step 1: get Signatures of app from current context and verify ok. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5.<init>(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r8 - r2;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r5.append(r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r4, r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        r2 = 1;
        goto L_0x000e;
    L_0x017b:
        r4 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r9 = "verify: step 1: get Signatures of app from current context and verify failed. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5.<init>(r9);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r10 - r2;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r5.append(r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r4, r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x019b:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = "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";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = 2;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = android.util.Base64.decode(r2, r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r17.getCacheDir();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4.<init>();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r9 = "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";	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r9 = com.uc.webview.export.cyclone.UCCyclone.getSourceHash(r9);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = r4.append(r9);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r9 = "_2336_";	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = r4.append(r9);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r9 = r2.length;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r9 = java.lang.String.valueOf(r9);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = r4.append(r9);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r5.<init>(r3, r4);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r5.exists();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r3 == 0) goto L_0x01e7;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x01d7:
        r3 = r5.isFile();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r3 == 0) goto L_0x01e7;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x01dd:
        r12 = r5.length();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r2.length;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r14 = (long) r3;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r3 == 0) goto L_0x0223;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x01e7:
        r9 = new java.io.File;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r17.getCacheDir();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = java.lang.String.valueOf(r12);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r9.<init>(r3, r4);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r9.exists();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r3 == 0) goto L_0x0201;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x01fe:
        r9.delete();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x0201:
        r4 = 0;
        r3 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0274 }
        r3.<init>(r9);	 Catch:{ all -> 0x0274 }
        r3.write(r2);	 Catch:{ all -> 0x03d7 }
        com.uc.webview.export.cyclone.UCCyclone.close(r3);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r5.exists();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r3 == 0) goto L_0x0216;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x0213:
        r5.delete();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x0216:
        r12 = r9.length();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r2 = r2.length;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r2 = (long) r2;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r2 != 0) goto L_0x0223;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x0220:
        r9.renameTo(r5);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x0223:
        r2 = r5.getAbsolutePath();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r0 = r17;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r2 = com.uc.webview.export.internal.utility.c.a.b(r0, r2);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r2 = a(r8, r2);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        if (r2 == 0) goto L_0x027b;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x0233:
        r2 = "SignatureVerifier";	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = "verify: step 2: get Signatures of app from hardcode app and verify ok. Costs ";	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = r4 - r10;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r4 = "ms.";	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r2, r3);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        r2 = 1;
        goto L_0x000e;
    L_0x0274:
        r2 = move-exception;
        r3 = r4;
    L_0x0276:
        com.uc.webview.export.cyclone.UCCyclone.close(r3);	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
        throw r2;	 Catch:{ Throwable -> 0x027a, all -> 0x03b0 }
    L_0x027a:
        r2 = move-exception;
    L_0x027b:
        r2 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = "verify: step 2: get Signatures of app from hardcode app and verify failed. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = r4 - r10;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r2, r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r19.length();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r2 <= 0) goto L_0x032c;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x02a0:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r0 = r17;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r1 = r19;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = com.uc.webview.export.internal.utility.c.a.a(r0, r1);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r4 = a(r8, r4);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        if (r4 == 0) goto L_0x0300;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x02b2:
        r4 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = "verify: step 3: get Signatures of app from ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5.<init>(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r0 = r19;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = r5.append(r0);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = " and verify ok. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = r5.append(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r8 - r2;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r5.append(r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r4, r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        r2 = 1;
        goto L_0x000e;
    L_0x0300:
        r4 = "SignatureVerifier";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = "verify: step 3: get Signatures of app from ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5.<init>(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r0 = r19;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = r5.append(r0);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = " and verify failed. Costs ";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r5 = r5.append(r8);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r8 - r2;	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r5.append(r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r3 = "ms.";	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
        com.uc.webview.export.internal.utility.Log.d(r4, r2);	 Catch:{ Throwable -> 0x0369, all -> 0x03b0 }
    L_0x032c:
        if (r20 == 0) goto L_0x0347;
    L_0x032e:
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r3 = 0;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r4 = 8;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r3 = 1;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r4 = 3;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r0 = r20;	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
        r0.onReceiveValue(r2);	 Catch:{ Throwable -> 0x03d4, all -> 0x03b0 }
    L_0x0347:
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
    L_0x0366:
        r2 = 0;
        goto L_0x000e;
    L_0x0369:
        r2 = move-exception;
        if (r20 == 0) goto L_0x0390;
    L_0x036c:
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r4 = 0;	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r5 = 8;	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r4 = 1;	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r2 = r2.getClass();	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r2 = r2.getName();	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r2 = r2.hashCode();	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r3[r4] = r2;	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r0 = r20;	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
        r0.onReceiveValue(r3);	 Catch:{ Throwable -> 0x03d2, all -> 0x03b0 }
    L_0x0390:
        r2 = "SignatureVerifier";
        r3 = new java.lang.StringBuilder;
        r4 = "Verify: total costs:";
        r3.<init>(r4);
        r4 = java.lang.System.currentTimeMillis();
        r4 = r4 - r6;
        r3 = r3.append(r4);
        r4 = "ms";
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.uc.webview.export.internal.utility.Log.d(r2, r3);
        goto L_0x0366;
    L_0x03b0:
        r2 = move-exception;
        r3 = "SignatureVerifier";
        r4 = new java.lang.StringBuilder;
        r5 = "Verify: total costs:";
        r4.<init>(r5);
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r4 = r4.append(r6);
        r5 = "ms";
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.uc.webview.export.internal.utility.Log.d(r3, r4);
        throw r2;
    L_0x03d2:
        r2 = move-exception;
        goto L_0x0390;
    L_0x03d4:
        r2 = move-exception;
        goto L_0x0347;
    L_0x03d7:
        r2 = move-exception;
        goto L_0x0276;
    L_0x03da:
        r2 = move-exception;
        goto L_0x00e1;
    L_0x03dd:
        r2 = move-exception;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.utility.c.a(java.lang.String, android.content.Context, android.content.Context, java.lang.String, android.webkit.ValueCallback):boolean");
    }

    private static final boolean a(PublicKey[] publicKeyArr, Signature[] signatureArr) {
        try {
            PublicKey[] a = a.a(signatureArr);
            if (a.a(a)) {
                Log.d("SignatureVerifier", "公钥校验错误：Implement.isEmpty(appPublicKeys) == true");
                return false;
            }
            boolean z;
            if (a == null || publicKeyArr == null) {
                Log.e("SignatureVerifier", "Sign.equals: s1 == null || s2 == null");
            } else {
                HashSet hashSet = new HashSet();
                for (Object add : a) {
                    hashSet.add(add);
                }
                HashSet hashSet2 = new HashSet();
                for (Object add2 : publicKeyArr) {
                    hashSet2.add(add2);
                }
                if (hashSet.equals(hashSet2)) {
                    z = true;
                    if (!z) {
                        return true;
                    }
                    Log.d("SignatureVerifier", "公钥校验错误：Implement.equals(appPublicKeys, archiveKeys) == false");
                    return false;
                }
            }
            z = false;
            if (!z) {
                return true;
            }
            Log.d("SignatureVerifier", "公钥校验错误：Implement.equals(appPublicKeys, archiveKeys) == false");
            return false;
        } catch (Throwable th) {
            Log.d("SignatureVerifier", "公钥校验错误：Implement.isEmpty(appPublicKeys) == true");
            return false;
        }
    }
}
