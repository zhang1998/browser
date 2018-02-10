package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;

/* compiled from: ProGuard */
class d extends c {
    protected Path c = new Path();

    private d(d dVar) {
        super(dVar);
        this.c.set(dVar.c);
    }

    public void a(float f, b bVar, boolean z) {
        super.a(f, bVar, z);
        Matrix d = d();
        if (z && d != null) {
            bVar.a();
            bVar.a(d());
        }
        this.c.transform(bVar.a);
        if (z && d != null) {
            bVar.b();
        }
    }

    public void b() {
        RectF rectF = new RectF();
        this.c.computeBounds(rectF, false);
        this.b.set(rectF);
    }

    public void a(Canvas canvas, Paint paint) {
        Object obj;
        FillType fillType = this.c.getFillType();
        s sVar = this.a;
        if (sVar != null) {
            fillType = sVar.b.c;
        }
        if (this.c.getFillType() != fillType) {
            this.c.setFillType(fillType);
        }
        sVar = this.a;
        if (sVar != null) {
            if (sVar.b.e != null) {
                paint.setShader(sVar.b.e);
            } else {
                int i;
                s sVar2 = sVar;
                while (!p.FILL.a(sVar2.d)) {
                    if (sVar2.e == null) {
                        i = -16777216;
                        break;
                    }
                    sVar2 = sVar2.e;
                }
                i = sVar2.b.a;
                int i2 = (sVar.a * sVar.b.b) / 255;
                if (i == 0 || i2 == 0) {
                    obj = null;
                    if (obj != null) {
                        obj = 1;
                        if (obj != null) {
                            canvas.drawPath(this.c, paint);
                        }
                        if (!a(paint)) {
                            canvas.drawPath(this.c, paint);
                        }
                    }
                }
                paint.setShader(null);
                paint.setColor(i);
                paint.setAlpha(i2);
            }
            paint.setStyle(Style.FILL);
            obj = 1;
            if (obj != null) {
                obj = 1;
                if (obj != null) {
                    canvas.drawPath(this.c, paint);
                }
                if (!a(paint)) {
                    canvas.drawPath(this.c, paint);
                }
            }
        }
        obj = null;
        if (obj != null) {
            canvas.drawPath(this.c, paint);
        }
        if (!a(paint)) {
            canvas.drawPath(this.c, paint);
        }
    }

    protected final c a() {
        return new d(this);
    }
}
