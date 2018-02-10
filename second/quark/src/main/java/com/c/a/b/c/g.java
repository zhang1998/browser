package com.c.a.b.c;

import android.opengl.Matrix;
import com.c.a.a;
import com.c.a.ac;

/* compiled from: ProGuard */
final class g extends ac {
    final /* synthetic */ f a;

    private g(f fVar, a aVar) {
        this.a = fVar;
        super(aVar);
    }

    public final void a(float f) {
    }

    public final void b(float f) {
    }

    public final void a(float[] fArr) {
    }

    protected final void a() {
        this.a.b.a = this.d;
        this.a.b.b();
        Matrix.orthoM(this.c, 0, (-this.a.b.b) / 2.0f, this.a.b.b / 2.0f, (-this.a.b.c) / 2.0f, this.a.b.c / 2.0f, this.e * 0.7f, 500.0f);
    }
}
