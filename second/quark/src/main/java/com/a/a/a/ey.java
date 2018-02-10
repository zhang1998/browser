package com.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.a.a.a;
import com.a.a.b;
import com.a.a.g;
import com.uc.apollo.impl.SettingsConst;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class ey {
    protected static final String a = ey.class.getName();

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static String d() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (!"wlan0".equals(networkInterface.getName())) {
                    if ("eth0".equals(networkInterface.getName())) {
                    }
                }
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress == null || hardwareAddress.length == 0) {
                    return null;
                }
                StringBuilder stringBuilder = new StringBuilder();
                int length = hardwareAddress.length;
                for (int i = 0; i < length; i++) {
                    stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                }
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                return stringBuilder.toString().toLowerCase(Locale.getDefault());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static String e() {
        try {
            String[] strArr = new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            int i = 0;
            while (i < 3) {
                try {
                    String a = a(strArr[i]);
                    if (a != null) {
                        return a;
                    }
                    i++;
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
        return null;
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = null;
        try {
            Reader fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
                try {
                    str2 = bufferedReader.readLine();
                    try {
                        fileReader.close();
                    } catch (Throwable th2) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        fileReader.close();
                    } catch (Throwable th5) {
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = str2;
                fileReader.close();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th8) {
        }
        return str2;
    }

    public static String a() {
        String str = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                fw.b(a, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (Throwable th2) {
            fw.b(a, "Could not open file /proc/cpuinfo", th2);
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return "";
    }

    public static String c(Context context) {
        String string;
        if (a.E_UM_ANALYTICS_OEM.e == b.d(context) || a.E_UM_GAME_OEM.e == b.d(context)) {
            if (VERSION.SDK_INT < 23) {
                string = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = v(context);
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = f();
                if (TextUtils.isEmpty(string)) {
                    return w(context);
                }
                return string;
            } else if (VERSION.SDK_INT == 23) {
                string = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = d();
                if (TextUtils.isEmpty(string)) {
                    if (g.a) {
                        string = e();
                    } else {
                        string = v(context);
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = f();
                if (TextUtils.isEmpty(string)) {
                    return w(context);
                }
                return string;
            } else {
                string = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = f();
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = w(context);
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                string = d();
                if (TextUtils.isEmpty(string)) {
                    return v(context);
                }
                return string;
            }
        } else if (VERSION.SDK_INT < 23) {
            string = w(context);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = v(context);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                return f();
            }
            return string;
        } else if (VERSION.SDK_INT == 23) {
            string = w(context);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = d();
            if (TextUtils.isEmpty(string)) {
                if (g.a) {
                    string = e();
                } else {
                    string = v(context);
                }
            }
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                return f();
            }
            return string;
        } else {
            string = w(context);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = f();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            string = d();
            if (TextUtils.isEmpty(string)) {
                return v(context);
            }
            return string;
        }
    }

    public static String d(Context context) {
        return fu.b(c(context));
    }

    public static String e(Context context) {
        String subscriberId;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (a(context, "android.permission.READ_PHONE_STATE")) {
            subscriberId = telephonyManager.getSubscriberId();
        } else {
            subscriberId = null;
        }
        if (subscriberId == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i == 0) {
            return null;
        }
        subscriberId = String.valueOf(i2);
        if (i2 < 10) {
            subscriberId = String.format("%02d", new Object[]{Integer.valueOf(i2)});
        }
        return new StringBuffer().append(String.valueOf(i)).append(subscriberId).toString();
    }

    public static String f(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (a(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable th) {
        }
        return "";
    }

    public static String[] g(Context context) {
        String[] strArr = new String[]{"", ""};
        try {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                        strArr[0] = "2G/3G";
                        strArr[1] = networkInfo2.getSubtypeName();
                        return strArr;
                    }
                    return strArr;
                }
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            strArr[0] = "";
            return strArr;
        } catch (Throwable th) {
        }
    }

    public static boolean h(Context context) {
        return "Wi-Fi".equals(g(context)[0]);
    }

    public static boolean i(Context context) {
        try {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnectedOrConnecting();
                    }
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static int j(Context context) {
        try {
            Calendar instance = Calendar.getInstance(u(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            fw.a(a, "error in getTimeZone", th);
        }
        return 8;
    }

    public static String[] k(Context context) {
        String[] strArr = new String[2];
        try {
            Locale u = u(context);
            if (u != null) {
                strArr[0] = u.getCountry();
                strArr[1] = u.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
        } catch (Throwable th) {
            fw.b(a, "error in getLocaleInfo", th);
        }
        return strArr;
    }

    private static Locale u(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable th) {
            fw.a(a, "fail to read user config locale");
        }
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    public static String l(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                fw.a(a, "getAppkey failed. the applicationinfo is null!");
            }
        } catch (Throwable th) {
            fw.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", th);
        }
        return null;
    }

    public static String m(Context context) {
        if (VERSION.SDK_INT < 23) {
            return v(context);
        }
        String d;
        if (VERSION.SDK_INT == 23) {
            d = d();
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            if (g.a) {
                return e();
            }
            return v(context);
        }
        d = d();
        if (TextUtils.isEmpty(d)) {
            return v(context);
        }
        return d;
    }

    private static String v(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static int[] n(Context context) {
        try {
            int a;
            int a2;
            int i;
            Object displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & SpdyProtocol.SLIGHTSSL_1_RTT_MODE) == 0) {
                a = a(displayMetrics, "noncompatWidthPixels");
                a2 = a(displayMetrics, "noncompatHeightPixels");
            } else {
                a2 = 0;
                a = -1;
            }
            if (a == -1 || a2 == -1) {
                i = displayMetrics.widthPixels;
                a = displayMetrics.heightPixels;
            } else {
                i = a;
                a = a2;
            }
            int[] iArr = new int[2];
            if (i > a) {
                iArr[0] = a;
                iArr[1] = i;
                return iArr;
            }
            iArr[0] = i;
            iArr[1] = a;
            return iArr;
        } catch (Throwable th) {
            return null;
        }
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable th) {
            return -1;
        }
    }

    public static String o(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return str;
    }

    public static String p(Context context) {
        return context.getPackageName();
    }

    public static String q(Context context) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable th) {
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i]);
            int length = toHexString.length();
            if (length == 1) {
                toHexString = new StringBuilder(SettingsConst.FALSE).append(toHexString).toString();
            }
            if (length > 2) {
                toHexString = toHexString.substring(length - 2, length);
            }
            stringBuilder.append(toHexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                stringBuilder.append(':');
            }
        }
        return stringBuilder.toString();
    }

    public static String r(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String s(Context context) {
        String str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
        }
        return str;
    }

    private static String w(Context context) {
        String str = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return str;
        }
        try {
            String str2;
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                str2 = str;
            } else if (VERSION.SDK_INT > 26) {
                Class cls = Class.forName("android.telephony.TelephonyManager");
                str = (String) cls.getMethod("getImei", new Class[]{Integer.class}).invoke(telephonyManager, new Object[]{cls.getMethod("getImei", new Class[]{Integer.class}), Integer.valueOf(0)});
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                str = (String) cls.getMethod("getMeid", new Class[]{Integer.class}).invoke(telephonyManager, new Object[]{cls.getMethod("getMeid", new Class[]{Integer.class}), Integer.valueOf(0)});
                if (TextUtils.isEmpty(str)) {
                    return telephonyManager.getDeviceId();
                }
                return str;
            } else {
                str2 = telephonyManager.getDeviceId();
            }
            return str2;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String f() {
        String str = "";
        if (VERSION.SDK_INT >= 9 && VERSION.SDK_INT < 26) {
            return Build.SERIAL;
        }
        if (VERSION.SDK_INT >= 26) {
            try {
                Class cls = Class.forName("android.os.Build");
                return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
            } catch (Throwable th) {
            }
        }
        return str;
    }

    public static String b() {
        Properties g = g();
        try {
            String property = g.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                return "MIUI";
            }
            if (h()) {
                return "Flyme";
            }
            if (TextUtils.isEmpty(a(g))) {
                return property;
            }
            return "YunOS";
        } catch (Throwable th) {
            return null;
        }
    }

    public static String c() {
        Properties g = g();
        try {
            String property = g.getProperty("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            if (h()) {
                try {
                    return b(g);
                } catch (Throwable th) {
                    return property;
                }
            }
            try {
                return a(g);
            } catch (Throwable th2) {
                return property;
            }
        } catch (Throwable th3) {
            return null;
        }
    }

    private static String a(Properties properties) {
        Object property = properties.getProperty("ro.yunos.version");
        return !TextUtils.isEmpty(property) ? property : null;
    }

    private static String b(Properties properties) {
        try {
            String toLowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (toLowerCase.contains("flyme os")) {
                return toLowerCase.split(" ")[2];
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static Properties g() {
        FileInputStream fileInputStream;
        Throwable th;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream2 = fileInputStream;
                th = th4;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable th5) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return properties;
    }

    private static boolean h() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String t(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String str;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || !a(context, "android.permission.READ_PHONE_STATE")) {
                str = null;
            } else {
                str = telephonyManager.getDeviceId();
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                str = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str) || VERSION.SDK_INT < 9) {
                    return str;
                }
                return Build.SERIAL;
            } catch (Throwable th) {
                return str;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
