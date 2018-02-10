package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
abstract class cz implements bq, cx {
    final Matrix a = new Matrix();
    final cu b;
    final bx c;
    @Nullable
    cz d;
    @Nullable
    cz e;
    final cj f;
    private final Path g = new Path();
    private final Matrix h = new Matrix();
    private final Paint i = new Paint(1);
    private final Paint j = new Paint(1);
    private final Paint k = new Paint(1);
    private final Paint l = new Paint();
    private final RectF m = new RectF();
    private final RectF n = new RectF();
    private final RectF o = new RectF();
    private final RectF p = new RectF();
    @Nullable
    private dc q;
    private List<cz> r;
    private final List<bl<?, ?>> s = new ArrayList();
    private boolean t = true;

    abstract void a_(Canvas canvas, Matrix matrix, int i);

    cz(cu cuVar, bx bxVar) {
        this.b = cuVar;
        this.c = bxVar;
        this.l.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.j.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        if (bxVar.n == br.c) {
            this.k.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        } else {
            this.k.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        }
        this.f = bxVar.h.a();
        this.f.a((bq) this);
        this.f.a(this);
        if (!(bxVar.g == null || bxVar.g.isEmpty())) {
            this.q = new dc(bxVar.g);
            for (bl blVar : this.q.a) {
                a(blVar);
                blVar.a((bq) this);
            }
        }
        if (this.c.m.isEmpty()) {
            a(true);
            return;
        }
        bl bsVar = new bs(this.c.m);
        bsVar.b = true;
        bsVar.a(new aj(this, bsVar));
        a(((Float) bsVar.a()).floatValue() == IPictureView.DEFAULT_MIN_SCALE);
        a(bsVar);
    }

    private boolean b() {
        return this.d != null;
    }

    final void a(bl<?, ?> blVar) {
        if (!(blVar instanceof ai)) {
            this.s.add(blVar);
        }
    }

    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.a.set(matrix);
        this.a.preConcat(this.f.a());
    }

    public final void a(Canvas canvas, Matrix matrix, int i) {
        if (this.t) {
            if (this.r == null) {
                if (this.e == null) {
                    this.r = Collections.emptyList();
                } else {
                    this.r = new ArrayList();
                    for (cz czVar = this.e; czVar != null; czVar = czVar.e) {
                        this.r.add(czVar);
                    }
                }
            }
            this.h.reset();
            this.h.set(matrix);
            for (int size = this.r.size() - 1; size >= 0; size--) {
                this.h.preConcat(((cz) this.r.get(size)).f.a());
            }
            int intValue = (int) (((((float) ((Integer) this.f.a.a()).intValue()) * (((float) i) / 255.0f)) / 100.0f) * 255.0f);
            if (b() || c()) {
                this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
                a(this.m, this.h);
                RectF rectF = this.m;
                Matrix matrix2 = this.h;
                if (b() && this.c.n != br.c) {
                    this.d.a(this.o, matrix2);
                    rectF.set(Math.max(rectF.left, this.o.left), Math.max(rectF.top, this.o.top), Math.min(rectF.right, this.o.right), Math.min(rectF.bottom, this.o.bottom));
                }
                this.h.preConcat(this.f.a());
                b(this.m, this.h);
                this.m.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
                canvas.saveLayer(this.m, this.i, 31);
                a(canvas);
                a_(canvas, this.h, intValue);
                if (c()) {
                    a(canvas, this.h);
                }
                if (b()) {
                    canvas.saveLayer(this.m, this.k, 19);
                    a(canvas);
                    this.d.a(canvas, matrix, intValue);
                    canvas.restore();
                }
                canvas.restore();
                return;
            }
            this.h.preConcat(this.f.a());
            a_(canvas, this.h, intValue);
        }
    }

    private void a(Canvas canvas) {
        canvas.drawRect(this.m.left - IPictureView.DEFAULT_MIN_SCALE, this.m.top - IPictureView.DEFAULT_MIN_SCALE, this.m.right + IPictureView.DEFAULT_MIN_SCALE, IPictureView.DEFAULT_MIN_SCALE + this.m.bottom, this.l);
    }

    private void b(RectF rectF, Matrix matrix) {
        this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (c()) {
            int size = this.q.b.size();
            int i = 0;
            while (i < size) {
                j jVar = (j) this.q.b.get(i);
                this.g.set((Path) ((bl) this.q.a.get(i)).a());
                this.g.transform(matrix);
                switch (bf.b[jVar.a - 1]) {
                    case 1:
                        return;
                    default:
                        this.g.computeBounds(this.p, false);
                        if (i == 0) {
                            this.n.set(this.p);
                        } else {
                            this.n.set(Math.min(this.n.left, this.p.left), Math.min(this.n.top, this.p.top), Math.max(this.n.right, this.p.right), Math.max(this.n.bottom, this.p.bottom));
                        }
                        i++;
                }
            }
            rectF.set(Math.max(rectF.left, this.n.left), Math.max(rectF.top, this.n.top), Math.min(rectF.right, this.n.right), Math.min(rectF.bottom, this.n.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        canvas.saveLayer(this.m, this.j, 19);
        a(canvas);
        int size = this.q.b.size();
        for (int i = 0; i < size; i++) {
            j jVar = (j) this.q.b.get(i);
            this.g.set((Path) ((bl) this.q.a.get(i)).a());
            this.g.transform(matrix);
            switch (bf.b[jVar.a - 1]) {
                case 1:
                    this.g.setFillType(FillType.INVERSE_WINDING);
                    break;
                default:
                    this.g.setFillType(FillType.WINDING);
                    break;
            }
            canvas.drawPath(this.g, this.i);
        }
        canvas.restore();
    }

    private boolean c() {
        return (this.q == null || this.q.a.isEmpty()) ? false : true;
    }

    final void a(boolean z) {
        if (z != this.t) {
            this.t = z;
            this.b.invalidateSelf();
        }
    }

    void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.d != null) {
            this.d.a(f);
        }
        for (int i = 0; i < this.s.size(); i++) {
            ((bl) this.s.get(i)).a(f);
        }
    }

    public final void a(List<de> list, List<de> list2) {
    }

    public final void a() {
        this.b.invalidateSelf();
    }
}
