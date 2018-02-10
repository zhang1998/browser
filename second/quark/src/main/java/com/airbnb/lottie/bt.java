package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.d.e;

/* compiled from: ProGuard */
public final class bt extends aa {
    private final e<LinearGradient> b = new e();
    private final e<RadialGradient> c = new e();
    private final RectF d = new RectF();
    private final int e;
    private final int f;
    private final cb<af> g;
    private final cb<PointF> h;
    private final cb<PointF> i;

    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        super.a(this.d, matrix);
        Shader shader;
        PointF pointF;
        PointF pointF2;
        af afVar;
        if (this.e == w.a) {
            Paint paint = this.a;
            int b = b();
            shader = (LinearGradient) this.b.a((long) b);
            if (shader == null) {
                pointF = (PointF) this.h.a();
                pointF2 = (PointF) this.i.a();
                afVar = (af) this.g.a();
                shader = new LinearGradient((float) ((int) ((this.d.left + (this.d.width() / 2.0f)) + pointF.x)), (float) ((int) (pointF.y + (this.d.top + (this.d.height() / 2.0f)))), (float) ((int) ((this.d.left + (this.d.width() / 2.0f)) + pointF2.x)), (float) ((int) ((this.d.top + (this.d.height() / 2.0f)) + pointF2.y)), afVar.b, afVar.a, TileMode.CLAMP);
                this.b.a((long) b, shader);
            }
            paint.setShader(shader);
        } else {
            Paint paint2 = this.a;
            int b2 = b();
            shader = (RadialGradient) this.c.a((long) b2);
            if (shader == null) {
                pointF = (PointF) this.h.a();
                pointF2 = (PointF) this.i.a();
                afVar = (af) this.g.a();
                int[] iArr = afVar.b;
                float[] fArr = afVar.a;
                int width = (int) ((this.d.left + (this.d.width() / 2.0f)) + pointF.x);
                int height = (int) (pointF.y + (this.d.top + (this.d.height() / 2.0f)));
                float f = (float) width;
                float f2 = (float) height;
                shader = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.d.left + (this.d.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) (pointF2.y + (this.d.top + (this.d.height() / 2.0f)))) - height)), iArr, fArr, TileMode.CLAMP);
                this.c.a((long) b2, shader);
            }
            paint2.setShader(shader);
        }
        super.a(canvas, matrix, i);
    }

    private int b() {
        int round = Math.round(this.h.c * ((float) this.f));
        return ((((round * 527) * 31) * Math.round(this.i.c * ((float) this.f))) * 31) * Math.round(this.g.c * ((float) this.f));
    }

    bt(cu cuVar, cz czVar, bw bwVar) {
        super(cuVar, czVar, bwVar.g.a(), bwVar.h.a(), bwVar.c, bwVar.f, bwVar.i, bwVar.j);
        this.e = bwVar.a;
        this.f = (int) (cuVar.b.a() / 32);
        this.g = bwVar.b.b();
        this.g.a((bq) this);
        czVar.a(this.g);
        this.h = bwVar.d.b();
        this.h.a((bq) this);
        czVar.a(this.h);
        this.i = bwVar.e.b();
        this.i.a((bq) this);
        czVar.a(this.i);
    }
}
