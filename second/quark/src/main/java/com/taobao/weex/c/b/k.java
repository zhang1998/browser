package com.taobao.weex.c.b;

import android.mini.support.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class k {
    public final m a_ = new m();
    public final g b = new g();
    final a c = new a();
    public int d = 0;
    k e;
    k f;
    public ArrayList<k> g;
    public k h;
    j i = null;
    public int j = i.a;
    boolean k = true;
    private boolean l = true;

    public final boolean a(g gVar) {
        this.l = !this.c.equals(gVar);
        if (this.l) {
            this.c.a(gVar);
        }
        return this.l;
    }

    public final int e() {
        return this.g == null ? 0 : this.g.size();
    }

    public final k a(int i) {
        return (k) this.g.get(i);
    }

    public final void a(k kVar, int i) {
        if (kVar.h != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.g == null) {
            this.g = new ArrayList(4);
        }
        this.g.add(i, kVar);
        kVar.h = this;
        h();
    }

    public final void a(j jVar) {
        if (this.i != jVar) {
            this.i = jVar;
            h();
        }
    }

    public final boolean d_() {
        return this.i != null;
    }

    public final boolean e_() {
        return this.j == i.a;
    }

    public final void h() {
        while (this.j != i.a) {
            if (this.j == i.b) {
                throw new IllegalStateException("Previous csslayout was ignored! markLayoutSeen() never called");
            }
            this.j = i.a;
            if (this.h != null) {
                this = this.h;
            } else {
                return;
            }
        }
    }

    public final boolean f_() {
        return this.j == i.b;
    }

    private void a(StringBuilder stringBuilder, int i) {
        int i2 = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i3 = 0; i3 < i; i3++) {
            stringBuilder2.append("__");
        }
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(this.b.toString());
        stringBuilder.append(this.a_.toString());
        if (e() != 0) {
            stringBuilder.append(", children: [\n");
            while (i2 < e()) {
                a(i2).a(stringBuilder, i + 1);
                stringBuilder.append("\n");
                i2++;
            }
            stringBuilder.append(stringBuilder2 + "]");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder, 0);
        return stringBuilder.toString();
    }

    @NonNull
    public final r j() {
        return this.a_.j;
    }

    public final void a(int i, float f) {
        if (this.a_.j.a(i, f)) {
            h();
        }
    }

    @NonNull
    public final r k() {
        return this.a_.k;
    }

    public final void b(int i, float f) {
        if (this.a_.k.a(i, f)) {
            h();
        }
    }

    @NonNull
    public final r l() {
        return this.a_.l;
    }

    public final void c(int i, float f) {
        if (this.a_.l.a(i, f)) {
            h();
        }
    }

    public final void a(float f) {
        if (!o.a(this.a_.n[0], f)) {
            this.a_.n[0] = f;
            h();
        }
    }

    public final void b(float f) {
        if (!o.a(this.a_.n[1], f)) {
            this.a_.n[1] = f;
            h();
        }
    }

    public final float m() {
        return this.b.d[0];
    }

    public final float n() {
        return this.b.d[1];
    }

    public final float o() {
        return this.b.e[0];
    }

    public final void c(float f) {
        this.b.e[0] = f;
    }

    public final float p() {
        return this.b.e[1];
    }
}
