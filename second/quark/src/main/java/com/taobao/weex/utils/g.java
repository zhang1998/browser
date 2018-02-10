package com.taobao.weex.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

/* compiled from: ProGuard */
public final class g extends RectShape {
    final /* synthetic */ h a;
    private float[] b;
    private RectF c;
    private float[] d;
    private RectF e;
    private Path f;

    public final /* synthetic */ RectShape clone() throws CloneNotSupportedException {
        return a();
    }

    public final /* synthetic */ Shape m3clone() throws CloneNotSupportedException {
        return a();
    }

    public final /* synthetic */ Object m4clone() throws CloneNotSupportedException {
        return a();
    }

    public g(h hVar, float[] fArr) {
        this.a = hVar;
        if (fArr == null || fArr.length >= 8) {
            this.b = fArr;
            this.c = null;
            this.d = null;
            this.f = new Path();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
    }

    public final void draw(Canvas canvas, Paint paint) {
        canvas.drawPath(this.f, paint);
    }

    protected final void onResize(float f, float f2) {
        super.onResize(f, f2);
        RectF rect = rect();
        this.f.reset();
        if (this.b != null) {
            this.f.addRoundRect(rect, this.b, Direction.CW);
        } else {
            this.f.addRect(rect, Direction.CW);
        }
        if (this.e != null) {
            this.e.set(rect.left + this.c.left, rect.top + this.c.top, rect.right - this.c.right, rect.bottom - this.c.bottom);
            if (this.e.width() < f && this.e.height() < f2) {
                if (this.d != null) {
                    this.f.addRoundRect(this.e, this.d, Direction.CCW);
                } else {
                    this.f.addRect(this.e, Direction.CCW);
                }
            }
        }
    }

    private g a() throws CloneNotSupportedException {
        float[] fArr;
        g gVar = (g) super.clone();
        gVar.b = this.b != null ? (float[]) this.b.clone() : null;
        if (this.d != null) {
            fArr = (float[]) this.d.clone();
        } else {
            fArr = null;
        }
        gVar.d = fArr;
        if (this.c != null) {
            gVar.c = new RectF(this.c);
        }
        if (gVar.e != null) {
            gVar.e = new RectF(this.e);
        }
        gVar.f = new Path(this.f);
        return gVar;
    }
}
