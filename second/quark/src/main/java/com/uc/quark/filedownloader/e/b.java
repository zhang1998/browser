package com.uc.quark.filedownloader.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import com.uc.quark.ad;
import com.uc.quark.filedownloader.contentprovider.a;
import com.uc.quark.filedownloader.d.c;
import com.uc.quark.w;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: ProGuard */
public class b {
    private static int a = 65536;
    private static long b = 2000;
    private static String c;
    private static Boolean d;
    private static Boolean e = null;
    private static final Pattern f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Object g = new Object();

    public static void a(int i) throws IllegalAccessException {
        a = i;
    }

    public static void a(long j) throws IllegalAccessException {
        b = j;
    }

    public static int a() {
        return a;
    }

    public static long b() {
        return b;
    }

    public static boolean c() {
        return true;
    }

    public static String d() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (e.a().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return e.a().getExternalCacheDir().getAbsolutePath();
    }

    public static String a(String str) {
        return c(d(), e(str));
    }

    public static String b(String str) {
        return e(str);
    }

    private static String c(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        } else if (str == null) {
            throw new IllegalStateException("can't generate real path, the directory is null");
        } else {
            return a("%s%s%s", str, File.separator, str2);
        }
    }

    public static void c(String str) {
        c = str;
    }

    public static String d(String str) {
        return a("%s.temp", str);
    }

    public static int a(String str, String str2) {
        return a(str, str2, false);
    }

    public static int a(String str, String str2, boolean z) {
        if (z) {
            return e(a("%sp%s@dir", str, str2)).hashCode();
        }
        return e(a("%sp%s", str, str2)).hashCode();
    }

    public static String e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                if ((b & 255) < 16) {
                    stringBuilder.append(SettingsConst.FALSE);
                }
                stringBuilder.append(Integer.toHexString(b & 255));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    public static boolean a(Context context) {
        if (d != null) {
            return d.booleanValue();
        }
        boolean z;
        if (h.a().d) {
            z = true;
        } else {
            int myPid = Process.myPid();
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                j.e(b.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    z = runningAppProcessInfo.processName.endsWith(":filedownloader");
                    break;
                }
            }
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        d = valueOf;
        return valueOf.booleanValue();
    }

    public static String[] f(String str) {
        String[] split = str.split("\n");
        String[] strArr = new String[(split.length * 2)];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split(": ");
            strArr[i * 2] = split2[0];
            strArr[(i * 2) + 1] = split2[1];
        }
        return strArr;
    }

    public static long g(String str) {
        StatFs statFs = new StatFs(str);
        if (VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes();
        }
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static String a(String str, Object... objArr) {
        try {
            return String.format(str, objArr);
        } catch (Exception e) {
            return "";
        }
    }

    public static void b(Context context) {
        File d = d(context);
        try {
            d.getParentFile().mkdirs();
            d.createNewFile();
        } catch (IOException e) {
        }
    }

    public static boolean c(Context context) {
        if (e == null) {
            e = Boolean.valueOf(d(context).exists());
        }
        return e.booleanValue();
    }

    private static File d(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String h(String str) {
        String str2 = null;
        if (str != null) {
            try {
                Matcher matcher = f.matcher(str);
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
            } catch (IllegalStateException e) {
            }
        }
        return str2;
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return c(str, str2);
    }

    public static String i(String str) {
        int i = 2;
        int length = str.length();
        int i2;
        if (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') {
            i2 = 2;
        } else {
            i2 = 0;
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || r0 <= 0) {
            i = lastIndexOf;
        }
        if (i == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        if (str.indexOf(File.separatorChar) == i && str.charAt(r0) == File.separatorChar) {
            return str.substring(0, i + 1);
        }
        return str.substring(0, i);
    }

    public static String j(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean e() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.a().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean k(String str) {
        return e.a().checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r9, long r10) {
        /*
        r2 = 0;
        r1 = 1;
        r0 = 0;
        r3 = r9.exists();	 Catch:{ IOException -> 0x002f, all -> 0x003e }
        if (r3 != 0) goto L_0x0010;
    L_0x0009:
        r3 = r9.createNewFile();	 Catch:{ IOException -> 0x002f, all -> 0x003e }
        if (r3 != 0) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x002f, all -> 0x003e }
        r3.<init>(r9);	 Catch:{ IOException -> 0x002f, all -> 0x003e }
        r2 = r3.getChannel();	 Catch:{ IOException -> 0x004f, all -> 0x004d }
        r4 = 1;
        r4 = java.nio.ByteBuffer.allocate(r4);	 Catch:{ IOException -> 0x0053, all -> 0x004d }
        r6 = 1;
        r6 = r10 - r6;
        r2.write(r4, r6);	 Catch:{ IOException -> 0x0053, all -> 0x004d }
        if (r2 == 0) goto L_0x002a;
    L_0x0027:
        r2.close();	 Catch:{ IOException -> 0x0057 }
    L_0x002a:
        r3.close();	 Catch:{ IOException -> 0x0057 }
    L_0x002d:
        r0 = r1;
        goto L_0x000f;
    L_0x002f:
        r1 = move-exception;
        r1 = r2;
    L_0x0031:
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r1.close();	 Catch:{ IOException -> 0x003c }
    L_0x0036:
        if (r2 == 0) goto L_0x000f;
    L_0x0038:
        r2.close();	 Catch:{ IOException -> 0x003c }
        goto L_0x000f;
    L_0x003c:
        r1 = move-exception;
        goto L_0x000f;
    L_0x003e:
        r0 = move-exception;
        r3 = r2;
    L_0x0040:
        if (r2 == 0) goto L_0x0045;
    L_0x0042:
        r2.close();	 Catch:{ IOException -> 0x004b }
    L_0x0045:
        if (r3 == 0) goto L_0x004a;
    L_0x0047:
        r3.close();	 Catch:{ IOException -> 0x004b }
    L_0x004a:
        throw r0;
    L_0x004b:
        r1 = move-exception;
        goto L_0x004a;
    L_0x004d:
        r0 = move-exception;
        goto L_0x0040;
    L_0x004f:
        r1 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0031;
    L_0x0053:
        r1 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0031;
    L_0x0057:
        r0 = move-exception;
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.quark.filedownloader.e.b.a(java.io.File, long):boolean");
    }

    public static boolean a(int i, com.uc.quark.filedownloader.model.b bVar) {
        if (bVar == null) {
            if (!j.a) {
                return false;
            }
            j.d(b.class, "can't continue %d model == null", Integer.valueOf(i));
            return false;
        } else if (bVar.b() != null) {
            return a(i, bVar.b());
        } else {
            if (!j.a) {
                return false;
            }
            j.d(b.class, "can't continue %d temp path == null", Integer.valueOf(i));
            return false;
        }
    }

    public static boolean a(int i, String str) {
        if (str != null) {
            if (new File(str).exists()) {
                return true;
            }
            if (!j.a) {
                return false;
            }
            j.d(b.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(r3), Boolean.valueOf(r2.isDirectory()));
            return false;
        } else if (!j.a) {
            return false;
        } else {
            j.d(b.class, "can't continue %d path = null", Integer.valueOf(i));
            return false;
        }
    }

    public static synchronized void b(String str, String str2) {
        synchronized (b.class) {
            synchronized (g) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                } else {
                    File file = new File(str2);
                    try {
                        File file2 = new File(str);
                        if (file2.exists()) {
                            long length = file2.length();
                            if (file2.delete()) {
                                j.e("renameTempFile", "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", str, Long.valueOf(length), Long.valueOf(file.length()));
                            } else {
                                throw new IllegalStateException(a("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", str, Long.valueOf(length)));
                            }
                        }
                        file.renameTo(file2);
                        if (file.exists() && !file.delete()) {
                            j.e("renameTempFile", "delete the temp file(%s) failed, on completed downloading.", str2);
                        }
                    } catch (Throwable th) {
                        if (file.exists() && !file.delete()) {
                            j.e("renameTempFile", "delete the temp file(%s) failed, on completed downloading.", str2);
                        }
                    }
                }
            }
        }
    }

    public static X509TrustManager f() {
        return new c();
    }

    public static X509HostnameVerifier g() {
        return new i();
    }

    public static int b(long j) {
        if (j <= 0) {
            return 1;
        }
        int a = a.a();
        if (j.a) {
            Log.e("vanda", "File Download thread num = " + a);
        }
        if (a > 0) {
            return a;
        }
        if (j > 0 && j <= 1048576) {
            return 1;
        }
        if (j > 1048576 && j <= 31457280) {
            return 3;
        }
        if (j > 31457280 && j <= 1048576000) {
            return 5;
        }
        if (j > 1048576000) {
            return 9;
        }
        return 1;
    }

    public static int h() {
        int b = a.b();
        if (b <= 0) {
            return 512;
        }
        return b;
    }

    public static int i() {
        int c = a.c();
        if (c <= 0) {
            return SettingsConst.GLOBAL_SETTINGS;
        }
        return c;
    }

    public static int j() {
        int d = a.d();
        if (d <= 0) {
            return 3;
        }
        if (d <= 7) {
            return d;
        }
        return 7;
    }

    public static long l(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static w a(ad adVar) {
        if (adVar == null) {
            return new c();
        }
        adVar.a();
        return adVar.a();
    }
}
