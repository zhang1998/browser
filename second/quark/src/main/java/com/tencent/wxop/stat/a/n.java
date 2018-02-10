package com.tencent.wxop.stat.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.tencent.wxop.stat.ai;
import com.tencent.wxop.stat.i;
import com.uc.apollo.impl.SettingsConst;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.android.spdy.SpdyProtocol;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class n {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static Random e = null;
    private static DisplayMetrics f = null;
    private static String g = null;
    private static String h = "";
    private static String i = "";
    private static int j = -1;
    private static p k = null;
    private static String l = null;
    private static String m = null;
    private static volatile int n = -1;
    private static String o = null;
    private static String p = null;
    private static long q = -1;
    private static String r = "";
    private static l s = null;
    private static String t = "__MTA_FIRST_ACTIVATE__";
    private static int u = -1;
    private static long v = -1;
    private static int w = 0;
    private static String x = "";

    public static int a() {
        return i().nextInt(Integer.MAX_VALUE);
    }

    public static int a(Context context, boolean z) {
        if (z) {
            w = q.a(context, "mta.qq.com.difftime", 0);
        }
        return w;
    }

    private static Long a(String str, String str2, Long l) {
        if (str == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != 3) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i = 0;
            while (i < split.length) {
                Long valueOf2 = Long.valueOf(100 * (valueOf.longValue() + Long.valueOf(split[i]).longValue()));
                i++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String a(Context context, String str) {
        if (!i.v()) {
            return str;
        }
        if (m == null) {
            m = o(context);
        }
        return m != null ? str + "_" + m : str;
    }

    public static String a(String str) {
        if (str == null) {
            return SettingsConst.FALSE;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(SettingsConst.FALSE);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return SettingsConst.FALSE;
        }
    }

    public static HttpHost a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            k.b(th);
        }
    }

    public static void a(Context context, int i) {
        w = i;
        q.b(context, "mta.qq.com.difftime", i);
    }

    public static boolean a(ai aiVar) {
        return aiVar == null ? false : c(aiVar.a);
    }

    public static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static int b() {
        if (j != -1) {
            return j;
        }
        try {
            if (m.a()) {
                j = 1;
            }
        } catch (Throwable th) {
            k.b(th);
        }
        j = 0;
        return 0;
    }

    public static long b(String str) {
        return a(str, ".", Long.valueOf(0)).longValue();
    }

    public static synchronized String b(Context context) {
        String a;
        synchronized (n.class) {
            if (a == null || a.trim().length() == 0) {
                a = s.a(context);
                a = a;
                if (a == null || a.trim().length() == 0) {
                    a = Integer.toString(i().nextInt(Integer.MAX_VALUE));
                }
                a = a;
            } else {
                a = a;
            }
        }
        return a;
    }

    public static synchronized p c() {
        p pVar;
        synchronized (n.class) {
            if (k == null) {
                pVar = new p("MtaSDK");
                k = pVar;
                pVar.a = false;
            }
            pVar = k;
        }
        return pVar;
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (n.class) {
            if (c == null || c.trim().length() == 0) {
                c = s.b(context);
            }
            str = c;
        }
        return str;
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static long d() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            k.b(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static DisplayMetrics d(Context context) {
        if (f == null) {
            f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
        }
        return f;
    }

    public static String e() {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, 0);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static boolean e(Context context) {
        try {
            if (s.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            k.b((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            k.b(th);
        }
    }

    public static String f() {
        if (c(p)) {
            return p;
        }
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize())) / 1000000) + "/" + String.valueOf(blockCount);
        p = str;
        return str;
    }

    public static String f(Context context) {
        if (b != null) {
            return b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    b = string;
                    return string;
                }
                k.a((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            k.a((Object) "Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String g(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                k.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            k.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", k.a());
            String d = k.d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = k.b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = k.c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
            Log.w("MtaSDK", "get cpu error", th);
        }
        return jSONObject;
    }

    public static String h(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String i(Context context) {
        if (g != null) {
            return g;
        }
        try {
            if (s.a(context, "android.permission.READ_PHONE_STATE")) {
                if ((context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0 ? null : 1) != null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        g = telephonyManager.getSimOperator();
                    }
                }
            } else {
                k.e("Could not get permission of android.permission.READ_PHONE_STATE");
            }
        } catch (Throwable th) {
            k.b(th);
        }
        return g;
    }

    private static synchronized Random i() {
        Random random;
        synchronized (n.class) {
            if (e == null) {
                e = new Random();
            }
            random = e;
        }
        return random;
    }

    private static long j() {
        if (q > 0) {
            return q;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        q = j;
        return j;
    }

    public static String j(Context context) {
        if (c(h)) {
            return h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            k.b(th);
        }
        return h;
    }

    public static String k(Context context) {
        String str = "";
        try {
            if (s.a(context, "android.permission.INTERNET") && s.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            k.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            k.b(th);
            return str;
        }
    }

    public static Integer l(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String m(Context context) {
        if (c(i)) {
            return i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            i = str;
            if (str == null || i.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            k.b(th);
        }
        return i;
    }

    public static String n(Context context) {
        if (c(l)) {
            return l;
        }
        try {
            if (s.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            k.b((Object) "can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            k.b(th);
        }
    }

    static String o(Context context) {
        try {
            if (m != null) {
                return m;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    m = runningAppProcessInfo.processName;
                    break;
                }
            }
            return m;
        } catch (Throwable th) {
        }
    }

    public static String p(Context context) {
        return a(context, o.b);
    }

    public static synchronized Integer q(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (n.class) {
            if (n <= 0) {
                n = q.a(context, "MTA_EVENT_INDEX", 0);
                q.b(context, "MTA_EVENT_INDEX", n + 1000);
            } else if (n % 1000 == 0) {
                try {
                    int i2 = n + 1000;
                    if (n < 2147383647) {
                        i = i2;
                    }
                    q.b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    k.c(th);
                }
            }
            i = n + 1;
            n = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static String s(Context context) {
        if (c(r)) {
            return r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    r = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            k.b(th);
        }
        return r;
    }

    public static synchronized int t(Context context) {
        int i;
        synchronized (n.class) {
            if (u != -1) {
                i = u;
            } else {
                u(context);
                i = u;
            }
        }
        return i;
    }

    public static void u(Context context) {
        int a = q.a(context, t, 1);
        u = a;
        if (a == 1) {
            q.b(context, t, 0);
        }
    }

    public static boolean v(Context context) {
        if (v < 0) {
            v = q.a(context, "mta.qq.com.checktime");
        }
        return Math.abs(System.currentTimeMillis() - v) > 86400000;
    }

    public static void w(Context context) {
        v = System.currentTimeMillis();
        q.a(context, "mta.qq.com.checktime", v);
    }

    public static String x(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    public static String r(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return String.valueOf(memoryInfo.availMem / 1000000) + "/" + String.valueOf(j() / 1000000);
        } catch (Throwable th) {
            return null;
        }
    }
}
