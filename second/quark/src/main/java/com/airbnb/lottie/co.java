package com.airbnb.lottie;

import java.util.List;

/* compiled from: ProGuard */
final class co extends bm<Integer, Integer> {
    public final /* synthetic */ bl a() {
        return b();
    }

    private co(List<p<Integer>> list, Integer num) {
        super(list, num);
    }

    public final cb<Integer> b() {
        if (c()) {
            return new bd(this.a);
        }
        return new ai(this.b);
    }

    public final String toString() {
        return "AnimatableColorValue{initialValue=" + this.b + '}';
    }
}
