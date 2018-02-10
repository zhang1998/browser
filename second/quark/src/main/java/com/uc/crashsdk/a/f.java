package com.uc.crashsdk.a;

import android.os.Process;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.a;
import com.uc.crashsdk.b;
import com.uc.crashsdk.p;
import java.util.Locale;

/* compiled from: ProGuard */
public final class f {
    private static boolean a = true;
    private static final Object b = new Object();
    private static boolean c = false;
    private static String d = "hsdk";
    private static String e = "alid ";
    private static String f = null;

    public static void a() {
        i.a(0, new g(), 55000);
    }

    public static String b() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("inv");
            stringBuilder.append(e);
            stringBuilder.append("cras");
            stringBuilder.append(d);
            return stringBuilder.toString();
        } catch (Throwable th) {
            a.a(th, true);
            return "";
        }
    }

    private static boolean b(boolean z) {
        if (c) {
            return false;
        }
        c = !z;
        if (a.b.equals("2.0") && b.b(536870912)) {
            return false;
        }
        Object obj;
        int c;
        boolean z2;
        String h = b.h();
        String a = d.a(h);
        long j = 0;
        if (h.b(a)) {
            String[] split = a.split(" ");
            if (split.length == 3) {
                obj = split[0];
                j = h.c(split[1]);
                c = (int) h.c(split[2]);
                a = true;
                if (System.currentTimeMillis() - j < 259200000) {
                    if ("o".equals(obj)) {
                        z2 = false;
                    } else if (Global.APOLLO_SERIES.equals(obj)) {
                        a = false;
                        z2 = false;
                    } else if (SettingsConst.TRUE.equals(obj)) {
                        a = false;
                    }
                    if (z2 || z) {
                        return true;
                    }
                    if (c == Process.myPid()) {
                        return false;
                    }
                    f = "per";
                    String h2 = h();
                    if (h2 != null && h2.contains("retcode=")) {
                        if (h2.contains("retcode=0")) {
                            a = true;
                            h2 = "o";
                            f = "aus";
                        } else {
                            a = false;
                            if (SettingsConst.TRUE.equals(obj)) {
                                h2 = Global.APOLLO_SERIES;
                                f = "auf2";
                            } else {
                                h2 = SettingsConst.TRUE;
                                f = "auf1";
                            }
                        }
                        d.a(h, String.format(Locale.US, "%s %d %d", new Object[]{h2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())}));
                        return true;
                    } else if (h2 == null) {
                        f = "ner";
                        return false;
                    } else {
                        f = "ser";
                        return false;
                    }
                }
                z2 = true;
                if (z2) {
                }
                return true;
            }
        }
        obj = null;
        c = 0;
        a = true;
        if (System.currentTimeMillis() - j < 259200000) {
            if ("o".equals(obj)) {
                z2 = false;
            } else if (Global.APOLLO_SERIES.equals(obj)) {
                a = false;
                z2 = false;
            } else if (SettingsConst.TRUE.equals(obj)) {
                a = false;
            }
            if (z2) {
            }
            return true;
        }
        z2 = true;
        if (z2) {
        }
        return true;
    }

    public static byte[] c() {
        return new byte[]{(byte) 6, (byte) 0, (byte) 23, (byte) 8};
    }

    private static String h() {
        byte[] a;
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, "platform", p.e());
        a(stringBuilder, "pkgname", a.a);
        a(stringBuilder, "process", com.uc.crashsdk.f.d());
        a(stringBuilder, "version", a.a());
        a(stringBuilder, "os", "android");
        String stringBuilder2 = stringBuilder.toString();
        byte[] bArr = new byte[16];
        e.a(bArr, 0, k.d());
        e.a(bArr, 4, e.c());
        e.a(bArr, 8, c());
        e.a(bArr, 12, a.c());
        try {
            a = e.a(stringBuilder2.getBytes(), bArr, true);
        } catch (Throwable th) {
            a.a(th, false);
            a = null;
        }
        if (a == null) {
            return null;
        }
        a = e.a("https://woodpecker.uc.cn/api/crashsdk/validate", a);
        if (a == null) {
            return null;
        }
        try {
            a = e.a(a, bArr, false);
        } catch (Throwable th2) {
            a.a(th2, false);
            a = null;
        }
        if (a != null) {
            return new String(a);
        }
        return null;
    }

    private static StringBuilder a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append("`");
        }
        stringBuilder.append(str).append("=").append(str2);
        return stringBuilder;
    }

    public static boolean d() {
        try {
            b(true);
        } catch (Throwable th) {
        }
        return a;
    }
}
