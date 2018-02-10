package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* compiled from: ProGuard */
final class be extends bl<bp, Path> {
    private final bp d = new bp();
    private final Path e = new Path();

    be(List<p<bp>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(p pVar, float f) {
        bp bpVar = (bp) pVar.a;
        bp bpVar2 = (bp) pVar.b;
        bp bpVar3 = this.d;
        if (bpVar3.b == null) {
            bpVar3.b = new PointF();
        }
        boolean z = bpVar.c || bpVar2.c;
        bpVar3.c = z;
        if (bpVar3.a.isEmpty() || bpVar3.a.size() == bpVar.a.size() || bpVar3.a.size() == bpVar2.a.size()) {
            if (bpVar3.a.isEmpty()) {
                for (int size = bpVar.a.size() - 1; size >= 0; size--) {
                    bpVar3.a.add(new ac());
                }
            }
            PointF pointF = bpVar.b;
            PointF pointF2 = bpVar2.b;
            float f2 = pointF.x;
            f2 += (pointF2.x - f2) * f;
            float f3 = pointF.y;
            f3 += (pointF2.y - f3) * f;
            if (bpVar3.b == null) {
                bpVar3.b = new PointF();
            }
            bpVar3.b.set(f2, f3);
            for (int size2 = bpVar3.a.size() - 1; size2 >= 0; size2--) {
                ac acVar = (ac) bpVar.a.get(size2);
                ac acVar2 = (ac) bpVar2.a.get(size2);
                PointF pointF3 = acVar.a;
                PointF pointF4 = acVar.b;
                PointF pointF5 = acVar.c;
                PointF pointF6 = acVar2.a;
                PointF pointF7 = acVar2.b;
                pointF2 = acVar2.c;
                acVar = (ac) bpVar3.a.get(size2);
                float f4 = pointF3.x;
                f4 += (pointF6.x - f4) * f;
                float f5 = pointF3.y;
                acVar.a.set(f4, f5 + ((pointF6.y - f5) * f));
                acVar = (ac) bpVar3.a.get(size2);
                f5 = pointF4.x;
                f5 += (pointF7.x - f5) * f;
                float f6 = pointF4.y;
                acVar.b.set(f5, f6 + ((pointF7.y - f6) * f));
                acVar = (ac) bpVar3.a.get(size2);
                f5 = pointF5.x;
                f5 += (pointF2.x - f5) * f;
                f6 = pointF5.y;
                acVar.c.set(f5, ((pointF2.y - f6) * f) + f6);
            }
            am.a(this.d, this.e);
            return this.e;
        }
        throw new IllegalStateException("Curves must have the same number of control points. This: " + bpVar3.a.size() + "\tShape 1: " + bpVar.a.size() + "\tShape 2: " + bpVar2.a.size());
    }
}
