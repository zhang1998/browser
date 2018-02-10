package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* compiled from: ProGuard */
final class cy extends cb<PointF> {
    private final PointF d = new PointF();
    private final float[] e = new float[2];
    private dg f;
    private PathMeasure g;

    public final /* synthetic */ Object a(p pVar, float f) {
        dg dgVar = (dg) pVar;
        Path path = dgVar.f;
        if (path == null) {
            return (PointF) pVar.a;
        }
        if (this.f != dgVar) {
            this.g = new PathMeasure(path, false);
            this.f = dgVar;
        }
        this.g.getPosTan(this.g.getLength() * f, this.e, null);
        this.d.set(this.e[0], this.e[1]);
        return this.d;
    }

    cy(List<? extends p<PointF>> list) {
        super(list);
    }
}
