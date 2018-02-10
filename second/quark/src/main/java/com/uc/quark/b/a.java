package com.uc.quark.b;

import com.uc.quark.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class a {
    public b a = new b();
    public boolean b = false;
    private List<s> c = new ArrayList();
    private List<s> d = new ArrayList();
    private boolean e = false;

    public final List<s> a() {
        c();
        return this.c;
    }

    public final List<s> b() {
        if (!this.e) {
            b bVar = this.a;
            this.d = bVar.a(new d(bVar));
            this.e = true;
        }
        return this.d;
    }

    public final boolean a(s sVar) {
        c();
        if (sVar.l()) {
            synchronized (this.d) {
                this.d.add(0, sVar);
            }
        }
        if (b(sVar.a())) {
            return false;
        }
        if (this.a.a(sVar.g()) && this.a.b(sVar.b())) {
            return false;
        }
        if (!sVar.l()) {
            synchronized (this.c) {
                this.c.add(0, sVar);
            }
        }
        b bVar = this.a;
        if (bVar.a.insert("task", null, sVar.z()) != -1) {
            return true;
        }
        return false;
    }

    public final void a(int i) {
        c();
        int e = e(i);
        if (e >= 0) {
            this.c.remove(e);
        } else {
            s d = d(i);
            if (d != null) {
                this.d.remove(d);
            }
        }
        this.a.a.delete("task", "id=" + i, null);
    }

    private void c() {
        if (!this.b) {
            b bVar = this.a;
            this.c = bVar.a(new g(bVar));
            this.b = true;
        }
    }

    public final boolean b(int i) {
        c();
        return e(i) >= 0;
    }

    public final s c(int i) {
        c();
        int e = e(i);
        if (e >= 0) {
            return (s) this.c.get(e);
        }
        return null;
    }

    private int e(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            if (((s) this.c.get(i2)).a() == i) {
                return i2;
            }
        }
        return -1;
    }

    public final s d(int i) {
        for (s sVar : b()) {
            if (sVar.a() == i) {
                return sVar;
            }
        }
        return null;
    }

    public final boolean a(String str) {
        return this.a.b(str);
    }
}
