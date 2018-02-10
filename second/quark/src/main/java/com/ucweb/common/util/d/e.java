package com.ucweb.common.util.d;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Window;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.n.a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class e {
    private static Context a = d.a();
    private static boolean b = false;
    private static String c = "";
    private static boolean d = false;
    private static String e = "";
    private static boolean f = false;
    private static String g = "";
    private static boolean h = false;
    private static int i = 1;
    private static boolean j = false;
    private static int k = 0;
    private static boolean l = false;
    private static String m = "";
    private static boolean n = false;
    private static long o = 0;
    private static boolean p = false;
    private static double q = 0.0d;
    private static boolean r = false;
    private static String s = "";
    private static String t = "";
    private static String u = "";
    private static boolean v = false;
    private static boolean w = false;
    private static final String[] x = new String[]{"m2 note"};

    public static void a(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }

    private static void n() {
        if (a == null) {
            throw new RuntimeException("context has not been initialized! You MUST call this only after initialize() is invoked.");
        }
    }

    public static String a() {
        n();
        if (b) {
            return c;
        }
        try {
            c = Secure.getString(a.getContentResolver(), "android_id");
        } catch (Exception e) {
            c.a(e.toString());
        }
        if (c == null) {
            c = "";
        }
        b = true;
        return c;
    }

    public static String b() {
        n();
        if (d || a == null) {
            return e;
        }
        if (VERSION.SDK_INT >= 23) {
            String toHexString;
            try {
                byte[] hardwareAddress = NetworkInterface.getByInetAddress(o()).getHardwareAddress();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < hardwareAddress.length; i++) {
                    if (i != 0) {
                        stringBuffer.append(':');
                    }
                    toHexString = Integer.toHexString(hardwareAddress[i] & 255);
                    if (toHexString.length() == 1) {
                        toHexString = new StringBuilder(SettingsConst.FALSE).append(toHexString).toString();
                    }
                    stringBuffer.append(toHexString);
                }
                e = stringBuffer.toString().toUpperCase();
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(e)) {
                Enumeration networkInterfaces;
                Enumeration enumeration = null;
                try {
                    networkInterfaces = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException e2) {
                    networkInterfaces = enumeration;
                }
                while (networkInterfaces.hasMoreElements()) {
                    try {
                        toHexString = a.a(((NetworkInterface) networkInterfaces.nextElement()).getHardwareAddress());
                        e = toHexString;
                        if (toHexString != null) {
                            break;
                        }
                    } catch (SocketException e3) {
                    }
                }
                if (!TextUtils.isEmpty(e)) {
                    d = true;
                    return e;
                }
            }
            d = true;
            return e;
        }
        try {
            e = ((WifiManager) a.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } catch (Exception e4) {
            c.a(e4.toString());
        }
        if (e == null) {
            e = "";
        } else if (!TextUtils.isEmpty(e)) {
            d = true;
        }
        return e;
    }

    private static InetAddress o() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress inetAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    InetAddress inetAddress2;
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        inetAddress2 = (InetAddress) inetAddresses.nextElement();
                        try {
                            if (!inetAddress2.isLoopbackAddress() && inetAddress2.getHostAddress().indexOf(":") == -1) {
                                break;
                            }
                            inetAddress = null;
                        } catch (SocketException e) {
                            return inetAddress2;
                        }
                    }
                    inetAddress2 = inetAddress;
                    if (inetAddress2 != null) {
                        return inetAddress2;
                    }
                    inetAddress = inetAddress2;
                } catch (SocketException e2) {
                    return inetAddress;
                }
            }
            return inetAddress;
        } catch (SocketException e3) {
            return null;
        }
    }

    public static String c() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            NetworkInterface networkInterface = null;
            InetAddress inetAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface2 = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface2 != null) {
                    Enumeration inetAddresses = networkInterface2.getInetAddresses();
                    if (inetAddresses != null) {
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddress2 = (InetAddress) inetAddresses.nextElement();
                            if (inetAddress2 != null) {
                                InetAddress inetAddress3;
                                NetworkInterface networkInterface3;
                                if (!(inetAddress2.isLoopbackAddress() || inetAddress2.isLinkLocalAddress())) {
                                    if (inetAddress == null) {
                                        networkInterface = networkInterface2;
                                        inetAddress = inetAddress2;
                                    } else {
                                        String name = networkInterface.getName();
                                        String name2 = networkInterface2.getName();
                                        if (name != null && !name.contains("p2p") && name2 != null && name2.contains("p2p")) {
                                            networkInterface = networkInterface2;
                                            inetAddress = inetAddress2;
                                        } else if (!(name == null || name.contains("wlan") || name.contains("p2p") || name2 == null || !name2.contains("wlan"))) {
                                            inetAddress3 = inetAddress2;
                                            networkInterface3 = networkInterface2;
                                            inetAddress = inetAddress3;
                                            networkInterface = networkInterface3;
                                        }
                                    }
                                }
                                networkInterface3 = networkInterface;
                                inetAddress3 = inetAddress;
                                inetAddress = inetAddress3;
                                networkInterface = networkInterface3;
                            }
                        }
                    }
                }
            }
            if (inetAddress != null) {
                return inetAddress.getHostAddress();
            }
            return null;
        } catch (SocketException e) {
            c.a(e.toString());
        }
    }

    public static String d() {
        n();
        if (f || a == null) {
            return g;
        }
        if (TextUtils.isEmpty(g)) {
            g = p();
        }
        return g;
    }

    private static String p() {
        try {
            return ((TelephonyManager) a.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            c.a(e.toString());
            return null;
        }
    }

    public static String e() {
        if (a == null) {
            return "null";
        }
        String str = "null";
        String str2 = null;
        if (a != null) {
            try {
                String subscriberId;
                TelephonyManager telephonyManager = (TelephonyManager) a.getSystemService("phone");
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                } else {
                    subscriberId = null;
                }
                str2 = subscriberId;
            } catch (Exception e) {
                c.a(e.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str2;
    }

    public static String f() {
        String simSerialNumber;
        String str = "";
        try {
            simSerialNumber = ((TelephonyManager) a.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            simSerialNumber = str;
        }
        if (simSerialNumber == null) {
            return "";
        }
        return simSerialNumber;
    }

    public static int g() {
        if (h) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            if (listFiles != null) {
                i = listFiles.length;
            }
        } catch (Throwable th) {
            c.a(th.toString());
        }
        if (i <= 0) {
            i = 1;
        }
        h = true;
        return i;
    }

    private static void q() {
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        if (!r) {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                try {
                    String readLine;
                    HashMap hashMap = new HashMap();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        readLine = readLine.trim();
                        if (readLine.length() > 0) {
                            String[] split = readLine.split(":");
                            if (split.length > 1) {
                                hashMap.put(split[0].trim(), split[1].trim());
                            }
                        }
                    }
                    readLine = (String) hashMap.get("Processor");
                    if (readLine != null) {
                        int indexOf = readLine.indexOf("(");
                        int lastIndexOf = readLine.lastIndexOf(")");
                        int i = lastIndexOf - indexOf;
                        if (indexOf <= 0 || lastIndexOf <= 0 || i <= 0) {
                            s = "v" + ((String) hashMap.get("CPU architecture"));
                        } else {
                            s = readLine.substring(indexOf + 1, lastIndexOf);
                        }
                    }
                    t = (String) hashMap.get("Features");
                    u = (String) hashMap.get("CPU part");
                    r = true;
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        c.a(e2.toString());
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        c.a(e.toString());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                c.a(e22.toString());
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                c.a(e4.toString());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
                c.a(e.toString());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
    }

    public static String h() {
        q();
        return s;
    }

    public static String i() {
        q();
        return u;
    }

    public static String j() {
        q();
        return t;
    }

    public static String k() {
        Throwable th;
        if (l) {
            return m;
        }
        String readLine;
        if (VERSION.SDK_INT < 14 || VERSION.SDK_INT > 16) {
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream()));
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.contains("x86")) {
                        m = "x86";
                    } else if (readLine != null) {
                        if (readLine.contains("armeabi-v7a")) {
                            m = "armv7";
                        }
                    }
                    com.ucweb.common.util.o.a.a(bufferedReader);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        c.a(th.toString());
                        com.ucweb.common.util.o.a.a(bufferedReader);
                        if (TextUtils.isEmpty(m)) {
                            try {
                                readLine = System.getProperty("os.arch").toLowerCase();
                                m = readLine;
                                m = "x86";
                            } catch (Throwable th3) {
                                c.a(th3.toString());
                            }
                        }
                        if (m == null) {
                            m = "";
                        }
                        l = true;
                        return m;
                    } catch (Throwable th4) {
                        th3 = th4;
                        com.ucweb.common.util.o.a.a(bufferedReader);
                        throw th3;
                    }
                }
            } catch (Throwable th5) {
                th3 = th5;
                bufferedReader = null;
                com.ucweb.common.util.o.a.a(bufferedReader);
                throw th3;
            }
        }
        if (TextUtils.isEmpty(m)) {
            readLine = System.getProperty("os.arch").toLowerCase();
            m = readLine;
            if (readLine != null && m.contains("i686")) {
                m = "x86";
            }
        }
        if (m == null) {
            m = "";
        }
        l = true;
        return m;
    }

    public static long l() {
        Closeable fileReader;
        Closeable bufferedReader;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        if (n) {
            return o;
        }
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            } catch (Exception e2) {
                e = e2;
                bufferedReader = null;
                closeable = fileReader;
                try {
                    c.a(e.toString());
                    com.ucweb.common.util.o.a.a(bufferedReader);
                    com.ucweb.common.util.o.a.a(closeable);
                    if (o < 0) {
                        o = 0;
                    }
                    n = true;
                    return o;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader = closeable;
                    com.ucweb.common.util.o.a.a(bufferedReader);
                    com.ucweb.common.util.o.a.a(fileReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                com.ucweb.common.util.o.a.a(bufferedReader);
                com.ucweb.common.util.o.a.a(fileReader);
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split("\\s+");
                    if (!(split == null || split.length <= 1 || split[1] == null)) {
                        o = Long.parseLong(split[1].trim());
                    }
                }
                bufferedReader.close();
                fileReader.close();
                com.ucweb.common.util.o.a.a(bufferedReader);
                com.ucweb.common.util.o.a.a(fileReader);
            } catch (Exception e3) {
                e = e3;
                closeable = fileReader;
                c.a(e.toString());
                com.ucweb.common.util.o.a.a(bufferedReader);
                com.ucweb.common.util.o.a.a(closeable);
                if (o < 0) {
                    o = 0;
                }
                n = true;
                return o;
            } catch (Throwable th4) {
                th = th4;
                com.ucweb.common.util.o.a.a(bufferedReader);
                com.ucweb.common.util.o.a.a(fileReader);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
            c.a(e.toString());
            com.ucweb.common.util.o.a.a(bufferedReader);
            com.ucweb.common.util.o.a.a(closeable);
            if (o < 0) {
                o = 0;
            }
            n = true;
            return o;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileReader = null;
            com.ucweb.common.util.o.a.a(bufferedReader);
            com.ucweb.common.util.o.a.a(fileReader);
            throw th;
        }
        if (o < 0) {
            o = 0;
        }
        n = true;
        return o;
    }

    public static int m() {
        Closeable fileInputStream;
        int read;
        Throwable th;
        Throwable th2;
        int i = 1024;
        try {
            File file = new File("/proc/meminfo");
            if (file.exists()) {
                byte[] bArr = new byte[1024];
                fileInputStream = new FileInputStream(file);
                try {
                    read = fileInputStream.read(bArr);
                    if (read < 1024) {
                        i = read;
                    }
                    bArr[i - 1] = (byte) 0;
                    String str = new String(bArr);
                    read = a(str, "MemFree:") + 0;
                    try {
                        read += a(str, "Buffers:");
                        i = a(str, "Cached:") + read;
                        com.ucweb.common.util.o.a.a(fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            c.a(th.toString());
                            com.ucweb.common.util.o.a.a(fileInputStream);
                            i = read;
                            if (i < 0) {
                                return 0;
                            }
                            return i;
                        } catch (Throwable th4) {
                            th2 = th4;
                            com.ucweb.common.util.o.a.a(fileInputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    read = 0;
                    c.a(th.toString());
                    com.ucweb.common.util.o.a.a(fileInputStream);
                    i = read;
                    if (i < 0) {
                        return i;
                    }
                    return 0;
                }
                if (i < 0) {
                    return i;
                }
                return 0;
            }
            com.ucweb.common.util.o.a.a(null);
            return 0;
        } catch (Throwable th6) {
            th2 = th6;
            fileInputStream = null;
            com.ucweb.common.util.o.a.a(fileInputStream);
            throw th2;
        }
    }

    private static int a(String str, String str2) {
        if (a.a(str) || a.a(str2)) {
            return 0;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf < 0) {
            return 0;
        }
        indexOf += str2.length();
        int indexOf2 = str.indexOf("kB", indexOf);
        if (indexOf2 >= 0) {
            return Integer.parseInt(str.substring(indexOf, indexOf2).trim());
        }
        return 0;
    }

    private static void r() {
        if (VERSION.SDK_INT >= 19) {
            try {
                boolean z;
                if (Boolean.parseBoolean(String.valueOf(com.ucweb.common.util.b.a.a(Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", null).invoke(null, null), "hasNavigationBar", null, null)))) {
                    for (CharSequence charSequence : x) {
                        if (Build.MODEL != null && Build.MODEL.contains(charSequence)) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        z = true;
                        if (z) {
                            v = true;
                        }
                        w = true;
                    }
                }
                z = false;
                if (z) {
                    v = true;
                }
            } catch (Exception e) {
            }
            w = true;
        }
        v = false;
        w = true;
    }

    public static void b(Activity activity) {
        if (!w) {
            r();
        }
        if (v) {
            Window window = activity.getWindow();
            if (window != null) {
                try {
                    com.ucweb.common.util.b.a.a(window.getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(0)});
                } catch (Exception e) {
                }
            }
        }
    }

    public static void a(Activity activity) {
        if (!w) {
            r();
        }
        if (v) {
            Window window = activity.getWindow();
            if (window != null) {
                try {
                    com.ucweb.common.util.b.a.a(window.getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(3846)});
                } catch (Exception e) {
                }
            }
        }
    }
}
