package com.ucweb.common.util.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class a {
    private static final Object a = new Object();
    private static List<PackageInfo> b;

    public static String a() {
        String str = "unknown";
        PackageInfo c = c(d.a().getPackageName());
        if (c == null) {
            return str;
        }
        Signature[] signatureArr = c.signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Signature hashCode : signatureArr) {
            stringBuilder.append(hashCode.hashCode());
        }
        return stringBuilder.toString();
    }

    private static PackageInfo c(String str) {
        try {
            return d.a().getPackageManager().getPackageInfo(str, 64);
        } catch (Throwable th) {
            return null;
        }
    }

    private static List<PackageInfo> d() {
        List<PackageInfo> installedPackages;
        PackageManager packageManager = d.a().getPackageManager();
        synchronized (a) {
            try {
                installedPackages = packageManager.getInstalledPackages(0);
            } catch (Throwable th) {
                c.a(th.toString());
                return null;
            }
        }
        return installedPackages;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.pm.PackageInfo a(java.lang.String r5) {
        /*
        r1 = 0;
        r3 = a;
        monitor-enter(r3);
        r0 = b;	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = d();	 Catch:{ all -> 0x0033 }
        b = r0;	 Catch:{ all -> 0x0033 }
    L_0x000e:
        if (r5 == 0) goto L_0x0014;
    L_0x0010:
        r0 = b;	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0017;
    L_0x0014:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = 0;
        r2 = r0;
    L_0x0019:
        r0 = b;	 Catch:{ all -> 0x0033 }
        r0 = r0.size();	 Catch:{ all -> 0x0033 }
        if (r2 >= r0) goto L_0x003a;
    L_0x0021:
        r0 = b;	 Catch:{ all -> 0x0033 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0033 }
        r0 = (android.content.pm.PackageInfo) r0;	 Catch:{ all -> 0x0033 }
        r4 = r0.packageName;	 Catch:{ all -> 0x0033 }
        r4 = r5.equals(r4);	 Catch:{ all -> 0x0033 }
        if (r4 == 0) goto L_0x0036;
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x0016;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0019;
    L_0x003a:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        r0 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucweb.common.util.g.a.a(java.lang.String):android.content.pm.PackageInfo");
    }

    public static List<PackageInfo> b() {
        List arrayList;
        synchronized (a) {
            if (b == null) {
                b = d();
            }
            arrayList = new ArrayList(b != null ? b.size() : 0);
            if (b != null) {
                for (PackageInfo packageInfo : b) {
                    if (packageInfo != null) {
                        arrayList.add(packageInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    public static int c() throws NameNotFoundException {
        PackageInfo a = a(d.a().getPackageName());
        if (a != null) {
            return a.versionCode;
        }
        throw new NameNotFoundException();
    }

    public static boolean b(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = d.a().getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return true;
    }
}
