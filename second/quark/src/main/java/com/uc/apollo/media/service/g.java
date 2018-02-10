package com.uc.apollo.media.service;

import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class g {
    private static g g = null;
    private boolean a = false;
    private boolean b = false;
    private ArrayList<Integer> c = new ArrayList();
    private Object d = null;
    private Method e = null;
    private Method f = null;

    public static g a() {
        if (g == null) {
            synchronized (g.class) {
                if (g == null) {
                    g = new g();
                }
            }
        }
        return g;
    }

    private g() {
        try {
            Class classSliently = ReflectUtil.getClassSliently("com.uc.crashsdk.export.CrashApi");
            if (classSliently != null) {
                this.e = ReflectUtil.getMethod2(classSliently, "setForeground", Boolean.TYPE);
                this.f = ReflectUtil.getMethod2(classSliently, "addHeaderInfo", String.class, String.class);
                Method method2 = ReflectUtil.getMethod2(classSliently, "getInstance", new Class[0]);
                if (method2 != null) {
                    this.d = ReflectUtil.call(classSliently, (Object) classSliently, method2, new Object[0]);
                }
            }
        } catch (Exception e) {
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null && this.f != null) {
                ReflectUtil.call(Void.TYPE, this.d, this.f, str, str2);
            }
        } catch (Exception e) {
        }
    }

    public final void a(String str) {
        a("apolloPlayerType", str);
    }

    public final void b(String str) {
        a("apolloUrl", str);
    }

    public final void c(String str) {
        String str2 = "apolloBuildSeq";
        if (str == null) {
            str = "";
        }
        a(str2, str);
    }

    public final void d(String str) {
        a("apolloSoVer", str);
    }

    public final void a(int i, boolean z) {
        if (z && !this.c.contains(Integer.valueOf(i))) {
            this.c.add(Integer.valueOf(i));
            if (this.c.size() == 1) {
                a(true);
            }
        } else if (!z && this.c.contains(Integer.valueOf(i))) {
            this.c.remove(Integer.valueOf(i));
            if (this.c.size() == 0) {
                a(false);
            }
        }
    }

    private void a(boolean z) {
        a("apolloPlaying", z ? "true" : "false");
    }

    public final void b() {
        this.a = true;
        f();
    }

    public final void c() {
        this.a = false;
        f();
    }

    public final void d() {
        this.b = true;
        f();
    }

    public final void e() {
        this.b = false;
        f();
    }

    private void f() {
        if (this.b || !this.a) {
            b(true);
        } else {
            b(false);
        }
    }

    private void b(boolean z) {
        try {
            if (this.d == null || this.e == null) {
                Class cls = ReflectUtil.getClass("com.uc.crashsdk.export.CrashApi");
                if (cls != null) {
                    Method method2 = ReflectUtil.getMethod2(cls, "getInstance", new Class[0]);
                    if (method2 != null) {
                        this.e = ReflectUtil.getMethod2(cls, "setForeground", Boolean.TYPE);
                        if (this.e != null) {
                            this.d = ReflectUtil.call(cls, (Object) cls, method2, new Object[0]);
                            if (this.d == null) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.d != null && this.e != null) {
                ReflectUtil.call(Void.TYPE, this.d, this.e, Boolean.valueOf(z));
            }
        } catch (Exception e) {
        }
    }
}
