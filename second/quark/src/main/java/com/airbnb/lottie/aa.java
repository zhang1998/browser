package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
abstract class aa implements bq, cx {
    final Paint a = new Paint(1);
    private final PathMeasure b = new PathMeasure();
    private final Path c = new Path();
    private final Path d = new Path();
    private final RectF e = new RectF();
    private final cu f;
    private final List<do> g = new ArrayList();
    private final float[] h;
    private final bl<?, Float> i;
    private final bl<?, Integer> j;
    private final List<bl<?, Float>> k;
    @Nullable
    private final bl<?, Float> l;

    aa(cu cuVar, cz czVar, Cap cap, Join join, dt dtVar, cs csVar, List<cs> list, cs csVar2) {
        int i;
        int i2 = 0;
        this.f = cuVar;
        this.a.setStyle(Style.STROKE);
        this.a.setStrokeCap(cap);
        this.a.setStrokeJoin(join);
        this.j = dtVar.b();
        this.i = csVar.b();
        if (csVar2 == null) {
            this.l = null;
        } else {
            this.l = csVar2.b();
        }
        this.k = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (i = 0; i < list.size(); i++) {
            this.k.add(((cs) list.get(i)).b());
        }
        czVar.a(this.j);
        czVar.a(this.i);
        for (i = 0; i < this.k.size(); i++) {
            czVar.a((bl) this.k.get(i));
        }
        if (this.l != null) {
            czVar.a(this.l);
        }
        this.j.a((bq) this);
        this.i.a((bq) this);
        while (i2 < list.size()) {
            ((bl) this.k.get(i2)).a((bq) this);
            i2++;
        }
        if (this.l != null) {
            this.l.a((bq) this);
        }
    }

    public void a() {
        this.f.invalidateSelf();
    }

    public void a(List<de> list, List<de> list2) {
        do doVar = null;
        int size = list.size() - 1;
        bu buVar = null;
        while (size >= 0) {
            bu buVar2;
            de deVar = (de) list.get(size);
            if ((deVar instanceof bu) && ((bu) deVar).a == o.b) {
                buVar2 = (bu) deVar;
            } else {
                buVar2 = buVar;
            }
            size--;
            buVar = buVar2;
        }
        if (buVar != null) {
            buVar.a(this);
        }
        size = list2.size() - 1;
        while (size >= 0) {
            do doVar2;
            deVar = (de) list2.get(size);
            if ((deVar instanceof bu) && ((bu) deVar).a == o.b) {
                if (doVar != null) {
                    this.g.add(doVar);
                }
                doVar = new do((bu) deVar);
                ((bu) deVar).a(this);
                doVar2 = doVar;
            } else if (deVar instanceof bo) {
                if (doVar == null) {
                    doVar2 = new do(buVar);
                } else {
                    doVar2 = doVar;
                }
                doVar2.a.add((bo) deVar);
            } else {
                doVar2 = doVar;
            }
            size--;
            doVar = doVar2;
        }
        this.g.add(doVar);
    }

    public void a(Canvas canvas, Matrix matrix, int i) {
        int i2 = 0;
        this.a.setAlpha((int) (((((float) ((Integer) this.j.a()).intValue()) * (((float) i) / 255.0f)) / 100.0f) * 255.0f));
        this.a.setStrokeWidth(((Float) this.i.a()).floatValue() * dn.a(matrix));
        if (this.a.getStrokeWidth() > 0.0f) {
            if (!this.k.isEmpty()) {
                float f;
                float f2 = this.f.e;
                for (int i3 = 0; i3 < this.k.size(); i3++) {
                    this.h[i3] = ((Float) ((bl) this.k.get(i3)).a()).floatValue();
                    if (i3 % 2 == 0) {
                        if (this.h[i3] < IPictureView.DEFAULT_MIN_SCALE) {
                            this.h[i3] = IPictureView.DEFAULT_MIN_SCALE;
                        }
                    } else if (this.h[i3] < 0.1f) {
                        this.h[i3] = 0.1f;
                    }
                    float[] fArr = this.h;
                    fArr[i3] = fArr[i3] * f2;
                }
                if (this.l == null) {
                    f = 0.0f;
                } else {
                    f = ((Float) this.l.a()).floatValue();
                }
                this.a.setPathEffect(new DashPathEffect(this.h, f));
            }
            while (i2 < this.g.size()) {
                do doVar = (do) this.g.get(i2);
                if (doVar.b != null) {
                    a(canvas, doVar, matrix);
                } else {
                    this.c.reset();
                    for (int size = doVar.a.size() - 1; size >= 0; size--) {
                        this.c.addPath(((bo) doVar.a.get(size)).b(), matrix);
                    }
                    canvas.drawPath(this.c, this.a);
                }
                i2++;
            }
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        this.c.reset();
        for (int i = 0; i < this.g.size(); i++) {
            do doVar = (do) this.g.get(i);
            for (int i2 = 0; i2 < doVar.a.size(); i2++) {
                this.c.addPath(((bo) doVar.a.get(i)).b(), matrix);
            }
        }
        this.c.computeBounds(this.e, false);
        float floatValue = ((Float) this.i.a()).floatValue();
        this.e.set(this.e.left - (floatValue / 2.0f), this.e.top - (floatValue / 2.0f), this.e.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.e.bottom);
        rectF.set(this.e);
        rectF.set(rectF.left - IPictureView.DEFAULT_MIN_SCALE, rectF.top - IPictureView.DEFAULT_MIN_SCALE, rectF.right + IPictureView.DEFAULT_MIN_SCALE, rectF.bottom + IPictureView.DEFAULT_MIN_SCALE);
    }

    private void a(Canvas canvas, do doVar, Matrix matrix) {
        if (doVar.b != null) {
            this.c.reset();
            for (int size = doVar.a.size() - 1; size >= 0; size--) {
                this.c.addPath(((bo) doVar.a.get(size)).b(), matrix);
            }
            this.b.setPath(this.c, false);
            float length = this.b.getLength();
            while (this.b.nextContour()) {
                length = this.b.getLength() + length;
            }
            float floatValue = (((Float) doVar.b.d.a()).floatValue() * length) / 360.0f;
            float floatValue2 = ((((Float) doVar.b.b.a()).floatValue() * length) / 100.0f) + floatValue;
            float floatValue3 = ((((Float) doVar.b.c.a()).floatValue() * length) / 100.0f) + floatValue;
            int size2 = doVar.a.size() - 1;
            float f = 0.0f;
            while (size2 >= 0) {
                float f2;
                this.d.set(((bo) doVar.a.get(size2)).b());
                this.d.transform(matrix);
                this.b.setPath(this.d, false);
                float length2 = this.b.getLength();
                if (floatValue3 <= length || floatValue3 - length >= f + length2 || f >= floatValue3 - length) {
                    if (f + length2 >= floatValue2 && f <= floatValue3) {
                        if (f + length2 > floatValue3 || floatValue2 >= f) {
                            if (floatValue2 < f) {
                                floatValue = 0.0f;
                            } else {
                                floatValue = (floatValue2 - f) / length2;
                            }
                            if (floatValue3 > f + length2) {
                                f2 = IPictureView.DEFAULT_MIN_SCALE;
                            } else {
                                f2 = (floatValue3 - f) / length2;
                            }
                        } else {
                            canvas.drawPath(this.d, this.a);
                        }
                    }
                    size2--;
                    f += length2;
                } else {
                    if (floatValue2 > length) {
                        f2 = (floatValue2 - length) / length2;
                    } else {
                        f2 = 0.0f;
                    }
                    floatValue = f2;
                    f2 = Math.min((floatValue3 - length) / length2, IPictureView.DEFAULT_MIN_SCALE);
                }
                dn.a(this.d, floatValue, f2, 0.0f);
                canvas.drawPath(this.d, this.a);
                size2--;
                f += length2;
            }
        }
    }
}
