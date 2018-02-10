package com.uc.b.a;

import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: ProGuard */
final class ab extends v {
    ae e;

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public ab(float f, float f2) {
        this(0.0f, 0.0f, f, f2);
    }

    public ab(float f, float f2, float f3, float f4) {
        a(f, f2, f + f3, f2 + f4);
    }

    private ab(ab abVar) {
        super(abVar);
        this.e = abVar.e;
    }

    public final Matrix d() {
        if (this.e == null) {
            return super.d();
        }
        ae aeVar = this.e;
        RectF rectF = this.b;
        if (aeVar.e == null) {
            aeVar.e = new Matrix();
        } else {
            aeVar.e.reset();
        }
        if (rectF == null || aeVar.f == null || aeVar.f.j == null) {
            return aeVar.e;
        }
        Object obj;
        float width = rectF.width() / aeVar.c;
        float height = rectF.height() / aeVar.d;
        float f = -aeVar.a;
        float f2 = -aeVar.b;
        m mVar = aeVar.f;
        m mVar2 = m.b;
        if (mVar == mVar2 || (mVar2 != null && mVar.j == mVar2.j && mVar.k == mVar2.k)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            aeVar.e.preTranslate(rectF.left, rectF.top);
            aeVar.e.preScale(width, height);
            aeVar.e.preTranslate(f, f2);
            return aeVar.e;
        }
        float max;
        if (aeVar.f.k == l.SLICE) {
            max = Math.max(width, height);
        } else {
            max = Math.min(width, height);
        }
        width = rectF.width() / max;
        height = rectF.height() / max;
        k kVar = aeVar.f.j;
        switch (ae.a()[kVar.ordinal()]) {
            case 3:
            case 6:
            case 9:
                f -= (aeVar.c - width) / 2.0f;
                break;
            case 4:
            case 7:
            case 10:
                f -= aeVar.c - width;
                break;
        }
        switch (ae.a()[kVar.ordinal()]) {
            case 5:
            case 6:
            case 7:
                f2 -= (aeVar.d - height) / 2.0f;
                break;
            case 8:
            case 9:
            case 10:
                f2 -= aeVar.d - height;
                break;
        }
        aeVar.e.preTranslate(rectF.left, rectF.top);
        aeVar.e.preScale(max, max);
        aeVar.e.preTranslate(f, f2);
        return aeVar.e;
    }

    public final ab c() {
        return new ab(this);
    }
}
