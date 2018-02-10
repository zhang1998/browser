package com.uc.b.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
abstract class c extends g {
    final s a;
    RectF b;

    protected abstract c a();

    abstract void a(Canvas canvas, Paint paint);

    public abstract void b();

    public c() {
        super();
        this.b = new RectF();
        this.a = new s();
    }

    public c(c cVar) {
        super();
        this.b = new RectF(cVar.b);
        this.a = new s(cVar.a);
    }

    public void a(float f, b bVar, boolean z) {
        s sVar = this.a;
        if (z) {
            sVar.f = f;
        } else {
            sVar.f = af.a;
            sVar.f *= f;
        }
        sVar.g = (p.STROKE_WIDTH.a(sVar.d) ? sVar.c.c : IPictureView.DEFAULT_MIN_SCALE) * sVar.f;
        sVar.h = (p.STROKE_MITER_LIMIT.a(sVar.d) ? sVar.c.f : 4.0f) * sVar.f;
    }

    final void a(float f, float f2) {
        a(f, f2, f, f2);
    }

    final void a(float f, float f2, float f3, float f4) {
        if (this.b.left > f) {
            this.b.left = f;
        }
        if (this.b.top > f2) {
            this.b.top = f2;
        }
        if (this.b.right < f3) {
            this.b.right = f3;
        }
        if (this.b.bottom < f4) {
            this.b.bottom = f4;
        }
    }

    public void b(float f, b bVar, boolean z) {
        a(f, bVar, z);
        b();
    }

    public final void a(p pVar, Object... objArr) {
        s sVar = this.a;
        if (pVar.ordinal() > p.FILL_FILTER.ordinal()) {
            int i = 1;
        } else {
            byte b = (byte) 0;
        }
        if (i != 0 && sVar.c == null) {
            sVar.c = new r();
        }
        switch (s.a()[pVar.ordinal()]) {
            case 1:
                sVar.a = ((Integer) objArr[0]).intValue();
                break;
            case 2:
                if (!(objArr[0] instanceof Integer)) {
                    sVar.b.d = (f) objArr[0];
                    break;
                }
                sVar.b.a = ((Integer) objArr[0]).intValue();
                break;
            case 3:
                sVar.b.c = ((h) objArr[0]).d;
                break;
            case 4:
                sVar.b.b = ((Integer) objArr[0]).intValue();
                break;
            case 6:
                sVar.c.a = ((Integer) objArr[0]).intValue();
                break;
            case 7:
                sVar.c.b = ((Integer) objArr[0]).intValue();
                break;
            case 8:
                sVar.c.c = ((Float) objArr[0]).floatValue();
                break;
            case 9:
                sVar.c.d = ((i) objArr[0]).d;
                break;
            case 10:
                sVar.c.e = ((j) objArr[0]).d;
                break;
            case 11:
                sVar.c.f = ((Float) objArr[0]).floatValue();
                break;
            case 12:
                sVar.c.g = new float[1];
                for (int i2 = 0; i2 <= 0; i2++) {
                    sVar.c.g[0] = ((Float) objArr[0]).floatValue();
                }
                break;
            case 13:
                sVar.c.h = ((Float) objArr[0]).floatValue();
                break;
            default:
                return;
        }
        sVar.d |= pVar.n;
    }

    public final boolean a(Paint paint) {
        s sVar = this.a;
        if (sVar == null) {
            return false;
        }
        s sVar2;
        boolean z;
        for (sVar2 = sVar; sVar2.c == null; sVar2 = sVar2.e) {
            if (sVar2.e == null) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            int i;
            sVar2 = sVar;
            while (!p.STROKE.a(sVar2.d)) {
                if (sVar2.e == null) {
                    i = 0;
                    break;
                }
                sVar2 = sVar2.e;
            }
            i = sVar2.c.a;
            int i2 = (sVar.c.b * sVar.a) / 255;
            if (!(i == 0 && i2 == 0)) {
                Cap cap;
                Join join;
                float f;
                paint.setStyle(Style.STROKE);
                s sVar3 = sVar;
                while (!p.STROKE_WIDTH.a(sVar3.d) && sVar3.e != null) {
                    sVar3 = sVar3.e;
                }
                paint.setStrokeWidth(sVar3.g);
                sVar3 = sVar;
                while (!p.STROKE_LINE_CAP.a(sVar3.d)) {
                    if (sVar3.e == null) {
                        cap = Cap.BUTT;
                        break;
                    }
                    sVar3 = sVar3.e;
                }
                cap = sVar3.c.d;
                paint.setStrokeCap(cap);
                sVar3 = sVar;
                while (!p.STROKE_LINE_JOIN.a(sVar3.d)) {
                    if (sVar3.e == null) {
                        join = Join.MITER;
                        break;
                    }
                    sVar3 = sVar3.e;
                }
                join = sVar3.c.e;
                paint.setStrokeJoin(join);
                while (!p.STROKE_MITER_LIMIT.a(sVar.d)) {
                    if (sVar.e == null) {
                        f = sVar.h;
                        break;
                    }
                    sVar = sVar.e;
                }
                f = sVar.c.f;
                paint.setStrokeMiter(f);
                paint.setColor(i);
                paint.setAlpha(i2);
                paint.setShader(null);
                z = true;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    public void a(s sVar) {
        s sVar2 = this.a;
        if (sVar2 != null) {
            if (!(this.b == null || sVar2.b.d == null)) {
                sVar2.b.e = sVar2.b.d.a();
            }
            if (sVar2.c != null && sVar2.c.i == null && sVar2.c.g != null) {
                DashPathEffect dashPathEffect;
                r rVar = sVar2.c;
                float[] fArr = sVar2.c.g;
                float f = sVar2.c.h;
                int length = fArr.length;
                int i = length % 2 == 0 ? length : length * 2;
                float[] fArr2 = new float[i];
                float f2 = 0.0f;
                for (int i2 = 0; i2 < i; i2++) {
                    fArr2[i2] = fArr[i2 % length];
                    f2 += fArr2[i2];
                }
                if (f2 > 0.0f) {
                    float f3;
                    if (f < 0.0f) {
                        f3 = (f % f2) + f2;
                    } else {
                        f3 = f;
                    }
                    dashPathEffect = new DashPathEffect(fArr2, f3);
                } else {
                    dashPathEffect = null;
                }
                rVar.i = dashPathEffect;
            }
        }
    }
}
