package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.Collections;

/* compiled from: ProGuard */
final class ar extends cb<PointF> {
    private final PointF d = new PointF();
    private final cb<Float> e;
    private final cb<Float> f;

    ar(cb<Float> cbVar, cb<Float> cbVar2) {
        super(Collections.emptyList());
        this.e = cbVar;
        this.f = cbVar2;
    }

    final void a(float f) {
        this.e.a(f);
        this.f.a(f);
        this.d.set(((Float) this.e.a()).floatValue(), ((Float) this.f.a()).floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            ((bq) this.a.get(i)).a();
        }
    }

    final /* bridge */ /* synthetic */ Object a(p pVar, float f) {
        return this.d;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return this.d;
    }
}
