package com.ucpro.feature.bookmarkhis.bookmark.a;

import java.util.List;

/* compiled from: ProGuard */
final class ab implements i {
    final /* synthetic */ List a;
    final /* synthetic */ s b;

    ab(s sVar, List list) {
        this.b = sVar;
        this.a = list;
    }

    public final boolean a() {
        boolean z = true;
        for (m b : this.a) {
            z = this.b.b(b) & z;
        }
        return z;
    }
}
