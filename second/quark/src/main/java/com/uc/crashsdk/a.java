package com.uc.crashsdk;

import android.util.SparseArray;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.a.i;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
public class a {
    private static SparseArray<e> A = new SparseArray();
    private static List<Integer> B = new ArrayList();
    private static HashMap<String, a> C = new HashMap();
    private static List<String> D = new ArrayList();
    private static int E = 0;
    private static int F = 0;
    private static Runnable G = new d(1);
    private static boolean H = false;
    private static boolean I = false;
    public static String a = "";
    public static String b = "";
    public static int c = 10;
    public static int d = 8;
    public static int e = 6;
    public static int f = 2;
    public static int g = 6;
    public static int h = 8;
    public static int i = 2048;
    static final /* synthetic */ boolean j = (!a.class.desiredAssertionStatus());
    private static Map<String, String> k = new HashMap();
    private static List<String> l = new ArrayList();
    private static String m = "";
    private static String n = null;
    private static HashMap<String, c> o = new HashMap();
    private static List<String> p = new ArrayList();
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;
    private static HashMap<String, b> t = new HashMap();
    private static List<String> u = new ArrayList();
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static int y = 0;
    private static int z = 0;

    /* compiled from: ProGuard */
    final class a {
        int a;
        int b;
        List<String> c = new ArrayList();

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* compiled from: ProGuard */
    final class b {
        public int a;
        public Callable<String> b;
        public long c;

        public b(int i, Callable<String> callable, long j) {
            this.a = i;
            this.b = callable;
            this.c = j;
        }
    }

    /* compiled from: ProGuard */
    final class c {
        public int a;
        public String b;
        public boolean c;
        public boolean d;
        public boolean e;

        public c(int i, String str, boolean z, boolean z2, boolean z3) {
            this.a = i;
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }
    }

    /* compiled from: ProGuard */
    final class d implements Runnable {
        static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
        private int b = 0;

        d(int i) {
            this.b = i;
        }

        public final void run() {
            switch (this.b) {
                case 1:
                    a.i();
                    return;
                case 2:
                    a.j();
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
        WeakReference<Thread> a;
        public String b;

        public e(Thread thread, String str) {
            this.a = new WeakReference(thread);
            this.b = str;
        }
    }

    static /* synthetic */ void i() {
        com.uc.crashsdk.a.c.b("Begin update unexp info ...");
        long currentTimeMillis = System.currentTimeMillis();
        if (b.d) {
            JNIBridge.nativeUpdateUnexpInfo(p.C());
        }
        com.uc.crashsdk.a.c.b("Update unexp info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        a(false);
    }

    static /* synthetic */ void j() {
        String format = String.format("%s/%s/%s", new Object[]{p.K(), p.L(), p.M()});
        m = g();
        if (b.d) {
            JNIBridge.nativeSyncStatus("ver", m, 0);
        }
        com.uc.crashsdk.a.d.a(b.g(), format);
        if (m == null || !m.equals(format)) {
            boolean z = true;
        } else {
            int i = 0;
        }
        if (i != 0 && p.t()) {
            com.uc.crashsdk.a.c.b(String.format("Is new version ('%s' -> '%s'), deleting old stats data!", new Object[]{m, format}));
            b.a(true);
        }
    }

    public static String a() {
        if (n != null) {
            return n;
        }
        try {
            String str = e.a().getPackageManager().getPackageInfo(a, 0).versionName;
            n = str;
            return str;
        } catch (Throwable e) {
            com.uc.crashsdk.a.a.a(e, true);
            return "";
        }
    }

    public static void a(String str, String str2) {
        synchronized (k) {
            if (!k.containsKey(str)) {
                l.add(str);
            }
            k.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
        }
    }

    public static void b() {
        if (j || b.d) {
            synchronized (k) {
                for (String str : l) {
                    JNIBridge.nativeAddHeaderInfo(str, (String) k.get(str));
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (k) {
            for (String str2 : l) {
                try {
                    outputStream.write(str2.getBytes(str));
                    outputStream.write(": ".getBytes(str));
                    String str22 = (String) k.get(str22);
                    if (str22 != null) {
                        outputStream.write(str22.getBytes(str));
                    }
                    outputStream.write("\n".getBytes(str));
                } catch (Throwable th) {
                    f.a(th, outputStream);
                }
            }
        }
    }

    public static byte[] c() {
        return new byte[]{(byte) 24, (byte) 99, (byte) 121, (byte) 60};
    }

    public static int a(String str, String str2, boolean z, boolean z2, int i, boolean z3) {
        Object obj = null;
        if (str == null || str2 == null) {
            return 0;
        }
        int i2;
        synchronized (o) {
            int addType;
            if (o.containsKey(str)) {
                i2 = ((c) o.get(str)).a;
                addType = LogType.addType(i2, i);
            } else {
                i2 = 0;
                addType = i;
            }
            if (LogType.isForJava(addType) && !LogType.isForJava(i2)) {
                if (q >= c) {
                    addType = LogType.removeType(addType, 16);
                } else {
                    q++;
                }
            }
            if (LogType.isForNative(addType) && !LogType.isForNative(i2)) {
                if (r >= c) {
                    addType = LogType.removeType(addType, 1);
                } else {
                    r++;
                }
            }
            if (LogType.isForUnexp(addType) && !LogType.isForUnexp(i2)) {
                if (s >= c) {
                    addType = LogType.removeType(addType, LogType.UNEXP);
                } else {
                    s++;
                }
            }
            if ((addType & 273) != 0) {
                if (i2 == 0) {
                    p.add(str);
                }
                int i3 = 1;
            }
            if (obj != null) {
                if (b.d && (LogType.isForNative(i) || LogType.isForUnexp(i))) {
                    i2 = JNIBridge.nativeAddDumpFile(str, str2, z, z2, LogType.isForNative(i), LogType.isForUnexp(i), z3);
                    if (!LogType.isForNative(i2)) {
                        addType = LogType.removeType(addType, 1);
                    }
                    if (!LogType.isForUnexp(i2)) {
                        i3 = LogType.removeType(addType, LogType.UNEXP);
                        o.put(str, new c(i3, str2, z, z2, z3));
                        i2 = i3;
                    }
                }
                i3 = addType;
                o.put(str, new c(i3, str2, z, z2, z3));
                i2 = i3;
            } else {
                i2 = addType;
            }
        }
        return i2;
    }

    public static void d() {
        if (j || b.d) {
            synchronized (o) {
                for (String str : p) {
                    c cVar = (c) o.get(str);
                    int i = cVar.a;
                    if (LogType.isForNative(i) || LogType.isForUnexp(i)) {
                        JNIBridge.nativeAddDumpFile(str, cVar.b, cVar.c, cVar.d, LogType.isForNative(i), LogType.isForUnexp(i), cVar.e);
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        Object obj;
        if (arrayList == null) {
            obj = 1;
        } else {
            obj = null;
        }
        synchronized (o) {
            for (String str2 : p) {
                try {
                    c cVar = (c) o.get(str2);
                    if (arrayList == null) {
                        if (!LogType.isForJava(cVar.a)) {
                        }
                    } else if (!a((ArrayList) arrayList, str2)) {
                    }
                    if (cVar.d) {
                        outputStream.write((str2 + "\n").getBytes(str));
                    }
                    if (cVar.c) {
                        f.a(outputStream, cVar.b);
                    } else {
                        f.b(outputStream, cVar.b);
                    }
                    if (cVar.e && r2 != null) {
                        File file = new File(cVar.b);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                } catch (Throwable th) {
                    f.a(th, outputStream);
                }
            }
        }
    }

    private static boolean a(ArrayList<String> arrayList, String str) {
        if (h.a(str)) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r11, int r12, java.util.concurrent.Callable<java.lang.String> r13, long r14) {
        /*
        r8 = 0;
        r1 = 0;
        r2 = 1;
        if (r11 != 0) goto L_0x0008;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        return r0;
    L_0x0008:
        r7 = t;
        monitor-enter(r7);
        r0 = t;	 Catch:{ all -> 0x0025 }
        r0 = r0.containsKey(r11);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x015f;
    L_0x0013:
        r0 = t;	 Catch:{ all -> 0x0025 }
        r0 = r0.get(r11);	 Catch:{ all -> 0x0025 }
        r0 = (com.uc.crashsdk.a.b) r0;	 Catch:{ all -> 0x0025 }
        r0 = r0.a;	 Catch:{ all -> 0x0025 }
        r4 = com.uc.crashsdk.export.LogType.addType(r0, r12);	 Catch:{ all -> 0x0025 }
        if (r0 != r4) goto L_0x0028;
    L_0x0023:
        monitor-exit(r7);	 Catch:{ all -> 0x0025 }
        goto L_0x0007;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r6 = r0;
    L_0x0029:
        r0 = com.uc.crashsdk.export.LogType.isForJava(r4);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x0049;
    L_0x002f:
        r0 = com.uc.crashsdk.export.LogType.isForJava(r6);	 Catch:{ all -> 0x0025 }
        if (r0 != 0) goto L_0x0049;
    L_0x0035:
        r0 = d;	 Catch:{ all -> 0x0025 }
        r3 = f;	 Catch:{ all -> 0x0025 }
        r0 = r0 - r3;
        r3 = v;	 Catch:{ all -> 0x0025 }
        r5 = d;	 Catch:{ all -> 0x0025 }
        if (r3 < r5) goto L_0x00e5;
    L_0x0040:
        r0 = r2;
    L_0x0041:
        if (r0 == 0) goto L_0x0049;
    L_0x0043:
        r0 = 16;
        r4 = com.uc.crashsdk.export.LogType.removeType(r4, r0);	 Catch:{ all -> 0x0025 }
    L_0x0049:
        r0 = com.uc.crashsdk.export.LogType.isForNative(r4);	 Catch:{ all -> 0x0025 }
        if (r0 == 0) goto L_0x015a;
    L_0x004f:
        r0 = com.uc.crashsdk.export.LogType.isForNative(r6);	 Catch:{ all -> 0x0025 }
        if (r0 != 0) goto L_0x015a;
    L_0x0055:
        r0 = e;	 Catch:{ all -> 0x0025 }
        r3 = f;	 Catch:{ all -> 0x0025 }
        r0 = r0 - r3;
        r3 = w;	 Catch:{ all -> 0x0025 }
        r5 = e;	 Catch:{ all -> 0x0025 }
        if (r3 < r5) goto L_0x0109;
    L_0x0060:
        r5 = r2;
        r0 = r1;
        r3 = r1;
    L_0x0063:
        if (r5 == 0) goto L_0x0154;
    L_0x0065:
        r5 = 1;
        r4 = com.uc.crashsdk.export.LogType.removeType(r4, r5);	 Catch:{ all -> 0x0025 }
        r5 = r3;
        r10 = r0;
        r0 = r4;
        r4 = r10;
    L_0x006e:
        r3 = com.uc.crashsdk.export.LogType.isForUnexp(r0);	 Catch:{ all -> 0x0025 }
        if (r3 == 0) goto L_0x0151;
    L_0x0074:
        r3 = com.uc.crashsdk.export.LogType.isForUnexp(r6);	 Catch:{ all -> 0x0025 }
        if (r3 != 0) goto L_0x0151;
    L_0x007a:
        r3 = x;	 Catch:{ all -> 0x0025 }
        r8 = g;	 Catch:{ all -> 0x0025 }
        if (r3 < r8) goto L_0x013e;
    L_0x0080:
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = com.uc.crashsdk.export.LogType.removeType(r0, r3);	 Catch:{ all -> 0x0025 }
        r3 = r1;
    L_0x0087:
        r8 = r0 & 273;
        if (r8 != 0) goto L_0x0147;
    L_0x008b:
        if (r1 == 0) goto L_0x00e2;
    L_0x008d:
        r1 = com.uc.crashsdk.b.d;	 Catch:{ all -> 0x0025 }
        if (r1 == 0) goto L_0x00d8;
    L_0x0091:
        r1 = com.uc.crashsdk.export.LogType.isForNative(r12);	 Catch:{ all -> 0x0025 }
        if (r1 != 0) goto L_0x009d;
    L_0x0097:
        r1 = com.uc.crashsdk.export.LogType.isForUnexp(r12);	 Catch:{ all -> 0x0025 }
        if (r1 == 0) goto L_0x00d8;
    L_0x009d:
        r1 = com.uc.crashsdk.export.LogType.isForNative(r12);	 Catch:{ all -> 0x0025 }
        r2 = com.uc.crashsdk.export.LogType.isForUnexp(r12);	 Catch:{ all -> 0x0025 }
        r1 = com.uc.crashsdk.JNIBridge.nativeAddCallbackInfo(r11, r1, r2, r14);	 Catch:{ all -> 0x0025 }
        r2 = com.uc.crashsdk.export.LogType.isForNative(r1);	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x00c4;
    L_0x00af:
        r2 = 1;
        r0 = com.uc.crashsdk.export.LogType.removeType(r0, r2);	 Catch:{ all -> 0x0025 }
        if (r5 == 0) goto L_0x00bc;
    L_0x00b6:
        r2 = w;	 Catch:{ all -> 0x0025 }
        r2 = r2 + -1;
        w = r2;	 Catch:{ all -> 0x0025 }
    L_0x00bc:
        if (r4 == 0) goto L_0x00c4;
    L_0x00be:
        r2 = z;	 Catch:{ all -> 0x0025 }
        r2 = r2 + -1;
        z = r2;	 Catch:{ all -> 0x0025 }
    L_0x00c4:
        r1 = com.uc.crashsdk.export.LogType.isForUnexp(r1);	 Catch:{ all -> 0x0025 }
        if (r1 != 0) goto L_0x00d8;
    L_0x00ca:
        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = com.uc.crashsdk.export.LogType.removeType(r0, r1);	 Catch:{ all -> 0x0025 }
        if (r3 == 0) goto L_0x00d8;
    L_0x00d2:
        r1 = x;	 Catch:{ all -> 0x0025 }
        r1 = r1 + -1;
        x = r1;	 Catch:{ all -> 0x0025 }
    L_0x00d8:
        r1 = t;	 Catch:{ all -> 0x0025 }
        r2 = new com.uc.crashsdk.a$b;	 Catch:{ all -> 0x0025 }
        r2.<init>(r0, r13, r14);	 Catch:{ all -> 0x0025 }
        r1.put(r11, r2);	 Catch:{ all -> 0x0025 }
    L_0x00e2:
        monitor-exit(r7);	 Catch:{ all -> 0x0025 }
        goto L_0x0007;
    L_0x00e5:
        r3 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1));
        if (r3 == 0) goto L_0x00ff;
    L_0x00e9:
        r3 = y;	 Catch:{ all -> 0x0025 }
        if (r3 < r0) goto L_0x00f0;
    L_0x00ed:
        r0 = r2;
        goto L_0x0041;
    L_0x00f0:
        r0 = y;	 Catch:{ all -> 0x0025 }
        r0 = r0 + 1;
        y = r0;	 Catch:{ all -> 0x0025 }
    L_0x00f6:
        r0 = v;	 Catch:{ all -> 0x0025 }
        r0 = r0 + 1;
        v = r0;	 Catch:{ all -> 0x0025 }
        r0 = r1;
        goto L_0x0041;
    L_0x00ff:
        r3 = v;	 Catch:{ all -> 0x0025 }
        r5 = y;	 Catch:{ all -> 0x0025 }
        r3 = r3 - r5;
        if (r3 < r0) goto L_0x00f6;
    L_0x0106:
        r0 = r2;
        goto L_0x0041;
    L_0x0109:
        r3 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1));
        if (r3 == 0) goto L_0x0127;
    L_0x010d:
        r3 = z;	 Catch:{ all -> 0x0025 }
        if (r3 < r0) goto L_0x0116;
    L_0x0111:
        r5 = r2;
        r0 = r1;
        r3 = r1;
        goto L_0x0063;
    L_0x0116:
        r0 = z;	 Catch:{ all -> 0x0025 }
        r0 = r0 + 1;
        z = r0;	 Catch:{ all -> 0x0025 }
        r0 = w;	 Catch:{ all -> 0x0025 }
        r0 = r0 + 1;
        w = r0;	 Catch:{ all -> 0x0025 }
        r5 = r1;
        r0 = r2;
        r3 = r2;
        goto L_0x0063;
    L_0x0127:
        r3 = w;	 Catch:{ all -> 0x0025 }
        r5 = z;	 Catch:{ all -> 0x0025 }
        r3 = r3 - r5;
        if (r3 < r0) goto L_0x0133;
    L_0x012e:
        r5 = r2;
        r0 = r1;
        r3 = r1;
        goto L_0x0063;
    L_0x0133:
        r0 = w;	 Catch:{ all -> 0x0025 }
        r0 = r0 + 1;
        w = r0;	 Catch:{ all -> 0x0025 }
        r5 = r1;
        r0 = r1;
        r3 = r2;
        goto L_0x0063;
    L_0x013e:
        r3 = x;	 Catch:{ all -> 0x0025 }
        r3 = r3 + 1;
        x = r3;	 Catch:{ all -> 0x0025 }
        r3 = r2;
        goto L_0x0087;
    L_0x0147:
        if (r6 != 0) goto L_0x014e;
    L_0x0149:
        r1 = u;	 Catch:{ all -> 0x0025 }
        r1.add(r11);	 Catch:{ all -> 0x0025 }
    L_0x014e:
        r1 = r2;
        goto L_0x008b;
    L_0x0151:
        r3 = r1;
        goto L_0x0087;
    L_0x0154:
        r5 = r3;
        r10 = r0;
        r0 = r4;
        r4 = r10;
        goto L_0x006e;
    L_0x015a:
        r5 = r1;
        r0 = r4;
        r4 = r1;
        goto L_0x006e;
    L_0x015f:
        r6 = r1;
        r4 = r12;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long):int");
    }

    public static void e() {
        if (j || b.d) {
            synchronized (t) {
                for (String str : u) {
                    b bVar = (b) t.get(str);
                    int i = bVar.a;
                    if (LogType.isForNative(i) || LogType.isForUnexp(i)) {
                        JNIBridge.nativeAddCallbackInfo(str, LogType.isForNative(i), LogType.isForUnexp(i), bVar.c);
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static void a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (t) {
            for (String str3 : u) {
                try {
                    String str32;
                    b bVar = (b) t.get(str32);
                    int i = bVar.a;
                    if (arrayList == null) {
                        if (!LogType.isForJava(i)) {
                            continue;
                        }
                    } else if (!a((ArrayList) arrayList, str32)) {
                    }
                    outputStream.write((str32 + "\n").getBytes(str));
                    if (bVar.c != 0) {
                        str32 = JNIBridge.nativeGetCallbackInfo(str32, bVar.c);
                    } else {
                        str32 = c(str32).toString();
                    }
                    if (str32 == null || str32.length() <= 0) {
                        outputStream.write("(data is null)\n".getBytes(str));
                        try {
                            outputStream.write("\n".getBytes(str));
                            outputStream.write(str2.getBytes(str));
                        } catch (Throwable th) {
                            f.a(th, outputStream);
                        }
                    } else {
                        outputStream.write(str32.getBytes(str));
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                } catch (Throwable th2) {
                    f.a(th2, outputStream);
                }
            }
        }
    }

    public static String a(String str) {
        String stringBuilder;
        synchronized (t) {
            stringBuilder = c(str).toString();
        }
        return stringBuilder;
    }

    private static StringBuilder c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String str2;
            b bVar = (b) t.get(str);
            if (bVar == null) {
                str2 = "Unknown callback: " + str;
            } else if (bVar.b != null) {
                str2 = (String) bVar.b.call();
            } else {
                str2 = d.a(str);
            }
            if (str2 != null) {
                stringBuilder.append(str2);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
        }
        try {
            if (stringBuilder.length() == 0) {
                stringBuilder.append("(data is null)\n");
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
        }
        return stringBuilder;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (A) {
            int id = (int) thread.getId();
            if (((e) A.get(id)) == null) {
                B.add(Integer.valueOf(id));
            }
            A.put(id, new e(thread, str));
        }
        return true;
    }

    public static void a(OutputStream outputStream, String str, String str2) {
        Thread thread;
        Throwable th;
        StackTraceElement[] stackTrace;
        synchronized (A) {
            Thread currentThread = Thread.currentThread();
            for (Integer intValue : B) {
                int intValue2 = intValue.intValue();
                String str3;
                String str4;
                Object obj;
                try {
                    e eVar = (e) A.get(intValue2);
                    if (eVar != null) {
                        thread = (Thread) eVar.a.get();
                        try {
                            str3 = eVar.b;
                            if (thread == null) {
                                try {
                                    com.uc.crashsdk.a.c.c("Thread (" + str3 + ", " + intValue2 + ") has exited!");
                                } catch (Throwable th2) {
                                    th = th2;
                                    f.a(th, outputStream);
                                    try {
                                        outputStream.write(String.format("Thread Name: '%s'\n", new Object[]{str3}).getBytes(str));
                                        str4 = thread.isDaemon() ? " daemon" : "";
                                        outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", new Object[]{thread.getName(), str4, Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue2), thread.getState().toString()}).getBytes(str));
                                    } catch (Throwable th3) {
                                        f.a(th3, outputStream);
                                    }
                                    try {
                                        stackTrace = thread.getStackTrace();
                                        if (stackTrace.length == 0) {
                                            outputStream.write("  (no stack frames)".getBytes(str));
                                        }
                                        obj = 1;
                                        for (StackTraceElement stackTraceElement : stackTrace) {
                                            if (obj == null) {
                                                outputStream.write("\n".getBytes(str));
                                            }
                                            obj = null;
                                            outputStream.write(String.format("  at %s", new Object[]{stackTraceElement.toString()}).getBytes(str));
                                        }
                                    } catch (Throwable th32) {
                                        f.a(th32, outputStream);
                                    }
                                    try {
                                        outputStream.write("\n".getBytes(str));
                                        outputStream.write(str2.getBytes(str));
                                    } catch (Throwable th322) {
                                        f.a(th322, outputStream);
                                    }
                                }
                            } else if (currentThread != thread) {
                                outputStream.write(String.format("Thread Name: '%s'\n", new Object[]{str3}).getBytes(str));
                                if (thread.isDaemon()) {
                                }
                                outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", new Object[]{thread.getName(), str4, Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue2), thread.getState().toString()}).getBytes(str));
                                stackTrace = thread.getStackTrace();
                                if (stackTrace.length == 0) {
                                    outputStream.write("  (no stack frames)".getBytes(str));
                                }
                                obj = 1;
                                for (StackTraceElement stackTraceElement2 : stackTrace) {
                                    if (obj == null) {
                                        outputStream.write("\n".getBytes(str));
                                    }
                                    obj = null;
                                    outputStream.write(String.format("  at %s", new Object[]{stackTraceElement2.toString()}).getBytes(str));
                                }
                                outputStream.write("\n".getBytes(str));
                                outputStream.write(str2.getBytes(str));
                            } else {
                                continue;
                            }
                        } catch (Throwable th4) {
                            th322 = th4;
                            str3 = null;
                            f.a(th322, outputStream);
                            outputStream.write(String.format("Thread Name: '%s'\n", new Object[]{str3}).getBytes(str));
                            if (thread.isDaemon()) {
                            }
                            outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", new Object[]{thread.getName(), str4, Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue2), thread.getState().toString()}).getBytes(str));
                            stackTrace = thread.getStackTrace();
                            if (stackTrace.length == 0) {
                                outputStream.write("  (no stack frames)".getBytes(str));
                            }
                            obj = 1;
                            for (StackTraceElement stackTraceElement22 : stackTrace) {
                                if (obj == null) {
                                    outputStream.write("\n".getBytes(str));
                                }
                                obj = null;
                                outputStream.write(String.format("  at %s", new Object[]{stackTraceElement22.toString()}).getBytes(str));
                            }
                            outputStream.write("\n".getBytes(str));
                            outputStream.write(str2.getBytes(str));
                        }
                    } else {
                        continue;
                    }
                } catch (Throwable th5) {
                    th322 = th5;
                    thread = null;
                    str3 = null;
                    f.a(th322, outputStream);
                    outputStream.write(String.format("Thread Name: '%s'\n", new Object[]{str3}).getBytes(str));
                    if (thread.isDaemon()) {
                    }
                    outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", new Object[]{thread.getName(), str4, Integer.valueOf(thread.getPriority()), Integer.valueOf(intValue2), thread.getState().toString()}).getBytes(str));
                    stackTrace = thread.getStackTrace();
                    if (stackTrace.length == 0) {
                        outputStream.write("  (no stack frames)".getBytes(str));
                    }
                    obj = 1;
                    for (StackTraceElement stackTraceElement222 : stackTrace) {
                        if (obj == null) {
                            outputStream.write("\n".getBytes(str));
                        }
                        obj = null;
                        outputStream.write(String.format("  at %s", new Object[]{stackTraceElement222.toString()}).getBytes(str));
                    }
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                }
            }
        }
    }

    public static int a(String str, int i, int i2) {
        Object obj = null;
        if (str == null || i <= 0) {
            return 0;
        }
        int i3;
        synchronized (C) {
            int i4;
            if (C.containsKey(str)) {
                i3 = ((a) C.get(str)).b;
                int i5 = i3;
                i3 = LogType.addType(i3, i2);
                i4 = i5;
            } else {
                i4 = 0;
                i3 = i2;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                if (E >= h) {
                    i3 = LogType.removeType(i3, 16);
                } else {
                    E++;
                }
            }
            if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                if (F >= h) {
                    i3 = LogType.removeType(i3, 1);
                } else {
                    F++;
                }
            }
            if ((i3 & 273) != 0) {
                if (i4 == 0) {
                    D.add(str);
                }
                int i6 = 1;
            }
            if (obj != null) {
                if (b.d && LogType.isForNative(i2) && !JNIBridge.nativeCreateCachedInfo(str, i)) {
                    i3 = LogType.removeType(i3, 1);
                }
                C.put(str, new a(i, i3));
            }
        }
        return i3;
    }

    public static int b(String str, String str2) {
        int i = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        int addType;
        if (str2.length() > i) {
            str2 = str2.substring(0, i);
        }
        synchronized (C) {
            a aVar = (a) C.get(str);
            if (aVar != null) {
                if (aVar.c.size() >= aVar.a) {
                    aVar.c.remove(0);
                }
                aVar.c.add(str2);
                i = LogType.addType(0, 16);
                if (!b.d && LogType.isForNative(aVar.b)) {
                    addType = LogType.addType(i, 1);
                    if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                        addType = LogType.addType(addType, 1);
                    }
                }
            }
            addType = i;
            addType = LogType.addType(addType, 1);
        }
        return addType;
    }

    public static void f() {
        if (j || b.d) {
            synchronized (C) {
                for (String str : D) {
                    a aVar = (a) C.get(str);
                    if (LogType.isForNative(aVar.b) && JNIBridge.nativeCreateCachedInfo(str, aVar.a)) {
                        for (String nativeAddCachedInfo : aVar.c) {
                            if (!JNIBridge.nativeAddCachedInfo(str, nativeAddCachedInfo)) {
                                break;
                            }
                        }
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static void b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (C) {
            for (String str3 : D) {
                a aVar = (a) C.get(str3);
                int i = aVar.b;
                if (arrayList == null) {
                    if (!LogType.isForJava(i)) {
                        continue;
                    }
                } else if (!a((ArrayList) arrayList, str3)) {
                    continue;
                }
                try {
                    outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", new Object[]{str3, Integer.valueOf(aVar.c.size()), Integer.valueOf(aVar.a)}).getBytes(str));
                } catch (Throwable th) {
                    f.a(th, outputStream);
                }
                try {
                    for (String str32 : aVar.c) {
                        outputStream.write(str32.getBytes(str));
                        outputStream.write("\n".getBytes(str));
                    }
                } catch (Throwable th2) {
                    f.a(th2, outputStream);
                }
                try {
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                } catch (Throwable th22) {
                    f.a(th22, outputStream);
                }
            }
        }
    }

    public static int a(int i, String str) {
        if (h.a(str)) {
            str = Thread.currentThread().getName();
        }
        int i2 = 0;
        if (LogType.isForNative(i)) {
            if (b.d) {
                synchronized (A) {
                    JNIBridge.nativeRegisterCurrentThread(str);
                }
                i2 = 1;
            } else {
                com.uc.crashsdk.a.c.a("crashsdk", "crashsdk so has not loaded!");
            }
        }
        if (!LogType.isForJava(i)) {
            return i2;
        }
        a(str, Thread.currentThread());
        return i2 | 16;
    }

    public static boolean a(boolean z) {
        if (b.c && b.q()) {
            int i;
            if (z) {
                i.a(G);
                i = 0;
            } else if (!b.o()) {
                com.uc.crashsdk.a.c.b("Stop update unexp info in background!");
                return false;
            } else if (p.C() <= 0) {
                return false;
            } else {
                if (i.b(G)) {
                    return true;
                }
                i = p.C() * 1000;
            }
            i.a(0, G, (long) i);
            return true;
        }
        com.uc.crashsdk.a.c.b("Unexp log or unexp stats not enabled, skip update unexp info!");
        return false;
    }

    public static ArrayList<String> b(String str) {
        if (h.a(str)) {
            return null;
        }
        String[] split = str.split(";");
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : split) {
            if (!h.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static String g() {
        if (!H) {
            m = com.uc.crashsdk.a.d.a(b.g());
            H = true;
            if (m == null) {
                m = "";
            }
        }
        return m;
    }

    public static void h() {
        if (!I) {
            I = true;
            i.a(0, new d(2));
        } else if (b.d) {
            JNIBridge.nativeSyncStatus("ver", m, 0);
        }
    }
}
