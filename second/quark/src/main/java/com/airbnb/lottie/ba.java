package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class ba extends cb<af> {
    private final af d;

    ba(List<? extends p<af>> list) {
        int i;
        super(list);
        af afVar = (af) ((p) list.get(0)).a;
        if (afVar == null) {
            i = 0;
        } else {
            i = afVar.b.length;
        }
        this.d = new af(new float[i], new int[i]);
    }

    final /* synthetic */ Object a(p pVar, float f) {
        af afVar = this.d;
        af afVar2 = (af) pVar.a;
        af afVar3 = (af) pVar.b;
        if (afVar2.b.length != afVar3.b.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + afVar2.b.length + " vs " + afVar3.b.length + ")");
        }
        for (int i = 0; i < afVar2.b.length; i++) {
            float[] fArr = afVar.a;
            float f2 = afVar2.a[i];
            fArr[i] = f2 + ((afVar3.a[i] - f2) * f);
            afVar.b[i] = a.a(f, afVar2.b[i], afVar3.b[i]);
        }
        return this.d;
    }
}
