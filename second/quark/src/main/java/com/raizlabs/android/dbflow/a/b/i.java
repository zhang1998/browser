package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;

/* compiled from: ProGuard */
public final class i implements f {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;

    @NonNull
    public static h a(String str) {
        h hVar = new h(str);
        hVar.d = false;
        hVar.f = false;
        return hVar;
    }

    private i(h hVar) {
        if (hVar.d) {
            this.a = e.b(hVar.a);
        } else {
            this.a = hVar.a;
        }
        this.d = hVar.h;
        if (hVar.e) {
            this.b = e.b(hVar.b);
        } else {
            this.b = hVar.b;
        }
        if (a.a(hVar.c)) {
            this.c = e.a(hVar.c);
        } else {
            this.c = null;
        }
        this.e = hVar.d;
        this.f = hVar.e;
        this.g = hVar.f;
        this.h = hVar.g;
    }

    private String c() {
        return (a.a(this.b) && this.h) ? e.a(this.b) : this.b;
    }

    private String d() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        if (a.a(this.c)) {
            str = this.c + ".";
        } else {
            str = "";
        }
        stringBuilder = stringBuilder.append(str);
        str = (a.a(this.a) && this.g) ? e.a(this.a) : this.a;
        return stringBuilder.append(str).toString();
    }

    public final String a() {
        if (a.a(this.b)) {
            return c();
        }
        if (a.a(this.a)) {
            return d();
        }
        return "";
    }

    public final String toString() {
        return b();
    }

    public final String b() {
        String d = d();
        if (a.a(this.b)) {
            d = d + " AS " + c();
        }
        if (a.a(this.d)) {
            return this.d + " " + d;
        }
        return d;
    }
}
