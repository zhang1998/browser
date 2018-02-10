package com.ucpro.feature.bookmarkhis.bookmark.a;

import java.util.List;

/* compiled from: ProGuard */
final class t implements i {
    final /* synthetic */ List a;
    final /* synthetic */ s b;

    t(s sVar, List list) {
        this.b = sVar;
        this.a = list;
    }

    public final boolean a() {
        boolean z = true;
        for (m a : this.a) {
            z = (this.b.a(a) >= 0 ? 1 : 0) & z;
        }
        return z;
    }
}
