package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/* compiled from: ProGuard */
final class aw extends cz {
    private final Paint g = new Paint(3);
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final float j;

    aw(cu cuVar, bx bxVar, float f) {
        super(cuVar, bxVar);
        this.j = f;
    }

    public final void a_(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap b = b();
        if (b != null && !b.isRecycled()) {
            this.g.setAlpha(i);
            canvas.save();
            canvas.concat(matrix);
            this.h.set(0, 0, b.getWidth(), b.getHeight());
            this.i.set(0, 0, (int) (((float) b.getWidth()) * this.j), (int) (((float) b.getHeight()) * this.j));
            canvas.drawBitmap(b, this.h, this.i, this.g);
            canvas.restore();
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        Bitmap b = b();
        if (b != null) {
            rectF.set(rectF.left, rectF.top, Math.min(rectF.right, (float) b.getWidth()), Math.min(rectF.bottom, (float) b.getHeight()));
            this.a.mapRect(rectF);
        }
    }

    @Nullable
    private Bitmap b() {
        String str = this.c.f;
        cu cuVar = this.b;
        if (cuVar.g != null) {
            Object obj;
            cq cqVar = cuVar.g;
            Callback callback = cuVar.getCallback();
            if (callback == null || !(callback instanceof View)) {
                obj = null;
            } else {
                obj = ((View) callback).getContext();
            }
            if (!(obj == null && cqVar.a == null) && (obj == null || !cqVar.a.equals(obj))) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                cuVar.g.a();
                cuVar.g = null;
            }
        }
        if (cuVar.g == null) {
            cuVar.g = new cq(cuVar.getCallback(), cuVar.h, cuVar.i, cuVar.b.b);
        }
        return cuVar.g.a(str);
    }
}
