package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;

/* compiled from: ProGuard */
final class am {
    static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    static void a(bp bpVar, Path path) {
        path.reset();
        PointF pointF = bpVar.b;
        path.moveTo(pointF.x, pointF.y);
        for (int i = 0; i < bpVar.a.size(); i++) {
            ac acVar = (ac) bpVar.a.get(i);
            path.cubicTo(acVar.a.x, acVar.a.y, acVar.b.x, acVar.b.y, acVar.c.x, acVar.c.y);
        }
        if (bpVar.c) {
            path.close();
        }
    }
}
