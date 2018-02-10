package com.ucpro.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ucpro.visible.PlayReferrerReceiver;
import com.ucweb.common.util.d;
import java.util.Properties;

/* compiled from: ProGuard */
public final class a {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static Properties f;

    public static String a() {
        if (a == null) {
            a = a("bid", "bid", "35937");
        }
        return a;
    }

    public static String b() {
        if (b == null) {
            CharSequence a = a("ch", "ch", "");
            b = a;
            if (TextUtils.isEmpty(a)) {
                b = PlayReferrerReceiver.a("utm_source");
            }
        }
        return b;
    }

    public static String c() {
        if (c == null) {
            c = a("cid", "cid", "");
        }
        return c;
    }

    public static String d() {
        if (d == null) {
            d = a("btype", "btype", "");
        }
        return d;
    }

    public static String e() {
        if (e == null) {
            e = a("bmode", "bmode", "");
        }
        return e;
    }

    private static String a(String str, String str2, String str3) {
        CharSequence charSequence = null;
        SharedPreferences sharedPreferences = d.a().getSharedPreferences("__si", 0);
        String string = sharedPreferences.getString(str, null);
        if ("\"\"".equals(string)) {
            sharedPreferences.edit().remove(str).apply();
        } else {
            Object obj = string;
        }
        if (TextUtils.isEmpty(charSequence)) {
            Properties f = f();
            if (f != null) {
                charSequence = f.getProperty(str2);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence charSequence2 = charSequence;
        }
        if (!TextUtils.isEmpty(str3)) {
            sharedPreferences.edit().putString(str, str3).apply();
        }
        return str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.util.Properties f() {
        /*
        r0 = 0;
        r2 = com.ucpro.c.a.class;
        monitor-enter(r2);
        r1 = f;	 Catch:{ all -> 0x002d }
        if (r1 != 0) goto L_0x0021;
    L_0x0008:
        r1 = new java.util.Properties;	 Catch:{ all -> 0x002d }
        r1.<init>();	 Catch:{ all -> 0x002d }
        f = r1;	 Catch:{ all -> 0x002d }
        r1 = com.ucweb.common.util.d.b();	 Catch:{ all -> 0x002d }
        r3 = "config/config.ini";
        r0 = r1.open(r3);	 Catch:{ IOException -> 0x0025, all -> 0x0030 }
        r1 = f;	 Catch:{ IOException -> 0x0025 }
        r1.load(r0);	 Catch:{ IOException -> 0x0025 }
        com.ucweb.common.util.o.a.a(r0);	 Catch:{ all -> 0x002d }
    L_0x0021:
        r0 = f;	 Catch:{ all -> 0x002d }
        monitor-exit(r2);
        return r0;
    L_0x0025:
        r1 = move-exception;
        r1 = 0;
        f = r1;	 Catch:{ all -> 0x0038 }
        com.ucweb.common.util.o.a.a(r0);	 Catch:{ all -> 0x002d }
        goto L_0x0021;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0030:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0034:
        com.ucweb.common.util.o.a.a(r1);	 Catch:{ all -> 0x002d }
        throw r0;	 Catch:{ all -> 0x002d }
    L_0x0038:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.c.a.f():java.util.Properties");
    }
}
