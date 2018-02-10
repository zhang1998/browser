package com.ucpro.ui.d;

import java.util.concurrent.Callable;

/* compiled from: ProGuard */
final class e implements Callable<Void> {
    int[] a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;

    e(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = iArr;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
    }

    public final /* synthetic */ Object call() throws Exception {
        a.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        return null;
    }
}
