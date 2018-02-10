package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;

/* compiled from: ProGuard */
final class cm extends aa {
    private final cb<Integer> b;

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.a.setColor(((Integer) this.b.a()).intValue());
        super.a(canvas, matrix, i);
    }

    cm(cu cuVar, cz czVar, bj bjVar) {
        super(cuVar, czVar, bjVar.f.a(), bjVar.g.a(), bjVar.d, bjVar.e, bjVar.b, bjVar.a);
        this.b = bjVar.c.b();
        this.b.a((bq) this);
        czVar.a(this.b);
    }
}
