package com.c.a;

import android.content.Context;
import android.view.GestureDetector;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ProGuard */
public final class q {
    u a;
    List<x> b = new LinkedList();
    GestureDetector c;
    int d = 0;
    h e = new h();
    boolean f;
    float g;
    float h;
    float i;
    float j;
    float k;

    public q(Context context) {
        this.c = new GestureDetector(context, new e(this));
    }

    final void a(float f) {
        if (this.a != null) {
            this.a.a(f);
        }
        this.k = f;
    }

    final void a(float f, float f2, float f3, float f4) {
        h hVar = this.e;
        hVar.a = f;
        hVar.b = f2;
        hVar.c = f3;
        hVar.d = f4;
        hVar.e = b(f, f2, f3, f4);
        hVar.f = hVar.g;
    }

    static float b(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
    }

    public final void a(x xVar) {
        if (xVar != null) {
            this.b.add(xVar);
        }
    }
}
