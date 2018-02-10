package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class dt extends bm<Integer, Integer> {
    public final /* synthetic */ bl a() {
        return b();
    }

    private dt() {
        super(Integer.valueOf(100));
    }

    dt(List<p<Integer>> list, Integer num) {
        super(list, num);
    }

    public final cb<Integer> b() {
        if (c()) {
            return new cd(this.a);
        }
        return new ai(this.b);
    }

    public final /* bridge */ /* synthetic */ Object d() {
        return (Integer) this.b;
    }
}
