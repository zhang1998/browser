package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class bd extends cb<Integer> {
    bd(List<p<Integer>> list) {
        super(list);
    }

    public final /* synthetic */ Object a(p pVar, float f) {
        if (pVar.a != null && pVar.b != null) {
            return Integer.valueOf(a.a(f, ((Integer) pVar.a).intValue(), ((Integer) pVar.b).intValue()));
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
