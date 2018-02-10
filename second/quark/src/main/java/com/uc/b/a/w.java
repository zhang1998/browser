package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/* compiled from: ProGuard */
public final class w extends c {
    private float[] c;

    public final /* bridge */ /* synthetic */ void a(s sVar) {
        super.a(sVar);
    }

    public final /* bridge */ /* synthetic */ void b(float f, b bVar, boolean z) {
        super.b(f, bVar, z);
    }

    public final /* bridge */ /* synthetic */ Matrix d() {
        return super.d();
    }

    public w(float f, float f2, float f3, float f4) {
        this.c = new float[]{f, f2, f3, f4};
    }

    private w(w wVar) {
        super(wVar);
        this.c = new float[wVar.c.length];
        System.arraycopy(wVar.c, 0, this.c, 0, this.c.length);
    }

    public final void a(Canvas canvas, Paint paint) {
        if (a(paint)) {
            canvas.drawLines(this.c, paint);
        }
    }

    public final void a(float f, b bVar, boolean z) {
        super.a(f, bVar, z);
        Matrix d = super.d();
        if (z && d != null) {
            bVar.a();
            bVar.a(super.d());
        }
        bVar.a.mapPoints(this.c);
        if (z && d != null) {
            bVar.b();
        }
    }

    public final void b() {
        this.b.set(this.c[0], this.c[1], this.c[2], this.c[3]);
    }

    protected final c a() {
        return new w(this);
    }
}
