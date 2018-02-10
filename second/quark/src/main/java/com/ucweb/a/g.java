package com.ucweb.a;

/* compiled from: ProGuard */
public final class g {
    public String a;
    public String b;
    final /* synthetic */ h c;

    public g(h hVar, String str, String str2) {
        this.c = hVar;
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return this.a.equals(((g) obj).a);
    }

    public final String toString() {
        return "ComponentBean{componentName='" + this.a + '\'' + ", componentVersionName='" + this.b + '\'' + '}';
    }
}
