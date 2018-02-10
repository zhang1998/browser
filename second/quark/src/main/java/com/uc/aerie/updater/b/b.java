package com.uc.aerie.updater.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public final class b {
    private static String a = null;

    public static synchronized String a(Context context) {
        ZipFile zipFile;
        Throwable th;
        String str;
        synchronized (b.class) {
            if (TextUtils.isEmpty(a)) {
                ZipFile zipFile2;
                try {
                    if (VERSION.SDK_INT >= 21) {
                        Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
                        declaredField.setAccessible(true);
                        a = (String) declaredField.get(context.getApplicationInfo());
                        zipFile2 = null;
                    } else if (VERSION.SDK_INT >= 14) {
                        String str2 = Build.CPU_ABI;
                        String str3 = Build.CPU_ABI2;
                        zipFile2 = new ZipFile(context.getApplicationInfo().sourceDir);
                        try {
                            Enumeration entries = zipFile2.entries();
                            while (entries.hasMoreElements()) {
                                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                                if (zipEntry.getName().startsWith("lib/") && zipEntry.getName().endsWith(".so")) {
                                    if (zipEntry.getName().startsWith("lib/" + str2 + "/")) {
                                        a = str2;
                                        break;
                                    } else if (zipEntry.getName().startsWith("lib/" + str3 + "/")) {
                                        a = str3;
                                        break;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        zipFile2 = null;
                    }
                    SharePatchFileUtil.closeZip(zipFile2);
                } catch (Throwable th3) {
                    th = th3;
                    zipFile2 = null;
                    SharePatchFileUtil.closeZip(zipFile2);
                    throw th;
                }
            }
            str = a;
        }
        return str;
    }
}
