package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class cd extends cb<Integer> {
    cd(List<p<Integer>> list) {
        super(list);
    }

    final /* synthetic */ Object a(p pVar, float f) {
        if (pVar.a == null || pVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = ((Integer) pVar.a).intValue();
        return Integer.valueOf((int) ((((float) (((Integer) pVar.b).intValue() - intValue)) * f) + ((float) intValue)));
    }
}
