package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.uc.sync.e.h;

/* compiled from: ProGuard */
final class n implements h {
    final /* synthetic */ af a;
    final /* synthetic */ f b;

    n(f fVar, af afVar) {
        this.b = fVar;
        this.a = afVar;
    }

    public final void a(int i, int i2) {
        this.b.b = false;
        if (this.a == null) {
            return;
        }
        if (i == 101) {
            this.a.a(true);
        } else if (i == 102 || i == 104 || i == 105) {
            this.a.a(false);
        }
    }
}
