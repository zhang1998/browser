package com.uc.base.wa.config;

import com.uc.base.wa.k;

/* compiled from: ProGuard */
public final class c implements Cloneable {
    private static String[] f = null;
    private static String[] g = null;
    private static int h = k.b;
    private static String[] i = null;
    public String[] a;
    public String[] b;
    public String[] c;
    public String[] d;
    public boolean e = false;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return f();
    }

    public static void a(String[] strArr, String[] strArr2, int i) {
        f = strArr;
        g = strArr2;
        h = i;
        i = null;
    }

    public final boolean a() {
        if (this.e) {
            return true;
        }
        if ((this.a == null || this.a.length == 0) && ((this.b == null || this.b.length == 0) && ((this.c == null || this.c.length == 0) && (this.d == null || this.d.length == 0)))) {
            return true;
        }
        return false;
    }

    public static String[] b() {
        return f;
    }

    public static String[] c() {
        return g;
    }

    public static int d() {
        return h;
    }

    public static String[] e() {
        return i;
    }

    public final c f() {
        c cVar = new c();
        if (this.a != null) {
            cVar.a = new String[this.a.length];
            System.arraycopy(this.a, 0, cVar.a, 0, this.a.length);
        }
        if (this.b != null) {
            cVar.b = new String[this.b.length];
            System.arraycopy(this.b, 0, cVar.b, 0, this.b.length);
        }
        if (this.c != null) {
            cVar.c = new String[this.c.length];
            System.arraycopy(this.c, 0, cVar.c, 0, this.c.length);
        }
        if (this.d != null) {
            cVar.d = new String[this.d.length];
            System.arraycopy(this.d, 0, cVar.d, 0, this.d.length);
        }
        return cVar;
    }
}
