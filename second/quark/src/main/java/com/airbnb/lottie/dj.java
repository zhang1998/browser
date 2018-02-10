package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class dj extends cb<cg> {
    dj(List<p<cg>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(p pVar, float f) {
        if (pVar.a == null || pVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        cg cgVar = (cg) pVar.a;
        cg cgVar2 = (cg) pVar.b;
        float f2 = cgVar.a;
        f2 += (cgVar2.a - f2) * f;
        float f3 = cgVar.b;
        return new cg(f2, f3 + ((cgVar2.b - f3) * f));
    }
}
