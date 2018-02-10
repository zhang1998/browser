package com.ucweb.a;

import android.text.TextUtils;
import com.d.a.b.a;
import com.d.a.b.b;
import com.d.a.b.d;
import com.d.a.b.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class u {
    private String A;
    private ArrayList<f> B;
    String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    int h;
    int i;
    public String j;
    int k;
    int l;
    String m;
    public String n;
    public ArrayList<a> o;
    String p;
    String q;
    String r;
    int s;
    byte[] t;
    private int u;
    private String v;
    private String w;
    private String x;
    private int y;
    private int z;

    u(d dVar) {
        String str;
        String str2 = null;
        this.u = dVar.j;
        this.b = dVar.i;
        if (dVar.n == null) {
            str = null;
        } else {
            str = dVar.n.toString();
        }
        this.e = str;
        if (dVar.m == null) {
            str = null;
        } else {
            str = dVar.m.toString();
        }
        this.f = str;
        if (dVar.g == null) {
            str = null;
        } else {
            str = dVar.g.toString();
        }
        this.g = str;
        if (dVar.b == null) {
            str = null;
        } else {
            str = dVar.b.toString();
        }
        this.x = str;
        this.y = dVar.c;
        this.h = dVar.a;
        this.k = dVar.p;
        this.l = dVar.q;
        if (dVar.d == null) {
            str = null;
        } else {
            str = dVar.d.toString();
        }
        this.c = str;
        if (dVar.h == null) {
            str = null;
        } else {
            str = dVar.h.toString();
        }
        this.v = str;
        if (dVar.e == null) {
            str = null;
        } else {
            str = dVar.e.toString();
        }
        this.w = str;
        if (dVar.r == null) {
            str = null;
        } else {
            str = dVar.r.toString();
        }
        this.d = str;
        this.z = dVar.o;
        this.k = dVar.p;
        this.l = dVar.q;
        if (dVar.f == null) {
            str = null;
        } else {
            str = dVar.f.toString();
        }
        this.j = str;
        if (dVar.l == null) {
            str = null;
        } else {
            str = dVar.l.toString();
        }
        this.m = str;
        if (dVar.k == null) {
            str = null;
        } else {
            str = dVar.k.toString();
        }
        this.A = str;
        if (dVar.s == null) {
            str = null;
        } else {
            str = dVar.s.toString();
        }
        this.n = str;
        this.B = dVar.t;
        if (dVar.u != null) {
            this.s = dVar.u.e;
            b bVar = dVar.u;
            if (bVar.a == null) {
                str = null;
            } else {
                str = bVar.a.toString();
            }
            this.p = str;
            bVar = dVar.u;
            if (bVar.c == null) {
                str = null;
            } else {
                str = bVar.c.toString();
            }
            this.q = str;
            bVar = dVar.u;
            if (bVar.d != null) {
                str2 = bVar.d.toString();
            }
            this.r = str2;
            this.t = dVar.u.b;
        }
        this.o = dVar.v;
    }

    public final boolean a() {
        if (this.h == 1 || this.h == 3) {
            return true;
        }
        return false;
    }

    public final String a(String str) {
        if (this.B == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator it = this.B.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null) {
                Object obj;
                if (fVar.a == null) {
                    obj = null;
                } else {
                    obj = fVar.a.toString();
                }
                if (str.equals(obj)) {
                    if (fVar.b != null) {
                        return fVar.b.toString();
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
