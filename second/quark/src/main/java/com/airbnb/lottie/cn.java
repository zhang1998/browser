package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.v4.d.e;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class cn extends cz {
    private final List<cz> g = new ArrayList();
    private final RectF h = new RectF();

    cn(cu cuVar, bx bxVar, List<bx> list, k kVar) {
        super(cuVar, bxVar);
        e eVar = new e(kVar.d.size());
        int size = list.size() - 1;
        cz czVar = null;
        while (size >= 0) {
            cz aqVar;
            cz czVar2;
            bx bxVar2 = (bx) list.get(size);
            switch (bf.a[bxVar2.d.ordinal()]) {
                case 1:
                    aqVar = new aq(cuVar, bxVar2);
                    break;
                case 2:
                    aqVar = new cn(cuVar, bxVar2, (List) kVar.a.get(bxVar2.f), kVar);
                    break;
                case 3:
                    aqVar = new i(cuVar, bxVar2);
                    break;
                case 4:
                    aqVar = new aw(cuVar, bxVar2, kVar.g);
                    break;
                case 5:
                    aqVar = new da(cuVar, bxVar2);
                    break;
                default:
                    Log.w("LOTTIE", "Unknown layer type " + bxVar2.d);
                    aqVar = new da(cuVar, bxVar2);
                    break;
            }
            eVar.a(aqVar.c.c, aqVar);
            if (czVar == null) {
                this.g.add(0, aqVar);
                switch (q.a[bxVar2.n - 1]) {
                    case 1:
                    case 2:
                        czVar2 = aqVar;
                        break;
                    default:
                        czVar2 = czVar;
                        break;
                }
            }
            czVar.d = aqVar;
            czVar2 = null;
            size--;
            czVar = czVar2;
        }
        for (int i = 0; i < eVar.a(); i++) {
            czVar2 = (cz) eVar.a(eVar.a(i));
            aqVar = (cz) eVar.a(czVar2.c.e);
            if (aqVar != null) {
                czVar2.e = aqVar;
            }
        }
    }

    final void a_(Canvas canvas, Matrix matrix, int i) {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            ((cz) this.g.get(size)).a(canvas, matrix, i);
        }
    }

    public final void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.g.size() - 1; size >= 0; size--) {
            ((cz) this.g.get(size)).a(this.h, this.a);
            if (rectF.isEmpty()) {
                rectF.set(this.h);
            } else {
                rectF.set(Math.min(rectF.left, this.h.left), Math.min(rectF.top, this.h.top), Math.max(rectF.right, this.h.right), Math.max(rectF.bottom, this.h.bottom));
            }
        }
    }

    public final void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.a(f);
        float f2 = f - this.c.l;
        for (int size = this.g.size() - 1; size >= 0; size--) {
            ((cz) this.g.get(size)).a(f2);
        }
    }
}
