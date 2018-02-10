package com.uc.crashsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.a.i;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class f implements UncaughtExceptionHandler {
    private static boolean A = false;
    private static Runnable B = null;
    private static Object C = new Object();
    static String a = null;
    static final /* synthetic */ boolean b = (!f.class.desiredAssertionStatus());
    private static long c;
    private static volatile boolean d = false;
    private static boolean e = false;
    private static boolean g = true;
    private static String h;
    private static int i = 8;
    private static int j = 128;
    private static boolean k = false;
    private static String l = null;
    private static Object m = new Object();
    private static Object n = new Object();
    private static Object o = new Object();
    private static Object p = new Object();
    private static ArrayList<String> q = new ArrayList();
    private static int r = 0;
    private static String s = null;
    private static boolean t = false;
    private static String u = null;
    private static String v = null;
    private static String w = null;
    private static Object x = new Object();
    private static UncaughtExceptionHandler y = null;
    private static Throwable z = null;
    private final List<FileInputStream> f = new ArrayList();

    /* compiled from: ProGuard */
    final class a implements Runnable {
        private final String a;
        private boolean b;
        private boolean c;

        private a(String str, boolean z, boolean z2) {
            this.b = true;
            this.c = false;
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        public final void run() {
            com.uc.crashsdk.a.c.b("CrashHandler uploading logs");
            synchronized (f.m) {
                try {
                    if (h.b(this.a)) {
                        f.a(this.a, this.b, false);
                    } else {
                        com.uc.crashsdk.a.c.b("CrashHandler url is empty!");
                    }
                    if (this.c) {
                        f.m.notify();
                    }
                } catch (Throwable th) {
                    if (this.c) {
                        f.m.notify();
                    }
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class b extends OutputStream {
        private final OutputStream a;
        private int b = 0;
        private int c = 0;
        private boolean d = false;

        public b(OutputStream outputStream) {
            this.a = outputStream;
        }

        private int a(byte[] bArr, int i, int i2) {
            this.c += i2;
            if (this.d) {
                return 0;
            }
            int w = p.w();
            if (w <= 0 || this.b + i2 <= w) {
                w = i2;
            } else {
                w -= this.b;
            }
            this.b += w;
            this.a.write(bArr, i, w);
            if (w >= i2) {
                return w;
            }
            this.d = true;
            return w;
        }

        public final void a() {
            try {
                if (this.c - this.b > 0) {
                    a("\n".getBytes("UTF-8"));
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
                }
                int w = p.w();
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(w), Integer.valueOf(this.c - this.b)}).getBytes("UTF-8"));
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
        }

        public final void a(byte[] bArr) {
            if (f.g && p.G()) {
                com.uc.crashsdk.a.c.a("DEBUG", new String(bArr));
            }
            this.a.write(bArr);
        }

        public final void write(int i) {
            if (f.g && p.G()) {
                com.uc.crashsdk.a.c.a("DEBUG", String.format("%c", new Object[]{Integer.valueOf(i)}));
            }
            this.a.write(i);
            this.b++;
            this.c++;
        }

        public final void write(byte[] bArr, int i, int i2) {
            if (f.g && p.G()) {
                Object obj = new byte[i2];
                System.arraycopy(bArr, i, obj, 0, i2);
                com.uc.crashsdk.a.c.a("DEBUG", new String(obj));
            }
            a(bArr, i, i2);
        }

        public final void write(byte[] bArr) {
            if (f.g && p.G() && !(bArr.length == 1 && bArr[0] == (byte) 10)) {
                com.uc.crashsdk.a.c.a("DEBUG", new String(bArr));
            }
            a(bArr, 0, bArr.length);
        }
    }

    /* compiled from: ProGuard */
    final class c implements Comparator<File> {
        private c() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            File file = (File) obj;
            File file2 = (File) obj2;
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() < file2.lastModified() ? -1 : 0;
        }
    }

    /* compiled from: ProGuard */
    final class d implements Runnable {
        static final /* synthetic */ boolean a = (!f.class.desiredAssertionStatus());
        private int b;
        private String c;

        d(int i) {
            this.b = 0;
            this.c = null;
            this.b = i;
        }

        d(String str) {
            this.b = 0;
            this.c = null;
            this.b = 4;
            this.c = str;
        }

        public final void run() {
            switch (this.b) {
                case 1:
                    f.r();
                    return;
                case 2:
                    f.s();
                    return;
                case 3:
                    f.B();
                    return;
                case 4:
                    f.e(this.c);
                    return;
                default:
                    if (!a) {
                        throw new AssertionError();
                    }
                    return;
            }
        }
    }

    /* compiled from: ProGuard */
    final class e {
        long a = 0;
        long b = 0;
        int c = 0;
        int d = 0;
        boolean e = false;
        boolean f = false;
        boolean g = false;

        e() {
        }
    }

    /* compiled from: ProGuard */
    abstract class f {
        protected String b;
        protected e c;

        public abstract boolean a();

        public f(String str, e eVar) {
            this.b = str;
            this.c = eVar;
        }
    }

    static /* synthetic */ void e(String str) {
        File file = new File(b.e());
        if (!k) {
            k = true;
            String str2 = null;
            if (file.exists()) {
                str2 = a(com.uc.crashsdk.a.b.a(file, j, true));
            }
            JNIBridge.nativeSyncInfo("mLogTypeSuffix", str2, 1, 0);
        }
        if (h.a(str)) {
            com.uc.crashsdk.a.b.a(file);
        } else {
            com.uc.crashsdk.a.b.a(file, str.getBytes());
        }
    }

    static /* synthetic */ void r() {
        JNIBridge.nativePrepareUnexpInfos(CrashApi.getInstance().getLastExitType() == 5);
        a.a(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void s() {
        /*
        r2 = 1;
        r1 = C;
        monitor-enter(r1);
        r0 = B;	 Catch:{ all -> 0x0034 }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
    L_0x0009:
        return;
    L_0x000a:
        r0 = 1;
        A = r0;	 Catch:{ all -> 0x0034 }
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
        r0 = com.uc.crashsdk.p.o();
        r0 = (long) r0;
        r0 = com.uc.crashsdk.JNIBridge.nativeGenerateUnexpLog(r0);
        if (r0 == 0) goto L_0x0029;
    L_0x0019:
        r1 = 11;
        com.uc.crashsdk.k.a(r1);
        r1 = 2;
        if (r0 != r1) goto L_0x0037;
    L_0x0021:
        r0 = 10;
        com.uc.crashsdk.k.a(r0);
    L_0x0026:
        c(r2);
    L_0x0029:
        r1 = C;
        monitor-enter(r1);
        r0 = 0;
        B = r0;	 Catch:{ all -> 0x0031 }
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        goto L_0x0009;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r1 = 3;
        if (r0 != r1) goto L_0x0040;
    L_0x003a:
        r0 = 29;
        com.uc.crashsdk.k.a(r0);
        goto L_0x0026;
    L_0x0040:
        r1 = 4;
        if (r0 != r1) goto L_0x0049;
    L_0x0043:
        r0 = 30;
        com.uc.crashsdk.k.a(r0);
        goto L_0x0026;
    L_0x0049:
        r1 = 5;
        if (r0 != r1) goto L_0x0026;
    L_0x004c:
        r0 = 31;
        com.uc.crashsdk.k.a(r0);
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.s():void");
    }

    public f() {
        try {
            v();
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    private void v() {
        int D = p.D();
        int i = 0;
        while (i < D) {
            try {
                this.f.add(new FileInputStream("/dev/null"));
                i++;
            } catch (Throwable e) {
                com.uc.crashsdk.a.a.a(e, false);
                return;
            }
        }
    }

    private static String f(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable th) {
            return "unknown";
        }
    }

    private static String w() {
        return p.e() + "_";
    }

    public static void a() {
        h = null;
    }

    public static String b() {
        if (h != null) {
            return h;
        }
        String g = g(null);
        h = g;
        return g;
    }

    private static String g(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis());
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", new Object[]{w(), p.K(), p.M(), f(Build.MODEL), f(VERSION.RELEASE), str});
    }

    private static String x() {
        return b.o() ? "fg" : "bg";
    }

    private static byte[] y() {
        byte[] bArr = null;
        int i = 1024;
        while (bArr == null && i > 0) {
            try {
                bArr = new byte[i];
            } catch (Throwable th) {
                i /= 2;
                if (i < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String h(String str) {
        return String.format(Locale.US, "%s%s_%s_%s%s.log", new Object[]{b(), g(), x(), str, a(p.H())});
    }

    static String a(String str) {
        if (h.a(str)) {
            return "";
        }
        if (str.length() > j) {
            str = str.substring(0, j);
        }
        String f = f(str);
        return !f.startsWith(".") ? "." + f : f;
    }

    static void b(String str) {
        i.a(0, new d(str));
    }

    private static String z() {
        if (!b.s() || e) {
            return LogType.JAVA_TYPE;
        }
        return "ucebujava";
    }

    private static void c(boolean z) {
        try {
            if (b.n()) {
                File[] listFiles = new File(p.O()).listFiles();
                if (listFiles != null) {
                    int l = p.l();
                    int m = p.m();
                    if (listFiles.length >= Math.min(l, m)) {
                        int i = 0;
                        int i2 = 0;
                        for (File b : listFiles) {
                            if (b(b)) {
                                i2++;
                            } else {
                                i++;
                            }
                        }
                        if (!z || i2 < l) {
                            i2 = 0;
                        } else {
                            i2 = (i2 - l) + 1;
                        }
                        if (z || i < m) {
                            m = 0;
                        } else {
                            m = (i - m) + 1;
                        }
                        if (i2 != 0 || m != 0) {
                            Arrays.sort(listFiles, new c());
                            i = i2;
                            l = m;
                            for (File file : listFiles) {
                                boolean b2 = b(file);
                                if (b2 && i > 0) {
                                    com.uc.crashsdk.a.c.b("Delete oldest crash log: " + file.getPath());
                                    file.delete();
                                    i--;
                                } else if (!b2 && l > 0) {
                                    com.uc.crashsdk.a.c.b("Delete oldest custom log: " + file.getPath());
                                    file.delete();
                                    l--;
                                }
                                if (i == 0 && r4 == 0) {
                                    break;
                                }
                            }
                            k.a(16, i2 + m);
                            if (i2 > 0) {
                                k.a(22, i2);
                            }
                            if (m > 0) {
                                k.a(23, m);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    private static void a(OutputStream outputStream, String str, String str2) {
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        String str3 = "-";
        try {
            str3 = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/logver: 2/time: %s/cpu: %s/cpu hardware: %s'\n", new Object[]{Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), g(), Build.CPU_ABI, str3}).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", new Object[]{Build.MODEL, VERSION.RELEASE, Integer.valueOf(VERSION.SDK_INT)}).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            outputStream.write(String.format("Runtime Information: 'start: %s/maxheap: %s'\n", new Object[]{a(new Date(c)), Long.valueOf(Runtime.getRuntime().maxMemory())}).getBytes("UTF-8"));
        } catch (Throwable th32) {
            a(th32, outputStream);
        }
        try {
            outputStream.write(String.format("Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", new Object[]{p.K(), p.L(), p.M()}).getBytes("UTF-8"));
            str3 = SettingsConst.FALSE;
            if (b.d) {
                str3 = JNIBridge.nativeGetNativeBuildseq();
            }
            outputStream.write(String.format("CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", new Object[]{"2.0.0.4", str3, "170706161743", "release"}).getBytes("UTF-8"));
            if (str == null) {
                str = "";
            }
            outputStream.write(("Report Name: " + str.substring(str.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th322) {
            a(th322, outputStream);
        }
        try {
            outputStream.write(("UUID: " + a + "\n").getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th3222) {
            a(th3222, outputStream);
        }
        a(outputStream);
        try {
            a.a(outputStream, "UTF-8");
        } catch (Throwable th32222) {
            a(th32222, outputStream);
        }
        a(outputStream);
    }

    public static String c() {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append("JavaMax:    ").append(Runtime.getRuntime().maxMemory() / 1024).append(" kB\n");
            stringBuilder.append("JavaTotal:  ").append(Runtime.getRuntime().totalMemory() / 1024).append(" kB\n");
            stringBuilder.append("JavaFree:   ").append(Runtime.getRuntime().freeMemory() / 1024).append(" kB\n");
            stringBuilder.append("NativeHeap: ").append(Debug.getNativeHeapSize() / 1024).append(" kB\n");
            stringBuilder.append("NativeAllocated: ").append(Debug.getNativeHeapAllocatedSize() / 1024).append(" kB\n");
            stringBuilder.append("NativeFree: ").append(Debug.getNativeHeapFreeSize() / 1024).append(" kB\n");
            ActivityManager activityManager = (ActivityManager) e.a().getSystemService("activity");
            if (activityManager != null) {
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                stringBuilder.append("\n");
                stringBuilder.append("availMem:   ").append(memoryInfo.availMem / 1024).append(" kB\n");
                stringBuilder.append("threshold:  ").append(memoryInfo.threshold / 1024).append(" kB\n");
                stringBuilder.append("lowMemory:  ").append(memoryInfo.lowMemory).append("\n");
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return "exception exists.";
        }
        return stringBuilder.toString();
    }

    public static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"ps"}).getInputStream()));
            boolean b = h.b(str);
            boolean b2 = h.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                boolean z;
                if ((b && readLine.indexOf(str) >= 0) || (b2 && readLine.indexOf(str2) >= 0)) {
                    z = true;
                } else if (readLine.indexOf(47) >= 0 || readLine.indexOf(46) <= 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    byteArrayOutputStream.write(readLine.getBytes("UTF-8"));
                    byteArrayOutputStream.write("\n".getBytes("UTF-8"));
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return "exception exists.";
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i = SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
        while (bufferedReader == null && i > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i);
            } catch (Throwable th) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static void b(OutputStream outputStream) {
        int i = 0;
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat: \n".getBytes("UTF-8"));
            if (p.n() <= 0) {
                outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                a(outputStream);
                return;
            }
            int n = p.n();
            bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", "events", "-b", "main", "-v", "threadtime", "-t", String.valueOf(n)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (Throwable th2) {
                        a(th2, outputStream);
                        return;
                    }
                }
                return;
            }
            g = false;
            int i2 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i++;
                    if (i2 < n) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i2++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th22) {
                        a(th22, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}).getBytes("UTF-8"));
            g = true;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable th222) {
                    a(th222, outputStream);
                }
            }
            a(outputStream);
        } catch (Throwable th2222) {
            try {
                g = true;
                a(th2222, outputStream);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Throwable th22222) {
                a(th22222, outputStream);
            }
        }
    }

    private static void c(OutputStream outputStream) {
        Throwable th;
        Set hashSet;
        File file;
        File[] listFiles;
        try {
            outputStream.write(String.format("disk info:\n", new Object[0]).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            hashSet = new HashSet();
            try {
                a(outputStream, a(new File(e.a)), hashSet);
            } catch (Throwable th3) {
                th2 = th3;
                a(th2, outputStream);
                a(outputStream, a(Environment.getExternalStorageDirectory()), hashSet);
                file = new File("/storage");
                if (file.exists()) {
                    listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (!file2.isDirectory()) {
                                a(outputStream, a(file2), hashSet);
                            }
                        }
                    }
                }
                a(outputStream);
            }
        } catch (Throwable th4) {
            th2 = th4;
            hashSet = null;
            a(th2, outputStream);
            a(outputStream, a(Environment.getExternalStorageDirectory()), hashSet);
            file = new File("/storage");
            if (file.exists()) {
                listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file22 : listFiles) {
                        if (!file22.isDirectory()) {
                            a(outputStream, a(file22), hashSet);
                        }
                    }
                }
            }
            a(outputStream);
        }
        try {
            a(outputStream, a(Environment.getExternalStorageDirectory()), hashSet);
            file = new File("/storage");
            if (file.exists()) {
                listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file222 : listFiles) {
                        if (!file222.isDirectory()) {
                            a(outputStream, a(file222), hashSet);
                        }
                    }
                }
            }
        } catch (Throwable th22) {
            a(th22, outputStream);
        }
        a(outputStream);
    }

    private static String a(File file) {
        String str = null;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable th) {
        }
        if (h.a(str)) {
            return file.getPath();
        }
        return str;
    }

    private static void a(OutputStream outputStream, String str, Set<String> set) {
        if (!h.a(str) && !set.contains(str)) {
            if (!str.equals("/storage/emulated")) {
                set.add(str);
                try {
                    StatFs statFs = new StatFs(str);
                    long a = a(statFs, "getBlockCountLong", "getBlockCount");
                    if ((a / 1024) * a(statFs, "getBlockSizeLong", "getBlockSize") >= 10240) {
                        long a2 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                        long a3 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                        try {
                            OutputStream outputStream2 = outputStream;
                            outputStream2.write(String.format("%s:\n", new Object[]{str}).getBytes("UTF-8"));
                            outputStream2 = outputStream;
                            outputStream2.write(String.format("  total:      %d kB\n", new Object[]{Long.valueOf((long) (((((double) a) * 1.0d) * ((double) r6)) / 1024.0d))}).getBytes("UTF-8"));
                            outputStream2 = outputStream;
                            outputStream2.write(String.format("  available:  %d kB\n", new Object[]{Long.valueOf((long) (((((double) a2) * 1.0d) * ((double) r6)) / 1024.0d))}).getBytes("UTF-8"));
                            outputStream2 = outputStream;
                            outputStream2.write(String.format("  free:       %d kB\n", new Object[]{Long.valueOf((long) (((((double) a3) * 1.0d) * ((double) r6)) / 1024.0d))}).getBytes("UTF-8"));
                            outputStream2 = outputStream;
                            outputStream2.write(String.format("  block size: %d B\n\n", new Object[]{Long.valueOf(r6)}).getBytes("UTF-8"));
                        } catch (Throwable th) {
                            a(th, outputStream);
                        }
                    }
                } catch (Throwable th2) {
                }
            }
        }
    }

    private static long a(StatFs statFs, String str, String str2) {
        Object invoke;
        try {
            if (VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                invoke = declaredMethod.invoke(statFs, new Object[0]);
                if (invoke != null && (invoke instanceof Long)) {
                    return ((Long) invoke).longValue();
                }
            }
        } catch (Throwable th) {
        }
        try {
            declaredMethod = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(statFs, new Object[0]);
            if (invoke != null && (invoke instanceof Integer)) {
                return (long) ((Integer) invoke).intValue();
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
        }
        return 0;
    }

    private static void d(OutputStream outputStream) {
        File[] fileArr = null;
        int i = SecExceptionCode.SEC_ERROR_UMID_VALID;
        try {
            i = p.E();
            fileArr = new File("/proc/self/fd").listFiles();
            if (fileArr != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", new Object[]{Integer.valueOf(fileArr.length), Integer.valueOf(i)}).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th) {
            a(th, outputStream);
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder stringBuilder = new StringBuilder();
                    for (File file : fileArr) {
                        stringBuilder.append(file.getName());
                        stringBuilder.append(" -> ");
                        stringBuilder.append(file.getCanonicalPath());
                        stringBuilder.append("\n");
                    }
                    outputStream.write(stringBuilder.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th2) {
                a(th2, outputStream);
            }
        }
        a(outputStream);
    }

    private static void e(OutputStream outputStream) {
        File[] fileArr = null;
        int i = SecExceptionCode.SEC_ERROR_STA_ENC;
        int length;
        try {
            i = p.F();
            fileArr = new File("/proc/self/task").listFiles();
            if (fileArr != null) {
                length = fileArr.length;
                if (length < i) {
                    return;
                }
                if (fileArr != null) {
                    try {
                        outputStream.write("threads info:\n".getBytes("UTF-8"));
                        outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", new Object[]{Integer.valueOf(length), Integer.valueOf(i)}).getBytes("UTF-8"));
                        outputStream.write(" tid     name\n".getBytes("UTF-8"));
                        for (File path : fileArr) {
                            String i2 = i(com.uc.crashsdk.a.b.a(new File(path.getPath(), "comm"), 128, true));
                            outputStream.write(String.format(Locale.US, "%5s %s\n", new Object[]{path.getName(), i2}).getBytes("UTF-8"));
                        }
                    } catch (Throwable th) {
                        a(th, outputStream);
                    }
                    a(outputStream);
                }
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
            length = 0;
        }
    }

    private static void a(b bVar) {
        try {
            bVar.a(String.format("log end: %s\n", new Object[]{g()}).getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, (OutputStream) bVar);
        }
    }

    public static void a(OutputStream outputStream, String str) {
        if (str == null) {
            a(outputStream);
            return;
        }
        try {
            String a = com.uc.crashsdk.a.d.a(str);
            if (a == null) {
                a = "file: '" + str + "' not found or decode failed!";
            }
            outputStream.write(a.getBytes("UTF-8"));
            outputStream.write("\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        a(outputStream);
    }

    public static void b(OutputStream outputStream, String str) {
        Throwable th;
        DataInputStream dataInputStream = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] y = y();
                if (y == null) {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                    return;
                }
                DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = dataInputStream2.read(y);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(y, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        dataInputStream = dataInputStream2;
                    }
                }
                dataInputStream = dataInputStream2;
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
            }
            outputStream.write("\n".getBytes("UTF-8"));
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.a.a(th3, false);
                }
            }
        } catch (Throwable th4) {
            th3 = th4;
            try {
                a(th3, outputStream);
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable th32) {
                        com.uc.crashsdk.a.a.a(th32, false);
                    }
                }
                a(outputStream);
            } catch (Throwable th5) {
                th32 = th5;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable th6) {
                        com.uc.crashsdk.a.a.a(th6, false);
                    }
                }
                throw th32;
            }
        }
        a(outputStream);
    }

    private static void f(OutputStream outputStream) {
        try {
            outputStream.write("meminfo:\n".getBytes("UTF-8"));
            b(outputStream, "/proc/meminfo");
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            String format = String.format(Locale.US, "/proc/%d/status", new Object[]{Integer.valueOf(Process.myPid())});
            outputStream.write("status:\n".getBytes("UTF-8"));
            b(outputStream, format);
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(("Dalvik:\nMaxMemory: " + Runtime.getRuntime().maxMemory() + " TotalMemory: " + Runtime.getRuntime().totalMemory() + " FreeMemory: " + Runtime.getRuntime().freeMemory() + "\n").getBytes("UTF-8"));
        } catch (Throwable th22) {
            a(th22, outputStream);
        }
        a(outputStream);
    }

    public static String a(int i) {
        try {
            String a = com.uc.crashsdk.a.b.a(new File(String.format(Locale.US, "/proc/%d/cmdline", new Object[]{Integer.valueOf(i)})), 128, true);
            if (h.b(a)) {
                return i(a);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
        return "unknown";
    }

    private static String i(String str) {
        if (!h.b(str)) {
            return str;
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    public static String d() {
        if (l != null) {
            return l;
        }
        String a = a(Process.myPid());
        l = a;
        return a;
    }

    private static boolean a(String str, String str2, int i) {
        if (b.d) {
            return JNIBridge.nativeSyncStatus(str, str2, i);
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.Throwable r8, boolean r9) {
        /*
        r2 = 0;
        r6 = 0;
        r0 = 1;
        c(r0);	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r0 = com.uc.crashsdk.p.g();	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        if (r0 == 0) goto L_0x0014;
    L_0x000c:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        if (r1 == 0) goto L_0x001c;
    L_0x0014:
        r0 = z();	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r0 = h(r0);	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
    L_0x001c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r1.<init>();	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r3 = com.uc.crashsdk.p.O();	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r1 = r1.append(r3);	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r1 = r0.toString();	 Catch:{ Throwable -> 0x0208, all -> 0x0201 }
        r3 = new com.uc.crashsdk.f$b;	 Catch:{ Throwable -> 0x020d, all -> 0x0201 }
        r0 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x020d, all -> 0x0201 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x020d, all -> 0x0201 }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x020d, all -> 0x0201 }
        r0 = com.uc.crashsdk.b.d;	 Catch:{ Throwable -> 0x0161, all -> 0x0182 }
        if (r0 == 0) goto L_0x0045;
    L_0x003f:
        r0 = "logj";
        r2 = 0;
        a(r0, r1, r2);	 Catch:{ Throwable -> 0x0161, all -> 0x0182 }
    L_0x0045:
        r0 = z();	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        a(r3, r1, r0);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        if (r9 == 0) goto L_0x0051;
    L_0x004e:
        r3.flush();	 Catch:{ Throwable -> 0x017b, all -> 0x0182 }
    L_0x0051:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = "Process Name: '";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = d();	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = "'\n";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = "UTF-8";
        r0 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = "Thread Name: '";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = r2.getName();	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = "'\n";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r2 = "UTF-8";
        r0 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0189, all -> 0x0182 }
    L_0x0099:
        r0 = "Back traces starts.\n";
        r2 = "UTF-8";
        r0 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r0 = java.lang.Throwable.class;
        r2 = "detailMessage";
        r2 = r0.getDeclaredField(r2);	 Catch:{ Throwable -> 0x0190, all -> 0x0182 }
        r0 = 1;
        r2.setAccessible(r0);	 Catch:{ Throwable -> 0x0190, all -> 0x0182 }
        r0 = r2.get(r8);	 Catch:{ Throwable -> 0x0190, all -> 0x0182 }
        if (r0 == 0) goto L_0x00c3;
    L_0x00b6:
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0190, all -> 0x0182 }
        r4 = "\n\t";
        r5 = "\n->  ";
        r0 = r0.replaceAll(r4, r5);	 Catch:{ Throwable -> 0x0190, all -> 0x0182 }
        r2.set(r8, r0);	 Catch:{ Throwable -> 0x0190, all -> 0x0182 }
    L_0x00c3:
        r0 = r8.getMessage();	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        if (r0 == 0) goto L_0x00f1;
    L_0x00c9:
        r2 = r8.getLocalizedMessage();	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r2 = r0.equals(r2);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        if (r2 != 0) goto L_0x00f1;
    L_0x00d3:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r4 = "Message: ";
        r2.<init>(r4);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r0 = r2.append(r0);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r2 = "\n";
        r0 = r0.append(r2);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r2 = "UTF-8";
        r0 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        r3.write(r0);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
    L_0x00f1:
        r0 = new java.io.PrintStream;	 Catch:{ Throwable -> 0x019e, all -> 0x0182 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x019e, all -> 0x0182 }
        r8.printStackTrace(r0);	 Catch:{ Throwable -> 0x019e, all -> 0x0182 }
    L_0x00f9:
        r0 = "Back traces ends.\n";
        r2 = "UTF-8";
        r0 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x01a5, all -> 0x0182 }
        r3.write(r0);	 Catch:{ Throwable -> 0x01a5, all -> 0x0182 }
    L_0x0104:
        a(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        r3.flush();	 Catch:{ Throwable -> 0x01ac, all -> 0x0182 }
    L_0x010a:
        r0 = "UTF-8";
        r2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        com.uc.crashsdk.a.a(r3, r0, r2);	 Catch:{ Throwable -> 0x01b3, all -> 0x0182 }
    L_0x0111:
        if (r9 == 0) goto L_0x0116;
    L_0x0113:
        r3.flush();	 Catch:{ Throwable -> 0x01ba, all -> 0x0182 }
    L_0x0116:
        f(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        g(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        r0 = "UTF-8";
        r2 = 0;
        com.uc.crashsdk.a.a(r3, r0, r2);	 Catch:{ Throwable -> 0x01c1, all -> 0x0182 }
    L_0x0122:
        r3.flush();	 Catch:{ Throwable -> 0x01c7, all -> 0x0182 }
    L_0x0125:
        b(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        r3.flush();	 Catch:{ Throwable -> 0x01ce, all -> 0x0182 }
    L_0x012b:
        c(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        d(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        e(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        r0 = "UTF-8";
        r2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        r4 = 0;
        com.uc.crashsdk.a.b(r3, r0, r2, r4);	 Catch:{ Throwable -> 0x01d5, all -> 0x0182 }
    L_0x013c:
        r3.flush();	 Catch:{ Throwable -> 0x01db, all -> 0x0182 }
    L_0x013f:
        r0 = "UTF-8";
        r2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        r4 = 0;
        com.uc.crashsdk.a.a(r3, r0, r2, r4);	 Catch:{ Throwable -> 0x01e2, all -> 0x0182 }
    L_0x0147:
        r3.a();	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        a(r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        r3.flush();	 Catch:{ Throwable -> 0x01e8, all -> 0x0182 }
    L_0x0150:
        r3.close();	 Catch:{ Throwable -> 0x01ef }
        r0 = r1;
    L_0x0154:
        m(r0);
        r1 = j(r0);	 Catch:{ Throwable -> 0x01fb }
        r2 = "java";
        b(r1, r2);	 Catch:{ Throwable -> 0x01fb }
    L_0x0160:
        return r0;
    L_0x0161:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0045;
    L_0x0168:
        r0 = move-exception;
        r2 = r3;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x016d:
        a(r1, r2);	 Catch:{ all -> 0x0204 }
        if (r2 == 0) goto L_0x0154;
    L_0x0172:
        r2.close();	 Catch:{ Throwable -> 0x0176 }
        goto L_0x0154;
    L_0x0176:
        r1 = move-exception;
        com.uc.crashsdk.a.a.a(r1, r6);
        goto L_0x0154;
    L_0x017b:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0051;
    L_0x0182:
        r0 = move-exception;
    L_0x0183:
        if (r3 == 0) goto L_0x0188;
    L_0x0185:
        r3.close();	 Catch:{ Throwable -> 0x01f6 }
    L_0x0188:
        throw r0;
    L_0x0189:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0099;
    L_0x0190:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0197, all -> 0x0182 }
        goto L_0x00c3;
    L_0x0197:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x00f1;
    L_0x019e:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x00f9;
    L_0x01a5:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0104;
    L_0x01ac:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x010a;
    L_0x01b3:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0111;
    L_0x01ba:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0116;
    L_0x01c1:
        r0 = move-exception;
        a(r0, r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0122;
    L_0x01c7:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0125;
    L_0x01ce:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x012b;
    L_0x01d5:
        r0 = move-exception;
        a(r0, r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x013c;
    L_0x01db:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x013f;
    L_0x01e2:
        r0 = move-exception;
        a(r0, r3);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0147;
    L_0x01e8:
        r0 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r0, r2);	 Catch:{ Throwable -> 0x0168, all -> 0x0182 }
        goto L_0x0150;
    L_0x01ef:
        r0 = move-exception;
        com.uc.crashsdk.a.a.a(r0, r6);
        r0 = r1;
        goto L_0x0154;
    L_0x01f6:
        r1 = move-exception;
        com.uc.crashsdk.a.a.a(r1, r6);
        goto L_0x0188;
    L_0x01fb:
        r1 = move-exception;
        com.uc.crashsdk.a.a.a(r1, r6);
        goto L_0x0160;
    L_0x0201:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0183;
    L_0x0204:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0183;
    L_0x0208:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x016d;
    L_0x020d:
        r0 = move-exception;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x016d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.Throwable, boolean):java.lang.String");
    }

    private static void g(OutputStream outputStream) {
        try {
            outputStream.write("Recent Status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format("last version: '%s'\n", new Object[]{a.g()}).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            synchronized (q) {
                if (s != null) {
                    outputStream.write(String.format("generating log: %s\n", new Object[]{s.toString()}).getBytes("UTF-8"));
                }
                if (r > 0 || q.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", new Object[]{Integer.valueOf(r)}).getBytes("UTF-8"));
                    Iterator it = q.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format("* %s\n", new Object[]{(String) it.next()}).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format("dumping all threads: %s\n", new Object[]{Boolean.valueOf(t)}).getBytes("UTF-8"));
            if (u != null) {
                outputStream.write(String.format("dumping threads: %s\n", new Object[]{u}).getBytes("UTF-8"));
            }
        } catch (Throwable th22) {
            a(th22, outputStream);
        }
        a(outputStream);
    }

    private static String j(String str) {
        String a = com.uc.crashsdk.a.d.a(str, p.v(), p.u());
        if (!str.equals(a)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a;
    }

    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.a.a(th2, false);
            }
        }
        com.uc.crashsdk.a.a.a(th, false);
    }

    public static void a(String str, boolean z, boolean z2) {
        String O = p.O();
        File file = new File(O);
        if (file.exists()) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.c.c("List folder failed: " + O);
                return;
            }
            int i6;
            int i7 = 0;
            int length = listFiles.length;
            int i8 = 0;
            while (i8 < length) {
                Object obj4;
                Object obj5;
                int i9;
                int i10;
                int i11;
                Object obj6;
                int i12;
                File file2 = listFiles[i8];
                if (!file2.isFile()) {
                    com.uc.crashsdk.a.b.a(file2);
                    obj4 = obj3;
                    obj5 = obj;
                    i9 = i4;
                    i10 = i3;
                    i11 = i;
                    i4 = i7;
                    obj6 = obj2;
                    i12 = i2;
                } else if (z2 && !file2.getName().contains("ucebu")) {
                    obj4 = obj3;
                    obj5 = obj;
                    i9 = i4;
                    i10 = i3;
                    i11 = i;
                    i4 = i7;
                    obj6 = obj2;
                    i12 = i2;
                } else if (file2.length() == 0) {
                    r2 = i + 1;
                    com.uc.crashsdk.a.b.a(file2);
                    obj5 = obj;
                    i9 = i4;
                    i11 = r2;
                    i4 = i7;
                    obj4 = obj3;
                    i10 = i3;
                    obj6 = obj2;
                    i12 = i2;
                } else {
                    long currentTimeMillis;
                    String group;
                    File file3;
                    String k;
                    e eVar;
                    File file4;
                    int A;
                    String[] split;
                    Object obj7;
                    if (z) {
                        currentTimeMillis = (System.currentTimeMillis() - file2.lastModified()) / 1000;
                        boolean z3 = true;
                        if (currentTimeMillis >= 0) {
                            if (currentTimeMillis < 2) {
                                z3 = false;
                            } else if (currentTimeMillis < 5 && file2.getName().endsWith(".log")) {
                                z3 = false;
                            }
                        }
                        com.uc.crashsdk.a.c.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", new Object[]{file2.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z3)}));
                        if (!z3) {
                            obj5 = obj;
                            i9 = i4 + 1;
                            i4 = i7;
                            i11 = i;
                            obj4 = obj3;
                            i10 = i3;
                            obj6 = obj2;
                            i12 = i2;
                        }
                    }
                    try {
                        if (p.k()) {
                            Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file2.getName());
                            if (matcher.matches()) {
                                group = matcher.group(1);
                                String group2 = matcher.group(2);
                                O = matcher.group(3);
                                file = new File(p.O() + String.format(Locale.US, "%s%s_%s_%s.%s", new Object[]{g(group2), g(), x(), group, O}));
                                com.uc.crashsdk.a.c.b("File " + file2.getPath() + " matches, rename to " + file.getPath());
                                file2.renameTo(file);
                                if (file == file2) {
                                    r2 = i3 + 1;
                                } else {
                                    r2 = i3;
                                }
                                i3 = r2;
                                file3 = file;
                                group = file3.getPath();
                                k = k(group);
                                if (group == k) {
                                    i6 = i5 + 1;
                                    file3 = new File(k);
                                } else {
                                    i6 = i5;
                                }
                                file2 = d.a(file3);
                                if (file2 != null) {
                                    file2 = null;
                                } else if (!(file3 == file2 || file3.getName().equals(file2.getName()) || !file3.exists())) {
                                    file3.delete();
                                }
                                if (file2 != null) {
                                    com.uc.crashsdk.a.c.c("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                    obj4 = obj3;
                                    i5 = i6;
                                    i9 = i4;
                                    obj5 = obj;
                                    i10 = i3;
                                    i4 = i7;
                                    i11 = i;
                                    obj6 = obj2;
                                    i12 = i2;
                                } else {
                                    r2 = p.x();
                                    if (r2 > 0 || file2.length() < ((long) r2)) {
                                        eVar = new e();
                                        eVar.b = 0;
                                        eVar.a = System.currentTimeMillis();
                                        O = A();
                                        file4 = new File(O);
                                        if (file4.exists()) {
                                            a(O, new g(O, eVar, file4));
                                        }
                                        currentTimeMillis = p.y();
                                        r2 = p.z();
                                        A = p.A();
                                        if (currentTimeMillis < 0 && eVar.b + file2.length() > currentTimeMillis) {
                                            eVar.e = true;
                                            com.uc.crashsdk.a.c.c("Reach max upload bytes: " + currentTimeMillis);
                                        } else if (!p.f()) {
                                            if (b(file2)) {
                                                if (A >= 0 && eVar.d >= A) {
                                                    eVar.f = true;
                                                    com.uc.crashsdk.a.c.c("Reach max upload custom log count: " + A);
                                                }
                                            } else if (r2 >= 0 && eVar.c >= r2) {
                                                eVar.g = true;
                                                com.uc.crashsdk.a.c.c("Reach max upload crash log count: " + r2);
                                            }
                                        }
                                        if (!eVar.e) {
                                            if (!eVar.g) {
                                                if (eVar.f) {
                                                    O = file2.getName();
                                                    if (O.startsWith(w())) {
                                                        split = O.split("_");
                                                        if (split.length == 9) {
                                                            O = split[1];
                                                            obj4 = (O == null && O.equals(p.K())) ? 1 : null;
                                                            if (q.a(file2, file2.getName(), str)) {
                                                                i9 = i7 + 1;
                                                                if (obj4 != null) {
                                                                    k.a(14);
                                                                }
                                                                r2 = i9;
                                                            } else {
                                                                com.uc.crashsdk.a.c.a("crashsdk", "Uploaded log: " + file2.getName());
                                                                if (obj4 != null) {
                                                                    k.a(13);
                                                                }
                                                                eVar.b += file2.length();
                                                                if (b(file2)) {
                                                                    eVar.d++;
                                                                } else {
                                                                    eVar.c++;
                                                                }
                                                                O = A();
                                                                a(O, new h(O, eVar));
                                                                file2.delete();
                                                                r2 = 0;
                                                            }
                                                            if (r2 < 3) {
                                                                com.uc.crashsdk.a.c.a("crashsdk", "Upload failed 3 times continuously, abort upload!");
                                                                break;
                                                            }
                                                            i5 = i6;
                                                            i9 = i4;
                                                            obj5 = obj;
                                                            i4 = r2;
                                                            i11 = i;
                                                            obj4 = obj3;
                                                            i10 = i3;
                                                            obj6 = obj2;
                                                            i12 = i2;
                                                        }
                                                    }
                                                    O = null;
                                                    if (O == null) {
                                                    }
                                                    if (q.a(file2, file2.getName(), str)) {
                                                        i9 = i7 + 1;
                                                        if (obj4 != null) {
                                                            k.a(14);
                                                        }
                                                        r2 = i9;
                                                    } else {
                                                        com.uc.crashsdk.a.c.a("crashsdk", "Uploaded log: " + file2.getName());
                                                        if (obj4 != null) {
                                                            k.a(13);
                                                        }
                                                        eVar.b += file2.length();
                                                        if (b(file2)) {
                                                            eVar.d++;
                                                        } else {
                                                            eVar.c++;
                                                        }
                                                        O = A();
                                                        a(O, new h(O, eVar));
                                                        file2.delete();
                                                        r2 = 0;
                                                    }
                                                    if (r2 < 3) {
                                                        com.uc.crashsdk.a.c.a("crashsdk", "Upload failed 3 times continuously, abort upload!");
                                                        break;
                                                    }
                                                    i5 = i6;
                                                    i9 = i4;
                                                    obj5 = obj;
                                                    i4 = r2;
                                                    i11 = i;
                                                    obj4 = obj3;
                                                    i10 = i3;
                                                    obj6 = obj2;
                                                    i12 = i2;
                                                } else {
                                                    obj4 = 1;
                                                    i5 = i6;
                                                    i9 = i4;
                                                    i10 = i3;
                                                    obj5 = obj;
                                                    obj6 = obj2;
                                                    i4 = i7;
                                                    i11 = i;
                                                    i12 = i2;
                                                }
                                            } else {
                                                i5 = i6;
                                                i9 = i4;
                                                i12 = i2;
                                                obj5 = obj;
                                                i4 = i7;
                                                i11 = i;
                                                obj7 = obj3;
                                                i10 = i3;
                                                i3 = 1;
                                                obj4 = obj7;
                                            }
                                        } else {
                                            i5 = i6;
                                            i9 = i4;
                                            i11 = i;
                                            i6 = 1;
                                            i4 = i7;
                                            obj4 = obj3;
                                            i10 = i3;
                                            obj6 = obj2;
                                            i12 = i2;
                                        }
                                    } else {
                                        r2 = i2 + 1;
                                        com.uc.crashsdk.a.b.a(file2);
                                        i5 = i6;
                                        i9 = i4;
                                        obj5 = obj;
                                        i4 = i7;
                                        i11 = i;
                                        int i13 = i3;
                                        obj6 = obj2;
                                        i12 = r2;
                                        obj4 = obj3;
                                        i10 = i13;
                                    }
                                }
                            }
                        }
                        file = file2;
                        if (file == file2) {
                            r2 = i3;
                        } else {
                            r2 = i3 + 1;
                        }
                        i3 = r2;
                        file3 = file;
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.a.a(th, false);
                        file3 = file2;
                    }
                    group = file3.getPath();
                    k = k(group);
                    if (group == k) {
                        i6 = i5;
                    } else {
                        i6 = i5 + 1;
                        file3 = new File(k);
                    }
                    file2 = d.a(file3);
                    if (file2 != null) {
                        file3.delete();
                    } else {
                        file2 = null;
                    }
                    if (file2 != null) {
                        r2 = p.x();
                        if (r2 > 0) {
                        }
                        eVar = new e();
                        eVar.b = 0;
                        eVar.a = System.currentTimeMillis();
                        O = A();
                        file4 = new File(O);
                        if (file4.exists()) {
                            a(O, new g(O, eVar, file4));
                        }
                        currentTimeMillis = p.y();
                        r2 = p.z();
                        A = p.A();
                        if (currentTimeMillis < 0) {
                        }
                        if (p.f()) {
                            if (b(file2)) {
                                eVar.f = true;
                                com.uc.crashsdk.a.c.c("Reach max upload custom log count: " + A);
                            } else {
                                eVar.g = true;
                                com.uc.crashsdk.a.c.c("Reach max upload crash log count: " + r2);
                            }
                        }
                        if (!eVar.e) {
                            i5 = i6;
                            i9 = i4;
                            i11 = i;
                            i6 = 1;
                            i4 = i7;
                            obj4 = obj3;
                            i10 = i3;
                            obj6 = obj2;
                            i12 = i2;
                        } else if (!eVar.g) {
                            i5 = i6;
                            i9 = i4;
                            i12 = i2;
                            obj5 = obj;
                            i4 = i7;
                            i11 = i;
                            obj7 = obj3;
                            i10 = i3;
                            i3 = 1;
                            obj4 = obj7;
                        } else if (eVar.f) {
                            O = file2.getName();
                            if (O.startsWith(w())) {
                                split = O.split("_");
                                if (split.length == 9) {
                                    O = split[1];
                                    if (O == null) {
                                    }
                                    if (q.a(file2, file2.getName(), str)) {
                                        com.uc.crashsdk.a.c.a("crashsdk", "Uploaded log: " + file2.getName());
                                        if (obj4 != null) {
                                            k.a(13);
                                        }
                                        eVar.b += file2.length();
                                        if (b(file2)) {
                                            eVar.c++;
                                        } else {
                                            eVar.d++;
                                        }
                                        O = A();
                                        a(O, new h(O, eVar));
                                        file2.delete();
                                        r2 = 0;
                                    } else {
                                        i9 = i7 + 1;
                                        if (obj4 != null) {
                                            k.a(14);
                                        }
                                        r2 = i9;
                                    }
                                    if (r2 < 3) {
                                        com.uc.crashsdk.a.c.a("crashsdk", "Upload failed 3 times continuously, abort upload!");
                                        break;
                                    }
                                    i5 = i6;
                                    i9 = i4;
                                    obj5 = obj;
                                    i4 = r2;
                                    i11 = i;
                                    obj4 = obj3;
                                    i10 = i3;
                                    obj6 = obj2;
                                    i12 = i2;
                                }
                            }
                            O = null;
                            if (O == null) {
                            }
                            if (q.a(file2, file2.getName(), str)) {
                                i9 = i7 + 1;
                                if (obj4 != null) {
                                    k.a(14);
                                }
                                r2 = i9;
                            } else {
                                com.uc.crashsdk.a.c.a("crashsdk", "Uploaded log: " + file2.getName());
                                if (obj4 != null) {
                                    k.a(13);
                                }
                                eVar.b += file2.length();
                                if (b(file2)) {
                                    eVar.d++;
                                } else {
                                    eVar.c++;
                                }
                                O = A();
                                a(O, new h(O, eVar));
                                file2.delete();
                                r2 = 0;
                            }
                            if (r2 < 3) {
                                com.uc.crashsdk.a.c.a("crashsdk", "Upload failed 3 times continuously, abort upload!");
                                break;
                            }
                            i5 = i6;
                            i9 = i4;
                            obj5 = obj;
                            i4 = r2;
                            i11 = i;
                            obj4 = obj3;
                            i10 = i3;
                            obj6 = obj2;
                            i12 = i2;
                        } else {
                            obj4 = 1;
                            i5 = i6;
                            i9 = i4;
                            i10 = i3;
                            obj5 = obj;
                            obj6 = obj2;
                            i4 = i7;
                            i11 = i;
                            i12 = i2;
                        }
                    } else {
                        com.uc.crashsdk.a.c.c("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                        obj4 = obj3;
                        i5 = i6;
                        i9 = i4;
                        obj5 = obj;
                        i10 = i3;
                        i4 = i7;
                        i11 = i;
                        obj6 = obj2;
                        i12 = i2;
                    }
                }
                i8++;
                i = i11;
                i7 = i4;
                obj = obj5;
                i4 = i9;
                i2 = i12;
                obj2 = obj6;
                i3 = i10;
                obj3 = obj4;
            }
            i6 = i5;
            if (i > 0) {
                k.a(15, i);
            }
            if (i2 > 0) {
                k.a(17, i2);
            }
            if (obj != null) {
                k.a(19);
            }
            if (obj2 != null) {
                k.a(20);
            }
            if (obj3 != null) {
                k.a(21);
            }
            if (!(obj == null && obj2 == null && obj3 == null)) {
                k.a(18);
            }
            if (i6 > 0) {
                k.a(24, i6);
            }
            if (i3 > 0) {
                k.a(25, i3);
            }
            if (i4 > 0) {
                k.a(26, i4);
                return;
            }
            return;
        }
        com.uc.crashsdk.a.c.b("Folder not exist: " + O);
    }

    public static boolean e() {
        return e;
    }

    public static boolean a(boolean z) {
        if (z) {
            e = true;
            if (b.d) {
                JNIBridge.nativeSetCrashLogFilesUploaded();
            }
        }
        try {
            String f = f();
            if (h.a(f)) {
                com.uc.crashsdk.a.c.b("CrashHandler url is empty!");
                return false;
            }
            synchronized (m) {
                int i;
                boolean z2 = !z;
                Runnable aVar = new a(f, z, z2);
                if (z) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i.a(i, aVar) && z2) {
                    try {
                        m.wait();
                    } catch (Throwable e) {
                        com.uc.crashsdk.a.a.a(e, false);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return false;
        }
    }

    public static void b(boolean z) {
        try {
            if (!p.r() || !a.a.equals(d()) || b.s() || e) {
                return;
            }
            if (z) {
                String f = f();
                if (!h.a(f)) {
                    StrictMode.setThreadPolicy(new Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
                    new a(f, false, false).run();
                    return;
                }
                return;
            }
            a(false);
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    private static String A() {
        return p.N() + "bytes";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r7, com.uc.crashsdk.f.f r8) {
        /*
        r1 = 0;
        r2 = 0;
        r3 = n;
        monitor-enter(r3);
        r0 = new java.io.File;	 Catch:{ all -> 0x003a }
        r0.<init>(r7);	 Catch:{ all -> 0x003a }
        r4 = r0.exists();	 Catch:{ all -> 0x003a }
        if (r4 != 0) goto L_0x0013;
    L_0x0010:
        r0.createNewFile();	 Catch:{ Exception -> 0x0034 }
    L_0x0013:
        r4 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x003d }
        r5 = "rw";
        r4.<init>(r0, r5);	 Catch:{ Exception -> 0x003d }
        r0 = r4.getChannel();	 Catch:{ Exception -> 0x003d }
    L_0x001e:
        if (r0 == 0) goto L_0x0024;
    L_0x0020:
        r1 = r0.lock();	 Catch:{ Exception -> 0x0044, all -> 0x0064 }
    L_0x0024:
        r2 = r8.a();	 Catch:{ all -> 0x006e }
        if (r1 == 0) goto L_0x002d;
    L_0x002a:
        r1.release();	 Catch:{ Exception -> 0x005e, all -> 0x0064 }
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();	 Catch:{ Exception -> 0x007b }
    L_0x0032:
        monitor-exit(r3);	 Catch:{ all -> 0x003a }
        return r2;
    L_0x0034:
        r4 = move-exception;
        r5 = 0;
        com.uc.crashsdk.a.a.a(r4, r5);	 Catch:{ all -> 0x003a }
        goto L_0x0013;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        r0 = move-exception;
        r4 = 0;
        com.uc.crashsdk.a.a.a(r0, r4);	 Catch:{ Exception -> 0x0089 }
        r0 = r1;
        goto L_0x001e;
    L_0x0044:
        r4 = move-exception;
        r5 = 0;
        com.uc.crashsdk.a.a.a(r4, r5);	 Catch:{ Exception -> 0x004a, all -> 0x0064 }
        goto L_0x0024;
    L_0x004a:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x004e:
        r4 = 0;
        com.uc.crashsdk.a.a.a(r0, r4);	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x0032;
    L_0x0054:
        r1.close();	 Catch:{ Exception -> 0x0058 }
        goto L_0x0032;
    L_0x0058:
        r0 = move-exception;
        r1 = 0;
        com.uc.crashsdk.a.a.a(r0, r1);	 Catch:{ all -> 0x003a }
        goto L_0x0032;
    L_0x005e:
        r1 = move-exception;
        r4 = 0;
        com.uc.crashsdk.a.a.a(r1, r4);	 Catch:{ Exception -> 0x004a, all -> 0x0064 }
        goto L_0x002d;
    L_0x0064:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0068:
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ Exception -> 0x0081 }
    L_0x006d:
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x006e:
        r4 = move-exception;
        if (r1 == 0) goto L_0x0074;
    L_0x0071:
        r1.release();	 Catch:{ Exception -> 0x0075, all -> 0x0064 }
    L_0x0074:
        throw r4;	 Catch:{ Exception -> 0x004a, all -> 0x0064 }
    L_0x0075:
        r1 = move-exception;
        r5 = 0;
        com.uc.crashsdk.a.a.a(r1, r5);	 Catch:{ Exception -> 0x004a, all -> 0x0064 }
        goto L_0x0074;
    L_0x007b:
        r0 = move-exception;
        r1 = 0;
        com.uc.crashsdk.a.a.a(r0, r1);	 Catch:{ all -> 0x003a }
        goto L_0x0032;
    L_0x0081:
        r1 = move-exception;
        r2 = 0;
        com.uc.crashsdk.a.a.a(r1, r2);	 Catch:{ all -> 0x003a }
        goto L_0x006d;
    L_0x0087:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0089:
        r0 = move-exception;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.a(java.lang.String, com.uc.crashsdk.f$f):boolean");
    }

    private static boolean b(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0) {
            return false;
        }
        int indexOf = name.indexOf(46, lastIndexOf);
        if (indexOf <= 0) {
            return false;
        }
        name = name.substring(lastIndexOf + 1, indexOf);
        if (LogType.JAVA_TYPE.equals(name) || "ucebujava".equals(name) || LogType.NATIVE_TYPE.equals(name) || "ucebujni".equals(name) || LogType.UNEXP_TYPE.equals(name)) {
            return true;
        }
        return false;
    }

    private static String k(String str) {
        if (p.u() && !h.a(p.v())) {
            int lastIndexOf = str.lastIndexOf(".log");
            if (lastIndexOf > 0 && lastIndexOf + 4 == str.length()) {
                int i;
                int lastIndexOf2 = str.lastIndexOf(File.separatorChar);
                if (lastIndexOf2 < 0) {
                    lastIndexOf2 = 0;
                    i = 0;
                } else {
                    i = 0;
                }
                do {
                    lastIndexOf2 = str.indexOf(95, lastIndexOf2);
                    if (lastIndexOf2 >= 0) {
                        i++;
                        lastIndexOf2++;
                        continue;
                    }
                } while (lastIndexOf2 >= 0);
                if (i == i) {
                    lastIndexOf2 = str.lastIndexOf(95);
                    if (!b && lastIndexOf2 <= 0) {
                        throw new AssertionError();
                    } else if (str.indexOf(".log", lastIndexOf2) == lastIndexOf) {
                        try {
                            str = j(str);
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.a.a(th, false);
                        }
                    }
                }
            }
        }
        return str;
    }

    public static boolean a(StringBuffer stringBuffer, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        if (d) {
            com.uc.crashsdk.a.c.c("Processing java crash, skip generate custom log: " + str);
            return false;
        } else if (!com.uc.crashsdk.a.f.d()) {
            com.uc.crashsdk.a.c.b("DEBUG", com.uc.crashsdk.a.f.b());
            return false;
        } else if (b.d && JNIBridge.nativeIsCrashing()) {
            com.uc.crashsdk.a.c.c("Processing native crash, skip generate custom log: " + str);
            return false;
        } else if (stringBuffer == null || str == null) {
            return false;
        } else {
            if (l(str)) {
                com.uc.crashsdk.a.c.c(String.format("Custom log '%s' has reach max count!", new Object[]{str}));
                return false;
            }
            String a;
            c(false);
            synchronized (o) {
                a = a(stringBuffer, str, z, z2, z3, z4, arrayList, arrayList2, arrayList3, str2);
            }
            if (a == null || a.length() == 0) {
                return false;
            }
            m(a);
            b(j(a), str);
            if (z5) {
                try {
                    a(false);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.a.a(th, false);
                }
            }
            return true;
        }
    }

    private static boolean l(String str) {
        Throwable e;
        boolean z;
        boolean z2 = false;
        synchronized (p) {
            FileWriter fileWriter;
            File file = new File(p.N() + "customlog");
            String a = com.uc.crashsdk.a.b.a(file, 1024, true);
            long currentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            Object obj = null;
            if (a != null) {
                stringBuffer.append(a);
                int i = 0;
                Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                while (matcher.find(i)) {
                    if (str.equals(matcher.group(1))) {
                        int parseInt;
                        long parseLong = Long.parseLong(matcher.group(2));
                        if (currentTimeMillis - parseLong < 86400000) {
                            try {
                                parseInt = Integer.parseInt(matcher.group(3));
                            } catch (Throwable e2) {
                                com.uc.crashsdk.a.a.a(e2, false);
                                parseInt = 0;
                            }
                        } else {
                            parseLong = currentTimeMillis;
                            parseInt = 0;
                        }
                        int B = p.B();
                        if (B >= 0 && parseInt >= B) {
                            z2 = true;
                        }
                        parseInt++;
                        stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", new Object[]{str, Long.valueOf(parseLong), Integer.valueOf(parseInt)}));
                        obj = 1;
                        z = z2;
                        if (obj == null) {
                            stringBuffer.append(String.format(Locale.US, "%s %d 1\n", new Object[]{str, Long.valueOf(currentTimeMillis)}));
                        }
                        fileWriter = new FileWriter(file);
                        try {
                            String stringBuffer2 = stringBuffer.toString();
                            fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
                            try {
                                fileWriter.close();
                            } catch (Throwable e22) {
                                com.uc.crashsdk.a.a.a(e22, false);
                            }
                        } catch (Exception e3) {
                            e22 = e3;
                            try {
                                com.uc.crashsdk.a.a.a(e22, false);
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (Throwable e222) {
                                        com.uc.crashsdk.a.a.a(e222, false);
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                e222 = th;
                                if (fileWriter != null) {
                                    try {
                                        fileWriter.close();
                                    } catch (Throwable e4) {
                                        com.uc.crashsdk.a.a.a(e4, false);
                                    }
                                }
                                throw e222;
                            }
                        }
                    } else {
                        i = matcher.end();
                    }
                }
            }
            z = false;
            if (obj == null) {
                stringBuffer.append(String.format(Locale.US, "%s %d 1\n", new Object[]{str, Long.valueOf(currentTimeMillis)}));
            }
            try {
                fileWriter = new FileWriter(file);
                String stringBuffer22 = stringBuffer.toString();
                fileWriter.write(stringBuffer22, 0, stringBuffer22.length());
                fileWriter.close();
            } catch (Exception e5) {
                e222 = e5;
                fileWriter = null;
                com.uc.crashsdk.a.a.a(e222, false);
                if (fileWriter != null) {
                    fileWriter.close();
                }
                return z;
            } catch (Throwable th2) {
                e222 = th2;
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw e222;
            }
        }
        return z;
    }

    private static void a(b bVar, String str) {
        String nativeDumpThreads;
        String str2 = null;
        if (b.d) {
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str);
            if (nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith("/") || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else if (!new File(nativeDumpThreads).exists()) {
                str2 = "Can not found " + nativeDumpThreads;
            }
        } else {
            nativeDumpThreads = null;
            str2 = "Native not initialized, skip dump!";
        }
        if (str2 != null) {
            try {
                bVar.write(str2.getBytes("UTF-8"));
                bVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
            a((OutputStream) bVar);
        } else if (nativeDumpThreads != null) {
            b((OutputStream) bVar, nativeDumpThreads);
            File file = new File(nativeDumpThreads);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            bVar.flush();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
        }
    }

    private static String a(StringBuffer stringBuffer, String str, boolean z, boolean z2, boolean z3, boolean z4, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        OutputStream bVar;
        Throwable th;
        String str3 = p.O() + h(str);
        try {
            bVar = new b(new FileOutputStream(str3));
            try {
                synchronized (q) {
                    s = str3;
                    a("logb", s, 0);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bVar = null;
            com.uc.crashsdk.a.a.a(th, false);
            if (bVar == null) {
                return null;
            }
            if (z) {
                a(bVar, str3, str);
            }
            try {
                bVar.write(stringBuffer.toString().getBytes());
                bVar.write("\n".getBytes("UTF-8"));
                bVar.flush();
            } catch (Throwable th4) {
                try {
                    a(th4, bVar);
                    bVar.close();
                } catch (Throwable th42) {
                    com.uc.crashsdk.a.a.a(th42, false);
                }
            }
            a(bVar);
            if (z3) {
                b(bVar);
                try {
                    bVar.flush();
                } catch (Throwable th422) {
                    com.uc.crashsdk.a.a.a(th422, false);
                }
            }
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    a.a(bVar, "UTF-8", (ArrayList) arrayList);
                }
            }
            a.a(bVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", (ArrayList) arrayList2);
            a.b(bVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
            if (str2 != null) {
                try {
                    bVar.flush();
                } catch (Throwable th4222) {
                    a(th4222, bVar);
                }
                try {
                    bVar.write("threads dump:\n".getBytes("UTF-8"));
                } catch (Throwable th42222) {
                    a(th42222, bVar);
                }
                g = false;
                u = str2;
                try {
                    a((b) bVar, str2);
                } catch (Throwable th422222) {
                    a(th422222, bVar);
                }
                u = null;
                g = true;
            }
            if (z4) {
                try {
                    bVar.flush();
                } catch (Throwable th4222222) {
                    a(th4222222, bVar);
                }
                try {
                    bVar.write("all threads dump:\n".getBytes("UTF-8"));
                } catch (Throwable th42222222) {
                    a(th42222222, bVar);
                }
                t = true;
                try {
                    a((b) bVar, ShareConstants.IGNORE_ALL_SYMBOLIC);
                } catch (Throwable th422222222) {
                    a(th422222222, bVar);
                }
                t = false;
            }
            if (z2) {
                bVar.a();
                a((b) bVar);
            }
            try {
                bVar.close();
            } catch (Throwable th4222222222) {
                com.uc.crashsdk.a.a.a(th4222222222, false);
            }
            try {
                synchronized (q) {
                    r++;
                    if (s != null) {
                        q.add(s);
                        if (q.size() > 3) {
                            q.remove(0);
                        }
                        a("loge", s.toString(), 0);
                        s = null;
                    }
                    a("logct", null, r);
                }
                return str3;
            } catch (Throwable th42222222222) {
                com.uc.crashsdk.a.a.a(th42222222222, false);
                return str3;
            }
        }
        if (bVar == null) {
            return null;
        }
        if (z) {
            a(bVar, str3, str);
        }
        bVar.write(stringBuffer.toString().getBytes());
        bVar.write("\n".getBytes("UTF-8"));
        bVar.flush();
        a(bVar);
        if (z3) {
            b(bVar);
            bVar.flush();
        }
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                a.a(bVar, "UTF-8", (ArrayList) arrayList);
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            a.a(bVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", (ArrayList) arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            a.b(bVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str2 != null) {
            bVar.flush();
            bVar.write("threads dump:\n".getBytes("UTF-8"));
            g = false;
            u = str2;
            a((b) bVar, str2);
            u = null;
            g = true;
        }
        if (z4) {
            bVar.flush();
            bVar.write("all threads dump:\n".getBytes("UTF-8"));
            t = true;
            a((b) bVar, ShareConstants.IGNORE_ALL_SYMBOLIC);
            t = false;
        }
        if (z2) {
            bVar.a();
            a((b) bVar);
        }
        bVar.close();
        synchronized (q) {
            r++;
            if (s != null) {
                q.add(s);
                if (q.size() > 3) {
                    q.remove(0);
                }
                a("loge", s.toString(), 0);
                s = null;
            }
            a("logct", null, r);
        }
        return str3;
    }

    public static String f() {
        String str = null;
        if (v != null && v.length() > 0) {
            return v;
        }
        synchronized (x) {
            if (new File(b.f()).exists()) {
                String a = com.uc.crashsdk.a.d.a(b.f());
                if (a != null) {
                    a = a.trim();
                    if (a.length() != 0) {
                        if (!a.toLowerCase().startsWith("http")) {
                            return null;
                        }
                    }
                }
                str = a;
            }
            if (str == null) {
                str = w;
            }
            v = str;
            return str;
        }
    }

    public static void a(String str, boolean z) {
        if (z) {
            w = str;
            return;
        }
        v = str;
        synchronized (x) {
            com.uc.crashsdk.a.d.a(b.f(), str + "\n");
        }
    }

    public static String g() {
        return a(new Date());
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds())});
    }

    public static void h() {
        c = System.currentTimeMillis();
    }

    private static void m(String str) {
        if (p.p()) {
            try {
                B();
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
            if (str != null && !"".equals(str)) {
                try {
                    File file = new File(p.P());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    com.uc.crashsdk.a.c.b("copy log to: " + file);
                    com.uc.crashsdk.a.b.a(new File(str), file, new byte[1048576]);
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.a.a(th2, false);
                }
            }
        }
    }

    private static void b(String str, String str2) {
        try {
            d.a(str, str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
    }

    public static void i() {
        Throwable th;
        if (h.a(a)) {
            String replaceAll;
            try {
                File file = new File(p.N() + "unique");
                if (file.exists()) {
                    String a = com.uc.crashsdk.a.b.a(file, 48, true);
                    if (a != null) {
                        try {
                            replaceAll = a.length() != 36 ? null : a.replaceAll("[^0-9a-zA-Z-]", "-");
                        } catch (Throwable e) {
                            com.uc.crashsdk.a.a.a(e, false);
                        } catch (Throwable e2) {
                            Throwable th2 = e2;
                            replaceAll = a;
                            th = th2;
                            com.uc.crashsdk.a.a.a(th, false);
                            a = replaceAll;
                        }
                    }
                    replaceAll = a;
                } else {
                    replaceAll = null;
                }
                try {
                    if (h.a(replaceAll)) {
                        replaceAll = UUID.randomUUID().toString();
                        if (!h.a(replaceAll)) {
                            com.uc.crashsdk.a.b.a(file, replaceAll.getBytes());
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.uc.crashsdk.a.a.a(th, false);
                    a = replaceAll;
                }
            } catch (Throwable e22) {
                th = e22;
                replaceAll = null;
                com.uc.crashsdk.a.a.a(th, false);
                a = replaceAll;
            }
            a = replaceAll;
        }
    }

    public static String j() {
        return a;
    }

    public static void k() {
        y = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new f());
    }

    public static void l() {
        Thread.setDefaultUncaughtExceptionHandler(y);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    public final void a(Thread thread, Throwable th, boolean z) {
        Throwable e;
        boolean z2;
        boolean z3;
        int myPid;
        boolean z4;
        Throwable th2;
        boolean z5 = true;
        if (!d || Process.myPid() <= 0) {
            d = true;
            z = th;
            if (com.uc.crashsdk.a.f.d()) {
                com.uc.crashsdk.a.c.c("DEBUG", "begin to generate java report");
                try {
                    for (FileInputStream close : this.f) {
                        close.close();
                    }
                } catch (Throwable e2) {
                    com.uc.crashsdk.a.a.a(e2, false);
                } catch (Throwable e22) {
                    com.uc.crashsdk.a.a.a(e22, false);
                }
                try {
                    if (b.o()) {
                        k.a(3);
                    } else {
                        k.a(4);
                    }
                } catch (Throwable e222) {
                    com.uc.crashsdk.a.a.a(e222, false);
                }
                new File(b.b()).createNewFile();
                try {
                    if (p.s()) {
                        com.uc.crashsdk.a.c.c("DEBUG", "omit java crash");
                        if (z) {
                            try {
                                if (p.q()) {
                                    try {
                                        a(false);
                                        z2 = true;
                                        z3 = z2;
                                    } catch (Throwable th3) {
                                        e222 = th3;
                                        z3 = true;
                                        com.uc.crashsdk.a.a.a(e222, false);
                                        z2 = p.i();
                                        if (com.uc.crashsdk.a.f.d()) {
                                            z5 = z2;
                                        }
                                        com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                                        y.uncaughtException(thread, th);
                                        if (b.o()) {
                                            r.a(e.a());
                                        }
                                        if (!z3) {
                                            b(false);
                                        }
                                        if (Process.myPid() <= 0) {
                                            myPid = Process.myPid();
                                            Process.killProcess(myPid);
                                        }
                                        return;
                                    }
                                    z2 = p.i();
                                    if (com.uc.crashsdk.a.f.d()) {
                                        z5 = z2;
                                    }
                                    com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                                    if (z5 && y != null) {
                                        y.uncaughtException(thread, th);
                                    }
                                    if (b.o()) {
                                        r.a(e.a());
                                    }
                                    if (z3) {
                                        b(false);
                                    }
                                    if (Process.myPid() <= 0) {
                                        myPid = Process.myPid();
                                    } else {
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                e222 = th4;
                                z3 = false;
                                com.uc.crashsdk.a.a.a(e222, false);
                                z2 = p.i();
                                if (com.uc.crashsdk.a.f.d()) {
                                    z5 = z2;
                                }
                                com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                                y.uncaughtException(thread, th);
                                if (b.o()) {
                                    r.a(e.a());
                                }
                                if (z3) {
                                    b(false);
                                }
                                if (Process.myPid() <= 0) {
                                    myPid = Process.myPid();
                                    Process.killProcess(myPid);
                                }
                                return;
                            }
                        }
                        z2 = false;
                        z3 = z2;
                        try {
                            z2 = p.i();
                            if (com.uc.crashsdk.a.f.d()) {
                                z5 = z2;
                            }
                            com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                            y.uncaughtException(thread, th);
                            if (b.o()) {
                                r.a(e.a());
                            }
                        } catch (Throwable e2222) {
                            com.uc.crashsdk.a.a.a(e2222, false);
                        }
                        if (z3) {
                            b(false);
                        }
                        if (Process.myPid() <= 0) {
                            myPid = Process.myPid();
                        } else {
                            return;
                        }
                    }
                    z2 = th instanceof OutOfMemoryError;
                    String a = a(th, z2);
                    com.uc.crashsdk.a.c.c("DEBUG", "generate java report finished");
                    if (z2 && p.j()) {
                        String name = new File(a).getName();
                        File file = new File(p.P());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        name = String.format("%s%s.hprof", new Object[]{a, name});
                        com.uc.crashsdk.a.c.c("DEBUG", "begin dump hprof: " + name);
                        long currentTimeMillis = System.currentTimeMillis();
                        Debug.dumpHprofData(name);
                        com.uc.crashsdk.a.c.c("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    if (z) {
                        try {
                            if (p.q()) {
                                try {
                                    a(false);
                                    z2 = true;
                                    z3 = z2;
                                } catch (Throwable th5) {
                                    e2222 = th5;
                                    z3 = true;
                                    com.uc.crashsdk.a.a.a(e2222, false);
                                    z2 = p.i();
                                    if (com.uc.crashsdk.a.f.d()) {
                                        z5 = z2;
                                    }
                                    com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                                    y.uncaughtException(thread, th);
                                    if (b.o()) {
                                        r.a(e.a());
                                    }
                                    if (!z3) {
                                        b(false);
                                    }
                                    if (Process.myPid() <= 0) {
                                        myPid = Process.myPid();
                                        Process.killProcess(myPid);
                                    }
                                    return;
                                }
                                z2 = p.i();
                                if (com.uc.crashsdk.a.f.d()) {
                                    z5 = z2;
                                }
                                com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                                if (z5 && y != null) {
                                    y.uncaughtException(thread, th);
                                }
                                if (b.o()) {
                                    r.a(e.a());
                                }
                                if (z3) {
                                    b(false);
                                }
                                if (Process.myPid() <= 0) {
                                    myPid = Process.myPid();
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable th6) {
                            e2222 = th6;
                            z3 = false;
                            com.uc.crashsdk.a.a.a(e2222, false);
                            z2 = p.i();
                            if (com.uc.crashsdk.a.f.d()) {
                                z5 = z2;
                            }
                            com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                            y.uncaughtException(thread, th);
                            if (b.o()) {
                                r.a(e.a());
                            }
                            if (z3) {
                                b(false);
                            }
                            if (Process.myPid() <= 0) {
                                myPid = Process.myPid();
                                Process.killProcess(myPid);
                            }
                            return;
                        }
                    }
                    z2 = false;
                    z3 = z2;
                    try {
                        z2 = p.i();
                        if (com.uc.crashsdk.a.f.d()) {
                            z5 = z2;
                        }
                        com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                        y.uncaughtException(thread, th);
                        if (b.o()) {
                            r.a(e.a());
                        }
                    } catch (Throwable e22222) {
                        com.uc.crashsdk.a.a.a(e22222, false);
                    }
                    if (z3) {
                        b(false);
                    }
                    if (Process.myPid() <= 0) {
                        myPid = Process.myPid();
                    } else {
                        return;
                    }
                } catch (Throwable e222222) {
                    try {
                        com.uc.crashsdk.a.a.a(e222222, false);
                        if (z) {
                            if (p.q()) {
                                a(false);
                                z2 = true;
                                z3 = z2;
                                z2 = p.i();
                                if (com.uc.crashsdk.a.f.d()) {
                                    z5 = z2;
                                }
                                com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                                y.uncaughtException(thread, th);
                                if (b.o()) {
                                    r.a(e.a());
                                }
                                if (!z3) {
                                    b(false);
                                }
                                if (Process.myPid() > 0) {
                                    myPid = Process.myPid();
                                } else {
                                    return;
                                }
                            }
                        }
                        z2 = false;
                        z3 = z2;
                    } catch (Throwable e2222222) {
                        com.uc.crashsdk.a.a.a(e2222222, false);
                    }
                    z2 = p.i();
                    if (com.uc.crashsdk.a.f.d()) {
                        z5 = z2;
                    }
                    com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                    y.uncaughtException(thread, th);
                    if (b.o()) {
                        r.a(e.a());
                    }
                    if (z3) {
                        b(false);
                    }
                    if (Process.myPid() > 0) {
                        myPid = Process.myPid();
                    } else {
                        return;
                    }
                }
            }
            com.uc.crashsdk.a.c.b("DEBUG", com.uc.crashsdk.a.f.b());
            if (z) {
                try {
                    if (p.q()) {
                        try {
                            a(false);
                            z2 = true;
                            z3 = z2;
                        } catch (Throwable th7) {
                            e2222222 = th7;
                            z3 = true;
                            com.uc.crashsdk.a.a.a(e2222222, false);
                            z2 = p.i();
                            if (com.uc.crashsdk.a.f.d()) {
                                z5 = z2;
                            }
                            com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                            y.uncaughtException(thread, th);
                            if (b.o()) {
                                r.a(e.a());
                            }
                            if (!z3) {
                                b(false);
                            }
                            if (Process.myPid() <= 0) {
                                myPid = Process.myPid();
                                Process.killProcess(myPid);
                            }
                            return;
                        }
                        z2 = p.i();
                        if (com.uc.crashsdk.a.f.d()) {
                            z5 = z2;
                        }
                        com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                        if (z5 && y != null) {
                            y.uncaughtException(thread, th);
                        }
                        if (b.o()) {
                            r.a(e.a());
                        }
                        if (z3) {
                            b(false);
                        }
                        if (Process.myPid() <= 0) {
                            myPid = Process.myPid();
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th8) {
                    e2222222 = th8;
                    z3 = false;
                    com.uc.crashsdk.a.a.a(e2222222, false);
                    z2 = p.i();
                    if (com.uc.crashsdk.a.f.d()) {
                        z5 = z2;
                    }
                    com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                    y.uncaughtException(thread, th);
                    if (b.o()) {
                        r.a(e.a());
                    }
                    if (z3) {
                        b(false);
                    }
                    if (Process.myPid() <= 0) {
                        myPid = Process.myPid();
                        Process.killProcess(myPid);
                    }
                    return;
                }
            }
            z2 = false;
            z3 = z2;
            try {
                z2 = p.i();
                if (com.uc.crashsdk.a.f.d()) {
                    z5 = z2;
                }
                com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                y.uncaughtException(thread, th);
                if (b.o()) {
                    r.a(e.a());
                }
            } catch (Throwable e22222222) {
                com.uc.crashsdk.a.a.a(e22222222, false);
            }
            if (z3) {
                b(false);
            }
            if (Process.myPid() <= 0) {
                myPid = Process.myPid();
            } else {
                return;
            }
            Process.killProcess(myPid);
        }
        Process.killProcess(Process.myPid());
        if (z) {
            try {
                if (p.q()) {
                    try {
                        a(false);
                        z2 = true;
                        z3 = z2;
                    } catch (Throwable th9) {
                        e22222222 = th9;
                        z3 = true;
                        com.uc.crashsdk.a.a.a(e22222222, false);
                        z2 = p.i();
                        if (com.uc.crashsdk.a.f.d()) {
                            z5 = z2;
                        }
                        com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                        y.uncaughtException(thread, th);
                        if (b.o()) {
                            r.a(e.a());
                        }
                        if (!z3) {
                            b(false);
                        }
                        if (Process.myPid() <= 0) {
                            myPid = Process.myPid();
                            Process.killProcess(myPid);
                        }
                    }
                    z2 = p.i();
                    if (com.uc.crashsdk.a.f.d()) {
                        z5 = z2;
                    }
                    com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                    if (z5 && y != null) {
                        y.uncaughtException(thread, th);
                    }
                    if (b.o()) {
                        r.a(e.a());
                    }
                    if (z3) {
                        b(false);
                    }
                    if (Process.myPid() <= 0) {
                        myPid = Process.myPid();
                        Process.killProcess(myPid);
                    }
                }
            } catch (Throwable th10) {
                e22222222 = th10;
                z3 = false;
                com.uc.crashsdk.a.a.a(e22222222, false);
                z2 = p.i();
                if (com.uc.crashsdk.a.f.d()) {
                    z5 = z2;
                }
                com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
                y.uncaughtException(thread, th);
                if (b.o()) {
                    r.a(e.a());
                }
                if (z3) {
                    b(false);
                }
                if (Process.myPid() <= 0) {
                    myPid = Process.myPid();
                    Process.killProcess(myPid);
                }
            }
        }
        z2 = false;
        z3 = z2;
        try {
            z2 = p.i();
            if (com.uc.crashsdk.a.f.d()) {
                z5 = z2;
            }
            com.uc.crashsdk.a.c.b("Call java default handler: " + z5);
            y.uncaughtException(thread, th);
            if (b.o()) {
                r.a(e.a());
            }
        } catch (Throwable e222222222) {
            com.uc.crashsdk.a.a.a(e222222222, false);
        }
        if (z3) {
            b(false);
        }
        if (Process.myPid() <= 0) {
            myPid = Process.myPid();
            Process.killProcess(myPid);
        }
    }

    public static Throwable m() {
        return z;
    }

    public static void n() {
        long o = (long) p.o();
        if (o >= 0 && b.q()) {
            int i = CrashApi.getInstance().getLastExitType() == 5 ? 1 : 0;
            i.a(0, new d(1));
            if (i != 0) {
                B = new d(2);
                i.a(0, B, o);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean o() {
        /*
        r1 = C;
        monitor-enter(r1);
        r0 = B;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0016;
    L_0x0007:
        r0 = A;	 Catch:{ all -> 0x0019 }
        if (r0 != 0) goto L_0x0016;
    L_0x000b:
        r0 = B;	 Catch:{ all -> 0x0019 }
        com.uc.crashsdk.a.i.a(r0);	 Catch:{ all -> 0x0019 }
        r0 = 0;
        B = r0;	 Catch:{ all -> 0x0019 }
        r0 = 1;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
    L_0x0015:
        return r0;
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r0 = 0;
        goto L_0x0015;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.o():boolean");
    }

    public static boolean c(String str) {
        boolean z;
        String name;
        boolean z2 = true;
        File file = new File(str);
        try {
            if (file.exists()) {
                System.load(file.getAbsolutePath());
                z = true;
                if (!z) {
                    try {
                        name = file.getName();
                        if (h.b(name) && name.startsWith(ShareConstants.SO_PATH) && name.endsWith(".so")) {
                            System.loadLibrary(name.substring(3, name.length() - 3));
                            return z2;
                        }
                    } catch (Throwable e) {
                        com.uc.crashsdk.a.a.a(e, false);
                        return z;
                    }
                }
                z2 = z;
                return z2;
            }
        } catch (Throwable e2) {
            com.uc.crashsdk.a.a.a(e2, false);
        }
        z = false;
        if (z) {
            name = file.getName();
            System.loadLibrary(name.substring(3, name.length() - 3));
            return z2;
        }
        z2 = z;
        return z2;
    }

    private static void B() {
        String P = p.P();
        File file = new File(P);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 150) {
                boolean z;
                Arrays.sort(listFiles, new c());
                boolean length = listFiles.length - 150;
                if (length >= false) {
                    z = false;
                } else {
                    z = length;
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = false;
                int i = 0;
                int i2 = 0;
                while (z2 < listFiles.length) {
                    File file2 = listFiles[z2];
                    boolean z3 = z2 < z;
                    if (!z3 && currentTimeMillis - file2.lastModified() >= 432000000) {
                        z3 = true;
                    }
                    if (z3) {
                        int i3;
                        try {
                            file2.delete();
                            i2++;
                            i3 = 0;
                        } catch (Throwable e) {
                            i3 = i + 1;
                            com.uc.crashsdk.a.a.a(e, false);
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.a.a(th, false);
                            return;
                        }
                        if (i3 < 3) {
                            z2++;
                            i = i3;
                        }
                    }
                }
                com.uc.crashsdk.a.c.a("Removed " + i2 + " logs in " + P);
            }
        }
    }

    public static void p() {
        if (p.p()) {
            i.a(0, new d(3), 10000);
        }
    }

    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            int i2;
            if (str == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                stringBuilder.append("  at ");
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
                if (i2 == 0 && stackTraceElement.getMethodName().indexOf(str) >= 0) {
                    stringBuilder.delete(0, stringBuilder.length());
                    i2 = 1;
                    i3 = 0;
                }
            }
            i = i3;
        }
        if (i == 0) {
            stringBuilder.append("  (no java stack)\n");
        }
        return stringBuilder;
    }

    public static StringBuilder d(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }
}
