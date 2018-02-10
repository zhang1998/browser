package com.airbnb.lottie;

import android.support.annotation.Nullable;
import java.util.List;
import java.util.Locale;

/* compiled from: ProGuard */
class bx {
    private static final String o = bx.class.getSimpleName();
    final List<Object> a;
    final String b;
    final long c;
    final cp d;
    final long e;
    @Nullable
    final String f;
    final List<j> g;
    final du h;
    final int i;
    final int j;
    final int k;
    final float l;
    final List<p<Float>> m;
    final int n;
    private final k p;
    private final float q;
    private final int r;
    private final int s;

    private bx(List<Object> list, k kVar, String str, long j, cp cpVar, long j2, @Nullable String str2, List<j> list2, du duVar, int i, int i2, int i3, float f, float f2, int i4, int i5, List<p<Float>> list3, int i6) {
        this.a = list;
        this.p = kVar;
        this.b = str;
        this.c = j;
        this.d = cpVar;
        this.e = j2;
        this.f = str2;
        this.g = list2;
        this.h = duVar;
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.q = f;
        this.l = f2;
        this.r = i4;
        this.s = i5;
        this.m = list3;
        this.n = i6;
    }

    public String toString() {
        return a("");
    }

    final String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append(this.b).append("\n");
        bx a = this.p.a(this.e);
        if (a != null) {
            stringBuilder.append("\t\tParents: ").append(a.b);
            a = this.p.a(a.e);
            while (a != null) {
                stringBuilder.append("->").append(a.b);
                a = this.p.a(a.e);
            }
            stringBuilder.append(str).append("\n");
        }
        if (!this.g.isEmpty()) {
            stringBuilder.append(str).append("\tMasks: ").append(this.g.size()).append("\n");
        }
        if (!(this.i == 0 || this.j == 0)) {
            stringBuilder.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k)}));
        }
        if (!this.a.isEmpty()) {
            stringBuilder.append(str).append("\tShapes:\n");
            for (Object append : this.a) {
                stringBuilder.append(str).append("\t\t").append(append).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
