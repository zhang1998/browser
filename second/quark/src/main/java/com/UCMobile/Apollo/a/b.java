package com.UCMobile.Apollo.a;

import android.content.Context;
import android.os.Build.VERSION;
import com.UCMobile.Apollo.Apollo;
import com.UCMobile.Apollo.Global;
import com.UCMobile.Apollo.UCLibraryLoader;
import com.UCMobile.Apollo.e;

/* compiled from: ProGuard */
public final class b {
    private static String a = "";
    private static boolean b = false;

    private static synchronized boolean b() {
        boolean z = true;
        boolean z2 = false;
        synchronized (b.class) {
            int i;
            String version = Apollo.getVersion();
            if (version != null && version.length() > 0) {
                String[] split = version.split("\\.");
                if (split.length >= 4) {
                    try {
                        int parseInt = Integer.parseInt(split[2]) + ((Integer.parseInt(split[0]) * 10000) + (Integer.parseInt(split[1]) * 100));
                        if (parseInt > 21405) {
                            z = false;
                        }
                        z2 = z;
                        i = parseInt;
                        new StringBuilder("isNativeLibrarySupportPlayingDownload()  getVersionString=").append(version).append(", verInt=").append(i);
                    } catch (NumberFormatException e) {
                    }
                }
            }
            i = 0;
            new StringBuilder("isNativeLibrarySupportPlayingDownload()  getVersionString=").append(version).append(", verInt=").append(i);
        }
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean c() {
        /*
        r0 = 1;
        r2 = com.UCMobile.Apollo.a.b.class;
        monitor-enter(r2);
        r1 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0085 }
        r3.<init>();	 Catch:{ all -> 0x0085 }
        r4 = com.UCMobile.Apollo.Global.gApolloSoPath;	 Catch:{ all -> 0x0085 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0085 }
        r4 = "/libinitHelper.so";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0085 }
        r3 = r3.toString();	 Catch:{ all -> 0x0085 }
        r4 = com.UCMobile.Apollo.Global.gLoadFromAppLibPath;	 Catch:{ all -> 0x0085 }
        if (r4 != 0) goto L_0x0088;
    L_0x001e:
        java.lang.System.load(r3);	 Catch:{ UnsatisfiedLinkError -> 0x0026 }
        r1 = r0;
    L_0x0022:
        if (r1 == 0) goto L_0x0088;
    L_0x0024:
        monitor-exit(r2);
        return r0;
    L_0x0026:
        r4 = move-exception;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0085 }
        r6 = "System.load ";
        r5.<init>(r6);	 Catch:{ all -> 0x0085 }
        r5 = r5.append(r3);	 Catch:{ all -> 0x0085 }
        r6 = " failed; ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r6 = r4.getMessage();	 Catch:{ all -> 0x0085 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r6 = ";";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r6 = r4.getCause();	 Catch:{ all -> 0x0085 }
        r5.append(r6);	 Catch:{ all -> 0x0085 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0085 }
        r5.<init>();	 Catch:{ all -> 0x0085 }
        r6 = a;	 Catch:{ all -> 0x0085 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r6 = " ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r5 = r5.append(r3);	 Catch:{ all -> 0x0085 }
        r6 = ":";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r6 = r4.getMessage();	 Catch:{ all -> 0x0085 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r6 = ";";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0085 }
        r4 = r4.getCause();	 Catch:{ all -> 0x0085 }
        r4 = r5.append(r4);	 Catch:{ all -> 0x0085 }
        r4 = r4.toString();	 Catch:{ all -> 0x0085 }
        a = r4;	 Catch:{ all -> 0x0085 }
        goto L_0x0022;
    L_0x0085:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0088:
        r4 = "initHelper";
        java.lang.System.loadLibrary(r4);	 Catch:{ UnsatisfiedLinkError -> 0x008e }
        goto L_0x0024;
    L_0x008e:
        r0 = move-exception;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0085 }
        r5 = "System.loadLibrary initHelper failed; ";
        r4.<init>(r5);	 Catch:{ all -> 0x0085 }
        r5 = r0.getMessage();	 Catch:{ all -> 0x0085 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0085 }
        r5 = ";";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0085 }
        r5 = r0.getCause();	 Catch:{ all -> 0x0085 }
        r4.append(r5);	 Catch:{ all -> 0x0085 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0085 }
        r4.<init>();	 Catch:{ all -> 0x0085 }
        r5 = a;	 Catch:{ all -> 0x0085 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0085 }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0085 }
        r3 = r4.append(r3);	 Catch:{ all -> 0x0085 }
        r4 = ":";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0085 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x0085 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0085 }
        r4 = ";";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0085 }
        r0 = r0.getCause();	 Catch:{ all -> 0x0085 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0085 }
        r0 = r0.toString();	 Catch:{ all -> 0x0085 }
        a = r0;	 Catch:{ all -> 0x0085 }
        r0 = r1;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.UCMobile.Apollo.a.b.c():boolean");
    }

    private static synchronized boolean a(a[] aVarArr) {
        boolean z = false;
        synchronized (b.class) {
            boolean b = b();
            if (!b || c() || VERSION.SDK_INT <= 23) {
                for (int i = 0; i < 2; i++) {
                    if (!a(aVarArr[i], b)) {
                        break;
                    }
                }
                z = true;
            }
        }
        return z;
    }

    private static synchronized boolean a(a aVar, boolean z) {
        boolean z2 = true;
        synchronized (b.class) {
            for (String str : aVar.b) {
                boolean z3;
                String str2 = aVar.a;
                if (Global.gLoadFromAppLibPath) {
                    int length = str2.length();
                    if (length < 7) {
                        new StringBuilder("Cannot load ").append(aVar.a);
                        z3 = false;
                    } else {
                        String substring = str2.substring(3, length - 3);
                        try {
                            UCLibraryLoader.b(substring, z);
                            z3 = true;
                        } catch (UnsatisfiedLinkError e) {
                            new StringBuilder("loadNativeLibrary UCLibraryLoader.loadLibrary ").append(substring).append(" failed");
                            a += " " + str2 + ":" + e.getMessage() + ";" + e.getCause();
                            z3 = false;
                        }
                    }
                } else {
                    try {
                        UCLibraryLoader.a(str + str2, z);
                        z3 = true;
                    } catch (UnsatisfiedLinkError e2) {
                        new StringBuilder("loadNativeLibrary UCLibraryLoader.load").append(str).append(str2).append(" failed");
                        a += " " + str2 + ":" + e2.getMessage() + ";" + e2.getCause();
                        z3 = false;
                    }
                }
                if (z3) {
                    break;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public static synchronized boolean a(Context context) {
        boolean z = true;
        synchronized (b.class) {
            if (!b) {
                a = "";
                String str = Global.gApolloSoPath;
                if (!Global.gLoadFromAppLibPath && e.a(str)) {
                    str = context.getApplicationInfo().dataDir + "/lib/";
                }
                r2 = new a[2];
                r2[0] = new a("libffmpeg.so", new String[]{str});
                r2[1] = new a("libu3player.so", new String[]{str});
                z = a(r2);
                b = z;
            }
        }
        return z;
    }

    public static String a() {
        return a;
    }
}
