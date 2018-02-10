package com.uc.base.wa.component;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class b {
    f a = new f();
    int b;
    boolean c = false;
    ArrayList<d> d = new ArrayList();

    public b(String str, Object obj, int i, int i2, List<d> list) {
        this.a.a = str;
        this.a.b = obj;
        this.a.c = i;
        this.b = i2;
        if (list != null && list.size() > 0) {
            this.d.addAll(list);
        }
    }

    public b(String str, Object obj) {
        this.a.a = str;
        this.a.b = obj;
        this.a.c = 4;
        this.b = 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.b == bVar.b && ((this.a == null && bVar.a == null) || !(this.a == null || bVar.a == null || !this.a.equals(bVar.a)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.b + "_" + (this.a != null ? this.a.c + "_" + this.a.a : "null")).hashCode();
    }
}
