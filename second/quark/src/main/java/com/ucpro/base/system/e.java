package com.ucpro.base.system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.encrypt.f;
import com.ucpro.c.b;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: ProGuard */
final class e {
    private static Matcher a;
    private static Pattern b = Pattern.compile("[0-9]*");
    private static Matcher c;
    private static Pattern d = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[7-9])|(17[0-9]))\\d{8}$");
    private static HashSet<String> e;

    public static String a(String str) {
        if (a.a(str)) {
            return "";
        }
        String str2 = "";
        try {
            byte[] a = f.a(str.getBytes("utf-8"), com.uc.encrypt.a.b);
            if (a != null) {
                return URLEncoder.encode(com.ucweb.common.util.e.a.f(a));
            }
            return str2;
        } catch (Exception e) {
            c.a(e.toString());
            return str2;
        }
    }

    public static String a() {
        return c(d.a());
    }

    private static String c(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (PackageInfo packageInfo : com.ucweb.common.util.g.a.b()) {
                if (!(packageInfo.packageName == null || packageInfo.packageName.trim().length() == 0 || !packageInfo.packageName.startsWith("QuarkBrowser"))) {
                    stringBuilder.append(packageInfo.packageName).append('|');
                }
            }
        } catch (Exception e) {
            c.a(e.toString());
        }
        if (stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '|') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static Intent b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.startsWith("intent:")) {
                return Intent.parseUri(str, 1);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            return intent;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        boolean z = false;
        if (!(str == null || context == null)) {
            try {
                Intent b = b(str);
                if (b != null) {
                    z = a(context, b);
                }
            } catch (Exception e) {
            }
        }
        return z;
    }

    private static boolean a(Context context, Intent intent) {
        if (intent == null || context == null) {
            return false;
        }
        if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
            Log.e("hjw-app", "ActivityInfo ai == null");
            return true;
        }
        try {
            Intent intent2 = new Intent("com.uc.browser.action.CALL_PROXY_VIEW");
            intent2.setPackage(context.getPackageName());
            intent2.putExtra("call_intent", intent);
            context.startActivity(intent2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static byte[] a(boolean z, boolean z2, byte[] bArr) {
        byte[] b;
        if (z) {
            b = f.b(bArr, com.uc.encrypt.a.b);
            if (b == null || b.length <= 0) {
                return null;
            }
        }
        b = null;
        if (!z2) {
            return b;
        }
        try {
            InputStream byteArrayInputStream;
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(512);
            if (z) {
                byteArrayInputStream = new ByteArrayInputStream(b);
            } else {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            }
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            b = new byte[512];
            while (true) {
                int read = gZIPInputStream.read(b);
                if (read == -1) {
                    return byteArrayBuffer.buffer();
                }
                byteArrayBuffer.append(b, 0, read);
            }
        } catch (Exception e) {
            return null;
        }
    }

    static void b(Context context, String str) {
        m.a(0, new f(context, str));
    }

    static Drawable c(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith(ShareConstants.PATCH_SUFFIX)) {
            return null;
        }
        PackageManager packageManager = d.a().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
            return null;
        }
        packageArchiveInfo.applicationInfo.sourceDir = str;
        packageArchiveInfo.applicationInfo.publicSourceDir = str;
        return packageArchiveInfo.applicationInfo.loadIcon(packageManager);
    }

    static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        PackageManager packageManager = d.a().getPackageManager();
        if (packageManager == null) {
            return "";
        }
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
            return "";
        }
        packageArchiveInfo.applicationInfo.sourceDir = str;
        packageArchiveInfo.applicationInfo.publicSourceDir = str;
        return (String) packageArchiveInfo.applicationInfo.loadLabel(packageManager);
    }

    private static String j(String str) {
        int indexOf = str.indexOf(".");
        int indexOf2 = str.indexOf("B");
        if (indexOf == -1 || indexOf2 - indexOf <= 4) {
            return str;
        }
        return a.a(str.substring(0, indexOf + 3), str.substring(str.length() - 2));
    }

    private static String k(String str) {
        if (str.indexOf(".") == -1) {
            return str;
        }
        return a.a(str.substring(0, str.indexOf(".")), str.substring(str.length() - 2));
    }

    static String a(long j) {
        String str = "0KB";
        if (j - 1 <= 0) {
            return str;
        }
        double d = ((double) j) / 1024.0d;
        if (d < 1024.0d) {
            return k(String.valueOf(d) + "KB");
        }
        d /= 1024.0d;
        if (d < 1024.0d) {
            return j(String.valueOf(d) + "MB");
        }
        d /= 1024.0d;
        if (d < 1024.0d) {
            return j(String.valueOf(d) + "GB");
        }
        d /= 1024.0d;
        if (d < 1024.0d) {
            return j(String.valueOf(d) + "GB");
        }
        if (str.length() > 0) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    static boolean e(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return false;
        }
        return true;
    }

    static void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            m.a(0, new j(str));
        }
    }

    static boolean a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), str2);
        intent.setFlags(MediaPlayer.MEDIA_ERROR_UNKNOWN);
        try {
            d.a().startActivity(intent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void b(String str, String str2) {
        if (!a.a(str) && !a.a(str2)) {
            m.a(new d(str, str2));
        }
    }

    static boolean g(String str) {
        if (a == null) {
            a = b.matcher(str);
        }
        return a.reset(str).matches();
    }

    static boolean h(String str) {
        if (c == null) {
            c = d.matcher(str);
        }
        c.reset(str);
        return c.matches();
    }

    static boolean a(Activity activity) {
        c.a((Object) activity);
        int requestedOrientation = activity.getRequestedOrientation();
        if (requestedOrientation == 1 || requestedOrientation == 9 || requestedOrientation == 7) {
            return true;
        }
        return false;
    }

    static void a(Context context, ValueCallback<HashSet<String>> valueCallback) {
        m.a(0, new h(context), new k(valueCallback));
    }

    private static boolean l(String str) {
        Throwable th;
        if (a.a(str)) {
            return false;
        }
        File file = new File(str, "init.txt");
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                file.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                }
                return true;
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static HashSet<String> d(Context context) {
        HashSet<String> hashSet = new HashSet();
        if (context == null) {
            return hashSet;
        }
        String str = "(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*";
        String str2 = "";
        try {
            Process start = new ProcessBuilder(new String[0]).command(new String[]{"mount"}).redirectErrorStream(true).start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                str2 = str2 + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e) {
        }
        for (String str22 : r0.split("\n")) {
            if (!str22.toLowerCase(Locale.US).contains("asec") && str22.matches(str)) {
                for (String str222 : str222.split(" ")) {
                    if (str222.startsWith("/") && !str222.toLowerCase(Locale.US).contains("vold")) {
                        String replace = str222.replace("/media_rw", "").replace("mnt", "storage");
                        File file = new File(new File(replace), "Quark");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        boolean l = l(replace + File.separator + "Quark");
                        if (b.b()) {
                            Log.e("vanda", "path:" + replace + "   isSucess:" + l);
                        }
                        com.ucpro.business.stat.m.a("download", "ext_sd_write", l ? 1 : 0, new String[0]);
                        if (l) {
                            str222 = replace + File.separator + "Quark" + File.separator + "Download";
                            file = new File(str222);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            hashSet.add(str222);
                        } else {
                            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                            if (externalFilesDir != null) {
                                str222 = externalFilesDir.getAbsolutePath();
                                str222 = replace + str222.substring(str222.indexOf("/Android/data/"), str222.length());
                                if (l(str222)) {
                                    hashSet.add(str222);
                                }
                            }
                        }
                    }
                }
            }
        }
        hashSet.remove(Environment.getExternalStorageDirectory().getPath());
        return hashSet;
    }

    static /* synthetic */ List b(Context context) {
        List arrayList = new ArrayList();
        if (context != null) {
            String str = System.getenv("SECONDARY_STORAGE");
            if (!TextUtils.isEmpty(str)) {
                File file = new File(new File(str), "Quark");
                if (!file.exists()) {
                    file.mkdir();
                }
                boolean l = l(str + File.separator + "Quark");
                if (b.b()) {
                    Log.e("vanda", "path:" + str + "   isSucess:" + l);
                }
                com.ucpro.business.stat.m.a("download", "ext_sd_write", l ? 1 : 0, new String[0]);
                String str2;
                if (l) {
                    str2 = str + File.separator + "Quark" + File.separator + "Download";
                    file = new File(str2);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    arrayList.add(str2);
                } else {
                    File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                    if (externalFilesDir != null) {
                        str2 = externalFilesDir.getAbsolutePath();
                        str2 = str + str2.substring(str2.indexOf("/Android/data/"), str2.length());
                        if (l(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
