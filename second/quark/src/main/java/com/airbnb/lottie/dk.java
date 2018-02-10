package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.List;

/* compiled from: ProGuard */
final class dk extends cb<PointF> {
    private final PointF d = new PointF();

    dk(List<p<PointF>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(p pVar, float f) {
        if (pVar.a == null || pVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) pVar.a;
        PointF pointF2 = (PointF) pVar.b;
        this.d.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.d;
    }
}
