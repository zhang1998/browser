package com.uc.framework.resources;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class r {
    static final /* synthetic */ boolean b;
    private static boolean c = true;
    private static r d;
    public f a;
    private Context e;
    private String f;
    private String g;
    private String h;
    private ArrayList<Object> i = new ArrayList();

    static {
        boolean z;
        if (r.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        b = z;
    }

    public static void a(Context context) {
        if (d == null) {
            d = new r(context);
        }
    }

    public static r a() {
        if (b || d != null) {
            return d;
        }
        throw new AssertionError();
    }

    private r(Context context) {
        this.e = context;
        this.h = context.getApplicationInfo().dataDir;
        this.f = this.h + "/downloadtheme/theme/";
        this.g = this.h + "/downloadtheme/theme_hidden/";
        this.a = new f(context);
        this.a.a("theme/default/");
    }

    public static void b() {
        c = true;
    }

    public static boolean c() {
        return c;
    }

    public static void d() {
        e.a();
    }
}
