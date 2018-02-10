package com.uc.base.wa.component;

/* compiled from: ProGuard */
public final class f {
    String a;
    Object b;
    int c;

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.c == fVar.c && ((this.a == null && fVar.a == null) || !(this.a == null || fVar.a == null || !this.a.equals(fVar.a)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.c + "_" + this.a).hashCode();
    }
}
