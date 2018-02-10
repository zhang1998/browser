package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import com.UCMobile.Apollo.MediaPlayer;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.f;
import com.uc.crashsdk.p;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
public class k {
    private static final Object a = new Object();
    private static Map<String, String> b = new HashMap();
    private static int c = 0;
    private static Map<String, b> d = new HashMap();
    private static Object e = new Object();
    private static SparseArray<String> f = new SparseArray();
    private static boolean g = false;
    private static boolean h = false;
    private static final char[] i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* compiled from: ProGuard */
    final class a implements Runnable {
        static final /* synthetic */ boolean a = (!k.class.desiredAssertionStatus());
        private int b = 0;

        a(int i) {
            this.b = i;
        }

        public final void run() {
            switch (this.b) {
                case 1:
                    k.f();
                    return;
                case 2:
                    synchronized (k.a) {
                        k.h();
                    }
                    return;
                case 3:
                    k.i();
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
    final class b {
        long a = 0;
        int b = 0;
        Map<String, String> c = new HashMap();
        private String d;
        private boolean e = false;
        private boolean f = false;

        b(String str, boolean z, boolean z2) {
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        final void a(String str, String str2) {
            this.c.put(str, str2);
        }

        final void a(String str, long j) {
            a(str, String.valueOf(c(str) + j));
        }

        final boolean a(b bVar) {
            if (this.f) {
                for (String str : bVar.c.keySet()) {
                    if (str.startsWith("c_")) {
                        a(str, bVar.a(str));
                    } else {
                        long c = bVar.c(str);
                        if (c != 0) {
                            a(str, c);
                        } else {
                            a(str, bVar.a(str));
                        }
                    }
                }
                return true;
            }
            c.a("crashsdk", String.format("WaItem '%s' is not mergable!", new Object[]{this.d}));
            return false;
        }

        final String a(String str) {
            return (String) this.c.get(str);
        }

        private long c(String str) {
            return h.c(a(str));
        }

        final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (z) {
                String str = "-";
                try {
                    str = Build.HARDWARE;
                } catch (Throwable th) {
                    a.a(th, false);
                }
                k.b(stringBuilder, "lt", "uc");
                k.b(stringBuilder, "pre", p.e());
                k.b(stringBuilder, "pkg", com.uc.crashsdk.a.a);
                k.b(stringBuilder, "rom", VERSION.RELEASE);
                k.b(stringBuilder, "model", Build.MODEL);
                k.b(stringBuilder, "sdk", String.valueOf((long) VERSION.SDK_INT));
                k.b(stringBuilder, "cpu", Build.CPU_ABI);
                k.b(stringBuilder, "hdw", str);
                k.b(stringBuilder, "ram", String.valueOf((long) k.k()));
                k.b(stringBuilder, "cver", "2.0.0.4");
                k.b(stringBuilder, "cseq", "170706161743");
                k.b(stringBuilder, "aver", com.uc.crashsdk.a.a());
                k.b(stringBuilder, "ver", p.K());
                k.b(stringBuilder, "sver", p.L());
                k.b(stringBuilder, "seq", p.M());
                k.b(stringBuilder, "os", "android");
                stringBuilder.append("\n");
            }
            k.b(stringBuilder, "lt", this.d);
            k.a(stringBuilder, this.c);
            if (this.e && !z2) {
                if (this.a != 0) {
                    k.b(stringBuilder, "up", String.valueOf(this.a));
                }
                if (z3) {
                    k.b(stringBuilder, "pid", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(Process.myPid())}));
                } else if (this.b != 0) {
                    k.b(stringBuilder, "pid", String.format(Locale.US, "%d", new Object[]{Integer.valueOf(this.b)}));
                }
            }
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }

        final boolean b(String str) {
            if (h.a(str)) {
                return false;
            }
            Map hashMap = new HashMap();
            Map a = k.a(str);
            long j = 0;
            String str2 = null;
            int i = 0;
            for (String str3 : a.keySet()) {
                String str4 = (String) a.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals("up")) {
                    j = h.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    i = (int) h.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            if (this.d != null && !this.d.equals(str2)) {
                return false;
            }
            this.a = j;
            this.b = i;
            this.d = str2;
            this.c = hashMap;
            return true;
        }
    }

    static /* synthetic */ boolean c(String str) {
        if (h) {
            return false;
        }
        h = true;
        File file = new File(str);
        Iterable a = a(file, "crp", 100);
        b bVar = new b("crp", false, false);
        bVar.a("et", String.valueOf(com.uc.crashsdk.b.u()));
        bVar.a("prc", f.d());
        bVar.a("imp", com.uc.crashsdk.b.t() ? SettingsConst.TRUE : SettingsConst.FALSE);
        a(bVar);
        a.add(0, bVar);
        boolean b = b(f.j(), a(a, true, false).toString());
        b.a(file);
        if (!b) {
            b.a(file, a(a, false, true).toString());
        }
        return true;
    }

    static /* synthetic */ boolean d(String str) {
        File file = new File(str);
        Iterator it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            String a = bVar.a("prc");
            if (!h.a(a)) {
                b bVar2 = (b) d.get(a);
                if (bVar2 != null) {
                    bVar2.a(bVar);
                } else {
                    d.put(a, bVar);
                }
            }
        }
        boolean b = b(f.j(), a(d.values(), true, false).toString());
        b.a(file);
        if (!b) {
            b.a(file, a(d.values(), false, true).toString());
        }
        return true;
    }

    static /* synthetic */ void f() {
        String str = p.N() + "cr.wa";
        com.uc.crashsdk.b.a(a, str, new l(str, str));
    }

    static /* synthetic */ boolean h() {
        if (g) {
            return false;
        }
        g = true;
        if (com.uc.crashsdk.a.b.equals("2.0") && com.uc.crashsdk.b.b((int) MediaPlayer.MEDIA_ERROR_UNKNOWN)) {
            return false;
        }
        File file = new File(j());
        String b = b.b(file);
        b bVar = new b("pv", true, true);
        if (!h.a(b)) {
            bVar.b(b);
        }
        if (bVar.b == Process.myPid()) {
            return false;
        }
        bVar.a("pv", 1);
        bVar.a("fjv", 1);
        b = f.j();
        long j = bVar.a;
        boolean b2 = (j == 0 || System.currentTimeMillis() - j >= 28800000) ? b(b, bVar.a(true, true, false)) : false;
        if (b2) {
            bVar.c = new HashMap();
            bVar.a = System.currentTimeMillis();
            bVar.b = Process.myPid();
        }
        b.a(file, bVar.a(false, false, true));
        return true;
    }

    static /* synthetic */ void i() {
        String str = p.N() + "dt.wa";
        com.uc.crashsdk.b.a(e, str, new m(str, str));
    }

    public static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static void a(StringBuilder stringBuilder, Map<String, String> map) {
        for (String str : map.keySet()) {
            b(stringBuilder, str, (String) map.get(str));
        }
    }

    private static void b(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(str).append("=").append(str2).append("`");
    }

    public static void b(String str) {
        synchronized (a) {
            File file = new File(j());
            b bVar = new b("pv", true, true);
            String b = b.b(file);
            if (!h.a(b)) {
                bVar.b(b);
            }
            bVar.a(str, 1);
            bVar.a("aujv", 1);
            b.a(file, bVar.a(false, false, false));
        }
    }

    public static void a() {
        if (com.uc.crashsdk.b.t()) {
            i.a(0, new a(2), 36000);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            Object obj;
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            if (h.a(str2)) {
                obj = "";
            } else {
                obj = str2.replaceAll("[`=]", "-");
            }
            synchronized (b) {
                if (b.get(str3) == null) {
                    if (c >= 20) {
                        return false;
                    }
                    c++;
                }
                b.put(str3, obj);
                return true;
            }
        } catch (Throwable th) {
            a.a(th, false);
            return false;
        }
    }

    private static void a(b bVar) {
        synchronized (b) {
            for (String str : b.keySet()) {
                bVar.a(str, (String) b.get(str));
            }
        }
    }

    public static void b() {
        if (p.I()) {
            i.a(1, new a(1), 2000);
        }
    }

    private static StringBuilder a(Iterable<b> iterable, boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean z3 = true;
        for (b bVar : iterable) {
            if (z3) {
                stringBuilder.append(bVar.a(z, z, z2));
                z3 = false;
            } else {
                stringBuilder.append(bVar.a(false, z, z2));
            }
        }
        return stringBuilder;
    }

    public static void a(String str, int i, int i2) {
        if (p.I()) {
            synchronized (e) {
                b bVar;
                b bVar2 = (b) d.get(str);
                if (bVar2 == null) {
                    bVar2 = new b("cst", false, true);
                    d.put(str, bVar2);
                    a(bVar2);
                    bVar = bVar2;
                } else {
                    bVar = bVar2;
                }
                synchronized (f) {
                    if (f.size() != 0) {
                    } else {
                        a(100, "pv");
                        a(1, ShareConstants.IGNORE_ALL_SYMBOLIC);
                        a(2, "afg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = (String) f.get(i);
                if (str2 == null) {
                    c.a("crashsdk", "map key is not set with: " + i);
                }
                bVar.a("prc", str);
                if (str2 != null) {
                    bVar.a(str2, String.valueOf(i2));
                }
            }
        }
    }

    public static void c() {
        if (p.I()) {
            i.a(1, new a(3));
        }
    }

    private static void a(int i, String str) {
        f.put(i, str);
    }

    private static ArrayList<b> a(File file, String str, int i) {
        ArrayList a = b.a(file, i);
        ArrayList<b> arrayList = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            b bVar = new b(str, false, false);
            if (bVar.b(str2)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private static String j() {
        return p.N() + "pv.wa";
    }

    private static boolean b(String str, String str2) {
        if (h.a(str2)) {
            return true;
        }
        byte[] bArr;
        boolean z;
        String str3;
        String valueOf;
        String e;
        StringBuilder stringBuilder;
        byte[] bytes = str2.getBytes();
        try {
            bArr = new byte[16];
            e.a(bArr, 0, e.c());
            e.a(bArr, 4, d());
            e.a(bArr, 8, com.uc.crashsdk.a.c());
            e.a(bArr, 12, f.c());
            bArr = e.a(bytes, bArr);
            if (bArr != null) {
                bytes = bArr;
                z = true;
                str3 = "28ef1713347d";
                if (p.J()) {
                    str3 = "4ea4e41a3993";
                }
                valueOf = String.valueOf(System.currentTimeMillis());
                e = e(str3 + str + valueOf + "AppChk#2014");
                stringBuilder = new StringBuilder();
                if (p.J()) {
                    stringBuilder.append("https://applog.uc.cn/collect?chk=");
                } else {
                    stringBuilder.append("https://gjapplog.uc.cn/collect?chk=");
                }
                stringBuilder.append(e.substring(e.length() - 8, e.length())).append("&vno=").append(valueOf).append("&uuid=").append(str).append("&app=").append(str3);
                if (z) {
                    stringBuilder.append("&enc=aes");
                }
                bArr = e.a(stringBuilder.toString(), bytes);
                if (bArr == null) {
                    return false;
                }
                if (new String(bArr).contains("retcode=0")) {
                    return false;
                }
                return true;
            }
        } catch (Throwable th) {
            a.a(th, false);
        }
        z = false;
        str3 = "28ef1713347d";
        if (p.J()) {
            str3 = "4ea4e41a3993";
        }
        valueOf = String.valueOf(System.currentTimeMillis());
        e = e(str3 + str + valueOf + "AppChk#2014");
        stringBuilder = new StringBuilder();
        if (p.J()) {
            stringBuilder.append("https://applog.uc.cn/collect?chk=");
        } else {
            stringBuilder.append("https://gjapplog.uc.cn/collect?chk=");
        }
        stringBuilder.append(e.substring(e.length() - 8, e.length())).append("&vno=").append(valueOf).append("&uuid=").append(str).append("&app=").append(str3);
        if (z) {
            stringBuilder.append("&enc=aes");
        }
        bArr = e.a(stringBuilder.toString(), bytes);
        if (bArr == null) {
            return false;
        }
        if (new String(bArr).contains("retcode=0")) {
            return true;
        }
        return false;
    }

    private static int k() {
        Iterator it = b.a(new File("/proc/meminfo"), 2).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.indexOf("MemTotal:") >= 0) {
                try {
                    return Integer.parseInt(str.replaceAll("\\D+", ""));
                } catch (Throwable e) {
                    a.a(e, false);
                    return 0;
                }
            }
        }
        return 0;
    }

    public static byte[] d() {
        return new byte[]{Byte.MAX_VALUE, (byte) 100, (byte) 110, (byte) 31};
    }

    private static String e(String str) {
        String str2 = null;
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            StringBuilder stringBuilder = new StringBuilder(length * 2);
            length += 0;
            for (int i = 0; i < length; i++) {
                byte b = digest[i];
                char c = i[(b & 240) >> 4];
                char c2 = i[b & 15];
                stringBuilder.append(c);
                stringBuilder.append(c2);
            }
            str2 = stringBuilder.toString();
        } catch (Exception e) {
            p.G();
        }
        return str2;
    }
}
