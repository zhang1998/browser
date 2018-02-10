package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

/* compiled from: ProGuard */
final class i extends cz {
    private final RectF g = new RectF();
    private final Paint h = new Paint();
    private final bx i;

    i(cu cuVar, bx bxVar) {
        super(cuVar, bxVar);
        this.i = bxVar;
        this.h.setAlpha(0);
        this.h.setStyle(Style.FILL);
        this.h.setColor(bxVar.k);
    }

    public final void a_(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.i.k);
        if (alpha != 0) {
            alpha = (int) (((((float) ((Integer) this.f.a.a()).intValue()) * (((float) alpha) / 255.0f)) / 100.0f) * 255.0f);
            this.h.setAlpha(alpha);
            if (alpha > 0) {
                a(matrix);
                canvas.drawRect(this.g, this.h);
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        a(this.a);
        rectF.set(this.g);
    }

    private void a(Matrix matrix) {
        this.g.set(0.0f, 0.0f, (float) this.i.i, (float) this.i.j);
        matrix.mapRect(this.g);
    }
}
