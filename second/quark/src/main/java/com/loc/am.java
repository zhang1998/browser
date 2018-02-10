package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexFile;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: ProGuard */
final class am extends af {
    private PublicKey g = null;

    public am(Context context, ep epVar, boolean z) throws Exception {
        super(context, epVar);
        String b = ak.b(context, epVar.a(), epVar.b());
        String a = ak.a(context);
        if (TextUtils.isEmpty(b) || TextUtils.isEmpty(a)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
        File file = new File(b);
        File parentFile = file.getParentFile();
        if (!file.exists()) {
            if (parentFile != null && parentFile.exists()) {
                ak.c(context, epVar.a(), epVar.b());
            }
            throw new Exception("file not exist!");
        } else if (z) {
            String str = a + File.separator + ak.a(file.getName());
            try {
                if (this.c == null) {
                    b();
                    this.c = DexFile.loadDex(b, str, 0);
                }
                new al(this, context, b, a).start();
            } catch (Throwable e) {
                es.a(e, "DynamicClassLoader", "loadDexFile()");
                throw new Exception("load dex fail");
            }
        }
    }

    private static void a(java.util.jar.JarFile r4, java.util.jar.JarEntry r5) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
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
        r1 = r4.getInputStream(r5);	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
    L_0x0009:
        r2 = r1.read(r0);	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
        if (r2 > 0) goto L_0x0009;
    L_0x000f:
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.close();
    L_0x0014:
        return;
    L_0x0015:
        r0 = move-exception;
        r2 = "DyLoader";	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
        r3 = "loadJa";	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
        com.loc.es.a(r0, r2, r3);	 Catch:{ Throwable -> 0x0015, all -> 0x0023 }
        if (r1 == 0) goto L_0x0014;
    L_0x001f:
        r1.close();
        goto L_0x0014;
    L_0x0023:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0029;
    L_0x0026:
        r1.close();
    L_0x0029:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.am.a(java.util.jar.JarFile, java.util.jar.JarEntry):void");
    }

    private boolean a(n nVar, String str, String str2) {
        String a = ak.a(this.a, str);
        if (ak.a(nVar, str, a, this.e)) {
            return true;
        }
        if (aj.a(nVar, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f)) {
            ap apVar = new ap(str, ek.a(a), this.e.a(), this.e.b(), str2);
            apVar.f = "useod";
            nVar.a(apVar.a(), aq.b(str));
        }
        return true;
    }

    private boolean a(File file) {
        JarFile jarFile = null;
        try {
            if (this.g == null) {
                this.g = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(ej.b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5")))).getPublicKey();
            }
        } catch (Throwable th) {
            th = th;
            try {
                Throwable th2;
                es.a(th2, "DyLoader", "verify");
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable th22) {
                        es.a(th22, "DyLoader", "verify1");
                    }
                }
                return false;
            } catch (Throwable th3) {
                th22 = th3;
                if (jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (Throwable th4) {
                        es.a(th4, "DyLoader", "verify1");
                    }
                }
                throw th22;
            }
        }
        JarFile jarFile2 = new JarFile(file);
        try {
            JarEntry jarEntry = jarFile2.getJarEntry(ShareConstants.DEX_IN_JAR);
            if (jarEntry == null) {
                try {
                    jarFile2.close();
                } catch (Throwable th222) {
                    es.a(th222, "DyLoader", "verify1");
                }
                return false;
            }
            a(jarFile2, jarEntry);
            Certificate[] certificates = jarEntry.getCertificates();
            if (certificates == null) {
                try {
                    jarFile2.close();
                } catch (Throwable th2222) {
                    es.a(th2222, "DyLoader", "verify1");
                }
                return false;
            }
            boolean a = a(certificates);
            try {
                jarFile2.close();
                return a;
            } catch (Throwable th42) {
                es.a(th42, "DyLoader", "verify1");
                return a;
            }
        } catch (Throwable th5) {
            th2222 = th5;
            jarFile = jarFile2;
            if (jarFile != null) {
                jarFile.close();
            }
            throw th2222;
        }
    }

    private boolean a(Certificate[] certificateArr) {
        try {
            if (certificateArr.length > 0) {
                int length = certificateArr.length - 1;
                if (length >= 0) {
                    certificateArr[length].verify(this.g);
                    return true;
                }
            }
        } catch (Throwable e) {
            es.a(e, "DyLoader", "check");
        }
        return false;
    }

    final void a(Context context, String str, String str2) throws Exception {
        boolean z = false;
        new Date().getTime();
        try {
            n nVar = new n(context, ao.b());
            File file = new File(str);
            aq a = aj.a(nVar, file.getName());
            if (a != null) {
                this.f = a.d;
            }
            ep epVar = this.e;
            String absolutePath = file.getAbsolutePath();
            if (a(new File(absolutePath))) {
                z = ak.a(nVar, ak.a(this.a, epVar.a(), epVar.b()), absolutePath, epVar);
            }
            if (!z) {
                this.d = false;
                ak.a(this.a, nVar, file.getName());
                Object a2 = ak.a(this.a, nVar, this.e);
                if (!TextUtils.isEmpty(a2)) {
                    this.f = a2;
                    a(this.a, this.e);
                }
            }
            if (file.exists()) {
                if (new File(str2 + File.separator + ak.a(file.getName())).exists() && !a(nVar, ak.a(file.getName()), this.f)) {
                    a(this.a, this.e);
                }
                new Date().getTime();
            }
        } catch (Throwable th) {
            es.a(th, "DynamicClassLoader", "verifyDynamicSDK()");
        }
    }

    protected final void a(File file, String str, String str2, n nVar) {
        if (!TextUtils.isEmpty(this.f) || !file.exists()) {
            String a = ek.a(str);
            String name = file.getName();
            ap apVar = new ap(name, a, this.e.a(), this.e.b(), str2);
            apVar.f = "useod";
            nVar.a(apVar.a(), aq.b(name));
        }
    }

    protected final Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            if (this.c == null) {
                throw new ClassNotFoundException(str);
            }
            Class<?> cls = (Class) this.b.get(str);
            if (cls == null) {
                cls = this.c.loadClass(str, this);
                if (cls == null) {
                    throw new ClassNotFoundException(str);
                }
                this.b.put(str, cls);
            }
            return cls;
        } catch (Throwable th) {
            es.a(th, "DynamicClassLoader", "findCl");
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(str);
        }
    }
}
