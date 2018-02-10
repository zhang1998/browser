package com.taobao.weex.ui.view.border;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.mini.support.annotation.NonNull;

/* compiled from: ProGuard */
final class c {
    final int a;
    @NonNull
    private final a b;
    @NonNull
    private final a c;
    private final float d;

    c(@NonNull a aVar, @NonNull a aVar2, int i, float f) {
        this.b = aVar;
        this.c = aVar2;
        this.a = i;
        this.d = f;
    }

    final void a(@NonNull Canvas canvas, @NonNull Paint paint) {
        PointF e = this.b.e();
        paint.setStrokeWidth(this.d);
        a(canvas, paint, this.b, this.b.g(), this.b.h(), e);
        paint.setStrokeWidth(this.d);
        PointF b = this.c.b();
        canvas.drawLine(e.x, e.y, b.x, b.y, paint);
        a(canvas, paint, this.c, this.c.g() - 45.0f, b, this.c.i());
    }

    private static void a(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull a aVar, float f, @NonNull PointF pointF, @NonNull PointF pointF2) {
        if (aVar.a()) {
            boolean z;
            RectF j;
            if (!aVar.a() || aVar.b < 0.0f || aVar.c < 0.0f || aVar.a <= aVar.b || aVar.a <= aVar.c) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                j = aVar.j();
            } else {
                paint.setStrokeWidth(aVar.a);
                j = aVar.k();
            }
            canvas.drawArc(j, f, 45.0f, false, paint);
            return;
        }
        canvas.drawLine(pointF.x, pointF.y, pointF2.x, pointF2.y, paint);
    }
}
