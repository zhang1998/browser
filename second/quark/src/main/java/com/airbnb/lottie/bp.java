package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class bp {
    final List<ac> a;
    PointF b;
    boolean c;

    private bp(PointF pointF, boolean z, List<ac> list) {
        this.a = new ArrayList();
        this.b = pointF;
        this.c = z;
        this.a.addAll(list);
    }

    bp() {
        this.a = new ArrayList();
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }
}
