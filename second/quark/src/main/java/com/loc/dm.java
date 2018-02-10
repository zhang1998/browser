package com.loc;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.uc.apollo.impl.SettingsConst;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class dm {
    private static int a = 0;
    private static String[] b = null;
    private static Hashtable<String, Long> c = new Hashtable();
    private static DecimalFormat d = null;
    private static SimpleDateFormat e = null;

    public static double a(double d) {
        return ((double) ((long) (d * 1000000.0d))) / 1000000.0d;
    }

    public static float a(AmapLoc amapLoc, AmapLoc amapLoc2) {
        return a(new double[]{amapLoc.c, amapLoc.b, amapLoc2.c, amapLoc2.b});
    }

    public static float a(double[] dArr) {
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    public static int a(int i) {
        return (i * 2) - 113;
    }

    public static int a(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public static int a(NetworkInfo networkInfo) {
        return (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) ? networkInfo.getType() : -1;
    }

    public static int a(boolean z, CellLocation cellLocation) {
        if (z || cellLocation == null) {
            return 9;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            cq.a(th, "Utils", "getCellLocT");
            return 9;
        }
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static Object a(Context context, String str) {
        Object obj = null;
        if (context != null) {
            try {
                obj = context.getApplicationContext().getSystemService(str);
            } catch (Throwable th) {
                cq.a(th, "Utils", "getServ");
            }
        }
        return obj;
    }

    public static synchronized void a(Context context, int i) {
        synchronized (dm.class) {
            if (context != null) {
                try {
                    n nVar = new n(context, n.a(cx.class), i());
                    Object ctVar = new ct();
                    ctVar.a = i;
                    nVar.a(ctVar, "_id=1");
                } catch (Throwable th) {
                    cq.a(th, "Utils", "getDBConfigVersion");
                }
            }
        }
    }

    public static synchronized boolean a(long j, long j2) {
        boolean z;
        synchronized (dm.class) {
            String str = "yyyyMMddHH";
            z = false;
            if (e == null) {
                try {
                    e = new SimpleDateFormat(str, Locale.CHINA);
                } catch (Throwable th) {
                    cq.a(th, "Utils", "isSameDay part1");
                }
            } else {
                e.applyPattern(str);
            }
            try {
                if (e != null) {
                    z = e.format(Long.valueOf(j)).equals(e.format(Long.valueOf(j2)));
                }
            } catch (Throwable th2) {
                cq.a(th2, "Utils", "isSameHour");
            }
        }
        return z;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return c() < 17 ? b(context, "android.provider.Settings$System") : b(context, "android.provider.Settings$Global");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(ScanResult scanResult) {
        return (scanResult == null || TextUtils.isEmpty(scanResult.BSSID) || scanResult.BSSID.equals("00:00:00:00:00:00") || scanResult.BSSID.contains(" :")) ? false : true;
    }

    public static boolean a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            double longitude = aMapLocation.getLongitude();
            double latitude = aMapLocation.getLatitude();
            float accuracy = aMapLocation.getAccuracy();
            if (!(longitude == 0.0d && latitude == 0.0d && ((double) accuracy) == 0.0d)) {
                if (longitude > 180.0d || latitude > 90.0d) {
                    return false;
                }
                if (longitude >= -180.0d && latitude >= -90.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(AmapLoc amapLoc) {
        if (!(amapLoc == null || amapLoc.k.equals("8") || amapLoc.k.equals("5") || amapLoc.k.equals("6"))) {
            double d = amapLoc.b;
            double d2 = amapLoc.c;
            float f = amapLoc.d;
            if (!(d == 0.0d && d2 == 0.0d && ((double) f) == 0.0d)) {
                if (d > 180.0d || d2 > 90.0d) {
                    return false;
                }
                if (d >= -180.0d && d2 >= -90.0d) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(String str) {
        return (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) ? ",111,123,134,199,202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,560,598,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,665,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,850,901,".contains("," + str + ",") : false;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return eq.a(jSONObject, str);
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            bArr2 = eq.b(bArr);
        } catch (Throwable th) {
            cq.a(th, "Utils", "gz");
        }
        return bArr2;
    }

    public static String[] a(TelephonyManager telephonyManager) {
        int parseInt;
        Object obj = null;
        if (telephonyManager != null) {
            obj = telephonyManager.getNetworkOperator();
        }
        String[] strArr = new String[]{SettingsConst.FALSE, SettingsConst.FALSE};
        int i = TextUtils.isEmpty(obj) ? 0 : !TextUtils.isDigitsOnly(obj) ? 0 : obj.length() <= 4 ? 0 : 1;
        if (i != 0) {
            strArr[0] = obj.substring(0, 3);
            char[] toCharArray = obj.substring(3).toCharArray();
            i = 0;
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = obj.substring(3, i + 3);
        }
        try {
            parseInt = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            cq.a(th, "Utils", "getMccMnc");
            parseInt = 0;
        }
        if (parseInt == 0) {
            strArr[0] = SettingsConst.FALSE;
        }
        if (strArr[0].equals(SettingsConst.FALSE) || strArr[1].equals(SettingsConst.FALSE)) {
            return (strArr[0].equals(SettingsConst.FALSE) && strArr[1].equals(SettingsConst.FALSE) && b != null) ? b : strArr;
        } else {
            b = strArr;
            return strArr;
        }
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public static String b(Context context) {
        CharSequence charSequence = null;
        if (!TextUtils.isEmpty(cq.f)) {
            return cq.f;
        }
        if (context == null) {
            return null;
        }
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 64);
        } catch (Throwable th) {
            cq.a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(cq.g)) {
                cq.g = null;
            }
        } catch (Throwable th2) {
            cq.a(th2, "Utils", "getAppName");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                stringBuilder.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                stringBuilder.append(packageInfo.versionName);
            }
        }
        Object c = dx.c(context);
        if (!TextUtils.isEmpty(c)) {
            stringBuilder.append(",").append(c);
        }
        if (!TextUtils.isEmpty(cq.g)) {
            stringBuilder.append(",").append(cq.g);
        }
        String stringBuilder2 = stringBuilder.toString();
        cq.f = stringBuilder2;
        return stringBuilder2;
    }

    public static String b(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return (String) cq.m.get(i, "UNKWN");
    }

    public static String b(String str) {
        return f(str);
    }

    public static synchronized boolean b(long j, long j2) {
        boolean z;
        synchronized (dm.class) {
            String str = "yyyyMMdd";
            z = false;
            if (e == null) {
                try {
                    e = new SimpleDateFormat(str, Locale.CHINA);
                } catch (Throwable th) {
                    cq.a(th, "Utils", "isSameDay part1");
                }
            } else {
                e.applyPattern(str);
            }
            try {
                if (e != null) {
                    z = e.format(Long.valueOf(j)).equals(e.format(Long.valueOf(j2)));
                }
            } catch (Throwable th2) {
                cq.a(th2, "Utils", "isSameDay");
            }
        }
        return z;
    }

    private static boolean b(Context context, String str) throws Throwable {
        ContentResolver contentResolver = context.getContentResolver();
        String str2 = ((String) dg.a(str, "AIRPLANE_MODE_ON")).toString();
        return ((Integer) dg.a(str, "getInt", new Object[]{contentResolver, str2}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    public static byte[] b(int i) {
        byte[] bArr = new byte[2];
        for (int i2 = 0; i2 < 2; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    public static int c() {
        if (a > 0) {
            return a;
        }
        int i = 0;
        String str = "android.os.Build$VERSION";
        try {
            return dg.b(str, "SDK_INT");
        } catch (Throwable th) {
            return i;
        }
    }

    public static NetworkInfo c(Context context) {
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ei.n(context);
        } catch (Throwable th) {
            cq.a(th, "Utils", "getNetWorkInfo");
        }
        return networkInfo;
    }

    public static synchronized String c(int i) {
        String str;
        synchronized (dm.class) {
            str = "其他错误";
            switch (i) {
                case 0:
                    str = "success";
                    break;
                case 1:
                    str = "重要参数为空";
                    break;
                case 2:
                    str = "WIFI信息不足";
                    break;
                case 3:
                    str = "请求参数获取出现异常";
                    break;
                case 4:
                    str = "网络连接异常";
                    break;
                case 5:
                    str = "解析数据异常";
                    break;
                case 6:
                    str = "定位结果错误";
                    break;
                case 7:
                    str = "KEY错误";
                    break;
                case 8:
                    str = "其他错误";
                    break;
                case 9:
                    str = "初始化异常";
                    break;
                case 10:
                    str = "定位服务启动失败";
                    break;
                case 11:
                    str = "错误的基站信息，请检查是否插入SIM卡";
                    break;
                case 12:
                    str = "缺少定位权限";
                    break;
            }
        }
        return str;
    }

    public static String c(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Throwable th) {
            cq.a(th, "Utils", "base642Str");
            return null;
        }
    }

    public static synchronized boolean c(long j, long j2) {
        boolean z = true;
        boolean z2 = false;
        synchronized (dm.class) {
            if (b(j, j2)) {
                Calendar instance = Calendar.getInstance(Locale.CHINA);
                instance.setTimeInMillis(j);
                int i = instance.get(11);
                instance.setTimeInMillis(j2);
                int i2 = instance.get(11);
                if (i <= 12 ? i2 <= 12 : i2 > 12) {
                    z = false;
                }
                z2 = z;
            }
        }
        return z2;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static boolean d(Context context) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return runningAppProcessInfo.importance != 100;
                }
            }
            return false;
        } catch (Throwable th) {
            cq.a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    public static byte[] d(String str) {
        return b(Integer.parseInt(str));
    }

    public static synchronized int e(Context context) {
        int i;
        synchronized (dm.class) {
            try {
                List a = new n(context, n.a(cx.class), i()).a("_id=1", ct.class, false);
                if (a.size() > 0) {
                    i = ((ct) a.get(0)).a;
                }
            } catch (Throwable th) {
                cq.a(th, "Utils", "getDBConfigVersion");
            }
            i = -1;
        }
        return i;
    }

    public static String e() {
        return VERSION.RELEASE;
    }

    public static byte[] e(String str) {
        int parseInt = Integer.parseInt(str);
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr[i] = (byte) ((parseInt >> (i * 8)) & 255);
        }
        return bArr;
    }

    private static String f(String str) {
        byte[] bArr = null;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable th) {
            cq.a(th, "Utils", "str2Base64");
        }
        return Base64.encodeToString(bArr, 0);
    }

    public static boolean f() {
        return a(0, 1) == 1;
    }

    public static void g() {
        c.clear();
    }

    public static String h() {
        try {
            return ej.a("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String i() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator);
        stringBuilder.append("amap").append(File.separator);
        stringBuilder.append("openamaplocationsdk").append(File.separator);
        return stringBuilder.toString();
    }
}
