package com.ucweb.a.a;

import android.content.Context;
import android.util.Log;
import com.ucweb.a.b.a;
import com.ucweb.a.b.b;
import com.ucweb.a.b.d;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public final class c {
    public static boolean a = false;
    private static Context b;
    private static Context c;
    private static a d;
    private static b e;
    private static int f = b.a;

    public static void a(Context context, a aVar, b bVar, int i, boolean z) {
        b = context;
        d = aVar;
        e = bVar;
        f = i;
        a = z;
    }

    public static final int a() {
        return f;
    }

    public static Context d() {
        if (c == null && b != null) {
            c = b.getApplicationContext();
            if (b.getApplicationContext() == null) {
                c = b;
            }
        }
        return c;
    }

    public static void a(d dVar, boolean z) {
        if (b == null) {
            Log.e("Upgrade", "please invoke upgrade init");
        } else {
            m.a(0, new a(dVar, z));
        }
    }

    public static a b() {
        if (d != null) {
            return d;
        }
        throw new RuntimeException("请提供加解密程序!");
    }

    public static b c() {
        if (e != null) {
            return e;
        }
        throw new RuntimeException("请提供升级所需要的参数!");
    }
}
