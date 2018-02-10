package com.uc.weex.component.c;

import com.uc.weex.component.c.a.f;

/* compiled from: ProGuard */
final class c implements f {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;
    final /* synthetic */ f c;

    c(f fVar, boolean z, b bVar) {
        this.c = fVar;
        this.a = z;
        this.b = bVar;
    }

    public final void a(float f, float f2, boolean z) {
        float f3 = 0.0f;
        if (f2 != 0.0f && z) {
            if (this.a) {
                f3 = f2;
                f2 = 0.0f;
            }
            this.c.v = -f;
            f.a(this.b, f2, f3);
        }
    }
}
