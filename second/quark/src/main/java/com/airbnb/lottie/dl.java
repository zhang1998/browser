package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.d.e;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class dl implements bq, cx {
    private final e<LinearGradient> a = new e();
    private final e<RadialGradient> b = new e();
    private final Path c = new Path();
    private final Paint d = new Paint(1);
    private final RectF e = new RectF();
    private final List<bo> f = new ArrayList();
    private final int g;
    private final cb<af> h;
    private final cb<Integer> i;
    private final cb<PointF> j;
    private final cb<PointF> k;
    private final cu l;
    private final int m;

    dl(cu cuVar, cz czVar, az azVar) {
        this.l = cuVar;
        this.g = azVar.a;
        this.c.setFillType(azVar.b);
        this.m = (int) (cuVar.b.a() / 32);
        this.h = azVar.c.b();
        this.h.a((bq) this);
        czVar.a(this.h);
        this.i = azVar.d.b();
        this.i.a((bq) this);
        czVar.a(this.i);
        this.j = azVar.e.b();
        this.j.a((bq) this);
        czVar.a(this.j);
        this.k = azVar.f.b();
        this.k.a((bq) this);
        czVar.a(this.k);
    }

    public final void a() {
        this.l.invalidateSelf();
    }

    public final void a(List<de> list, List<de> list2) {
        for (int i = 0; i < list2.size(); i++) {
            de deVar = (de) list2.get(i);
            if (deVar instanceof bo) {
                this.f.add((bo) deVar);
            }
        }
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        this.c.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.c.addPath(((bo) this.f.get(i2)).b(), matrix);
        }
        this.c.computeBounds(this.e, false);
        Shader shader;
        PointF pointF;
        PointF pointF2;
        af afVar;
        if (this.g == w.a) {
            Paint paint = this.d;
            int b = b();
            shader = (LinearGradient) this.a.a((long) b);
            if (shader == null) {
                pointF = (PointF) this.j.a();
                pointF2 = (PointF) this.k.a();
                afVar = (af) this.h.a();
                shader = new LinearGradient((float) ((int) ((this.e.left + (this.e.width() / 2.0f)) + pointF.x)), (float) ((int) (pointF.y + (this.e.top + (this.e.height() / 2.0f)))), (float) ((int) ((this.e.left + (this.e.width() / 2.0f)) + pointF2.x)), (float) ((int) ((this.e.top + (this.e.height() / 2.0f)) + pointF2.y)), afVar.b, afVar.a, TileMode.CLAMP);
                this.a.a((long) b, shader);
            }
            paint.setShader(shader);
        } else {
            Paint paint2 = this.d;
            int b2 = b();
            shader = (RadialGradient) this.b.a((long) b2);
            if (shader == null) {
                pointF = (PointF) this.j.a();
                pointF2 = (PointF) this.k.a();
                afVar = (af) this.h.a();
                int[] iArr = afVar.b;
                float[] fArr = afVar.a;
                int width = (int) ((this.e.left + (this.e.width() / 2.0f)) + pointF.x);
                int height = (int) (pointF.y + (this.e.top + (this.e.height() / 2.0f)));
                float f = (float) width;
                float f2 = (float) height;
                shader = new RadialGradient(f, f2, (float) Math.hypot((double) (((int) ((this.e.left + (this.e.width() / 2.0f)) + pointF2.x)) - width), (double) (((int) (pointF2.y + (this.e.top + (this.e.height() / 2.0f)))) - height)), iArr, fArr, TileMode.CLAMP);
                this.b.a((long) b2, shader);
            }
            paint2.setShader(shader);
        }
        this.d.setAlpha((int) (((((float) ((Integer) this.i.a()).intValue()) * (((float) i) / 255.0f)) / 100.0f) * 255.0f));
        canvas.drawPath(this.c, this.d);
    }

    public final void a(RectF rectF, Matrix matrix) {
        this.c.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.c.addPath(((bo) this.f.get(i)).b(), matrix);
        }
        this.c.computeBounds(rectF, false);
        rectF.set(rectF.left - IPictureView.DEFAULT_MIN_SCALE, rectF.top - IPictureView.DEFAULT_MIN_SCALE, rectF.right + IPictureView.DEFAULT_MIN_SCALE, rectF.bottom + IPictureView.DEFAULT_MIN_SCALE);
    }

    private int b() {
        int round = Math.round(this.j.c * ((float) this.m));
        return ((((round * 527) * 31) * Math.round(this.k.c * ((float) this.m))) * 31) * Math.round(this.h.c * ((float) this.m));
    }
}
