package com.airbnb.lottie;

import android.graphics.Rect;
import android.support.v4.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class k {
    final Map<String, List<bx>> a;
    final Map<String, bc> b;
    final e<bx> c;
    final List<bx> d;
    final Rect e;
    final long f;
    final float g;
    private final long h;
    private final int i;

    private k(Rect rect, long j, long j2, int i, float f) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new e();
        this.d = new ArrayList();
        this.e = rect;
        this.h = j;
        this.f = j2;
        this.i = i;
        this.g = f;
    }

    final bx a(long j) {
        return (bx) this.c.a(j);
    }

    public final long a() {
        return (long) ((((float) (this.f - this.h)) / ((float) this.i)) * 1000.0f);
    }

    final float b() {
        return (((float) a()) * ((float) this.i)) / 1000.0f;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        for (bx a : this.d) {
            stringBuilder.append(a.a("\t"));
        }
        return stringBuilder.toString();
    }
}
