package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import java.util.Collections;

/* compiled from: ProGuard */
final class aq extends cz {
    private final Matrix g = new Matrix();
    private final au h;

    aq(cu cuVar, bx bxVar) {
        super(cuVar, bxVar);
        this.h = new au(cuVar, this, new db(bxVar.b, bxVar.a));
        this.h.a(Collections.emptyList(), Collections.emptyList());
    }

    final void a_(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.h.a(canvas, matrix, i);
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.h.a(rectF, this.a);
    }
}
