package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class bs extends cb<Float> {
    bs(List<p<Float>> list) {
        super(list);
    }

    final /* synthetic */ Object a(p pVar, float f) {
        if (pVar.a == null || pVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        float floatValue = ((Float) pVar.a).floatValue();
        return Float.valueOf(((((Float) pVar.b).floatValue() - floatValue) * f) + floatValue);
    }
}
