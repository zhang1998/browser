package com.airbnb.lottie;

import android.graphics.Path;
import java.util.List;

/* compiled from: ProGuard */
final class s extends bm<bp, Path> {
    private final Path c;

    private s(List<p<bp>> list, bp bpVar) {
        super(list, bpVar);
        this.c = new Path();
    }

    public final bl<?, Path> a() {
        if (c()) {
            return new be(this.a);
        }
        return new ai(a((bp) this.b));
    }

    private Path a(bp bpVar) {
        this.c.reset();
        am.a(bpVar, this.c);
        return this.c;
    }
}
