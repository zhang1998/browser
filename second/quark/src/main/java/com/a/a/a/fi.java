package com.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.Locale;

/* compiled from: ProGuard */
public final class fi {
    private static fi b = null;
    private static Context c;
    private static String d;
    fy a;

    private fi(Context context) {
        this.a = new fy(context);
    }

    public static synchronized fi a(Context context) {
        fi fiVar;
        synchronized (fi.class) {
            c = context.getApplicationContext();
            d = context.getPackageName();
            if (b == null) {
                b = new fi(context);
            }
            fiVar = b;
        }
        return fiVar;
    }

    public static String a() {
        SharedPreferences sharedPreferences = c.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("appkey", null);
        }
        return null;
    }

    public static void a(String str) {
        SharedPreferences sharedPreferences = c.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("appkey", str).commit();
        }
    }

    public static String b() {
        SharedPreferences sharedPreferences = c.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public static void a(int i) {
        SharedPreferences sharedPreferences = c.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public static int c() {
        SharedPreferences sharedPreferences = c.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public final void d() {
        String str;
        c.deleteFile("mobclick_agent_header_" + d);
        Context context = c;
        SharedPreferences sharedPreferences = c.getSharedPreferences("umeng_general_config", 0);
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt("versioncode", 0);
            int parseInt = Integer.parseInt(ey.a(c));
            if (i == 0 || parseInt == i) {
                str = "mobclick_agent_cached_" + d + ey.a(c);
            } else {
                str = "mobclick_agent_cached_" + d + i;
            }
        } else {
            str = "mobclick_agent_cached_" + d + ey.a(c);
        }
        context.deleteFile(str);
        aj.a(c).a(true, false);
        bx.c = c;
        bx a = bv.a;
        fv fvVar = new fv(this);
        a.c();
    }

    public final void a(byte[] bArr) {
        fy fyVar = this.a;
        if (bArr != null && bArr.length != 0) {
            try {
                fu.a(new File(fyVar.a, String.format(Locale.US, "um_cache_%d.env", new Object[]{Long.valueOf(System.currentTimeMillis())})), bArr);
            } catch (Exception e) {
            }
        }
    }

    public final boolean e() {
        File[] listFiles = this.a.a.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return false;
        }
        return true;
    }

    public static SharedPreferences f() {
        return c.getSharedPreferences("mobclick_agent_user_" + d, 0);
    }
}
